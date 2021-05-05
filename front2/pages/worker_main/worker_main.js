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
      'title': '员工',
      'color': true,
      'class': '0'
    },
    isLogin: false,
    nickName: null,
    avatarUrl: null,
    ec: {
      lazyLoad: true
    },
    // showChart: false,
    myChart: {},
    flag: true
  },

  onShow() {
    // req.get({
    //   url: '/auth/getHomepageCounts'
    // }).then(res => {
    //   this.setData({
    //     activityCount: res.data.activityCount,
    //     followerCount: res.data.followerCount,
    //     balance: res.data.balance,
    //     // showChart: true
    //   })
    // })
  },

  onReady() {
    
    // this.login()
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

  // 登录
  login(e) {
    console.log("login")
    wx.showLoading({
      title: '正在登录',
      mask: true
    })
    wx.login()
      .then(res => {
        console.log(res)
        return req.post({
          url: '/auth/login',
          data: res.code
        })
      }).then(res => {
        console.log(res)
        this.setData({
          isLogin: true,
          avatarUrl: res.data.avatarUrl,
          nickName: res.data.nickName,
          phone: res.data.phone
        })
        getApp().globalData.token = res.data.token
        return req.get({
          url: '/auth/getHomepageCounts'
        })
      }).then(res => {
        this.setData({
          activityCount: res.data.activityCount,
          followerCount: res.data.followerCount,
          balance: res.data.balance,
          // showChart: true
        })
        this.chart.clear()
        this.chart.setOption(this.getOption(res.data.data))
        wx.hideLoading()
        wx.showToast({
          title: '登录成功',
          icon: 'success'
        })
      })
      .catch(res => {
        console.log(res)
        wx.hideLoading()
        if (this.data.isLogin) {
          wx.showToast({
            title: '登录成功',
            icon: 'success'
          })
        } else {
          wx.showToast({
            title: '登录失败',
            icon: 'error'
          })
        }
      })
  },

  // 如果没有必要信息点击获取
  getUserProfile(e) {
    wx.getUserProfile({
      desc: '用户获取初始信息'
    }).then(res => {
      wx.showLoading({
        title: '正在获取用户信息',
        mask: true
      })
      console.log(res)
      this.setData({
        avatarUrl: res.userInfo.avatarUrl,
        nickName: res.userInfo.nickName
      })
      return req.post({
        url: '/auth/setWechatUserInfo',
        data: res.userInfo
      })
    }).then(res => {
      console.log(res)
      wx.hideLoading()
    }).catch(res => {
      console.log('fail')
      console.log(res)
      wx.hideLoading()
      wx.showToast({
        title: '无法获取',
        icon: 'error'
      })
    })
  },

  scanQr(e) {
    wx.scanCode()
      .then(res => {
        console.log(res.result)
        wx.navigateTo({
          url: '/pages/verify_order/verify_order?id=' + res.result,
        })
      }).catch(res => {
        console.log(res)
      })
  },
  // 初始化图表

})