// components/activity/activity.js
Component({
  /**
   * 组件的属性列表
   */
  properties: {
    "item-height": {
      type: Number,
      value: 250
    },
    "content": {
      type: Object,
      value: {
        src: "https://img.yzcdn.cn/vant/cat.jpeg",
        title: "标题从前有座山",
        subTitle: "副标题山里有座庙庙里有个老和尚在讲故事",
        organizer:"组织者",
        time: "11月10日",
        position: "哈尔滨 南岗区 牛房屯"
      }
    }
  },
  lifetimes: {
    ready: function () {
      var heightPx = this.data["item-height"] * wx.getSystemInfoSync().windowWidth / 750
      var widthPx = heightPx 
      
      this.setData({
        myContent: this.data.content,
        picWidthPx: widthPx,
        picHeightPx: heightPx
      })
      console.log(this.data)
    },
  },
  /**
   * 组件的初始数据
   */
  data: {
    myContent: null,
    picHeightPx: 120,
    picWidthPx: 80
  },

  /**
   * 组件的方法列表
   */
  methods: {

  }
})
