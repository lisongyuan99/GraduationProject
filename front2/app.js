App({
  onLaunch: function (option) {
    // 获取导航高度；
    wx.getSystemInfo({
      success: res => {
        //导航高度
        this.globalData.navHeight = res.statusBarHeight * (750 / res.windowWidth) + 97;
        // console.log(this.globalData)
      },
      fail(err) {
        console.log(err)
      }
    });
  },
  $chat: null,
  globalData: {
    navHeight: 0,
    routineStyle: '#ffffff',
    openPages: '',
    spid: 0,
    code: 0,
    urlImages: '',
    token: '',
    isLog: false,
    expiresTime: 0,
    MyMenus: [],
    userInfo: {},
    loginType: 'routine',
    editorContent: null, //editor中的内容
    editor: null
  }
})