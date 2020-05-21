<template>
  <el-container>
    <el-aside style="width: 200px;margin-top: 20px;">
      <switch></switch>
      <SideMenu @indexSelect="listByCategory" ref="sideMenu"></SideMenu>

    </el-aside>
    <el-main>
      <bookscantedit class="books-area" ref="booksArea"></bookscantedit>
    </el-main>
  </el-container>
</template>

<script>
  import SideMenu from './SideMenu'
  import Bookscantedit from './Bookscantedit'

  export default {
    name: 'AppLibrary',
    components: {SideMenu,Bookscantedit},
    methods: {
      listByCategory () {
        var _this = this
        var cid = this.$refs.sideMenu.cid
        var url = 'categories/' + cid + '/books'
        this.$axios.get(url).then(resp => {
          if (resp && resp.status === 200) {
            _this.$refs.booksArea.books = resp.data.result;
          }
        })
      }
    }

  }
</script>

<style scoped>

</style>

