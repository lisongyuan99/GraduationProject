import {
  wxp
} from '../../utils/wxp'
import req from '../../utils/req'
import * as echarts from '../../ec-canvas/echarts';

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
    nickName: null,
    avatarUrl: null,
    ec: {
      lazyLoad: true
    },
    showChart: false,
    myChart: {},
    flag: true
  },

  onShow() {
    req.get({
      url: '/auth/getHomepageCounts'
    }).then(res => {
      this.setData({
        activityCount: res.data.activityCount,
        followerCount: res.data.followerCount,
        balance: res.data.balance,
        showChart: true
      })
    })
  },

  // 跳转
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

  // 登录
  login(e) {
    console.log("login")
    wx.showLoading({
      title: '正在登录',
      mask: true
    })
    wxp.login()
      .then(res => {
        console.log(res)
        return req.post({
          url: '/auth/login',
          data: res.code
        })
      }).then(res => {
        console.log(res)
        this.setData({
          isLogin: true,
          avatarUrl: res.data.avatarUrl,
          nickName: res.data.nickName,
          phone: res.data.phone
        })
        getApp().globalData.token = res.data.token
        return req.get({
          url: '/auth/getHomepageCounts'
        })
      }).then( res=>{
        this.setData({
          activityCount: res.data.activityCount,
          followerCount: res.data.followerCount,
          balance: res.data.balance,
          showChart: true
        })
        wx.hideLoading()
        wx.showToast({
          title: '登录成功',
          icon: 'success'
        })
      })
      .catch(res => {
        console.log(res)
        wx.hideLoading()
        wx.showToast({
          title: '登录失败',
          icon: 'error'
        })
      })
  },

  // 如果没有必要信息点击获取
  getUserProfile(e) {
    wxp.getUserProfile({
      desc: '用户获取初始信息'
    }).then(res => {
      wx.showLoading({
        title: '正在获取用户信息',
        mask: true
      })
      console.log(res)
      this.setData({
        avatarUrl: res.userInfo.avatarUrl,
        nickName: res.userInfo.nickName
      })
      return req.post({
        url: '/auth/setWechatUserInfo',
        data: res.userInfo
      })
    }).then(res => {
      console.log(res)
      wx.hideLoading()
    }).catch(res => {
      console.log('fail')
      console.log(res)
      wx.hideLoading()
      wx.showToast({
        title: '无法获取',
        icon: 'error'
      })
    })
  },

  getOption1() {
    var option = {
      title: {
        // text: '活动趋势'
      },
      tooltip: {},
      legend: {
        data: ['下单数量', '浏览数量']
      },
      xAxis: {
        data: ['2/15', '2/16', '2/17', '2/18', '2/19', '2/20', '2/21', ]
      },
      yAxis: [{
        position: 'left',
        type: 'value',
        name: '浏览数量',
      }, {
        position: 'right',
        type: 'value',
        name: '下单数量',
      }, ],
      series: [{
        name: '下单数量',
        type: 'bar',
        // yAxisIndex: '1',
        data: [1, 6, 10, 2, 3, 5, 2],
        itemStyle: {
          normal: {
            label: {
              show: true, //开启显示
            }
          }
        },
      }, {
        name: '浏览数量',
        type: 'line',
        // yAxisIndex: '0',
        data: [5, 20, 36, 10, 10, 20, 8],
        itemStyle: {
          normal: {
            label: {
              show: true, //开启显示
            }
          }
        },
      }]
    };
    return option
  },
  getOption2() {
    var data = [];
    var data2 = [];

    for (var i = 0; i < 10; i++) {
      data.push(
        [
          Math.round(Math.random() * 100),
          Math.round(Math.random() * 100),
          Math.round(Math.random() * 40)
        ]
      );
      data2.push(
        [
          Math.round(Math.random() * 100),
          Math.round(Math.random() * 100),
          Math.round(Math.random() * 100)
        ]
      );
    }

    var axisCommon = {
      axisLabel: {
        textStyle: {
          color: '#C8C8C8'
        }
      },
      axisTick: {
        lineStyle: {
          color: '#fff'
        }
      },
      axisLine: {
        lineStyle: {
          color: '#C8C8C8'
        }
      },
      splitLine: {
        lineStyle: {
          color: '#C8C8C8',
          type: 'solid'
        }
      }
    };

    var option = {
      color: ["#FF7070", "#60B6E3"],
      backgroundColor: '#eee',
      xAxis: axisCommon,
      yAxis: axisCommon,
      legend: {
        data: ['aaaa', 'bbbb']
      },
      visualMap: {
        show: false,
        max: 100,
        inRange: {
          symbolSize: [20, 70]
        }
      },
      series: [{
          type: 'scatter',
          name: 'aaaa',
          data: data
        },
        {
          name: 'bbbb',
          type: 'scatter',
          data: data2
        }
      ],
      animationDelay: function (idx) {
        return idx * 50;
      },
      animationEasing: 'elasticOut'
    };
    return option
  },

  // 测试
  init(e) {
    this.ecComponent.init((canvas, width, height, dpr) => {
      // 获取组件的 canvas、width、height 后的回调函数
      // 在这里初始化图表
      const chart = echarts.init(canvas, null, {
        width: width,
        height: height,
        devicePixelRatio: dpr // new
      });
      // 将图表实例绑定到 this 上，可以在其他成员函数（如 dispose）中访问
      this.chart = chart;
      // 注意这里一定要返回 chart 实例，否则会影响事件处理等
      return chart;
    });
    console.log("init")
  },

  click(e) {
    if (!this.chart) {
      this.init()
    } else {
      this.chart.clear()
      if (this.flag) {
        this.chart.setOption(this.getOption1())
      } else {
        this.chart.setOption(this.getOption2())
      }
      this.flag = !this.flag
    }
  },

  click2(e) {
    wxp.getUserProfile({
      desc: "123"
    }).then(res => {
      console.log(res)
    }).catch(res => {
      console.log(res)
    })
  },

  onReady() {
    this.ecComponent = this.selectComponent('#my-chart')
    this.login()
  },

})