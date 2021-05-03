import req from '../../utils/req'
import util from '../../utils/util'
import time from '../../utils/time'
Page({
  data: {
    parameter: {
      'navbar': '1',
      'return': '1',
      'title': '我的订单',
      'color': true,
      'class': '0'
    },
    type: -1,
    orderList: [],
    orderListDisplay: []
  },
  onLoad(options) {
    if (options.type == 'all') {
      this.getAllOrder()
    } else if (options.type = 'activity') {
      this.getActivityOrder(options.activity)
    }
  },
  // 获取所有订单
  getAllOrder() {
    req.get({
      url: '/order/getAll'
    }).then(res => {
      let orderList = res.data
      this.prcessOrder(orderList)
      this.setData({
        orderList: orderList
      })
      console.log(this.data.orderList)
      this.changeShowOrder()
    })
  },

  // 获取活动的订单
  getActivityOrder(id) {
    req.post({
      url: '/order/getByActivity',
      data: id
    }).then(res => {
      let orderList = res.data
      this.prcessOrder(orderList)
      this.setData({
        orderList: orderList
      })
      this.changeShowOrder()
    })
  },

  // 调整显示字段
  prcessOrder(orderList) {
    for (let e of orderList) {
      e.activity.region = util.getRegion(e.activity.regionCode)
      e.activity.fullAddress = e.activity.region + '\n' + e.activity.address
      e.activity.timeString = time.dateToFullString(time.utcToDate(e.activity.time))
      e.order.timeString = time.dateToFullString(time.utcToDate(e.order.createTime))
      e.order.priceString = '￥' + e.order.price.toFixed(2)
      e.order.sumPriceString = '￥' + (e.order.price * e.order.count).toFixed(2)
      let statusString = ''
      switch (e.order.status) {
        case 0:
          statusString = '未付款'
          break
        case 1:
          statusString = '已付款'
          break
        case 2:
          statusString = '已核销'
          break
        case 3:
          statusString = '已评价'
          break
      }
      e.order.statusString = statusString
    }
  },

  // 改变展示订单分类
  changeType(e) {
    let type = e.target.dataset.type
    this.setData({
      type: type
    })
    this.changeShowOrder()
  },

  // 处理展示的订单
  changeShowOrder() {
    let list = []
    let type = this.data.type
    if (type == -1) {
      for (let e of this.data.orderList) {
        list.push(e)
      }
    } else {
      for (let e of this.data.orderList) {
        if (type == e.order.status) {
          list.push(e)
        }
      }
    }
    this.setData({
      orderListDisplay: list
    })
  },

  // 订单详细信息界面
  goOrderDetails(e) {
    console.log(e.currentTarget.dataset.id)
    wx.navigateTo({
      url: '/pages/order_details/order_details?id=' + e.currentTarget.dataset.id,
    })
  }
})