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

    <el-table-column prop="userid" label="用户ID"></el-table-column>
    <el-table-column label="操作" width="180" text-align="center">
        <template v-slot="scope" >
          <el-button type="success" @click="handleEdit(scope.row)">编辑<i class="el-icon-edit"></i></el-button>
          <el-popconfirm
          class="ml-5"
          confirm-button-text="确定"
          cancel-button-text="我再想想"
          icon="el-icon-info"
          icon-color="red"
          title="您确定删除吗"
          @confirm="del(scope.row.id)"
          >
          <el-button type="danger" slot="reference">删除<i class="el-icon-remove-outline"></i>

          </el-button>
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
      totalPrice: 520,
      tableData : [
        {
        id:1,
        goodsName:"数据库原理",
        num:"1",
        img:"https://tse2-mm.cn.bing.net/th/id/OIP-C.WI_kPj3BbBOgzKFUFj8NQgHaHa?pid=ImgDet&rs=1",
        price:"25"
      }
    ]
    }
  }
}
</script>

<style>

</style>