<template>
  <el-container class="layout-container-demo" style="height: 500px">
    <el-aside width="200px">
      <el-row class="tac" width="200px">
        <!-- <el-col :span="12">
        <h5 class="mb-2">Default colors</h5>
        <el-menu
          default-active="2"
          class="el-menu-vertical-demo"
          @open="handleOpen"
          @close="handleClose"
        >
          <el-menu-item index="1">
            <el-icon><setting /></el-icon>
            <span>Navigator one</span>
          </el-menu-item>
          <el-menu-item index="2">
            <el-icon><icon-menu /></el-icon>
            <span>Navigator Two</span>
          </el-menu-item>
          <el-menu-item index="3">
            <el-icon><document /></el-icon>
            <span>Navigator Three</span>
          </el-menu-item>
        </el-menu>
      </el-col> -->
        <el-col :span="20">
          <h5 class="mb-2"></h5>
          <el-menu
            router
            :default-active="this.$router.path"
            active-text-color="#ffd04b"
            background-color="#545c64"
            class="el-menu-vertical-demo"
            text-color="#fff"
            @open="handleOpen"
            @close="handleClose"
          >
            <el-menu-item index="/help">
              <el-icon><setting /></el-icon>
              <span>查看F.A.Q</span>
            </el-menu-item>
            <el-menu-item index="/rule">
              <el-icon><icon-menu /></el-icon>
              <span>使用规则</span>
            </el-menu-item>
            <el-menu-item index="/contact">
              <el-icon><document /></el-icon>
              <span>联系我们</span>
            </el-menu-item>
          </el-menu>
        </el-col>
      </el-row>
    </el-aside>

    <el-container>
      <el-main>
        <el-row>
          <el-col
            v-for="(o, index) in 2"
            :key="o"
            :span="8"
            :offset="index > 0 ? 2 : 0"
          >
            <el-card :body-style="{ padding: '0px' }">
              <img src="../../assets/contact.png" class="image" />
              <div style="padding: 14px">
                <div><span>email:</span></div>
                <span>2100000@seu.edu.cn</span>
                <!-- <div class="bottom">
                  <time class="time">{{ currentDate }}</time>
                  <el-button text class="button">Operating</el-button>
                </div> -->
              </div>
            </el-card>
          </el-col>
        </el-row>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
import { ref } from "vue";

import {
  Document,
  Menu as IconMenu,
  Location,
  Setting,
} from "@element-plus/icons-vue";
// const handleOpen = (key: string, keyPath: string[]) => {
//   console.log(key, keyPath);
// };
// const handleClose = (key: string, keyPath: string[]) => {
//   console.log(key, keyPath);
// };
// const activeNames = ref(["1"]);
// const handleChange = (val: string[]) => {
//   console.log(val);
// };
const currentDate = ref(new Date());
export default {
  name: "Contact"
}
</script>

<style>
.time {
  font-size: 12px;
  color: #999;
}

.bottom {
  margin-top: 13px;
  line-height: 12px;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.button {
  padding: 0;
  min-height: auto;
}

.image {
  width: 100%;
  display: block;
}
</style>
