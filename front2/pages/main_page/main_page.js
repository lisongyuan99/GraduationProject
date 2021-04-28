// pages/main_page/mainpage.js
import req from '../../utils/req'
Page({

  /**
   * 页面的初始数据
   */
  data: {
    parameter: {
      'navbar': '1',
      'return': '1',
      'title': '选择',
      'color': true,
      'class': '0'
    },
  },

  gotoShopReview() {
    wx.navigateTo({
      url: '/pages/shop_review/shop_review',
    })
  },

  gotoWorker() {
    wx.navigateTo({
      url: '/pages/worker_scan_qr/worker_scan_qr',
    })
  },

  login(e) {
    console.log("login")
    wx.showLoading({
      title: '正在登录',
      mask: true
    })
    wx.login().then(res => {
      return req.post({
        url: '/auth/login',
        data: res.code
      })
    }).then(res => {
      console.log(res.data)
      getApp().globalData.token = res.data.token
      if(res.data.shop){
        getApp().globalData.shop = res.data.shop
      }
      getApp().globalData.name = res.data.name
      getApp().globalData.phone = res.data.phone
      getApp().globalData.avatar = res.data.avatar
      if (res.data.type === 1) {
        // 老板
        if (res.data.shop) {
          let status = res.data.shop.status
          if (status === 0) {
            // 待审核
            wx.navigateTo({
              url: '/pages/wait/wait',
            })
          } else if (status === 1) {
            // 审核通过
            wx.navigateTo({
              url: '/pages/boss_main/boss_main',
            })
          } else if (status === 2) {
            // 审核未通过
            wx.showToast({
              title: '审核未通过',
              icon: 'error'
            })
          }
        }
      } else if(res.data.type === 2){
        // 员工已经通过
        wx.navigateTo({
          url: '/pages/worker_main/worker_main',
        })
      } else if(res.data.type === 3){
        // 员工尚未通过
        wx.navigateTo({
          url: '/pages/wait/wait',
        })
      }
      wx.hideLoading()
      wx.showToast({
        title: '登录成功',
        icon: 'success'
      })
    }).catch(res => {
      console.log(res)
      wx.showToast({
        title: '登录失败',
        icon: 'error'
      })
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
    this.login()
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})