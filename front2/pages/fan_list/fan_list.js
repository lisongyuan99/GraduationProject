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
      'title': '粉丝列表',
      'color': true,
      'class': '0'
    },
    fansList: []
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

  getAllFans() {
    req.get({
      url: '/follower/all'
    }).then(res => {
      var list = res.data
      this.setData({
        fansList: list
      })
    }).catch(res => {
      wx.navigateBack()
    })
  },

  deleteFan(e) {
    var fanId = e.target.dataset.fanId
    console.log(fanId)
    wxp.showModal({
      title:'确认删除吗'
    }).then(res=>{
      if(res.confirm){
        console.log('确认')
        return req.post({
          url:'/follower/remove',
          data:fanId
        })
      } else if(res.cancel){
        console.log('取消')
      }
    }).then(res=>{
      console.log(res)
      wx.showToast({
        title: '删除成功',
      })
      this.getAllFans()
    }).catch(res=>{
      console.log(res)
      this.getAllFans()
    })
  }
})