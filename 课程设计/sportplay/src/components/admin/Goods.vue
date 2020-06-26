<template>
  <div>
    <!-- 面包屑导航 -->
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item>权限管理</el-breadcrumb-item>
      <el-breadcrumb-item>商品模块</el-breadcrumb-item>
    </el-breadcrumb>
    <!-- 卡片视图区 -->
    <el-card>
      <el-row :gutter="25">
        <el-col :span="10">
          <!-- 搜索添加 -->
          <el-input placeholder="请输入搜索内容" v-model="queryInfo.query" disabled clearable @clear="getGoodList">
            <el-button slot="append" icon="el-icon-search" @click="getGoodList"></el-button>
          </el-input>
        </el-col>

        <el-col :span="8">
          <el-button type="primary" @click="addDialogVisible = true">添加商品</el-button>
          <el-button type="success" @click="exportExcel">导出商品</el-button>
        </el-col>
      </el-row>
      <!-- 用户列表 -->
      <el-table :data="goodlist" border stripe id="goodTable">
        <el-table-column type="index"></el-table-column>
        <el-table-column label="商品名称" prop="goodName"></el-table-column>
        <el-table-column label="分类" prop="goodType">
					<template slot-scope="scope">
						<el-tag disable-transitions>{{scope.row.goodType}}</el-tag>
					</template>
				</el-table-column>
        <el-table-column label="价格(￥)" prop="fee"></el-table-column>
        <el-table-column label="图片" prop="img">
					<template slot-scope="scope">
						<el-tag disable-transitions @click="look(scope.row.img)">点击查看</el-tag>
					</template>
				</el-table-column>
        <el-table-column label="操作">
          <template slot-scope="scope">
            <!-- 修改 -->
            <el-button type="primary" icon="el-icon-edit" size="mini" @click="showEditDialog(scope.row)"></el-button>
            <!-- 删除 -->
            <el-button type="danger" icon="el-icon-delete" size="mini" @click="deleteGood(scope.row.id)"></el-button>
            <!-- 上传图片 -->
            <el-button type="warning" icon="el-icon-upload" size="mini" @click="upload(scope.row.id)"></el-button>
          </template>
        </el-table-column>
      </el-table>
      <!-- 分页 -->
      <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="queryInfo.pageNum"
        :page-sizes="[1, 2, 5, 100]"
        :page-size="queryInfo.pageSize"
        layout="total, sizes, prev, pager, next, jumper"
        :total="total"
      ></el-pagination>
    </el-card>

    <!-- 创建新用户对话框 -->
    <el-dialog title="添加商品" :visible.sync="addDialogVisible" width="50%"
    @close="addDialogClosed">
      <!-- 内容主体区域 -->
      <el-form :model="addForm" :rules="addFormRules"
        ref="addFormRef" label-width="70px">
        <!-- 用户名 -->
        <el-form-item label="商品名称" prop="goodName">
          <el-input v-model="addForm.goodName"></el-input>
        </el-form-item>
        <!-- 密码 -->
        <el-form-item label="分类" prop="goodType">
          <el-select v-model="addForm.goodType" placeholder="请选择商品分类">
            <el-option :label="item.typeName" :value="item.id+''" v-for="item in types" :key="item.id"></el-option>
          </el-select>
        </el-form-item>
        <!-- 邮箱 -->
        <el-form-item label="价格" prop="fee">
          <el-input v-model="addForm.fee"></el-input>
        </el-form-item>
      </el-form>
      <!-- 内容底部区域 -->
      <span slot="footer" class="dialog-footer">
        <el-button @click="addDialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="addGood">确 定</el-button>
      </span>
    </el-dialog>
    <!-- 上传图片 -->
    <el-dialog title="添加图片" :visible.sync="uploadShow" width="50%"
    @close="uploadShow = false">
      <!-- 内容主体区域 -->
      <el-upload
        class="upload-demo"
        drag
        :on-change="before"
        :on-success="success"
        :with-credentials=true
        :action="url">
        <i class="el-icon-upload"></i>
        <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
        <div class="el-upload__tip" slot="tip">只能上传jpg/png文件，且不超过500kb</div>
      </el-upload>
    </el-dialog>
    <!-- 查看图片 -->
    <el-dialog title="查看图片" :visible.sync="picShow" width="50%"
    @close="picShow = false">
      <!-- 内容主体区域 -->
      <img :src="pic" alt="暂无图片" width="500">
    </el-dialog>
    <!-- 修改用户对话框 -->
    <el-dialog title="修改商品" :visible.sync="editDialogVisible" width="50%" @colse="editDialogClosed">
       <el-form :model="editForm" :rules="editFormRules" ref="editFormRef" label-width="70px">
        <el-form-item label="商品名" prop="goodName">
          <el-input v-model="editForm.goodName"></el-input>
        </el-form-item>
        <el-form-item label="分类" prop="goodType">
          <el-select v-model="editForm.goodType" placeholder="请选择商品分类">
            <el-option :label="item.typeName" :value="item.id+''" v-for="item in types" :key="item.id"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="价格" prop="fee">
          <el-input v-model="editForm.fee"></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="editDialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="editGoodInfo">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>
