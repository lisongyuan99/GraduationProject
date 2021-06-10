import {
  wxp
} from '../../utils/wxp'
import req from '../../utils/req'
import time from '../../utils/time'

Page({

  /**
   * 页面的初始数据
   */
  data: {
    parameter: {
      'navbar': '1',
      // 'return': '0',
      'return': '1',
      'title': '商家',
      'color': true,
      'class': '0'
    },
    nickName: null,
    avatar: null,
    ec: {
      lazyLoad: true
    },
    // showChart: false,
    myChart: {},
    flag: true
  },

  onLoad() {

  },
  onShow() {
    this.getInfo()
  },

  getInfo() {
    req.get({
      url: '/user/getHomepageInfo'
    }).then(res => {
      console.log(res)
      this.setData({
        nickName: res.data.name,
        avatar: res.data.avatar,
        expire: res.data.expire,
        expireDate: time.dateToDateString(time.utcToDate(res.data.expireDate))
      })
    })
  },

  onReady() {
    // this.ecComponent = this.selectComponent('#my-chart')
    // if (!this.chart) {
    //   this.init()
    // }
  },

  // 跳转
  goPages: function (e) {
    if (e.currentTarget.dataset.url != '/pages/contact_us/contact_us' && !this.data.isLogin) {
      wx.showToast({
        title: '需要登录',
        icon: 'error'
      })
    } else {
      wx.navigateTo({
        url: e.currentTarget.dataset.url
      })
    }
  },

  scanQr(e) {
    wx.scanCode()
      .then(res => {
        console.log(JSON.parse(res.result))
        let qrResult = JSON.parse(res.result)
        let id
        if (qrResult.orderId) {
          id = parseInt(qrResult.orderId, 10)
        } else {
          throw new Error()
        }
        wx.navigateTo({
          url: '/pages/verify_order/verify_order?id=' + id,
        })
      }).catch(res => {
        wx.showToast({
          title: '二维码错误',
          icon: 'error',
          duration: 1500
        })
      })
  },


 
})