// pages/homepage/homepage.js
import {wxp} from '../../utils/wxp'
import my from "../../utils/my";

Page({

  /**
   * 页面的初始数据
   */
  data: {
    canIUse: wx.canIUse('button.open-type.getUserInfo')
  },
  onLoad() {
  },
  bindGetUserInfo(e) {
    var userInfo
    var loginCode
    wxp.getSetting()
        .then(res => {
          if (!res.authSetting['scope.userInfo']) {
            throw new Error("需要授权")
          }
          return wxp.getUserInfo()
        })
        .then(res => {
          userInfo = res
          return wxp.login()
        })
        .then(res => {
          loginCode = res.code
          // console.log(userInfo)
          console.log(loginCode)
          return my.request2({
            url: "/auth/login",
            method: "POST",
            data: {
              code: loginCode
              // signature: userInfo.signature,
              // iv: userInfo.iv,
              // encryptedData: userInfo.encryptedData
            }
          })
        })
        .then(res => {
          console.log(res)
        })
  },
  tap() {
    // wxp.getSystemInfo().then(res => console.log('getSystemInfo', res))
  }
})