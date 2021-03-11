

const app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    // parameter: {
    //   'navbar': '1',
    //   'return': '1',
    //   'title': '评价列表',
    //   'color': false,
    // },
    parameter: {
      'navbar': '1',
      'return': '1',
      'title': '评价管理',
      'color': true,
      'class': '0'
    },
    replyData: {
      reply_star: 5,
      reply_chance: 100,
      sum_count: 10,
      good_count: 23,
      in_count: 3,
      poor_count: 7,
      sum_count: 8,
    },
    product_id: 0,
    reply: [
      {
        avatar:"/images/noOrder.png",
        nickname:"昵称",
        star:3,
        add_time:'2021-01-01',
        suk:'123',
        comment:'评论',
        pics:[
          '/images/noOrder.png',
          '/images/noSearch.png'
        ],
        merchant_reply_content:'回复'
      }
    ],
    type: 0,
    loading: false,
    loadend: false,
    loadTitle: '加载更多',
    page: 1,
    limit: 8
  },
  /**
   * 授权回调
   * 
   */
  onLoadFun: function () {
    // this.getProductReplyCount();
    // this.getProductReplyList();
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    // if(!options.product_id) return app.Tips({title:'缺少参数'},{tab:3,url:1});
    // this.setData({product_id:options.product_id});
  },
  /**
   * 获取评论统计数据
   * 
   */
  getProductReplyCount: function () {
    var that = this;
    getReplyConfig(that.data.product_id).then(res => {
      that.setData({
        replyData: res.data
      });
    });
  },
  /**
   * 分页获取评论
   */
  getProductReplyList: function () {
    var that = this;
    if (that.data.loadend) return;
    if (that.data.loading) return;
    that.setData({
      loading: true,
      loadTitle: ''
    });
    getReplyList(that.data.product_id, {
      page: that.data.page,
      limit: that.data.limit,
      type: that.data.type,
    }).then(res => {
      var list = res.data,
        loadend = list.length < that.data.limit;
      that.data.reply = app.SplitArray(list, that.data.reply);
      that.setData({
        reply: that.data.reply,
        loading: false,
        loadend: loadend,
        loadTitle: loadend ? "😕人家是有底线的~~" : "加载更多",
        page: that.data.page + 1
      });
    }).catch(err => {
      that.setData({
        loading: false,
        loadTitle: '加载更多'
      });
    });
  },
  /*
   * 点击事件切换
   * */
  changeType: function (e) {
    var type = e.target.dataset.type;
    type = parseInt(type);
    if (type == this.data.type) return;
    this.setData({
      type: type,
      page: 1,
      loadend: false,
      // reply: []
    });
    // this.getProductReplyList();
  },
  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {
    // this.getProductReplyList();
  },

})