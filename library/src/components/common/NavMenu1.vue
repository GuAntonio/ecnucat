<template xmlns:v-on="http://www.w3.org/1999/xhtml">
  <el-menu
    :default-active="'/index'"
    router
    mode="horizontal"
    background-color="white"
    text-color="#222"
    active-text-color="red"
    style="min-width: 1300px">
    <el-menu-item v-for="(item,i) in navList" :key="i" :index="item.name">
      {{ item.navItem }}
    </el-menu-item>
    <!--<a href="#nowhere" style="color: #222;float: right;padding: 20px;">更多功能</a>-->
    <i class="el-icon-switch-button" v-on:click="logout" style="float:right;font-size: 40px;color: #222;padding: 10px"></i>

    <i class="el-icon-menu" style="float:right;font-size: 45px;color: #222;padding-top: 8px"></i>
    <img src="../../assets/ecnu.jpg" alt="" width="100px" height="70px" style="float: left;margin-top: -5px">
    <img src="../../assets/qiantaidong.jpg" alt="" width="100px" height="70px" style="float: left;margin-top: -5px;">
    <span style="position: absolute;padding-top: 20px;right: 43%;font-size: 25px;font-weight: bold;font-family: 'Sitka Banner' ">华师大喵喵图鉴</span>
    <span style="position: absolute;padding-top: 20px;right: 13%;font-size: 20px;font-weight: bold">{{name1}}</span>

  </el-menu>
</template>

<script>

  export default {

    name: 'NavMenu',
    data () {
      return {
        navList: [
          {name: '/index', navItem: '首页'},
          {name: '/jotter', navItem: '匿名表白墙'},
          {name: '/library', navItem: '喵喵馆'},
          {name: '/admin', navItem: '个人中心'}
        ],
      name1:this.$store.state.user.username
      }
    },
    methods:{
      logout () {
        var _this = this
        this.$axios.get('/logout').then(resp => {
          if (resp.data.code === 200) {
            // 前后端状态保持一致
            _this.$store.commit('logout')
            _this.$router.replace('/login')
          }
        })
      }

    }
  }
</script>

<style scoped>
  a{
    text-decoration: none;
  }

  span {
    pointer-events: none;
  }
  .el-icon-switch-button {
    cursor: pointer;
    outline:0;
  }

</style>

