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
    workerList: [],
    newWorkerList: []
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
    this.getWorkerList()
  },

  onChange(){
    this.getWorkerList()
  },

  getWorkerList() {
    req.get({
      url: '/user/getWorker'
    }).then(res => {
      // console.log(res)
      this.setData({
        workerList: res.data
      })
      return req.get({
        url: '/user/getWorkerVerify'
      })
    }).then(res => {
      // console.log(res)
      this.setData({
        newWorkerList: res.data
      })
    })
  },

  accept(e) {
    wx.showModal({
      title: '确认接受'
    }).then(res => {
      if (res.confirm) {
        return req.post({
          url: '/user/passWorker',
          data: e.target.dataset.fanId
        })
      }
    }).then(res => {
      console.log(res)
      this.getWorkerList()
      wx.showToast({
        title: '已通过',
        icon: 'success'
      })
    })
  },

  deny(e) {
    // console.log(e.target.dataset.fanId)
    wx.showModal({
      title: '确认拒绝'
    }).then(res => {
      if (res.confirm) {
        return req.post({
          url: '/user/removeWorker',
          data: e.target.dataset.fanId
        })
      }
    }).then(res => {
      console.log(res)
      this.getWorkerList()
      wx.showToast({
        title: '已拒绝',
        icon: 'success'
      })
    })
  },

  remove(e) {
    // console.log(e.target.dataset.fanId)
    wx.showModal({
      title: '确认删除'
    }).then(res => {
      if (res.confirm) {
        return req.post({
          url: '/user/removeWorker',
          data: e.target.dataset.fanId
        })
      }
    }).then(res => {
      console.log(res)
      this.getWorkerList()
      wx.showToast({
        title: '已删除',
        icon: 'success'
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

  },

})