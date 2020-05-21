<template>
  <div>
    <el-row style="height: 840px;">
      <search-bar @onSearch="searchResult" ref="searchBar"></search-bar>
      <el-tooltip effect="dark" placement="right"
                  v-for="item in books.slice((currentPage-1)*pagesize,currentPage*pagesize)"
                  :key="item.catId">
        <p slot="content" style="font-size: 14px;margin-bottom: 6px;">{{item.location}}</p>
        <p slot="content" style="font-size: 13px;margin-bottom: 6px">

          <span>健康状况：{{item.healthState}}</span>/
          <span>性格：{{item.tempr}}</span> /
          <span>外观：{{item.apper}}</span>/
          <span>被发现时间：{{item.seenTime}}</span>/
          <!--<span>链接：{{item.linktouser}}</span>/-->
          <span>绝育状态：{{item.sterState}}</span>/
          <span>绝育时间：{{item.sterTime}}</span>/


        </p>
        <p slot="content" style="width: 300px" class="abstract">和其他喵星人的关系：{{item.relation}}</p>
        <el-card style="width: 150px;margin-bottom: 20px;height: 245px;float: left;margin-right: 15px" class="book"
                 bodyStyle="padding:10px" shadow="hover">
          <div class="cover" @click="">
            <img :src="item.photo" alt="封面">
            <!--<img :id ="item.publicFileURL" :src="item.photo" @click="aaa(item)" >-->


          </div>
          <div class="info">
            <div class="title">
              <a href="">{{item.catName}}</a>
            </div>
            <i class="el-icon-star-off" @click="updateLikes(item.catId)"> {{item.likes}}</i>
          </div>
          <div class="author">{{item.sex}}</div>
          <div class="author">{{item.categoryName}}</div>
        </el-card>
      </el-tooltip>
      <!--<edit-form @onSubmit="loadBooks()" ref="edit"></edit-form>-->
    </el-row>
    <el-row>
      <el-pagination
        @current-change="handleCurrentChange"
        :current-page="currentPage"
        :page-size="pagesize"
        :total="books.length">
      </el-pagination>
    </el-row>
  </div>
</template>

<script>
  import EditForm from './EditForm'
  import SearchBar from './SearchBar'
  export default {
    components: {EditForm, SearchBar},
    data () {
      return {
        books: [],
        currentPage: 1,
        pagesize: 17
      }
    },
    mounted: function () {
      this.loadBooks()
      //this.loadBooksLikes()
    },
    methods: {
      aaa(item) {

        var viewer = new Viewer(document.getElementById(item.publicFileURL), {

          url: item.publicFileURL,

        });},
      loadBooksLikes (cid) {

        var obj=this.books.find(function (obj) {
          return obj.catId === cid
        })
        var url='/cat/getlikes/'+cid
        this.$axios.get(url).then(resp => {
          if (resp && resp.status === 200) {
            obj.likes = resp.data
          }
        })
      },

        loadBooks () {
        var _this = this
        this.$axios.get('/books').then(resp => {
          if (resp && resp.status === 200) {
            _this.books = resp.data
          }
        })
      },
      handleCurrentChange: function (currentPage) {
        this.currentPage = currentPage
        console.log(this.currentPage)
      },
      searchResult () {
        var _this = this
        this.$axios
          .get('/search?keywords=' + this.$refs.searchBar.keywords, {
          }).then(resp => {
          if (resp && resp.status === 200) {
            _this.books = resp.data
          }
        })
      },
      updateLikes (id) {
        var _this = this
        this.$confirm('此操作将永久喜欢该猫咪, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {

          var url='/cat/updatelikes/'+id
            this.$axios
              .get(url).then(resp => {
              if (resp && resp.status === 200) {
                this.loadBooksLikes(id)
              }
            })
          }
        ).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消喜欢'
          })
        })

        // alert(id)
      },
      editBook (item) {
        this.$refs.edit.dialogFormVisible = true
        this.$refs.edit.form = {
          catId:item.catId,
          catName:item.catName,
          photo:item.photo,
          location:item.location,
          sterState:item.sterState,
          tempr:item.tempr,
          sterTime:item.sterTime,
          apper:item.apper,
          seenTime:item.seenTime,
          relation:item.relation,
          linktouser:item.linktouser,
          sex:item.sex,
          healthState:item.healthState,
          finderId:item.finderId,
          categoryId:item.categoryId,
          categoryName:item.categoryName,



        }
      }
    }
  }
</script>
<style scoped>

  .cover {
    width: 115px;
    height: 172px;
    margin-bottom: 7px;
    overflow: hidden;
    cursor: pointer;
  }

  img {
    width: 115px;
    height: 172px;
    /*margin: 0 auto;*/
  }

  .title {
    font-size: 14px;
    text-align: left;
  }

  .author {
    color: #333;
    width: 102px;
    font-size: 13px;
    margin-bottom: 6px;
    text-align: left;
  }

  .abstract {
    display: block;
    line-height: 17px;
  }

  .el-icon-star-off {
    cursor: pointer;
    float: right;
  }

  .switch {
    display: flex;
    position: absolute;
    left: 780px;
    top: 25px;
  }

  a {
    text-decoration: none;
  }

  a:link, a:visited, a:focus {
    color: #3377aa;
  }

</style>

