const app = getApp();
import req from '../../utils/req'
import {
  wxp
} from '../../utils/wxp'

function countdown(that) {
  var second = that.data.second
  if (second == 0) {
    // console.log("Time Out...");
    //  that.setData({
    //   second: "Time Out..."
    //  });
    return;
  }
  setTimeout(function () {
    that.setData({
      second: second - 1
    });
    countdown(that);
  }, 1000)
}
Page({

  /**
   * 页面的初始数据
   */
  data: {
    parameter: {
      'navbar': '1',
      'return': '1',
      'title': '绑定手机号',
      'color': true,
      'class': '0'
    },
    disabled: false,
    active: false,
    second: 0,
    userInfo: {},
    phone: '',
    phoneCode: '',
    imagesCode: false,
    httpUrl: '',
    captchaimg: ''
  },

  // 发送验证码
  code() {
    if (this.data.phone.match(/^1[3-9]\d{9}$/)) {
      req.post({
        url: '/user/getPhoneCode',
        data: this.data.phone
      }).then(res => {
        // 倒计时
        this.setData({
          second: 10
        })
        countdown(this)
        wx.showToast({
          title: '验证码已发送'
        })
      }).catch(res => {
        wx.showToast({
          title: '发送错误',
          icon: 'error'
        })
      })
    } else {
      wx.showToast({
        title: '手机号格式错误',
        icon: 'error'
      })
    }
  },

  // 输入手机号改变
  phoneChange(e) {
    // console.log(e.detail.value)
    this.setData({
      phone: e.detail.value
    })
  },

  phoneCodeChange(e) {
    this.setData({
      phoneCode: e.detail.value
    })
  },

  // 提交
  submit() {
    req.post({
      url:'/user/verifyPhoneCode',
      data: {
        phoneNum: this.data.phone,
        code: this.data.phoneCode
      }
    }).then(res=>{
      console.log(res)
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {},

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

  inputGetName() {

  }

})