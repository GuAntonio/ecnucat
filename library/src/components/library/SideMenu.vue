<template>
  <el-menu
    class="categories"
    default-active="0"
    @select="handleSelect"
    active-text-color="red">
    <el-menu-item index="0">
      <i class="el-icon-menu"></i>
      <span slot="title">全部</span>
    </el-menu-item>
    <el-menu-item index="1">
      <i class="el-icon-menu"></i>
      <span slot="title">美国短毛猫</span>
    </el-menu-item>
    <el-menu-item index="2">
      <i class="el-icon-menu"></i>
      <span slot="title">英国短毛猫</span>
    </el-menu-item>
    <el-menu-item index="3">
      <i class="el-icon-menu"></i>
      <span slot="title">布偶猫</span>
    </el-menu-item>
    <el-menu-item index="4">
      <i class="el-icon-menu"></i>
      <span slot="title">波斯猫</span>
    </el-menu-item>
    <el-menu-item index="5">
      <i class="el-icon-menu"></i>
      <span slot="title">加菲猫</span>
    </el-menu-item>
    <el-menu-item index="6">
      <i class="el-icon-menu"></i>
      <span slot="title">苏格兰折耳猫</span>
    </el-menu-item>
    <el-menu-item index="7">
      <i class="el-icon-menu"></i>
      <span slot="title">暹罗猫</span>
    </el-menu-item>
    <el-menu-item index="8">
      <i class="el-icon-menu"></i>
      <span slot="title">斯芬克斯猫</span>
    </el-menu-item>
    <el-menu-item index="9">
      <i class="el-icon-menu"></i>
      <span slot="title">卷毛猫</span>
    </el-menu-item>
    <el-menu-item index="10">
      <i class="el-icon-menu"></i>
      <span slot="title">未知</span>
    </el-menu-item>
    <el-menu-item index="11">
      <i class="el-icon-menu"></i>
      <span slot="title">狸花猫</span>
    </el-menu-item>
    <el-menu-item index="12">
      <i class="el-icon-menu"></i>
      <span slot="title">橘猫</span>
    </el-menu-item>
  </el-menu>
</template>

<script>
  export default {
    name: 'SideMenu',
    data () {
      return {
        cid: ''
      }
    },
    methods: {
      handleSelect (key, keyPath) {
        this.cid = key
        this.$emit('indexSelect')
      }
    }

  }
</script>

<style scoped>
  .categories {
    position: fixed;
    margin-left: 40%;
    left: -600px;
    top: 100px;
    width: 150px;
  }
</style>

