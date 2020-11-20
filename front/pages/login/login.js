// pages/auth/login.js
import myRequest from "../../utils/myRequest";

Page({
  data: {
    username: "",
    password: "",
    isPassword: true,
    icon: "closed-eye",
    errorMessage: "",
  },
  passwordIconClick: function () {
    if (this.data.isPassword) {
      this.setData({
        isPassword: false,
        icon: "eye-o"
      })
    } else {
      this.setData({
        isPassword: true,
        icon: "closed-eye"
      })
    }
  },
  login: function () {
    myRequest({
      url: "/auth/login",
      method: "POST",
      data: {
        username: this.data.username,
        password: this.data.password
      }
    }).then(res => {
      wx.showToast({title:"登录成功"})
      console.log(res)
      console.log(getApp().globalData)
      getApp().globalData.token = res.data.token
      getApp().globalData.user = res.data.organizer
      wx.redirectTo({
        url: '/pages/homepage/homepage'
      });
      console.log(getApp().globalData)
    }).catch(res => {
      this.setData({
        errorMessage: res.data.message,
        password:""
      })
    })
  }
})