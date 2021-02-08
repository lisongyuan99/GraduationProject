import { HTTP_REQUEST_URL, CACHE_USERINFO, CACHE_TOKEN, CACHE_EXPIRES_TIME } from './config.js';
import Server from './utils/Server.js';
import util from './utils/util.js';

App({
  onLaunch: function (option) {
    // 获取导航高度；
    wx.getSystemInfo({
      success: res => {
        //导航高度
        this.globalData.navHeight = res.statusBarHeight * (750 / res.windowWidth) + 97;
        // console.log(this.globalData)
      }, fail(err) {
        console.log(err)
      }
    });
    const updateManager = wx.getUpdateManager();

    updateManager.onCheckForUpdate(function (res) {
      // 请求完新版本信息的回调
      
    })
  },
  $chat:null,
  globalData: {
    navHeight: 0,
    routineStyle: '#ffffff',
    openPages: '',
    spid: 0,
    code:0,
    urlImages: '',
    url: HTTP_REQUEST_URL,
    token: '',
    isLog:false,
    expiresTime:0,
    MyMenus:[],
    userInfo:{},
    loginType:'routine'
  },
  /**
   * 聊天事件快捷注册
   * 
  */
  $on: function (name, action){
    this.$chat.$on(name,action);
  },
  /*
  * 信息提示 + 跳转
  * @param object opt {title:'提示语',icon:''} | url
  * @param object to_url 跳转url 有5种跳转方式 {tab:1-5,url:跳转地址}
  */
  Tips: function (opt, to_url) { 
    return util.Tips(opt, to_url);
  },
  /**
   * 快捷调取助手函数
  */
  help:function()
  {
    return util.$h;
  },
  /*
  * 合并数组
  * @param array list 请求返回数据
  * @param array sp 原始数组
  * @return array
  */
  SplitArray: function (list, sp) { return util.SplitArray(list, sp)},
})