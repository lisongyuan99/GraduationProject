// pages/new-activity/new-activity.js
import area from "../../utils/area";
Page({
  onLoad: function () {
    this.setData({
      areaList: area
    })
  },
  data: {
    style: {
      fieldTitleWidth: "5em",
      cellTitleWidth: "6em"
    },
    title: "",
    subtitle: "",

    categoryTexts: ["美食", "百货", "美容美发", "展览", "桌游", "戏剧"],
    categoryTextIds: [1, 3, 5, 7, 8, 10],
    categoryText: "请选择活动类型",
    selectedCategoryId: -1,
    categoryShow: false,

    dateText: "请选择日期",
    dateShow: false,
    date: null,

    areaShow: false,
    areaText: "请选择地点",
    area: null,

    fileList: [],
  },
  check: function () {
    console.log(this.data)
    // console.log(areaList)
  },

  onCategoryShow: function () {
    this.setData({categoryShow: true});
  },
  onCategoryClose: function () {
    this.setData({categoryShow: false,});
  },
  onCategoryConfirm: function (event) {
    this.setData({
      categoryShow: false,
      categoryText: event.detail.value,
      selectedCategoryId: this.data.categoryTextIds[event.detail.index]
    })
  },

  // 显示日期选择
  onDateShow() {
    this.setData({dateShow: true});
  },
  // 关闭日期选择
  onDateClose() {
    this.setData({dateShow: false});
  },
  // 格式化日期
  formatDate(date) {
    date = new Date(date);
    return `${date.getMonth() + 1}/${date.getDate()}`;
  },
  // 选择日期
  onDateConfirm(event) {
    this.setData({
      dateShow: false,
      dateText: this.formatDate(event.detail),
      date: event.detail
    });
  },

  onAreaShow: function () {
    this.setData({
      areaShow: true
    })
  },
  onAreaClose: function () {
    this.setData({
      areaShow: false
    })
  },
  onAreaConfirm: function (event) {
    this.setData({
      areaShow: false,
      area: event.detail,
      areaText: this.formatArea(event.detail)
    })
  },
  formatArea(areaDetail) {
    return areaDetail.values[0].name + " "
        + areaDetail.values[1].name + " "
        + areaDetail.values[2].name
  },

  afterRead(event) {
    console.log(event)
  },
})