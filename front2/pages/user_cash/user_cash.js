// pages/integral-details/index.js
const app=getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    parameter: {
      'navbar': '1',
      'return': '1',
      'title': '我的余额',
      'color': true,
      'class': '0'
    },
    current:0,
    page:1,
    limit:10,
    integralList:[{
      mark:'活动:光疗美甲',
      time:'2021-04-11 12:34',
      number:120,
    },{
      mark:'提现',
      time:'2021-04-11 12:34',
      number:-10,
    }],
    loadend:false,
    loading:false,
    loadTitle:'加载更多',
  },
  /**
   * 授权回调
  */
  onLoadFun:function(){
    this.getUserInfo();
    this.getIntegralList();
  },
  getUserInfo:function(){
    var that=this;
    postSignUser({sign: 1,integral: 1,all: 1}).then(function(res){
      that.setData({userInfo:res.data});
    });
  },

  /**
   * 获取积分明细
  */
  getIntegralList:function(){
    var that=this;
    if(that.data.loading) return;
    if(that.data.loadend) return;
    that.setData({loading:true,loadTitle:''});
    getIntegralList({ page: that.data.page, limit: that.data.limit }).then(function(res){
      var list=res.data,loadend=list.length < that.data.limit;
      that.data.integralList = app.SplitArray(list,that.data.integralList);
      that.setData({
        integralList: that.data.integralList,
        page:that.data.page+1,
        loading:false,
        loadend:loadend,
        loadTitle:loadend ? '哼~😕我也是有底线的~':"加载更多"
      });
    },function(res){
      that.setData({ loading: false, loadTitle:'加载更多'});
    });
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

  },
  
  nav:function(e){
     this.setData({
       current: e.currentTarget.dataset.idx
     })
  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {
    this.getIntegralList();
  }
})