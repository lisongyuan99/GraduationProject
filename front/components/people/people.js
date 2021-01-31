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
    nickname: {
      type: String,
      value: "无名氏"
    },
    avatar: {
      type: String,
      value: "/public/nopic.svg"
    },
    motto: {
      type: String,
      value: ""
    },
  },
  lifetimes: {
    ready: function () {
      console.log(this.data)
      var heightPx = this.data["item-height"] * wx.getSystemInfoSync().windowWidth / 750
      this.setData({
        picHeightPx: heightPx,
        nickname: this.data.nickname
      })
    },
  },
  /**
   * 组件的初始数据
   */
  data: {
    nickname: "无名氏",
    avatar: "/public/nopic.svg",
    motto: "这个人很懒，什么都没留下",
    picHeightPx: 120,
    picWidthPx: 80
  },

  /**
   * 组件的方法列表
   */
  methods: {}
})