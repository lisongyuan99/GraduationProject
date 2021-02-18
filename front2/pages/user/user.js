import {
  wxp
} from '../../utils/wxp'
import req from '../../utils/req'
const app = getApp();

Page({

  /**
   * 页面的初始数据
   */
  data: {
    parameter: {
      'navbar': '1',
      'return': '0',
      'title': '商家',
      'color': true,
      'class': '0'
    },
    isLogin: false,
    avatarUrl: '/images/noAvatar.svg'
  },

  /**
   * 授权回调
   */
  onLoadFun: function (e) {

  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

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
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },
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
  bindGetUserInfo(e) {
    let userInfo
    let loginCode
    wxp.getSetting()
      .then(res => {
        if (!res.authSetting['scope.userInfo']) {
          throw new Error('需要授权')
        }
        wx.showLoading({
          title: '正在登录',
          mask: true
        })
        return wxp.login();
      })
      .then(res => {
        loginCode = res.code;
        // console.log(res);
        return wxp.getUserInfo();
      })
      .then(res => {
        userInfo = res;
        // console.log(userInfo);
        return req.post({
          url: '/auth/login',
          data: {
            code: loginCode,
            signature: userInfo.signature,
            iv: userInfo.iv,
            encryptedData: userInfo.encryptedData
          }
        })
      })
      .then(res => {
        // console.log(res)
        this.setData({
          isLogin: true,
          avatarUrl: res.data.avatarUrl,
          nickname: res.data.nickname,
          motto: res.data.motto,
          phone: res.data.phone
        })
        getApp().globalData.token = res.data.token
        return req.get({
          url: '/auth/getHomepageCounts'
        })
      })
      .then(res => {
        // console.log(res)
        this.setData({
          activityCount: res.data.activityCount,
          followerCount: res.data.followerCount,
          orderCount: res.data.orderCount
        })
        wx.hideLoading()
      })
      .catch(res => {
        wx.hideLoading()
      })
  },

  click(e) {
    wxp.getSystemInfo().then(
      res => {
        console.log(res.SDKVersion)
      }
    )
  }

})