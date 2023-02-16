
<template>
    <div style="width:100%;height:100vh;overflow: hidden;background: pink linear-gradient(to right, rgb(247,209,215),rgb(191,227,241));" >
      <div style="width: 500px;border-radius:30px;box-shadow:2px 2px 6px 6px #ccc;margin: 120px auto;height: 320px;display: flex;position: relative;border: #cccccc">
        <el-form style="margin: 5px auto;" ref="form" :model="form" :rules="rules">
          <div style="color: #303133;font-size: 30px;text-align:center;padding:30px 0">注册界面</div>
          <el-form-item prop="name">
            <el-input :prefix-icon="Avatar"  v-model="form.userName" placeholder="请输入账号" clearable maxlength="10" style="width: 300px">
            </el-input>
          </el-form-item>
          <el-form-item prop="password">
            <el-input  :prefix-icon="Lock"  v-model="form.userPassword" show-password clearable placeholder="请输入密码" maxlength="10"
            ></el-input>
          </el-form-item>
          <el-form-item prop="confirm">
            <el-input  :prefix-icon="Lock"  v-model="form.confirm" show-password clearable placeholder="请确认密码"
                       maxlength="10"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button style="width:50%;color:#FFFFFF;margin-left: 5px" type="success" round @click="register" @keyup.enter="keyDown(e)" >注册</el-button>
              <div style="width: 30%;font-size: 10px;margin-left: 30px">
              <el-link style="font-size: 10px" @click="loginSwitch" type="primary" >立即去登录</el-link>
            </div>
          </el-form-item>
  
        </el-form>
  
      </div>
  
    </div>
  </template>
  
  <script>
  
  import { Avatar, Lock } from "@element-plus/icons-vue";
  import request from "@/utils/request";
  export default {
    name: "Register",
    setup(){
      return{
        Avatar,
        Lock,
      }
    },
    mounted() {
      window.addEventListener("keydown",this.keyDown)
    },
    destroyed() {
      window.removeEventListener("keydown",this.keyDown,false)
    },
    data() {
      return {
  
        form: {
        },
        rules:{
          userName:[
            {required:true,message:'请输入账号',trigger:'blur'},
            {min:6,max:10,message:'长度在6到10个字符',trigger:'blur'}
          ],
          userPassword:[
            {required:true,message:'请输入密码',trigger:'blur'},
            {min:6,max:10,message:'长度在6到10个字符',trigger:'blur'}
          ],
          confirm:[
            {required:true,message:'请输入密码',trigger:'blur'},
            {min:6,max:10,message:'长度在6到10个字符',trigger:'blur'}
          ]
        }
      }
    },
    methods: {
      keyDown(e){
        console.log("e",e.keyCode)
        if(e.keyCode===13){
          this.register()
        }
      },
      register(){
        if(this.form.userPassword==null||this.form.userName==null||this.form.confirm==null){
          this.$notify({
            title: '错误',
            message: '账号或者密码不能为空',
            type: 'error',
          })
          return
        }
        if(this.form.userPassword!==this.form.confirm){
          this.$notify({
            title: '错误',
            message: '两次密码不一致',
            type: 'error',
          })
          return
        }
        this.$refs["form"].validate((valid)=>{
              if(valid){
                request.post("/user/register",this.form).then(res => {
                  if (res.code === 200) {
                    this.$notify({
                      title: '成功',
                      message: '注册成功',
                      type: 'success',
                    })
                    this.$router.push("/login")//跳转到登录界面
                  }
                  else {
                    this.$notify({
                      title: '错误',
                      message: res.msg,
                      type: 'error',
                    })
              }
                })
              }
            }
        )
      },
      loginSwitch(){
        this.$router.push("/login")
      }
    }
  }
  </script>
  