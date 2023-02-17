<template>
  <div style ="margin: 10px 0;margin-left: 200px;margin-right: 200px;">
    
      <div>
        <el-button type="primary" @click="showBook()">搜索结果展示</el-button>
        <el-button type="primary" @click="showAll()">展示全部书籍</el-button>
      </div>
    
    
    <div style="margin: 20px 0;font-size: 20px;color: orangered;border-bottom:1px solid orangered; padding-bottom: 10px">商品列表</div>
    <el-row :gutter="10">
        <el-col :span = "6" v-for ="item in goods" :key = "item.id" style="margin-bottom:10px">
        <div>
            <img :src="item.img" alt="" style="width :100%;height: 200px;overflow: hidden; border-radius: 10px 10px 0 0" @click="seeDetail()">
            <div style="color: #666; padding: 10px">{{item.name}}</div>
            <div style="padding: 10px">
            <el-button type="primary">购买</el-button>
            
            </div>
        </div>
        </el-col>
    </el-row>
    </div>
</template>

<script>
  import axios from "axios";
import store from "../components/state.vue";
export default {
    name:"Goods",
    data () {
        return {
            goods:[
                {
                    id:'',
                    img:'https://ts1.cn.mm.bing.net/th/id/R-C.ff8d35e7d6f7462ade27bc63f653d32f?rik=oHnTt%2bCfmgRTfQ&riu=http%3a%2f%2fwww.wdp.com.cn%2fhtml%2fupload%2fadmin%2fimage%2f2021%2f03%2f01%2f1614586387945.jpg&ehk=0CWfTx22Qhp0e4iok2r7FOHxZAtAh3LNXnNNv93xUKg%3d&risl=&pid=ImgRaw&r=0',
                    name:'数据库原理及其应用'
                },
                {
                    id:'',
                    img:'https://ts1.cn.mm.bing.net/th/id/R-C.fff2d100c8a32c65f3aba46771ffc083?rik=62qTiRD5ZqfwvA&riu=http%3a%2f%2fwww.java1234.com%2fuploads%2fallimg%2f150225%2f1-1502250912464N.jpg&ehk=wSYccYxNF%2bPg1TASKeu17ofpbsFBjCMIEb4N341x9Sg%3d&risl=&pid=ImgRaw&r=0',
                    name:'数据库原理'
                },
                {
                    id:'',
                    img:'https://pic1.zhimg.com/50/v2-ca9fb62800c87926324b84663e7cc41a_720w.jpg?source=54b3c3a5',
                    name:'数据库系统概念'
                },
                {
                    id:'',
                    img:'https://pic1.zhimg.com/50/v2-8c751df14495839927b9b673432d5d6e_720w.jpg?source=54b3c3a5',
                    name:'数据库系统'
                },
                {
                    id:'',
                    img:'https://pic4.zhimg.com/50/v2-8e51057f640f9010e10f66b46ce79882_720w.jpg?source=54b3c3a5',
                    name:'MySQL数据库应用从入门到精通'
                }
            ],
            bookInf2:[{
        ISBN: '',
            bookName: '',
            bookAuthor: '',
            bookPrice: '',
            bookQuantities: '',
            bookSaleNumbers: '',
            bookIntroduction: '',
            bookImage:'',
      }],
        
        }
    },
    methods: {
        seeDetail () {
        this.$router.push("/detail")
    },
    mounted(){
      showAll();
    },
    showBook(){
      const self = this;
        const newData=JSON.parse(localStorage.getItem('bookData'))
        console.log(newData.length);
        for(let i=0;i<newData.length;i++)
        {
          self.goods[i].id=newData[i].ISBN;
          self.goods[i].img=newData[i].bookImage;
          self.goods[i].name=newData[i].bookName;
        }
    },
    showAll(){
      const self = this;
      axios({
          method: "post",
          url: "http://localhost:8081/books/allbook",
        })
          .then((res) => {
            console.log(res.data);
            if(res.data==null)
              alert("出错了");
            else{
              console.log(res.data.data.length);
              self.bookInf2=res.data.data;
              
              for(let i=0;i<res.data.data.length;i++)
        {
          self.goods[i].id=self.bookInf2[i].isbn;
          self.goods[i].img=self.bookInf2[i].bookImage;
          self.goods[i].name=self.bookInf2[i].bookName;
        }
          }
          })
          .catch((err) => {
            console.log(err);
          });
    }
}
}
</script>

<style>

</style>