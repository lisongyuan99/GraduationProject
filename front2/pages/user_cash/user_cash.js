import req from '../../utils/req'
import time from '../../utils/time'
Page({

  /**
   * 页面的初始数据
   */
  data: {
    parameter: {
      'navbar': '1',
      'return': '1',
      'title': '我的余额',
      'color': true,
      'class': '0'
    },
    balance: '0.00',
    withdraw: '0.00',
    today: '0.00',
    sum: '0.00',
    shopTopUp: false,
    showWithdraw: false,
    list: [],
    price:''
  },

  getInfo() {
    req.get({
      url: '/balance/getInfo'
    }).then(res => {
      console.log(res.data)
      // console.log(time.dateToDateString(time.utcToDate(res.data.expireDate)))
      let myBill = []
      for (let e of res.data.bills) {
        myBill.push({
          info: e.info,
          price: e.price.toFixed(2),
          time: time.dateToFullString(time.utcToDate(e.time)),
          orderId: e.orderId
        })
      }
      this.setData({
        list: myBill,
        balance: res.data.balance.toFixed(2),
        withdraw: res.data.withdraw.toFixed(2),
        today: res.data.today.toFixed(2),
        sum: res.data.sum.toFixed(2),
      })
      console.log(this.data)
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.getInfo()
  },
  openTopUp() {
    this.setData({
      price:'',
      showTopUp: true
    })
  },
  openWithdraw() {
    this.setData({
      price:'',
      showWithdraw: true
    })
  },
  empty(){},
  topUp(){
    req.post({
      url:'/balance/topUp',
      data: parseFloat(this.data.price)
    }).then(res=>{
      console.log(res)
      this.getInfo()
      wx.showToast({
        title: '充值成功',
        icon: 'success'
      })
    }).catch(res=>{

    })
  },
  withdraw(){
    req.post({
      url:'/balance/withdraw',
      data: parseFloat(this.data.price)
    }).then(res=>{
      this.getInfo()
      console.log(res)
      wx.showToast({
        title: '提现成功',
        icon: 'success'
      })
    }).catch(res=>{
      this.getInfo()
      console.log(res)
      wx.showToast({
        title: res.data.message,
        icon: 'error'
      })
    })
  }
})