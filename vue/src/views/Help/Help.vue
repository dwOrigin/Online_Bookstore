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
            <el-menu-item> </el-menu-item>
          </el-menu>
        </el-col>
      </el-row>
    </el-aside>
    <el-container>
      <el-main>
        <div class="demo-collapse">
          <el-collapse v-model="activeNames" @change="handleChange">
            <el-collapse-item title="商品包邮吗？" name="1">
              <div>
                本网站自营普通配送和平邮订单：单张订单满49元包邮，不符合以上免运费标准的，每单收取6元运费。
              </div>
            </el-collapse-item>
            <el-collapse-item title="可以修改收货人信息吗？" name="2">
              <div>
                订单在提交10分钟内且订单状态正常状态下可以联系客服修改订单中“收货人姓名、详细地址、联系方式”。
              </div>
              <div>
                注：分包裹订单无法修改订单信息，若您需要修改，建议您取消订单重新订购，重新订购过程中修改信息。同时需提醒您，取消订单可能会有商品库存及价格的变动，请您以最终提交订单时为准。
              </div>
            </el-collapse-item>
            <el-collapse-item title="是否有正品保障？" name="3">
              <div>
                我们坚持“诚信为本”的经营理念，我们保证所售自营商品均为有合法正规来源进货渠道的商品，如果您认为购买的商品是假货，并能提供国家相关质检机构的证明文件，我们会按照国家法律规定予以处理。
              </div>
            </el-collapse-item>
            <el-collapse-item title="为什么要验证手机、邮箱？" name="4">
              <div>
                为了保证账户安全，当购物时需输入与登录账户密码相独立的密码，作为使用者身份确认。这样即使登录账户密码被盗用，用户的个人资产信息将会受到保护。
                且当您忘记支付密码，登陆“我的当当-安全中心”，点击“支付密码”后方的“修改”按钮，通过已验证的手机号找回。
              </div>
            </el-collapse-item>
            <el-collapse-item title="如何预防诈骗？" name="5">
              <div>
                近期骗子异常活跃，现提供一点防骗小招，请大家在购物时谨防诈骗。
              </div>
              <div>

                绝招1：拒绝向陌生人转账、汇款，不要在陌生链接中付款，不要接受陌生文件或随意扫描陌生二维码付款。
              </div>
                <div>
                绝招2：收到中奖消息后请仔细辨认，当当没有“周年庆典”、“幸运用户抽奖”等活动，官网活动领奖不需要缴纳手续费、快递费。
        </div>
                <div>
                绝招3：任何一个验证码都有可能和您的款项相关，请勿随意告知他人。
        </div>
                <div>
                绝招4：任何涉及款项、个人信息等相关操作，请第一时间联系官方客服核实确认。
              </div>
            </el-collapse-item>
            <el-collapse-item title="交易说明" name="6">
              <div>
                1.关于银行转账
              </div>
              <div>
                1)国内顾客可以通过全国任何一家银行，向当当在平安银行、兴业银行开立的账户汇款。
        </div>
              <div>
                2)到款时间一般为办理转帐手续之后的1-3个工作日内。
        </div>
              <div>
                3)订单提交成功后，请您及时汇款，汇款完毕后请务必进入订单信息页面填写“付款确认”，如您24小时内未填写付款信息，订单将会被系统自动取消。
              </div>
            </el-collapse-item>
          </el-collapse>
        </div>
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
export default {
  name: "Help"
}
</script>
