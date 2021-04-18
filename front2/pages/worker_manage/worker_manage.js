import {
  wxp
} from '../../utils/wxp';
import req from '../../utils/req'
Page({

  /**
   * 页面的初始数据
   */
  data: {
    parameter: {
      'navbar': '1',
      'return': '1',
      'title': '员工管理',
      'color': true,
      'class': '0'
    },
    active: 0,
    workerList: [{
      id: 1,
      name: '张三',
      phone: '13812345678'
    }, {
      id: 2,
      name: '李四',
      phone: '13822345678'
    }, {
      id: 3,
      name: '王五',
      phone: '13832345678'
    }],
    newWorkerList: [{
      id: 1,
      name: '王二麻',
      phone: '13812345678'
    }]
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

  },

})