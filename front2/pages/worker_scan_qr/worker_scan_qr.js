const { default: req } = require("../../utils/req")

// pages/worker_scan_qr/worker_scan_qr.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    parameter: {
      'navbar': '1',
      'return': '1',
      'title': '员工扫码',
      'color': true,
      'class': '0'
    },
  },

  scanQr(e) {
    // wx.navigateTo({
    //   url: '/pages/worker_main/worker_main',
    // })
    wx.scanCode()
      .then(res => {
        console.log(res.result)
        let result = JSON.parse(res.result)
        console.log(result.shopId)
        if (result.shopId) {
          return req.post({
            url:'/user/workerAdd',
            data: result.shopId
          })
        } else {
          throw '二维码格式错误'
        }
      }).then(res=>{
        wx.showToast({
          title: '加入商铺成功',
        })
        wx.navigateTo({
          url: '/pages/worker_info/worker_info?next=wait',
        })
      }).catch(res => {
        console.log(res)
        wx.showToast({
          title: '二维码格式错误',
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