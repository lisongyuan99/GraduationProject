<template>
  <el-container>
    <el-header class="my-header">
      <el-page-header @back="goBack" content="活动审核"></el-page-header>
    </el-header>
    <el-main>
      <el-table :data="tableData" class="my-table" stripe>
        <el-table-column type="expand">
          <template v-slot="props">
            <el-form label-position="left" inline class="demo-table-expand">
              <el-form-item label="活动名称">
                <span>{{ props.row.activity.title }}</span>
              </el-form-item>
              <el-form-item label="活动简介">
                <span>{{ props.row.activity.subtitle }}</span>
              </el-form-item>
              <el-form-item label="时间">
                <span>{{ props.row.activity.timeString }}</span>
              </el-form-item>
              <el-form-item label="地区">
                <span>{{ props.row.activity.region }}</span>
              </el-form-item>
              <el-form-item label="详细地址">
                <span>{{ props.row.activity.positionDetail }}</span>
              </el-form-item>
              <el-form-item v-if="props.row.activity.notFree" label="价格">
                <span>{{ props.row.activity.price }}</span>
              </el-form-item>
              <el-form-item v-if="props.row.activity.notFree" label="原价">
                <span>{{ props.row.activity.priceOri }}</span>
              </el-form-item>
              <el-form-item label="数量">
                <span>{{ props.row.activity.sum }}</span>
              </el-form-item>
              <el-form-item label="图片">
                <span>
                  <el-image v-for="item in props.row.activity.imageList"
                            :key="item"
                            class="my-image" :src="item"
                            :preview-src-list="props.row.activity.imageList"
                            lazy>
                  </el-image>
                </span>
              </el-form-item>
              <el-form-item label="详情">
                <el-button type="text" @click="props.row.activity.dialogVisible = true">点击查看</el-button>
                <el-dialog title="详情" :visible.sync="props.row.activity.dialogVisible" width="50%">
                  <span v-html="props.row.activity.detail"></span>
                </el-dialog>
              </el-form-item>
            </el-form>
          </template>
        </el-table-column>
        <el-table-column label="活动名称" prop="activity.title">
        </el-table-column>
        <el-table-column label="活动简介" prop="activity.subtitle">
        </el-table-column>
        <el-table-column label="价格" prop="activity.price">
        </el-table-column>
        <el-table-column label="店铺" prop="shop.name">
        </el-table-column>
        <el-table-column label="操作" v-slot="scope">
          <el-button size="mini"
                     @click="handlePass(scope.row)">通过
          </el-button>
          <el-button size="mini" type="danger"
                     @click="handleDeny(scope.row)">拒绝
          </el-button>
        </el-table-column>
      </el-table>
    </el-main>
  </el-container>
</template>
<style scoped>
.my-header {
  display: flex;
  align-items: center;
}

.my-table {
  width: 100%;
  height: 100%;
}

.my-image {
  width: 100px;
  height: 100px;
}

.demo-table-expand {
  font-size: 0;
}

.demo-table-expand label {
  width: 90px;
  color: #99a9bf;
}

.demo-table-expand .el-form-item {
  margin-right: 0;
  margin-bottom: 0;
  width: 50%;
}
</style>
<script>
import util from "@/util/util";

export default {
  name: "Activity",
  methods: {
    goBack() {
      window.history.length > 1 ? this.$router.go(-1) : this.$router.push('/')
      // router.go(-1)
    },
    getAllActivity() {
      this.$api.getAllActivity().then(res => {
        let data = res.data
        for (let item of data) {
          if (item.activity) {
            item.activity.timeString = util.getTime(item.activity.beginTime)
            item.activity.region = util.getRegion(item.activity.positionCode)
            item.activity.notFree = !item.activity.free
            item.activity.imageList = util.split(item.activity.pics)
            item.activity.dialogVisible = false
          }
        }
        this.tableData = res.data
        console.log(this.tableData)
      }).catch(error => {
        console.log(error)
      })
    },
    handlePass(row) {
      console.log(row.activity.id)
      this.$api.passActivity(row.activity.id).then(res=>{
        console.log(res)
        this.$message({
          message: '已通过',
          type: 'success'
        })
        this.getAllActivity()
      })
    },
    handleDeny(row) {
      console.log(row.activity.id)
      this.$api.denyActivity(row.activity.id).then(res=>{
        console.log(res)
        this.$message({
          message: '已拒绝',
          type: 'success'
        })
        this.getAllActivity()
      })
    }
  },
  mounted() {
    this.getAllActivity()
  },
  data() {
    return {
      tableData: [],
      dialogVisible: false
    }
  }
}
</script>