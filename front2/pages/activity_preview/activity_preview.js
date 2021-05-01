import req from '../../utils/req'
import util from '../../utils/util'
import {
  wxp
} from '../../utils/wxp'
import time from '../../utils/time'
const app = getApp();

Page({

  /**
   * 页面的初始数据
   */
  data: {
    parameter: {
      'navbar': '1',
      'return': '1',
      'title': '活动预览',
      'color': true,
      'class': '0'
    },
    id: 0,
    activityInfo: {
      images: [
        '/images/noPic.svg',
        '/images/noAddress.png',
      ],
      title: '活动名称',
      description: '描述',
      time: '时间',
      position: '省市区',
      address: '地址',
      detail: '详细',
      userNum: 0
    },
    markers: [{
      id: 1,
      latitude: 36.77771,
      longitude: 114.49095,
    }],
    showSuggestion: false,
    addSuggestPrice: ''
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.setData({
      navH: app.globalData.navHeight,
      id: options.id
    });
  },
  onShow() {
    this.getActivityInfo(this.data.id)
  },
  // 获取商品信息
  getActivityInfo(id) {
    // console.log(id)
    req.post({
      url: '/activity/getById',
      data: id
    }).then(res => {
      console.log(res.data)
      let data = res.data
      this.setData({
        activityInfo: data,
        id: data.id
      })
      let timeString = time.dateToFullString(new Date(data.time))
      this.setData({
        'activityInfo.time': timeString
      })
      if (!data.free) {
        let price = util.fixTo2(data.price)
        let ori = util.fixTo2(data.ori)
        this.setData({
          'activityInfo.price': price,
          'activityInfo.ori': ori
        })
      }
      this.setData({
        markers: [{
          id: 1,
          latitude: data.lat,
          longitude: data.lng,
        }]
      })
    })
  },
  toOrderPage() {
    wx.navigateTo({
      url: "/pages/activity_order_list/activity_order_list?id=" + this.data.id
    })
  },
  editActivity() {
    wx.navigateTo({
      url: '/pages/activity_edit/activity_edit?id=' + this.data.id,
    })
  },
  deleteActivity() {
    wxp.showModal({
      title: '确认删除吗'
    }).then(res => {
      if (res.confirm) {
        // console.log('确认')
        return req.post({
          url: '/activity/delete',
          data: this.data.id
        })
      } else if (res.cancel) {
        // console.log('取消')
      }
    }).then(res => {
      console.log(res)
      if (res && res.statusCode == 200) {

      }
    })
  },
  openSuggestion() {
    this.setData({
      addSuggestPrice: '',
      showSuggestion: true
    })
  },
  empty() {

  },
  addSuggest(){
    console.log(parseFloat(this.data.addSuggestPrice))
  }
})