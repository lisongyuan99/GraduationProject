import req from '../../utils/req'
import util from '../../utils/util'
import time from '../../utils/time'
Page({

  data: {
    parameter: {
      'navbar': '1',
      'return': '1',
      'title': '订单详情',
      'color': true,
      'class': '0'
    },
    steps: [],
    active: 2,
    order: {}
  },
  onLoad(options) {
    console.log(options.id)
    this.getInfo(options.id)
  },

  getInfo(id) {
    req.post({
      url: '/order/getById',
      data: id
    }).then(res => {
      console.log(res.data)
      this.prcessOrder(res.data)
      this.setData({
        order: res.data
      })
      console.log(this.data.order)
      this.processStep()
      console.log(this.data)
    })
  },
  // 修改后端数据,用于显示
  prcessOrder(e) {
    e.activity.region = util.getRegion(e.activity.regionCode)
    e.activity.fullAddress = e.activity.region + '\n' + e.activity.address
    e.activity.timeString = time.dateToFullString(time.utcToDate(e.activity.time))
    e.order.createTimeString = time.dateToFullString(time.utcToDate(e.order.createTime))
    if (e.order.payTime) {
      e.order.payTimeString = time.dateToFullString(time.utcToDate(e.order.payTime))
    }
    if (e.order.useTime) {
      e.order.useTimeString = time.dateToFullString(time.utcToDate(e.order.useTime))
    }
    if (e.order.refundTime) {
      e.order.refundTimeString = time.dateToFullString(time.utcToDate(e.order.refundTime))
    }
    e.order.priceString = '￥' + e.order.price.toFixed(2)
    e.order.sumPriceString = '￥' + (e.order.price * e.order.count).toFixed(2)
  },

  processStep() {
    let comment = ''
    if (this.data.order.comment) {
      comment = this.data.order.comment.text
    }
    let steps = [{
        text: '下单',
        desc: this.data.order.order.createTimeString,
      },
      {
        text: '付款',
        desc: this.data.order.order.payTimeString,
      },
      {
        text: '核验',
        desc: this.data.order.order.useTimeString,
      },
      {
        text: '评价',
        desc: '评价内容' + comment,
      },
    ]
    this.setData({
      steps: steps,
      active: this.data.order.order.status
    })
  }

})