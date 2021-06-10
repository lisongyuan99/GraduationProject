import req from '../../utils/req'
import time from '../../utils/time'
Page({
  data: {
    parameter: {
      'navbar': '1',
      'return': '1',
      'title': '店铺会员',
      'color': true,
      'class': '0'
    },
    restDay: '0',
    lastRenew: '尚未开通会员',
    expireDate: '1970-01-01',
    list: [],
  },
  onLoad(options) {
    this.getInfo()
  },
  getInfo() {
    req.get({
      url: '/vip/getInfo'
    }).then(res => {
      // console.log(time.dateToDateString(time.utcToDate(res.data.expireDate)))
      let myBill = []
      for(let e of res.data.bills){
        myBill.push({
          info:e.info,
          price: e.price.toFixed(2),
          time: time.dateToFullString(time.utcToDate(e.time))
        })
      }
      let last = res.data.lastRenewDate ? time.dateToDateString(time.utcToDate(res.data.lastRenewDate)) : '尚未开通会员'
      this.setData({
        list: myBill,
        restDay: res.data.activeDay,
        expireDate: time.dateToDateString(time.utcToDate(res.data.expireDate)),
        lastRenew: last
      })
    })
  },
  renew1() {
    req.post({
      url: '/vip/renew',
      data: 'm'
    }).then(res => {
      console.log(res)
      this.getInfo()
    }).catch(res => {
      console.log(res)
      this.getInfo()
      wx.showToast({
        title:'余额不足',
        icon: 'error',
        duration: 1500
      })
    })
  },
  renew2() {
    req.post({
      url: '/vip/renew',
      data: 'y'
    }).then(res => {
      console.log(res)
      this.getInfo()
    }).catch(res => {
      this.getInfo()
      wx.showToast({
        title:'余额不足',
        icon: 'error',
        duration: 1500
      })
    })
  }

})