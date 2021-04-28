<template>
  <div class="main">
    <h1>管理员审核</h1>
    <div class="buttons">
      <el-badge :value="shopCount" class="item">
        <div class="button-div" @click="goToShop">
          <i class="el-icon-office-building my-icon"></i>
          <div class="name">店铺审核</div>
        </div>
      </el-badge>
      <el-badge :value="activityCount" class="item">
        <div class="button-div" @click="goToActivity">
          <i class="el-icon-date my-icon"></i>
          <div class="name">活动审核</div>
        </div>
      </el-badge>
    </div>
  </div>
</template>
<style>
.main{
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}
.my-icon::before{
  font-size: 100px;
}
.button-div{
  width: 150px;
  height: 150px;
  display: flex;
  margin: 20px;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  cursor: pointer;
  border-radius: 10px;
  border-style: solid;
}
.button-div:hover{
  border-color: #409eff;
}
.button-div:hover .my-icon::before{
  color: #409eff
}
.button-div:hover .name{
  color: #409eff
}
</style>
<script>
export default {
  name: 'Main',
  data(){
    return{
      shopCount: null,
      activityCount: null
    }
  },
  methods:{
    goToShop(){
      this.$router.push('/shop')
    },
    goToActivity(){
      this.$router.push('/activity')
    }
  }
}

</script>
