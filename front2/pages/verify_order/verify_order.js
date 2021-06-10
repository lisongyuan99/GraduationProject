// pages/verify_order/verify_order.js
import req from '../../utils/req'
import util from '../../utils/util'
import time from '../../utils/time'
Page({

  /**
   * 页面的初始数据
   */
  data: {
    parameter: {
      'navbar': '1',
      'return': '1',
      'title': '扫码核验',
      'color': true,
      'class': '0'
    },
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    console.log(options)
    this.getActivity(options.id)
  },

  getActivity(id) {
    req.post({
      url: '/order/getById',
      data: id
    }).then(res => {
      this.prcessOrder(res.data)
      this.setData({
        activity: res.data.activity,
        order: res.data.order,
      })
      console.log(this.data)
    })
  },

  prcessOrder(e) {
    e.activity.region = util.getRegion(e.activity.regionCode)
    e.activity.fullAddress = e.activity.region + '\n' + e.activity.address
    e.activity.timeString = time.dateToFullString(time.utcToDate(e.activity.time))
    e.order.createTimeString = time.dateToFullString(time.utcToDate(e.order.createTime))
    if (e.order.payTime) {
      e.order.payTimeString = time.dateToFullString(time.utcToDate(e.order.payTime))
    }
    if (e.order.useTime) {
      e.order.useTimeString = time.dateToFullString(time.utcToDate(e.order.useTime))
    }
    if (e.order.refundTime) {
      e.order.refundTimeString = time.dateToFullString(time.utcToDate(e.order.refundTime))
    }
    e.order.priceString = '￥' + e.order.price.toFixed(2)
    e.order.sumPriceString = '￥' + (e.order.price * e.order.count).toFixed(2)
  },
  confirm() {
    console.log(this.data.order.id)
    req.post({
        url: '/order/check',
        data: this.data.order.id
      }).then(res => {
        return wx.showToast({
          title: '核销成功',
          icon: 'success',
          duration: 1500
        })
      }).then(() => {
        wx.navigateBack()
      })
      .catch(res => {
        return wx.showToast({
          title: '核销失败',
          icon: 'error',
          duration: 1500
        })
      }).then(() => {
        wx.navigateBack()
      })
  },
  cancel() {
    wx.navigateBack()
  }
})