<template>
  <div class="root-node">
    <el-form ref="form" :model="form" label-width="auto">
      <el-form-item class="item-content-center">
        <h1>登录</h1>
      </el-form-item>
      <el-form-item label="用户名">
        <el-input v-model="form.name"></el-input>
      </el-form-item>
      <el-form-item label="密码">
        <el-input v-model="form.password" show-password></el-input>
      </el-form-item>
      <el-form-item class="item-content-center">
        <el-button type="primary" @click="login" class="my-button">
          登录
        </el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<style scoped>
.root-node {
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}
.item-content-center{
  display: flex;
  align-items: center;
  justify-content: center;
}
</style>
<script>
export default {
  name: "Login",
  data() {
    return {
      form: {
        name: '',
        password: ''
      }
    }
  },
  methods: {
    login() {
      this.$api.login(this.form.name, this.form.password).then(res => {
        this.$store.commit('setToken', res.data)
        this.$router.push('/')
      }).catch(() => {
        this.form.password = ''
        // this.$message({})
      })
    },
    test() {
      this.$api.test()
          .then(res => {
            console.log(res)
          })
    }
  }
}
</script>

