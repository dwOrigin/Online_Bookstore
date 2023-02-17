<template>
  <div
    style="
      height: 60px;
      line-height: 50px;
      border-bottom: 1px solid #ccc;
      display: flex;
    "
  >
    <div
      style="
        width: 200px;
        padding-left: 30px;
        color: dodgerblue;
        font-weight: bold;
      "
    >
      网上书店系统
    </div>
    <div style="flex: 1">
      <el-menu
        :default-active="$route.path"
        class="el-menu-demo"
        mode="horizontal"
        router
        style="border: none; height: 59px"
      >
        <el-menu-item index="/home">首页</el-menu-item>

        <el-menu-item index="/cart">我的购物车</el-menu-item>
        <el-menu-item index="/orders">我的订单</el-menu-item>

        <el-menu-item index="/usr">个人中心</el-menu-item>
        <el-menu-item index="/help">帮助与反馈</el-menu-item>
      </el-menu>
    </div>
    <div style="margin-right: 200px; margin-top: 5px">
      
      <el-input
      v-model="bookName"
      placeholder="通过书名或作者或ISBN搜索..."
      @input="onInput"
    >
      <template #append>
        <el-button :icon="Search" @click="Search(bookName)"/>
      </template>
    </el-input>
    
    </div>
    
    <div style="width: 100px; padding-top: 18px; font-weight: bold">
      <el-dropdown>
        <span class="el-dropdown-link" :icon="ArrowDown"> 欢迎您 </span>
        <template #dropdown>
          <el-dropdown-menu>
            <el-dropdown-item>
              <span style="text-decoration: none" @click="logout">退出</span>
            </el-dropdown-item>
          </el-dropdown-menu>
        </template>
      </el-dropdown>
    </div>
  </div>
</template>

<script>
import { Search } from "@element-plus/icons-vue";
import { ArrowDown } from "@element-plus/icons-vue";
import axios from "axios";
import store from "../components/state.vue";
export default {
  data(){
    return{
      bookInf:[{
        ISBN: '',
            bookName: '',
            bookAuthor: '',
            bookPrice: '',
            bookQuantities: '',
            bookSaleNumbers: '',
            bookIntroduction: '',
            bookImage:'',
      }],
      bookSearch: false
    }
  },
  setup() {
    return {
      Search,
      ArrowDown,
    };
  },
  methods: {
    logout() {
      
      this.$router.push("/register");
    },
    Search(bookName) {
      const self = this;
      localStorage.setItem('bookS',self.bookSearch);
      
      if (bookName == null) {
        this.$router.push("/goods");
      }
      else
      {
        console.log(self.bookName);
        axios({
          method: "post",
          url: "http://localhost:8081/books/search",
          data: {
            ISBN: self.bookName,
            bookName: self.bookName,
            bookAuthor: self.bookName,
            bookPrice: self.bookName,
            bookQuantities: self.bookName,
            bookSaleNumbers: 0,
            bookIntroduction: "",
            bookImage:" ",
          },
        })
          .then((res) => {
            console.log(res.data);
            self.bookInf=res.data.data;
            if(res.data==null)
            alert("并未查找到相关书籍");
            else{
            localStorage.setItem('bookData',JSON.stringify(self.bookInf));
            const newData=JSON.parse(localStorage.getItem('bookData'))
            console.log(newData);//将查找到的数据的数据存储到bookData中
            self.bookSearch=true;
            localStorage.setItem('bookS',self.bookSearch);
            console.log(localStorage.getItem('bookS'));
            this.$router.push("/goods");
          }
          })
          .catch((err) => {
            console.log(err);
          });
      }
    },
    onInput() {
      this.$forceUpdate();
    }
  },
};
</script>

<style>
.input-with-select .el-input-group__prepend {
  background-color: var(--el-fill-color-blank);
}
</style>
