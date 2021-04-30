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
    productListShow: [],
    debug: 'not loaded',
    parameter: {
      'navbar': '1',
      'return': '1',
      'title': '活动列表',
      'color': true,
      'class': '0'
    },
    allCategory: [],
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
    userInfo: {},
    type: 0
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    console.log(options)
    this.setData({
      ['where.sid']: options.sid || 0,
      title: options.title || '',
      ['where.keyword']: options.searchValue || '',
      navH: app.globalData.navHeight
    });
    this.getAllActivity()
  },
  changeType(e) {
    this.setData({
      type: e.target.dataset.type
    })
    this.changeShowProduct()
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
        url: '/activity/allCategory'
      })
    }).then(res => {
      // console.log(res)
      this.setData({
        allCategory: res.data
      })
      return req.get({
        url: "/activity/my"
      })
    }).then(res => {
      console.log(res)
      let list = []
      for (let item of res.data) {
        let lable = ''
        for (let category of this.data.allCategory) {
          // console.log(category, item.category)
          if (category.id === item.category) {
            lable = category.name
          }
        }
        list.push({
          id: item.id,
          name: item.name,
          image: item.pic,
          time: time.dateToFullString(time.utcToDate(item.date)),
          position: util.getRegion(item.regionCode), //item.regionCode
          free: item.free,
          price: item.price,
          ori: item.ori,
          count: item.count,
          category: lable,
          status: item.status
        })
      }
      this.setData({
        productList: list
      })
      this.changeShowProduct()
    })
  },
  changeShowProduct() {
    if (this.data.type == 0) {
      this.setData({
        productListShow: this.data.productList
      })
    } else {
      let temp = []
      let helper = [-1, 0, 2, 3]
      console.log()
      for (let e of this.data.productList) {
        if (helper[this.data.type] == e.status) {
          temp.push(e)
        }
      }
      this.setData({
        productListShow: temp
      })
      console.log(JSON.stringify(this.data.productListShow))
    }
  },
  onShow: function () {

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