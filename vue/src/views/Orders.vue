<template>
  <div style="margin: 10px 0; margin-left: 180px; margin-right: 180px">
    <el-table
      :data="tableData"
      stripe
      size="medium"
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" width="55"></el-table-column>
      <el-table-column
        prop="id"
        label="ID"
        width="80"
        sortable
      ></el-table-column>
      <el-table-column prop="goodsName" label="商品名称"></el-table-column>
      <el-table-column prop="price" label="商品单价"></el-table-column>
      <el-table-column prop="payTime" label="下单时间" ></el-table-column>
      <el-table-column prop="num" label="商品数量"></el-table-column>
      <el-table-column prop="img" label="图片">
        <template v-slot="scope">
          <el-image :src="scope.row.img" style="width: 100px"></el-image>
        </template>
      </el-table-column>

      
      <el-table-column label="操作" width="180" text-align="center">
        <template v-slot="scope">
          <el-button type="success" @click="handleEdit(scope.row)"
            >点击查看<i class="el-icon-edit"></i
          ></el-button>
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
    <div style="padding: 10px 0; background: white; margin: 10px 0">
      <el-pagination
        @size-change="handleSizeChange"
        @current-change="handelCurrentChange"
        :current-page="pageNum"
        :page-sizes="[2, 5, 10, 20]"
        :page-size="pageSize"
        layout="total,size,prev,pager,next,jumper"
        :total="total"
      ></el-pagination>
    </div>
    <div
      style="
        padding: 10px 20px;
        background-color: white;
        margin: 10px 0;
        border-radius: 10px;
        text-align: right;
      "
    >
      
      
    </div>

    <el-dialog
      title="信息"
      :visible.sync="dialogFormVisible"
      width="40%"
      :close-on-click-modal="false"
    >
      <el-form
        label-width="140px"
        size="small"
        style=""
        :model="form"
        :rules="rules"
        ref="ruleForm"
      >
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
  name: "Orders",
  data() {
    return {
      totalPrice: 520,
      tableData: [
        {
          id: 1,
          goodsName: "茶馆",
          num: "1",
          img: "https://img10.360buyimg.com/n1/jfs/t25927/12/1895594073/95966/2a873bcb/5bbec1bcN620b6b5a.jpg",
          price: "18",
          payTime: "2023/2/11 19:00"
        },
        {
          id: 2,
          goodsName: "老舍散文精选",
          num: "1",
          img: "https://ts1.cn.mm.bing.net/th/id/R-C.5621da63605feebd762139fefb682d31?rik=CQolCCCSQ6bW0Q&riu=http%3a%2f%2fimage12.bookschina.com%2f2018%2f20180525%2f7683893.jpg&ehk=HtC7WipRGBQ%2fmTBI%2bjO6Ee6xfM5VM5YvXnUCDHH9QzM%3d&risl=&pid=ImgRaw&r=0",
          price: "22",
          payTime: "2023/2/9 20:00"
        },
        {
          id: 3,
          goodsName: "四世同堂",
          num: "1",
          img: "https://ts1.cn.mm.bing.net/th/id/R-C.dab13089ecedfead129fdea813acf656?rik=9OuZ9uwWhmWMsQ&riu=http%3a%2f%2fy3.ifengimg.com%2fd183847b5f5545a0%2f2012%2f0307%2frdn_4f56aea2c4a0f.jpg&ehk=omy%2bk3BK7jR40Jwad0%2bF0GyHRyR3xvDRknaeXpKMSLs%3d&risl=&pid=ImgRaw&r=0&sres=1&sresct=1",
          price: "20",
          payTime: "2023/2/15 20:00"
        },  {
          id: 4,
          goodsName: "月牙儿",
          num: "1",
          img: "https://img3.jarhu.com/goodimages/201602/232/gi1456219582852.jpg",
          price: "30",
          payTime: "2023/2/16 21:00"
        },
      ],
    };
  },
};
</script>

<style></style>
