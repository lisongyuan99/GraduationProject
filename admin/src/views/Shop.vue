<template>
  <el-container>
    <el-header class="my-header">
      <el-page-header @back="goBack" content="商家审核"></el-page-header>
    </el-header>
    <el-main>
      <el-table :data="tableData" class="my-table" stripe>
        <el-table-column type="expand">
          <template v-slot="props">
            <el-form label-position="left" inline class="demo-table-expand">
              <el-form-item label="店铺名称">
                <span>{{ props.row.shop.name }}</span>
              </el-form-item>
              <el-form-item label="店铺简介">
                <span>{{ props.row.shop.description }}</span>
              </el-form-item>
              <el-form-item label="店铺地址">
                <span>{{ props.row.address }}</span>
              </el-form-item>
              <el-form-item label="店铺电话">
                <span>{{ props.row.boss.phone }}</span>
              </el-form-item>
              <el-form-item label="店铺头像">
                <span>
                  <el-image class="my-image" :src="props.row.shop.avatar"
                            :preview-src-list="[props.row.shop.avatar]"
                            lazy>
                  </el-image>
                </span>
              </el-form-item>
              <el-form-item label="营业执照">
                <span>
                  <el-image class="my-image" :src="props.row.shop.licnese"
                            :preview-src-list="[props.row.shop.licnese]"
                            lazy></el-image>
                </span>
              </el-form-item>
              <el-form-item label="店铺照片">
                <span>
                  <el-image v-for="item in props.row.pics" :key="item"
                            class="my-image" :src="item"
                            :preview-src-list="props.row.pics"
                            lazy>
                  </el-image>
                </span>
              </el-form-item>
            </el-form>
          </template>
        </el-table-column>
        <el-table-column label="店铺名称" prop="shop.name"></el-table-column>
        <el-table-column label="店铺简介" prop="shop.description"></el-table-column>
        <el-table-column label="店铺地址" prop="address"></el-table-column>
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
  name: "Shop",
  methods: {
    goBack() {
      window.history.length > 1 ? this.$router.go(-1) : this.$router.push('/')
      // router.go(-1)
    },
    getAllShop() {
      this.$api.getAllShop().then(res => {
        let data = res.data
        for (let item of data) {
          item.pics = util.split(item.shop.pictures)
          item.address = util.getRegion(item.shop.regionCode)
              + ' ' + item.shop.address
        }
        this.tableData = res.data
        console.log(this.tableData)
      }).catch(error => {
        console.log(error)
      })
    },
    handlePass(row) {
      this.$api.passShop(row.shop.id).then(res=>{
        console.log(res)
        this.$message({
          message: '已通过',
          type: 'success'
        })
        this.getAllShop()
      })

    },
    handleDeny(row) {
      this.$api.denyShop(row.shop.id).then(res=>{
        console.log(res)
        this.$message({
          message: '已拒绝',
          type: 'success'
        })
        this.getAllShop()
      })
    }
  },
  mounted() {
    this.getAllShop()
  },
  data() {
    return {
      tableData: [],
    }
  }
}
</script>