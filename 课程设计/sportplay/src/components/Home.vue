<template>
  <el-container class="home-container">
    <el-header>
      <div>
        <img src="../assets/bigMan.png" width="80" height="60" alt />
        <span>运动管理平台</span>
      </div>
      <el-button type="info" @click="logout">安全退出</el-button>
    </el-header>
    <el-container>
      <el-aside :width="isColl?'64px':'200px'">
        <div class="toggle-button" @click="toggerCollapse">|||</div>
        <el-menu
          background-color="#545c64"
          text-color="#fff"
          active-text-color="skyblue"
          :collapse="isColl"
          :collapse-transition="false"
          :router="true"
          :default-active="activePath">
          <!-- router来跳转子页面
           借助路由的children -->
          <el-submenu :index="item.id+''" :key="item.id" v-for="item in menuList">
            <template slot="title">
              <i class="el-icon-location"></i>
              <span>{{item.title}}</span>
            </template>
            <el-menu-item :index="it.path" :key="it.id" v-for="it in item.sList" @click="saveNavState(it.path)">
              <template slot="title">
                <span>{{it.title}}</span>
              </template>
            </el-menu-item>
          </el-submenu>
        </el-menu>
      </el-aside>
      <el-main>
        <router-view></router-view>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
export default {
  data() {
    return {
      menuList: [],
      isColl: false,
      activePath: '/welcome',
    };
  },
  created(){
    this.getMenuList();
    this.activePath = window.sessionStorage.getItem('activePath');// 取出session里的访问路径
  },
  methods: {
    toggerCollapse(){
      this.isColl = !this.isColl;
    },
    logout() {
      //先清除session, 回到首页
      window.sessionStorage.clear();
      this.$router.push({ path: "/login" });
    },
    handleOpen(key, keyPath) {
      console.log(key, keyPath);
    },
    handleClose(key, keyPath) {
      console.log(key, keyPath);
    },
    //获取导航菜单
    async getMenuList(){
      const {data: res} = await this.$http.get("/menus");   
      if(200 == res.status){
        //返回的data不null
        return this.menuList = res.menus;
      }else{
        //返回的data是null
        this.$message.error("获取菜单栏失败！请刷新页面重试！");
      }
    },
    saveNavState(activePath){
      window.sessionStorage.setItem('activePath', activePath);// 存放点击的二级菜单
      this.activePath = activePath; // 给点击的菜单添加高亮
    },
  }
};
</script>

<style lang="less" scoped>
.home-container {
  height: 100%;
}
.el-header {
  background-color: #373d41;
  display: flex;
  justify-content: space-between;
  padding-left: 0%;
  align-items: center;
  color: #fff;
  font-size: 20px;
  > div {
    display: flex;
    align-items: center;
    span {
      margin-left: 20px;
    }
  }
}
.el-aside {
  background-color: #333744;
  .el-menu{
    border-right: 0;
  }
}
.el-main {
  background-color: #eaedf1;
}
.toggle-button{
  background-color: #4a5064;
  font-size: 10px;
  line-height: 24px;
  color: #fff;
  text-align: center;
  cursor: pointer;
  letter-spacing: 0.2rem;//字体间距 
}
</style>