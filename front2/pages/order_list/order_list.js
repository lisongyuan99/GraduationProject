const app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    parameter: {
      'navbar': '1',
      'return': '1',
      'title': '我的订单',
      'color': true,
      'class': '0'
    },
    type:-1,
    orderList:[{id:2},{id:3},{id:4},{id:5},{id:6}]
  },
  changeType(e) {
    this.setData({
      type: e.target.dataset.type
    })
  },
  goOrderDetails(e){
    console.log(e.currentTarget.dataset.id)
    wx.navigateTo({
      url: '/pages/order_details/order_details',
    })
  }
})