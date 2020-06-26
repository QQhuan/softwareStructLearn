<template>
    <div class="container">
        <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item>权限管理</el-breadcrumb-item>
      <el-breadcrumb-item>分类管理</el-breadcrumb-item>
    </el-breadcrumb>
    <!-- 卡片视图区 -->
    <el-card> 
      <el-row :gutter="25">
        <el-tag
        :key="tag.id"
        v-for="tag in types"
        closable
        :disable-transitions="false"
        @close="handleClose(tag.id)"
        effect="light">
        {{tag.typeName}}
        </el-tag>
        <el-input
        class="input-new-tag"
        v-if="inputVisible"
        v-model="inputValue.typeName"
        ref="saveTagInput"
        size="medium"
        @keyup.enter.native="handleInputConfirm"
        @blur="handleInputConfirm"
        >
        </el-input>
        <el-button v-else class="button-new-tag" size="medium" @click="showInput">+ 添加分类</el-button>
      </el-row>
    </el-card>
    </div>
</template>
<script>
export default {
    data() {
      return {
        types: [],
        inputVisible: false,
        inputValue: {
            typeName: ''
        }
      };
    },
    created(){
        this.getTypes();
    },
    methods: {
      async handleClose(tagId) {
        const confirmResult = await this.$confirm('此操作将永久删除该商品, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).catch(err => err)
        // 成功删除为confirm 取消为 cancel
        if(confirmResult!='confirm'){
            return this.$message.info("已取消删除");
        }
        const {data:res} = await this.$http.delete("goodType/"+tagId);
        if (res != "success") {
            return this.$message.error("操作失败！！！");
        }
        this.$message.success("操作成功！！！");
        this.getTypes();
      },

      showInput() {
        this.inputVisible = true;
        this.$nextTick(_ => {
          this.$refs.saveTagInput.$refs.input.focus();
        });
      },

      async handleInputConfirm() {
        const {data:res} = await this.$http.post("goodType", this.inputValue);
        this.inputVisible = false;
        this.inputValue.typeName = '';
        this.getTypes();
      },
      async getTypes(){
        const {data: res} = await this.$http.get('goodType', {
            params: {
                query: "",
                pageNum: 1,
                pageSize: 1000
            }
        });    
        if(!res || !res.data) return;
        this.types = res.data; // 将返回数据赋值
        console.log(this.types)
      }
    }
}
</script>
<style lang="less" scoped>
.container{
    height: 100%;
}
.el-card{
    margin-top: 20px;
    height: 60%;
    padding: 5% 8%;
}
.el-tag + .el-tag {
    margin-left: 20px;
}
.button-new-tag {
    margin-left: 20px;
    height: 32px;
    line-height: 30px;
    padding-top: 0;
    padding-bottom: 0;
}
.input-new-tag {
    width: 90px;
    margin-left: 20px;
    vertical-align: bottom;
}
</style>