<script>
import FileSaver from 'file-saver'
import XLSX from 'xlsx'
export default {
  data() {
    return {
      url: '',
      pic: '',
      picShow: false,
      uploadShow: false,
      // 请求数据
      queryInfo: {
        query: "",
        pageNum: 1,
        pageSize: 5
      },
      goodlist: [],// 商品列表
			types: [], //分类表
      total: 0, // 最大数据记录
      addDialogVisible: false ,// 对话框显示
      // 添加用户表单项
      addForm: {
        goodName:'',
        fee:'',
        goodType:'',
      }, 
      // 控制修改用户对话框显示/隐藏
      editDialogVisible:false,
      // 修改用户信息
      editForm:{
				goodName:'',
        fee:'',
        goodType:'',
			},
      // 验证规则
      addFormRules:{
        goodName:[
           { required: true, message: "请输入商品名", trigger: "blur" },
          { min: 2, max: 8, message: "长度在 2 到 8 个字符", trigger: "blur" }
        ],
        goodType:[
           { required: true, message: "请选择分类", trigger: "blur" }
        ],
        fee:[
           { required: true, message: "请输入价格", trigger: "blur" }
        ],
      },
      // 修改用户表单验证规则
      editFormRules:{
          goodName:[
						{ required: true, message: "请输入商品名", trigger: "blur" },
						{ min: 2, max: 8, message: "长度在 2 到 8 个字符", trigger: "blur" }
					],
					goodType:[
						{ required: true, message: "请选择分类", trigger: "blur" }
					],
					fee:[
						{ required: true, message: "请输入价格", trigger: "blur" }
					],
      },
    };
  },
  created() {
    this.getGoodList();
    this.getGoodTypeList();
  },
  methods: {
    look(p){
      let u = `http://localhost:9000/getFile?path=${p}`;
      this.pic = u;
      this.picShow= true;
    },
    async getGoodList() {
      // 调用get请求
      const { data: res } = await this.$http.get("good", {
        params: this.queryInfo
      });
      this.goodlist = res.data; // 将返回数据赋值
      this.total = res.numbers; // 总个数
		},
		async getGoodTypeList() {
      // 调用get请求
      const { data: res } = await this.$http.get("goodType", {
        params: {
					query: "",
					pageNum: 1,
					pageSize: 1000
				}
      });
      this.types = res.data; // 将返回数据赋值
    },
    before(file, f){
      console.log(file)
    },
    upload(id){
      this.url = `http://localhost:9000/upload/${id}`;
      this.uploadShow = true;
    },
    success(){
      this.$message.success("上传成功!");
      this.getGoodList();
    },
    // 监听pageSize改变的事件
    handleSizeChange(newSize) {
      this.queryInfo.pageSize = newSize;
      this.getGoodList(); // 数据发生改变重新申请数据
    },
    // 监听pageNum改变的事件
    handleCurrentChange(newPage) {
      this.queryInfo.pageNum = newPage;
      this.getGoodList(); // 数据发生改变重新申请数据
    },
    // 监听添加用户
    addDialogClosed(){
      this.$refs.addFormRef.resetFields();// 重置表单项
    },
    // 添加商品
    addGood(){
        this.$refs.addFormRef.validate(async valid =>{
        console.log(valid);
        if( !valid ) return;
        // 发起请求
        const {data:res} = await this.$http.post("good",this.addForm);
        if (res != "success") {
        	return this.$message.error("操作失败！！！");
        }
        this.$message.success("操作成功！！！");
        //隐藏
        this.addDialogVisible = false;
        this.getGoodList();
      })
    },
    // 展示修改框
    async showEditDialog(row){
				console.log(row)
        this.editForm = row;
        this.editDialogVisible = true;
    },
    // 关闭窗口
    editDialogClosed(){
      this.$refs.editFormRef.resetFields();
    },
    // 确认修改
    editGoodInfo(){
      this.$refs.editFormRef.validate(async valid =>{
        console.log(valid);
        if( !valid ) return;
				// 发起请求
				console.log(this.editForm)
        const {data:res} = await this.$http.put("good", this.editForm);
        console.log(res);
         if (res != "success") return this.$message.error("操作失败！！！");
        this.$message.success("操作成功！！！");
        //隐藏
        this.editDialogVisible = false;
        this.getGoodList();
      });
    },
    // 删除按钮
    async deleteGood(id){
      // 弹框
      const confirmResult = await this.$confirm('此操作将永久删除该商品, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).catch(err => err)
      // 成功删除为confirm 取消为 cancel
      if(confirmResult!='confirm'){
        return this.$message.info("已取消删除");
      }
      const {data:res} = await this.$http.delete("good/"+id);
      if (res != "success") {
        return this.$message.error("操作失败！！！");
      }
      this.$message.success("操作成功！！！");
      this.getGoodList();
    },
    exportExcel () {
      //指定想要导出表格的id
      var wb = XLSX.utils.table_to_book(document.querySelector('#goodTable'))
      //数据写入
      var wbout = XLSX.write(wb, { bookType: 'xlsx', bookSST: true, type: 'array' })
      try {
        //表格的参数
        FileSaver.saveAs(new Blob([wbout], { type: 'application/octet-stream' }), 'goods.xlsx')
      } catch (e) { 
        if(typeof console !== 'undefined') 
          console.log(e, wbout) 
      }
      return wbout;
     },
  }
};
</script>
<style lang="less" scoped>
.el-card{
    margin-top: 10px;
}
.el-table{
    margin-top: 10px;
}
</style>