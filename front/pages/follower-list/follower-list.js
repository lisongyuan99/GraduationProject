const {
  default: my
} = require("../../utils/my")
import {
  wxp
} from '../../utils/wxp'

// pages/follower-list/follower-list.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    followerList: []
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
    wxp.getStorage({
      key: 'token'
    }).then(res => {
      console.log(res.data)
      return my.req({
        url: "/follower/all",
        method: "POST",
        header: {
          'token': res.data
        },
        data: {}
      })
    }).then(res => {
      console.log(res)
      this.setData({
        followerList: res.data
      })
    })
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