
<template>
	<div style="width:100%;height:100vh;overflow: hidden;background: pink linear-gradient(to right, rgb(247,209,215),rgb(191,227,241));" >
	  <div style="width: 500px;border-radius:30px;box-shadow:2px 2px 6px 6px #ccc;margin: 120px auto;height: 270px;display: flex;position: relative;
  
  ">
		<el-form style="margin: 5px auto;" ref="form" :model="form" :rules="rules">
		  <div style="color: #303133;font-size: 30px;text-align:center;padding:30px 0">登录界面</div>
		  <el-form-item prop="userName">
			<el-input :prefix-icon="Avatar"  v-model="form.userName" placeholder="请输入账号" clearable
					  maxlength="10">
			</el-input>
		  </el-form-item >
		  <el-form-item prop="userPassword">
			<el-input  :prefix-icon="Lock"  v-model="form.userPassword" show-password clearable placeholder="请输入密码"
					   maxlength="10" style="width: 300px"></el-input>
		  </el-form-item>
		  <el-form-item>
			<el-button style="width:50%;color:#FFFFFF;margin-left: 5px" type="success" round @click="login" @keyup.enter="keyDown(e)" >登录</el-button>
			<div style="width: 30%;font-size: 10px;margin-left: 30px">
			  <el-link style="font-size: 10px" @click="register" type="primary">立即去注册</el-link>
			 </div>
		  </el-form-item>
		</el-form>
  
	  </div>
  
	</div>
  </template>
  
  <script>
  
  import request from "@/utils/request";
  import { Avatar, Lock } from "@element-plus/icons-vue";
  export default {
	name: "Login",
	setup(){
	  return{
		Avatar,
		Lock,
	  }
	},
	mounted() {
	 /* window.addEventListener("keydown",this.keyDown)*/
	},
	destroyed() {
  /*    window.removeEventListener("keydown",this.keyDown,false)*/
	},
	data() {
	  return {
		form: {
		  userId:'',
		  userName:'',
		  userPassword:'',
		},
		rules:{
		  userName:[
			{required:true,message:'请输入账号',trigger:'blur'},
			{min:6,max:10,message:'长度在6到10个字符',trigger:'blur'}
		  ],
		  userPassword:[
			{required:true,message:'请输入密码',trigger:'blur'},
			{min:6,max:10,message:'长度在6到10个字符',trigger:'blur'}
		  ]
		}
	  }
	},
	methods: {
	 /* keyDown(e){
		console.log("e",e.keyCode)
		if(e.keyCode===13){
		  this.login()
		}
	  },*/
	  register(){
		this.$router.push("/register")
	  },
	  login() {
		if(this.form.userPassword==null||this.form.userName==null){
		  this.$message({
			type:"error",
			message:"账号或者密码不能为空",
		  })
		  return;
		}
		this.$refs["form"].validate((valid)=>{
		  if(valid){
			request.post("/user/login",this.form).then(res => {
			  if (res.code === 200) {
				sessionStorage.setItem("userId",res.data.userId);
				sessionStorage.setItem("userName",res.data.userName);
				this.$message({
				  type: "success",
				  message: "登录成功"
				})
				this.$router.push({
				  path:'/'+sessionStorage.getItem("userName")
				})//跳转到主页面
			  } else {
				this.$message({
				  type: "error",
				  message: res.msg
				})
			  }
			})
		  }
			}
		)
	  },
  
	},
  }
  </script>
  