<template>
  <div>
    <!-- 面包屑导航 -->
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item>个人运动</el-breadcrumb-item>
      <el-breadcrumb-item>卡路里</el-breadcrumb-item>
    </el-breadcrumb>
    <!-- 卡片视图区 -->
    <el-card>
      <el-row :gutter="25">
          <el-button type="success" @click="exportExcel" style="margin-left:12px;">导出信息</el-button>
      </el-row>
      <!-- 用户列表 -->
      <el-table :data="kaloriesList" border stripe id="kaloriesTable">
        <el-table-column type="index"></el-table-column>
        <el-table-column label="用户名" prop="username"></el-table-column>
        <el-table-column label="打卡天数" prop="days">
            <template slot-scope="scope">
                <el-tag disable-transitions>{{scope.row.days+'天'}}</el-tag>
            </template>
        </el-table-column>
        <el-table-column label="燃烧/天">
            <template slot-scope="scope">
                <span>{{(scope.row.kalories/scope.row.days).toFixed(0)}}</span>
            </template>
        </el-table-column>
        <el-table-column label="总消耗卡路里" prop="kalories"></el-table-column>
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
  </div>
</template>
<script>
import FileSaver from 'file-saver'
import XLSX from 'xlsx'
export default {
  data() {
    return {
      // 请求数据
      queryInfo: {
        query: "",
        pageNum: 1,
        pageSize: 5
      },
      kaloriesList: [],// 商品列表
      total: 0, // 最大数据记录
    };
  },
  created() {
    this.getKalories();
  },
  methods: {
    async getKalories() {
      // 调用get请求
      const { data: res } = await this.$http.get("kalory", {
        params: this.queryInfo
      });
      this.kaloriesList = res.data; // 将返回数据赋值
      this.total = res.numbers; // 总个数
	},
    // 监听pageSize改变的事件
    handleSizeChange(newSize) {
      this.queryInfo.pageSize = newSize;
      this.getKalories(); // 数据发生改变重新申请数据
    },
    // 监听pageNum改变的事件
    handleCurrentChange(newPage) {
      this.queryInfo.pageNum = newPage;
      this.getKalories(); // 数据发生改变重新申请数据
    },
    exportExcel () {
      //指定想要导出表格的id
      var wb = XLSX.utils.table_to_book(document.querySelector('#kaloriesTable'))
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