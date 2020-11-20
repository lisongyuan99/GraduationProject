// components/people/people.js
Component({
  /**
   * 组件的属性列表
   */
  properties: {
    "item-height": {
      type: Number,
      value: 150
    },
    "content": {
      type: Object,
      value: {
        src: "https://img.yzcdn.cn/vant/cat.jpeg",
        username: "用户名",
        motto: "一句话简介一句话简介一句话简介"
      }
    }
  },
  lifetimes: {
    ready: function () {
      var heightPx = this.data["item-height"] * wx.getSystemInfoSync().windowWidth / 750
      this.setData({
        myContent: this.data.content,
        picHeightPx: heightPx
      })
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
  methods: {}
})
