import req from '../../utils/req'
import util from '../../utils/util'
import time from '../../utils/time'
import {
  wxp
} from '../../utils/wxp'

const app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    productList: [],
    debug:'not loaded',
    parameter: {
      'navbar': '1',
      'return': '1',
      'title': '活动列表',
      'color': true,
      'class': '0'
    },
    navH: "",
    is_switch: true,
    where: {
      sid: 0,
      keyword: '',
      priceOrder: '',
      salesOrder: '',
      news: 0,
      page: 1,
      limit: 10,
      cid: 0,
    },
    price: 0,
    stock: 0,
    nows: false,
    loadend: false,
    loading: false,
    loadTitle: '加载更多',
    userInfo: {}
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.getAllActivity()
  },
  /**
   * 商品详情跳转
   */
  goDetail: function (e) {
    // console.log(e.currentTarget.dataset.id)
    wx.navigateTo({
      url: '/pages/activity_preview/activity_preview?id=' + e.currentTarget.dataset.id
    })
  },
  Changswitch: function () {
    var that = this;
    that.setData({
      is_switch: !this.data.is_switch
    })
  },
  searchSubmit: function (e) {
    var that = this;
    this.setData({
      ['where.keyword']: e.detail.value,
      loadend: false,
      ['where.page']: 1
    })
    this.get_product_list(true);
  },
  getAllActivity() {
    wxp.showToast({
      title: '加载中',
      icon: 'loading'
    }).then(() => {
      return req.get({
        url: "/activity/my"
      })
    }).then(res => {
      console.log(res)
      let list = []
      for (let item of res.data) {
        list.push({
          id: item.id,
          name: item.name,
          image: item.pic,
          time: time.dateToFullString(time.utcToDate(item.date)),
          position: util.getRegion(item.regionCode) //item.regionCode
        })
      }
      
      this.setData({
        productList: list
      })
    })
  },

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
  // onPullDownRefresh: function () {
  //   this.setData({
  //     ['where.page']: 1,
  //     loadend: false,
  //     productList: []
  //   });
  //   this.get_product_list();
  //   wx.stopPullDownRefresh();
  // },

  /**
   * 页面上拉触底事件的处理函数
   */
  // onReachBottom: function () {
  //   this.get_product_list();
  // },
})