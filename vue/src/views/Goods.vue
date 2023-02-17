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
                    img:'',
                    name:''
                },
                {
                    id:'',
                    img:'',
                    name:''
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