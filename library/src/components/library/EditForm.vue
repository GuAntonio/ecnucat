<template>
  <div>
    <i class="el-icon-circle-plus-outline"  @click="dialogFormVisible = true"></i>
    <el-dialog
      title="添加/修改猫咪信息"
      :visible.sync="dialogFormVisible"
      @close="clear">
      <el-form v-model="form" style="text-align: left" ref="dataForm">
        <el-form-item label="喵喵名" :label-width="formLabelWidth" prop="title">
          <el-input v-model="form.catName" autocomplete="off" ></el-input>
        </el-form-item>
        <el-form-item label="出没地点" :label-width="formLabelWidth" prop="author">
          <el-input v-model="form.location" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="健康状况" :label-width="formLabelWidth" prop="date">
          <el-input v-model="form.healthState" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="性格" :label-width="formLabelWidth" prop="press">
          <el-input v-model="form.tempr" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="照片" :label-width="formLabelWidth" prop="cover">
          <el-input v-model="form.photo" autocomplete="off" placeholder="图片 URL"></el-input>
          <imgUpload @onUpload="uploadImg" ref="ImgUpload"></imgUpload>
        </el-form-item>
        <el-form-item label="外观" :label-width="formLabelWidth" prop="abs">
          <el-input type="textarea" v-model="form.apper" autocomplete="off"></el-input>
        </el-form-item>
          <el-form-item label="绝育状态" :label-width="formLabelWidth" prop="abs">
            <el-input type="textarea" v-model="form.sterState" autocomplete="off"></el-input>
          </el-form-item>
            <el-form-item label="绝育时间" :label-width="formLabelWidth" prop="abs">
              <el-input type="textarea" v-model="form.sterTime" autocomplete="off"></el-input>
            </el-form-item>
              <el-form-item label="被发现的时间" :label-width="formLabelWidth" prop="abs">
                <el-input type="textarea" v-model="form.seenTime" autocomplete="off"></el-input>
              </el-form-item>
        <el-form-item label="性别" :label-width="formLabelWidth" prop="abs">
          <el-input type="textarea" v-model="form.sex" autocomplete="off"></el-input>
        </el-form-item>
                <el-form-item label="与其他喵星人的关系" :label-width="formLabelWidth" prop="abs">
                  <el-input type="textarea" v-model="form.relation" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="分类" :label-width="formLabelWidth" prop="cid">
          <el-select v-model="form.categoryId" placeholder="请选择分类">
            <el-option label="全部" value="0"></el-option>
            <el-option label="美国短毛猫" value="1"></el-option>
            <el-option label="英国短毛猫" value="2"></el-option>
            <el-option label="布偶猫" value="3"></el-option>
            <el-option label="波斯猫" value="4"></el-option>
            <el-option label="加菲猫" value="5"></el-option>
            <el-option label="苏格兰折耳猫" value="6"></el-option>
            <el-option label="暹罗猫" value="7"></el-option>
            <el-option label="斯芬克斯猫" value="8"></el-option>
            <el-option label="卷毛猫" value="9"></el-option>
            <el-option label="未知" value="10"></el-option>
            <el-option label="狸花猫" value="11"></el-option>
            <el-option label="橘猫" value="12"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item prop="id" style="height: 0">
          <el-input type="hidden" v-model="form.catId" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="onSubmit">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
  import ImgUpload from './ImgUpload'
  export default {


    name: 'EditForm',
    components:{ImgUpload},
    data () {
      return {
        dialogFormVisible: false,
        form: {
          catId:"",
          catName:"",
          photo:"",
          location:"",
          sterState:"",
          tempr:"",
          sterTime:"",
          apper:"",
          seenTime:"",
          relation:"",
          linktouser:"",
          sex:"",
          healthState:"",
          finderId:"",
          categoryId:"10",
        },
        formLabelWidth: '120px'
      }
    },
    methods: {
      clear () {
        this.form = {
          catId:"",
          catName:"",
          photo:"",
          location:"",
          sterState:"",
          tempr:"",
          sterTime:"",
          apper:"",
          seenTime:"",
          relation:"",
          linktouser:"",
          sex:"",
          healthState:"",
          finderId:"",
          categoryId:"",
        }
      },
      onSubmit () {
        this.$axios
          .post('/books', {
            catId:this.form.catId,
            catName:this.form.catName,
            photo:this.form.photo,
            location:this.form.location,
            sterState:this.form.sterState,
            tempr:this.form.tempr,
            sterTime:this.form.sterTime,
            apper:this.form.apper,
            seenTime:this.form.seenTime,
            relation:this.form.relation,
            linktouser:this.form.linktouser,
            sex:this.form.sex,
            healthState:this.form.healthState,
            finderId:this.form.finderId,
            categoryId:this.form.categoryId,
          }).then(resp => {
          if (resp && resp.status === 200) {
            this.dialogFormVisible = false
            this.$emit('onSubmit')
          }
        })
      },
      uploadImg () {
        this.form.photo = this.$refs.ImgUpload.url
      }


    }
  }
</script>

<style scoped>
  .el-icon-circle-plus-outline {
    margin: 50px 0 0 20px;
    font-size: 100px;
    float: left;
    cursor: pointer;
  }
</style>


