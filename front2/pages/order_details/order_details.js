const app = getApp();
Page({

  data: {
    parameter: {
      'navbar': '1',
      'return': '1',
      'title': '订单详情',
      'color': true,
      'class': '0'
    },
    steps: [{
        text: '下单',
        desc: '下单时间',
      },
      {
        text: '付款',
        desc: '付款时间',
      },
      {
        text: '核验',
        desc: '描述信息',
      },
      {
        text: '评价',
        desc: '描述信息',
      },
    ],
    active: 2,
    item: {
      "id": 60,
      "name": "测试",
      "image": "https://static.lsy99.cn/activity_publish/81e4739a9427578ca40ca728658dd4b886dcf6e276a99ec0c21c74cab4ed52ab_82131.jpg",
      "time": "2021-04-29 18:27",
      "position": "黑龙江省 哈尔滨市 南岗区",
      "free": true,
      "price": 0,
      "ori": 0,
      "count": 123,
      "category": "默认",
      "status": 2
    },
    reply: [
      {
        avatar:"/images/noOrder.png",
        nickname:"昵称",
        star:3,
        comment:'评论',
      }
    ],
  }
})