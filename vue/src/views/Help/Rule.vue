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
        <div class="demo-collapse">
          <el-collapse v-model="activeNames" @change="handleChange">
            <el-collapse-item title="用户须知" name="1">
              <div>
                1、您在使用本“软件产品”时可能需要注册一个使用账号，您应该妥善保管您的账号和密码。
              </div>
              <div>
                2、用户应在遵守法律法规及本协议的前提下使用本软件，用户不得实施以下行为：
                <div>（1）删除本软件及其他副本上一切关于版权的信息；</div>
                <div>
                  （2）使用本软件进行任何危害网络安全的行为，包括但不限于：使用未经许可的数据或进入未经许可的服务器/账户；未经允许进入公众网络或者其他人的操作系统并删除、修改、增加存储信息；
                </div>
                <div>
                  （3）利用本软件发表、传播、储存违反国家法律法规、危害国家安全、祖国统一、社会稳定、公序良俗的内容，或任何不当的、侮辱诽谤的、淫秽的、暴力的及任何违反国家法律法规政策的内容；
                </div>
                <div>
                  （4）利用本软件发表、传送、传播、储存侵害他人知识产权、商业秘密等合法权利的内容；
                </div>
                <div>
                  （5）利用本软件批量发表、传送、传播广告信息及垃圾信息；
                </div>
                <div>
                  （6）其他以任何不合法的方式、为任何不合法的目的、或以任何与本协议许可使用不一致的方式使用本软件和运营方提供的其他服务。
                </div>
              </div>
              <div>
                3、广告：您同意运营方可以在提供服务的过程中自行或由第三方广告商向您发送广告、推广或宣传信息（包括商业或非商业信息）。运营方依照法律的规定对广告履行相关义务，您应当自行判断广告信息的真实性并为自己的判断行为负责，除法律法规另有明确规定外，您因依该广告信息进行的交易或前述广告商提供的内容而遭受的损失或损害，运营方不承担任何赔偿责任。
              </div>
              <div>
                4、本“软件产品”及任何副本的著作权，均由东南大学拥有。本“软件产品”受《中华人民共和国著作权法》、《计算机软件保护条例》及知识产权国际公约的保护。本“软件产品”提供的书籍等内容，均由作品著作权人拥有相应的著作权，受《中华人民共和国著作权法》及知识产权国际公约的保护。
              </div>
              <div>
                5、对于本“软件产品”所涉及的技术和产品，运营方拥有其专利、商标或其它知识产权。任何对前述知识产权的使用或利用，均应事先取得运营方的明确书面授权。
              </div>
              <div>
                6、运营方严格遵守《隐私政策》中的用户个人信息收集、使用及保护等条款，具体隐私保护原则详见我们的《隐私政策》条款。
              </div>
              <div>
                7、您理解并同意，在本“软件产品”提供内容或服务的过程中，可能会因不可抗力等风险因素，使相关内容和服务的提供发生中断。不可抗力是指不能预见、不能克服并不能避免且对一方或双方造成重大影响的客观事件，包括但不限于自然灾害如洪水、地震等以及社会事件如战争、动乱、政府行为或网络安全事件等。出现上述情况时，运营方将采取相应的应急预案，努力在第一时间与相关单位配合，及时进行修复，但是由此给您造成的损失运营方在法律允许的范围内免责。
              </div>
              <div>
                8、在法律允许的范围内，运营方对以下情形导致内容和服务提供的中断或受阻不承担责任：
                <div>
                  （1）用户自身受到计算机病毒、木马或其他恶意程序、黑客攻击的破坏；
                </div>
                <div>
                  （2）用户的电脑、手机端软件、系统、硬件和通信线路出现故障；
                </div>
                <div>（3）用户操作不当；</div>
                <div>（4）用户通过非运营方授权的方式使用本服务。</div>
              </div>
              <div>
                9、服务的中断或终止
                如发生下列任何一种情形，运营方有权不经通知而中断或终止向您提供内容和服务：
                <div>
                  （1） 您违反相关法律法规或本协议的约定；
                  （2）您的账号已被注销；
                </div>
                <div>
                  （3） 按照法律规定或主管部门的要求；
                  （4）您提供虚假注册信息的；
                </div>
                <div>（5） 出于安全的原因或其他必要的情形。</div>
              </div>
              <div>
                <div>10、协议的生效及变更</div>
                我们将在明确获得您的同意和接受后，为您提供相应的服务。运营方有权在必要时修改本协议条款。您可以在相关服务页面查阅最新版本的协议条款。您有权不接受修改后的协议，但可能会导致您需要停止使用运营方提供的某项内容或服务。
              </div>
              <div>
                <div>11、其他</div>
                如果您对本协议或本服务有意见或建议，可通过电话客服联系我们，联系方式：4001066666。
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
  name: "Rule"
}
</script>
