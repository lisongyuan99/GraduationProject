// pages/worker_qr/worker_qr.js
import drawQrcode from '../../utils/weapp.qrcode.esm.js'
Page({

  /**
   * 页面的初始数据
   */
  data: {
    parameter: {
      'navbar': '1',
      'return': '1',
      'title': '店铺二维码',
      'color': true,
      'class': '0'
    },
    shop: {
      avatar: "/images/noAvatar.svg",
      name: "XX公司",
      description: "商家简介：减少事务损耗和浪费，倡导健康生活"
    }
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
    wx.getSystemInfo().then(res => {
      console.log(res)
      let width = res.windowWidth*0.6
      drawQrcode({
        width: width,
        height: width,
        canvasId: 'qr-code',
        text: '测试文字',
        // v1.0.0+版本支持在二维码上绘制图片
      })
    })
    
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