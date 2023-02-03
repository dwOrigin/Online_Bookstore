<template>
  <div style="height:60px;line-height:50px;border-bottom:1px solid #ccc;display: flex;">
    <div style="width:200px;padding-left: 30px;color:dodgerblue;font-weight: bold;">网上书店系统</div>
    <div style="flex: 1">
        <el-menu :default-active="$route.path" class="el-menu-demo" mode="horizontal" router style="border: none; height: 59px">
          <el-menu-item index="/home">首页</el-menu-item>
          <el-menu-item index="/cart">我的购物车</el-menu-item>
          <el-menu-item index="/orders">我的订单</el-menu-item>
          <el-menu-item index="/usr">个人中心</el-menu-item>
        </el-menu></div>
      <div style="margin-right: 500px;margin-top: 5px ;">
    <el-input
      v-model="input3"
      placeholder="请输入书名"
      class="input-with-select"
    >
      <template #append>
        <el-button :icon="Search" />
      </template>
    </el-input></div>
  
    <div style="width:60px;padding-top:18px;font-weight: bold">
        <el-dropdown>
    <span class="el-dropdown-link" >
      欢迎您
      <el-icon class="el-icon--right">
        <ArrowDown />
      </el-icon>
    </span>
    <template #dropdown>
      <el-dropdown-menu>
        <el-dropdown-item >
                <span style="text-decoration: none" @click="logout">退出</span>
              </el-dropdown-item>
      </el-dropdown-menu>
    </template>
  </el-dropdown></div>
</div>
</template>

<script>
import { Search } from '@element-plus/icons-vue'
import { ArrowDown } from '@element-plus/icons-vue'
export default {
  setup (){
    return {
      Search,
      ArrowDown
    }
  }

}
</script>

<style>
.input-with-select .el-input-group__prepend {
  background-color: var(--el-fill-color-blank);
}
</style>