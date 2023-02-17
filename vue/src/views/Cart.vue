<template>
  <div style="margin:10px 0;margin-left: 180px;margin-right: 180px">
    <el-table :data="tableData" stripe size="medium" @selection-change="handleSelectionChange">
    <el-table-column type="selection" width="55"></el-table-column>
    <el-table-column prop="id" label="ID" width="80" sortable></el-table-column>
    <el-table-column prop="goodsName" label="商品名称" ></el-table-column>
    <el-table-column prop="price" label="商品单价"></el-table-column>
    <el-table-column prop="num" label="商品数量"></el-table-column>
    <el-table-column prop="img" label="图片">
      <template v-slot="scope">
        <el-image :src="scope.row.img" style="width:100px"></el-image>
      </template>
    </el-table-column>

   
    <el-table-column label="操作" width="180" text-align="center">
        <template v-slot="scope" >
          <el-button type="danger" @click="handleEdit(scope.row)">删除<i class="el-icon-edit"></i></el-button>
          <el-popconfirm
          class="ml-5"
          confirm-button-text="确定"
          cancel-button-text="我再想想"
          icon="el-icon-info"
          icon-color="red"
          title="您确定删除吗"
          @confirm="del(scope.row.id)"
          >
        
          </el-popconfirm>
        </template>
    </el-table-column>
    </el-table>
    <div style="padding: 10px 0;background: white;margin: 10px 0;">
      <el-pagination
      @size-change="handleSizeChange"
      @current-change="handelCurrentChange"
      :current-page="pageNum"
      :page-sizes="[2,5,10,20]"
      :page-size="pageSize"
      layout="total,size,prev,pager,next,jumper"
      :total="total"
      ></el-pagination>
    
    
    </div>
    <div style="padding: 10px 20px;background-color: white;margin:10px 0;border-radius: 10px;text-align:right">
      <div style="color:red">总价 ￥{{totalPrice}}</div>
      <div style="margin:10px 0">
        <el-button style="background-color:red;color :white; font-size:18px;padding:10px 20px">下单</el-button>
      </div>
    </div>

    <el-dialog title="信息" :visible.sync="dialogFormVisible" width="40%" :close-on-click-modal="false">
      <el-form label-width="140px" size="small" style="" :model="form" :rules="rules" ref="ruleForm">
      <el-form-item prop="goodsId" label="商品id">
        <el-input v-model="form.goodsId" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item prop="num" label="商品数量">
        <el-input v-model="form.num" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item prop="userid" label="用户id">
        <el-input v-model="form.userid" autocomplete="off"></el-input>
      </el-form-item>
    </el-form>
    <div slot-="footer" class="dialog-footer">
      <el-button @click="dialogFormVisible = false">取消</el-button>
      <el-button type="primary" @click="save">确定</el-button>
    </div>
    </el-dialog>
  </div>
</template>

<script>
export default {
  name: "Cart",
  data () {
    return {
      totalPrice: " ",
      tableData : [
        {
        id:1,
        goodsName:"数据库原理",
        num:"1",
        img:"https://ts1.cn.mm.bing.net/th/id/R-C.f0cbfb731cb5a0571183b9e19a980d52?rik=sT9McGEbEMoMAQ&riu=http%3a%2f%2fwww.tup.tsinghua.edu.cn%2fupload%2fbigbookimg3%2f057816-01.jpg&ehk=v2lSrvrtiKJWGUmF1j3RigzE4qBCaOdCf8zTocjL3ps%3d&risl=&pid=ImgRaw&r=0",
        price:"25",
      
      },
      {
        id:2 ,
        goodsName:"计算机组成原理",
        num:"1",
        img:"https://ts1.cn.mm.bing.net/th/id/R-C.a2c3b5f13a58821e80b680eafe2b6a47?rik=crxgyt4AZUOQAw&riu=http%3a%2f%2fwww.ecsponline.com%2fbook_2019%2f2019%2flt%2f9787030619716-006093-fcv_lt.jpg&ehk=TYF6dWt7WOugyVuB13BOwA7tXs2yPRj3dh5qpHMVtB0%3d&risl=&pid=ImgRaw&r=0",
        price:"20",
       
      },
      {
        id:3,
        goodsName:"数据结构",
        num:"1",
        img:"https://img.alicdn.com/bao/uploaded/i1/671432529/TB1iJPfPXXXXXXWaFXXXXXXXXXX_!!0-item_pic.jpg",
        price:"18",
       
      }, {
        id:4,
        goodsName:"编译原理",
        num:"1",
        img:"https://tse3-mm.cn.bing.net/th/id/OIP-C.Dpswl2PHC4lBbc5mbVf33AAAAA?pid=ImgDet&rs=1",
        price:"22",
      },
    ]
    }
  }
}
</script>

<style>

</style>