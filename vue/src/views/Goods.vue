<template>
  <div style ="margin: 10px 0;margin-left: 200px;margin-right: 200px;">
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
export default {
    name:"Goods",
    data () {
        return {
            goods:[
                {
                    id:1,
                    img:"https://tse4-mm.cn.bing.net/th/id/OIP-C.Y12L8bWezV36MEGBBqah_QHaEo?pid=ImgDet&rs=1",
                    name:"计算机组成原理"
                },
                {
                    id:2,
                    img:"https://tse4-mm.cn.bing.net/th/id/OIP-C.Y12L8bWezV36MEGBBqah_QHaEo?pid=ImgDet&rs=1",
                    name:"数据库原理"
                },
                {
                    id:3,
                    img:"https://tse4-mm.cn.bing.net/th/id/OIP-C.Y12L8bWezV36MEGBBqah_QHaEo?pid=ImgDet&rs=1",
                    name:"数据结构与算法实践"
                }
            ]
        
        }
    },
    methods: {
        seeDetail () {
        this.$router.push("/detail")
    }
}
}
</script>

<style>

</style>