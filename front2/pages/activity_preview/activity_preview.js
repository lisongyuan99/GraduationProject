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
    attribute: {
      'cartAttr': false
    }, //属性是否打开
    reply: [{
      avatar: '/images/noOrder.png',
      nickname: '昵称',
      star: 3,
      add_time: '2021-01-01',
      suk: '123',
      comment: '评论',
      pics: [
        '/images/noOrder.png',
        '/images/noSearch.png'
      ],
      merchant_reply_content: '回复'
    }], //评论
    attr: '请选择', //属性页面提示
    attrValue: '', //已选属性
    animated: false, //购物车动画
    id: 0, //商品id
    replyCount: 0, //总评论数量

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
      // 'video_link': 123,
      // 'price': 123,
      // 'vip_price': 123,
      // 'ot_price': 123,
      // 'stock': 123,
      // 'unit_name': 123,
      // 'fsales': 123,
      // 'unit_name': 123,
      // 'give_integral': 13,
    }, //商品详情
    markers: [{
      id: 1,
      latitude: 36.77771,
      longitude: 114.49095,
    }],
    productAttr: [], //组件展示属性
    productValue: [], //系统属性
    couponList: [], //优惠券
    productSelect: {}, //属性选中规格
    cart_num: 1, //购买数量
    isAuto: false, //没有授权的不会自动授权
    iShidden: true, //是否隐藏授权
    isOpen: false, //是否打开属性组件
    isLog: app.globalData.isLog, //是否登录
    actionSheetHidden: true,
    posterImageStatus: false,
    storeImage: '', //海报产品图
    PromotionCode: '', //二维码图片
    canvasStatus: false, //海报绘图标签
    posterImage: '', //海报路径
    posterbackgd: '/images/posterbackgd.png',
    sharePacket: {
      isState: true, //默认不显示
      priceName: 0,
    }, //分销商详细
    uid: 0, //用户uid
    circular: false,
    autoplay: false,
    interval: 3000,
    duration: 500,
    clientHeight: '',
    systemStore: {}, //门店信息
    good_list: [],
    isDown: true,
    storeSelfMention: true,
    storeItems: {},
    storeList: [],
    activity: [],
    iSplus: true,
    navH: '',
    navList: [],
    opacity: 0,
    scrollY: 0,
    topArr: [],
    toView: '',
    height: 0,
    heightArr: [],
    lock: false,
    scrollTop: 0
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    console.log(options)
    this.setData({
      navH: app.globalData.navHeight,
      id: options.id
    });
    this.getActivityInfo(options.id)
    var that = this;
    //设置商品列表高度
    wx.getSystemInfo({
      success: function (res) {
        that.setData({
          height: res.windowHeight
          //res.windowHeight:获取整个窗口高度为px，*2为rpx；98为头部占据的高度；
        })
      },
    });
    //扫码携带参数处理
    if (options.scene) {
      var value = util.getUrlParams(decodeURIComponent(options.scene));
      if (value.id) options.id = value.id;
      //记录推广人uid
      if (value.pid) app.globalData.spid = value.pid;
    }
    // if (!options.id) return app.Tips({ title: '缺少参数无法查看商品' }, { tab: 3, url: 1 });
    this.setData({
      id: options.id
    });
    //记录推广人uid
    if (options.spid) app.globalData.spid = options.spid;
    this.getGoodsDetails();
    this.getList();
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
  returns: function () {
    wx.navigateBack();
  },
  tap: function (e) {
    var id = e.currentTarget.dataset.id;
    var index = e.currentTarget.dataset.index;
    var that = this;
    if (!this.data.good_list.length && id == 'past2') {
      id = 'past3'
    }
    this.setData({
      toView: id,
      navActive: index,
      lock: true,
      scrollTop: index > 0 ? that.data.topArr[index] - (app.globalData.navHeight / 2) : that.data.topArr[index]
    });
  },
  scroll: function (e) {
    var that = this,
      scrollY = e.detail.scrollTop;
    var opacity = scrollY / 200;
    opacity = opacity > 1 ? 1 : opacity;
    that.setData({
      opacity: opacity,
      scrollY: scrollY
    })
    if (that.data.lock) {
      that.setData({
        lock: false
      })
      return;
    }
    for (var i = 0; i < that.data.topArr.length; i++) {
      if (scrollY < that.data.topArr[i] - (app.globalData.navHeight / 2) + that.data.heightArr[i]) {
        that.setData({
          navActive: i
        });
        break
      }
    }
  },
  /**
   * 登录后加载
   * 
   */
  onLoadFun: function (e) {
    this.setData({
      isLog: true
    });
    // this.getCouponList();
    // this.getCartCount();
    // this.downloadFilePromotionCode();
    // this.getUserInfo();
    // this.get_product_collect();
  },
  ChangCouponsClone: function () {
    this.setData({
      'coupon.coupon': false
    });
  },
  goActivity: function (e) {
    let item = e.currentTarget.dataset.items;
    if (item.type === '1') {
      wx.navigateTo({
        url: `/pages/activity/goods_seckill_details/index?id=${item.id}&time=${item.time}&status=1`
      });
    } else if (item.type === '2') {
      wx.navigateTo({
        url: `/pages/activity/goods_bargain_details/index?id=${item.id}`
      });
    } else {
      wx.navigateTo({
        url: `/pages/activity/goods_combination_details/index?id=${item.id}`
      });
    }
  },
  /**
   * 商品详情跳转
   */
  goDetail: function (e) {
    let item = e.currentTarget.dataset.items;
    if (item.activity && item.activity.type === '1') {
      wx.navigateTo({
        url: `/pages/activity/goods_seckill_details/index?id=${item.activity.id}&time=${item.activity.time}&status=1`
      });
    } else if (item.activity && item.activity.type === '2') {
      wx.navigateTo({
        url: `/pages/activity/goods_bargain_details/index?id=${item.activity.id}`
      });
    } else if (item.activity && item.activity.type === '3') {
      wx.navigateTo({
        url: `/pages/activity/goods_combination_details/index?id=${item.activity.id}`
      });
    } else {
      wx.navigateTo({
        url: `/pages/goods_details/index?id=${item.id}`
      });
    }
  },
  /*
   * 跳转门店列表
   */
  showStoreList: function () {
    wx.navigateTo({
      url: '/pages/goods_details_store/index?go=details'
    })
  },
  /**
   * 获取门店列表数据
   */
  getList: function () {
    // let longitude = wx.getStorageSync(CACHE_LONGITUDE); //经度
    // let latitude = wx.getStorageSync(CACHE_LATITUDE); //纬度
    let data = {
      // latitude: latitude, //纬度
      // longitude: longitude, //经度
      page: 1,
      limit: 10
    }
    // storeListApi(data).then(res => {
    //   let list = res.data.list || [];
    //   this.setData({
    //     storeList: list,
    //     storeItems: list[0]
    //   });
    // }).catch(err => {

    // })
  },
  /*
   * 获取用户信息
   */
  getUserInfo: function () {
    var that = this;
    getUserInfo().then(res => {
      let isState = true;
      if ((res.data.is_promoter || res.data.statu == 2) && this.data.sharePacket.priceName != 0) {
        isState = false;
      }
      that.setData({
        'sharePacket.isState': isState,
        uid: res.data.uid
      });
    });
  },
  /**
   * 购物车手动填写
   * 
   */
  iptCartNum: function (e) {
    this.setData({
      ['productSelect.cart_num']: e.detail,
      cart_num: e.detail
    });
  },
  /**
   * 购物车数量加和数量减
   * 
   */
  ChangeCartNum: function (e) {
    //是否 加|减
    var changeValue = e.detail;
    //获取当前变动属性
    var productSelect = this.data.productValue[this.data.attrValue];
    //如果没有属性,赋值给商品默认库存
    if (productSelect === undefined && !this.data.productAttr.length) productSelect = this.data.productSelect;
    //不存在不加数量
    if (productSelect === undefined) return;

    if (this.data.cart_num) {
      productSelect.cart_num = this.data.cart_num;
    };
    //提取库存
    var stock = productSelect.stock || 0;
    //设置默认数据
    if (productSelect.cart_num == undefined) productSelect.cart_num = 1;
    //数量+
    if (changeValue) {
      productSelect.cart_num++;
      //大于库存时,等于库存
      if (productSelect.cart_num > stock) productSelect.cart_num = stock ? stock : 1;
      this.setData({
        ['productSelect.cart_num']: productSelect.cart_num,
        cart_num: productSelect.cart_num
      });
    } else {
      //数量减
      productSelect.cart_num--;
      //小于1时,等于1
      if (productSelect.cart_num < 1) productSelect.cart_num = 1;
      this.setData({
        ['productSelect.cart_num']: productSelect.cart_num,
        cart_num: productSelect.cart_num
      });
    }
  },
  /**
   * 属性变动赋值
   * 
   */
  ChangeAttr: function (e) {
    var values = e.detail;
    var productSelect = this.data.productValue[values];
    var activityInfo = this.data.activityInfo;
    this.setData({
      cart_num: 1
    })
    if (productSelect) {
      this.setData({
        ['productSelect.image']: productSelect.image,
        ['productSelect.price']: productSelect.price,
        ['productSelect.stock']: productSelect.stock,
        ['productSelect.unique']: productSelect.unique,
        ['productSelect.cart_num']: 1,
        attrValue: values,
        attr: '已选择'
      });
    } else {
      this.setData({
        ['productSelect.image']: activityInfo.image,
        ['productSelect.price']: activityInfo.price,
        ['productSelect.stock']: 0,
        ['productSelect.unique']: '',
        ['productSelect.cart_num']: 1,
        attrValue: '',
        attr: '请选择'
      });
    }
  },
  /**
   * 领取完毕移除当前页面领取过的优惠券展示
   */
  ChangCoupons: function (e) {
    var coupon = e.detail;
    var couponList = util.ArrayRemove(this.data.couponList, 'id', coupon.id);
    this.setData({
      couponList: couponList
    });
  },

  setClientHeight: function () {
    if (!this.data.good_list.length) return;
    var query = wx.createSelectorQuery().in(this);
    query.select('#list0').boundingClientRect();
    var that = this;
    query.exec(function (res) {
      that.setData({
        clientHeight: res[0].height + 20
      });
    });
  },
  infoScroll: function () {
    var that = this,
      topArr = [],
      heightArr = [];
    for (var i = 0; i < that.data.navList.length; i++) { //productList
      //获取元素所在位置
      var query = wx.createSelectorQuery().in(this);
      var idView = '#past' + i;
      if (!that.data.good_list.length && i == 2) {
        var idView = '#past' + 3;
      }
      query.select(idView).boundingClientRect();
      query.exec(function (res) {
        var top = res[0].top;
        var height = res[0].height;
        topArr.push(top);
        heightArr.push(height);
        that.setData({
          topArr: topArr,
          heightArr: heightArr
        });
      });
    };
  },
  /**
   * 获取产品详情
   * 
   */
  getGoodsDetails: function () {
    var that = this;
    // getProductDetail(that.data.id).then(res => {
    //   var activityInfo = res.data.activityInfo;
    //   var good_list = res.data.good_list || [];
    //   var count = Math.ceil(good_list.length / 6);
    //   var goodArray = new Array();
    //   for (var i = 0; i < count; i++) {
    //     var list = good_list.slice(i * 6, i * 6 + 6);
    //     if (list.length) goodArray.push({
    //       list: list
    //     });
    //   }
    //   that.setData({
    //     activityInfo: activityInfo,
    //     reply: res.data.reply ? [res.data.reply] : [],
    //     replyCount: res.data.replyCount,
    //     description: activityInfo.description,
    //     replyChance: res.data.replyChance,
    //     productAttr: res.data.productAttr,
    //     productValue: res.data.productValue,
    //     ['sharePacket.priceName']: res.data.priceName,
    //     // ['parameter.title']: activityInfo.store_name,
    //     systemStore: res.data.system_store,
    //     storeSelfMention: res.data.store_self_mention,
    //     good_list: goodArray,
    //     activity: res.data.activity ? res.data.activity : []
    //   });
    //   var navList = ['商品', '评价', '详情'];
    //   if (goodArray.length) {
    //     navList.splice(2, 0, '推荐')
    //   }
    //   that.setData({
    //     navList: navList
    //   });
    //   if (app.globalData.isLog) {
    //     that.getUserInfo();
    //   }
    //   that.downloadFilestoreImage();
    //   that.DefaultSelect();
    //   setTimeout(function () {
    //     that.setClientHeight();
    //   }, 500);
    //   setTimeout(function () {
    //     that.infoScroll();
    //   }, 500);
    //   //html转wxml
    //   WxParse.wxParse('description', 'html', that.data.description, that, 0);
    // }).catch(err => {
    //   //状态异常返回上级页面
    //   return app.Tips({
    //     title: err.toString()
    //   }, {
    //     tab: 3,
    //     url: 1
    //   });
    // })
  },
  goPages: function (e) {
    wx.navigateTo({
      url: 'pages/goods_details/index?id=' + e.currentTarget.dataset.id
    });
  },
  /**
   * 拨打电话
   */
  makePhone: function () {
    wx.makePhoneCall({
      phoneNumber: this.data.systemStore.phone
    })
  },
  /**
   * 打开地图
   * 
   */
  showMaoLocation: function () {
    if (!this.data.systemStore.latitude || !this.data.systemStore.longitude) return app.Tips({
      title: '缺少经纬度信息无法查看地图！'
    });
    wx.openLocation({
      latitude: parseFloat(this.data.systemStore.latitude),
      longitude: parseFloat(this.data.systemStore.longitude),
      scale: 8,
      name: this.data.systemStore.name,
      address: this.data.systemStore.address + this.data.systemStore.detailed_address,
      success: function () {

      },
    });
  },
  /**
   * 默认选中属性
   * 
   */
  DefaultSelect: function () {
    var productAttr = this.data.productAttr,
      activityInfo = this.data.activityInfo,
      productValue = this.data.productValue,
      value = [];
    for (var key in productValue) {
      if (productValue[key].stock > 0) {
        value = this.data.productAttr.length ? key.split(',') : [];
        break;
      }
    }
    for (var i = 0, len = productAttr.length; i < len; i++) {
      if (productAttr[i].attr_value[0]) productAttr[i].checked = value[i];
    };
    var productSelect = this.data.productValue[value.sort().join(',')];
    if (productSelect) {
      this.setData({
        ['productSelect.store_name']: activityInfo.store_name,
        ['productSelect.image']: productSelect.image,
        ['productSelect.price']: productSelect.price,
        ['productSelect.stock']: productSelect.stock,
        ['productSelect.unique']: productSelect.unique,
        ['productSelect.cart_num']: 1,
        attrValue: value,
        attr: '已选择'
      });
    } else {
      this.setData({
        ['productSelect.store_name']: activityInfo.store_name,
        ['productSelect.image']: activityInfo.image,
        ['productSelect.price']: activityInfo.price,
        ['productSelect.stock']: this.data.productAttr.length ? 0 : activityInfo.stock,
        ['productSelect.unique']: '',
        ['productSelect.cart_num']: 1,
        attrValue: '',
        attr: '请选择'
      });
    }
    this.setData({
      productAttr: productAttr,
      cart_num: 1
    });
  },
  /**
   * 获取是否收藏
   */
  get_product_collect: function () {
    var that = this;
    // getProductDetail(that.data.id).then(res => {
    //   that.setData({
    //     'activityInfo.userCollect': res.data.activityInfo.userCollect
    //   });
    // });
  },
  /**
   * 获取优惠券
   * 
   */
  getCouponList() {
    var that = this;
    getCoupons({
      page: 1,
      limit: 10,
      type: 1,
      product_id: that.data.id
    }).then(res => {
      var couponList = [];
      for (var i = 0; i < res.data.length; i++) {
        if (!res.data[i].is_use && couponList.length < 2) couponList.push(res.data[i]);
      }
      that.setData({
        ['coupon.list']: res.data,
        couponList: couponList
      });
    });
  },
  /** 
   * 
   * 
   * 收藏商品
   */
  setCollect: function () {
    if (app.globalData.isLog === false) {
      this.setData({
        isAuto: true,
        iShidden: false,
      });
    } else {
      var that = this;
      if (this.data.activityInfo.userCollect) {
        collectDel(this.data.activityInfo.id).then(res => {
          that.setData({
            ['activityInfo.userCollect']: !that.data.activityInfo.userCollect
          })
        })
      } else {
        collectAdd(this.data.activityInfo.id).then(res => {
          that.setData({
            ['activityInfo.userCollect']: !that.data.activityInfo.userCollect
          })
        })
      }
    }
  },
  /**
   * 打开属性插件
   */
  selecAttr: function () {
    if (app.globalData.isLog === false)
      this.setData({
        isAuto: true,
        iShidden: false
      })
    else
      this.setData({
        'attribute.cartAttr': true,
        isOpen: true
      })
  },
  /**
   * 打开优惠券插件
   */
  coupon: function () {
    if (app.globalData.isLog === false)
      this.setData({
        isAuto: true,
        iShidden: false
      })
    else {
      this.getCouponList();
      this.setData({
        'coupon.coupon': true
      })
    }
  },
  onMyEvent: function (e) {
    this.setData({
      'attribute.cartAttr': e.detail.window,
      isOpen: false
    });
  },
  /**
   * 打开属性加入购物车
   * 
   */
  joinCart: function (e) {
    //是否登录
    if (app.globalData.isLog === false)
      this.setData({
        isAuto: true,
        iShidden: false,
      });
    else {
      this.goCat();
    }
  },
  /*
   * 加入购物车
   */
  goCat: function (isPay) {
    var that = this;
    var productSelect = this.data.productValue[this.data.attrValue];
    //打开属性
    if (this.data.attrValue) {
      //默认选中了属性，但是没有打开过属性弹窗还是自动打开让用户查看默认选中的属性
      this.setData({
        'attribute.cartAttr': !this.data.isOpen ? true : false
      })
    } else {
      if (this.data.isOpen)
        this.setData({
          'attribute.cartAttr': true
        })
      else
        this.setData({
          'attribute.cartAttr': !this.data.attribute.cartAttr
        });
    }
    //只有关闭属性弹窗时进行加入购物车
    if (this.data.attribute.cartAttr === true && this.data.isOpen == false) return this.setData({
      isOpen: true
    });
    //如果有属性,没有选择,提示用户选择
    if (this.data.productAttr.length && productSelect === undefined && this.data.isOpen == true) return app.Tips({
      title: '请选择属性'
    });
    if (!that.data.cart_num || parseInt(that.data.cart_num) <= 0) return app.Tips({
      title: '请输入购买数量'
    });
    postCartAdd({
      productId: that.data.id,
      cartNum: that.data.cart_num,
      uniqueId: productSelect !== undefined ? productSelect.unique : '',
      'new': isPay === undefined ? 0 : 1,
    }).then(res => {
      that.setData({
        isOpen: false,
        'attribute.cartAttr': false
      });
      if (isPay)
        wx.navigateTo({
          url: '/pages/order_confirm/index?cartId=' + res.data.cartId
        });
      else
        app.Tips({
          title: '添加购物车成功',
          icon: 'success'
        }, function () {
          that.getCartCount(true);
        });
    }).catch(err => {
      return app.Tips({
        title: err
      });
    });
  },
  /**
   * 获取购物车数量
   * @param boolean 是否展示购物车动画和重置属性
   */
  getCartCount: function (isAnima) {
    var that = this;
    getCartCounts().then(res => {
      that.setData({
        CartCount: res.data.count
      });
      //加入购物车后重置属性
      if (isAnima) {
        that.setData({
          animated: true,
          attrValue: '',
          attr: '请选择',
          ['productSelect.image']: that.data.activityInfo.image,
          ['productSelect.price']: that.data.activityInfo.price,
          ['productSelect.stock']: that.data.activityInfo.stock,
          ['productSelect.unique']: '',
          ['productSelect.cart_num']: 1,
          cart_num: 1
        });
        that.selectComponent('#product-window').ResetAttr();
        setTimeout(function () {
          that.setData({
            animated: false
          });
        }, 500);
      }
    });
  },
  /**
   * 立即购买
   */
  goBuy: function (e) {
    if (app.globalData.isLog === false)
      this.setData({
        isAuto: true,
        iShidden: false
      });
    else
      this.goCat(true);
  },
  /**
   * 分享打开和关闭
   * 
   */
  listenerActionSheet: function () {
    if (app.globalData.isLog === false)
      this.setData({
        isAuto: true,
        iShidden: false
      });
    else
      this.setData({
        actionSheetHidden: !this.data.actionSheetHidden
      })
  },
  //隐藏海报
  posterImageClose: function () {
    this.setData({
      posterImageStatus: false,
    })
  },
  //替换安全域名
  setDomain: function (url) {
    url = url ? url.toString() : '';
    //本地调试打开,生产请注销
    // return url;
    if (url.indexOf('https://') > -1) return url;
    else return url.replace('http://', 'https://');
  },
  //获取海报产品图
  downloadFilestoreImage: function () {
    var that = this;
    wx.downloadFile({
      url: that.setDomain(that.data.activityInfo.image),
      success: function (res) {
        that.setData({
          storeImage: res.tempFilePath
        })
      },
      fail: function () {
        return app.Tips({
          title: ''
        });
        that.setData({
          storeImage: '',
        })
      },
    });
  },
  /**
   * 获取产品分销二维码
   * @param function successFn 下载完成回调
   * 
   */
  downloadFilePromotionCode: function (successFn) {
    var that = this;
    getProductCode(this.data.id).then(res => {
      wx.downloadFile({
        url: that.setDomain(res.data.code),
        success: function (res) {
          that.setData({
            isDown: false
          });
          if (typeof successFn == 'function')
            successFn && successFn(res.tempFilePath);
          else
            that.setData({
              PromotionCode: res.tempFilePath
            });
        },
        fail: function () {
          that.setData({
            isDown: false
          });
          that.setData({
            PromotionCode: ''
          });
        },
      });
    }).catch(err => {
      that.setData({
        isDown: false
      });
      that.setData({
        PromotionCode: ''
      });
    });
  },
  /**
   * 生成海报
   */
  goPoster: function () {
    var that = this;
    that.setData({
      canvasStatus: true
    });
    var arr2 = [that.data.posterbackgd, that.data.storeImage, that.data.PromotionCode];
    if (that.data.isDown) return app.Tips({
      title: '正在下载海报,请稍后再试！'
    });
    wx.getImageInfo({
      src: that.data.PromotionCode,
      fail: function (res) {
        return app.Tips({
          'title': '小程序二维码需要发布正式版后才能获取到'
        });
      },
      success() {
        if (arr2[2] == '') {
          //海报二维码不存在则从新下载
          that.downloadFilePromotionCode(function (msgPromotionCode) {
            arr2[2] = msgPromotionCode;
            if (arr2[2] == '') return app.Tips({
              title: '海报二维码生成失败！'
            });
            util.PosterCanvas(arr2, that.data.activityInfo.store_name, that.data.activityInfo.price, function (tempFilePath) {
              that.setData({
                posterImage: tempFilePath,
                posterImageStatus: true,
                canvasStatus: false,
                actionSheetHidden: !that.data.actionSheetHidden
              })
            });
          });
        } else {
          //生成推广海报
          util.PosterCanvas(arr2, that.data.activityInfo.store_name, that.data.activityInfo.price, function (tempFilePath) {
            that.setData({
              posterImage: tempFilePath,
              posterImageStatus: true,
              canvasStatus: false,
              actionSheetHidden: !that.data.actionSheetHidden
            })
          });
        }
      },
    });
  },
  /*
   * 保存到手机相册
   */
  savePosterPath: function () {
    var that = this;
    wx.getSetting({
      success(res) {
        if (!res.authSetting['scope.writePhotosAlbum']) {
          wx.authorize({
            scope: 'scope.writePhotosAlbum',
            success() {
              wx.saveImageToPhotosAlbum({
                filePath: that.data.posterImage,
                success: function (res) {
                  that.posterImageClose();
                  app.Tips({
                    title: '保存成功',
                    icon: 'success'
                  });
                },
                fail: function (res) {
                  app.Tips({
                    title: '保存失败'
                  });
                }
              })
            }
          })
        } else {
          wx.saveImageToPhotosAlbum({
            filePath: that.data.posterImage,
            success: function (res) {
              that.posterImageClose();
              app.Tips({
                title: '保存成功',
                icon: 'success'
              });
            },
            fail: function (res) {
              app.Tips({
                title: '保存失败'
              });
            },
          })
        }
      }
    })
  },
  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {
    var that = this;
    that.setData({
      actionSheetHidden: !that.data.actionSheetHidden
    });
    userShare();
    return {
      title: that.data.activityInfo.store_name || '',
      imageUrl: that.data.activityInfo.image || '',
      path: '/pages/goods_details/index?id=' + that.data.id + '&spid=' + that.data.uid,
    }
  }
})