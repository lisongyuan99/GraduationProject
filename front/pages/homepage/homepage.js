// pages/homepage/homepage.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    user: null,
    welcomeText: "点击登录"
  },
  onShow() {
    this.setData({user: getApp().globalData.user})
    let temp;
    if (this.data.user) {
      if (this.data.user.name) {
        temp = this.data.user.name
      } else {
        temp = this.data.user.username
      }
    } else {
      temp = "点击登录"
    }
    this.setData({welcomeText: temp})
  },
  welcomeTextClick() {
    if (!this.data.user) {
      wx.navigateTo({url: "/pages/login/login"})
    }
  }
})