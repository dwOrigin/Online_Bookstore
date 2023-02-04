<template>
    <div style="display: flex; margin: 10px 0">
      <div style="width: 30%;margin-left:200px;">
        <el-card>
          <el-image :src="goods.img" style="width: 100%;height: 320px;"> </el-image>
        </el-card>
      </div>
      <div style="margin-left: 10px;flex:1;width:100%;margin-right: 200px;">
          <el-card>
              <el-form label-width="80px">
                <el-form-item label="商品名称">{{goods.name}}</el-form-item>
                <el-form-item label="商品描述">{{goods.description}}</el-form-item>
                <el-form-item label="商品价格">
                  <span style="color:red">{{goods.price}}</span>
                </el-form-item>
                <el-form-item label="商品库存">
                  <span>{{goods.nums}}</span>
                </el-form-item>
                <div>
                  <el-input-number :value="1" size="medium" style="width: 100px" v-model="buyNum"></el-input-number>
                  <el-button style="background: red;font-size:16px; color:white;padding :10px;margin-left:100px">加入购物车</el-button>
                </div>
                <div style="margin-top: 20px;font-size: 12px;color: #888">
                  温馨提示
                  <div>*支持7天无理由退货</div>
                </div>
              </el-form>
          </el-card>
      </div>
    </div>
  </template>
  
<script>
  export default {
    name:"Detail",
    data () {
      return {
      goods: {
        img:"https://tse2-mm.cn.bing.net/th/id/OIP-C.WI_kPj3BbBOgzKFUFj8NQgHaHa?pid=ImgDet&rs=1",
        name: "资料",
        price: "25",
        description:  "这是一本可靠的书",
        nums:888

      },
      goodsId: 1,
      buyNum: 1,
    }
  }
}
  </script>
  
  <style>
  
  </style>