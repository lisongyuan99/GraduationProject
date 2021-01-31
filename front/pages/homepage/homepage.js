// pages/homepage/homepage.js
import {
  wxp
} from '../../utils/wxp'
import my from "../../utils/my";

Page({

  /**
   * 页面的初始数据
   */
  data: {
    canIUse: wx.canIUse('button.open-type.getUserInfo'),
    nickname: '',
    isLogin: false,
    avatarUrl: '/public/nopic.svg'
  },
  onLoad() {},
  bindGetUserInfo(e) {
    let userInfo
    let loginCode
    var app = getApp();
    wxp.getSetting()
      .then(res => {
        if (!res.authSetting['scope.userInfo']) {
          throw new Error("需要授权")
        }
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
        return my.req({
          url: "/auth/login",
          method: "POST",
          data: {
            code: loginCode,
            signature: userInfo.signature,
            iv: userInfo.iv,
            encryptedData: userInfo.encryptedData
          }
        })
      })
      .then(res => {
        console.log(res)
        if (res.statusCode == 200) {
          this.setData({
            avatarUrl: res.data.avatarUrl,
            isLogin: true,
            nickname: res.data.nickname
          })
          // app.globalData.token = res.data.token
          // console.log(app.globalData)
          wx.setStorage({
            data: res.data.token,
            key: 'token',
          })
        }
      })
  },
  tap() {
    
  }
})