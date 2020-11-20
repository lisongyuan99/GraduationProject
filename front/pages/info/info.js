// pages/info/info.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    editing: false,
    style: {
      fieldTitleWidth: "5em",
      cellTitleWidth: "6em"
    },
    username:"用户id",
    name:"昵称",
    info:"简介",
    email:"123567@qq.com",
    phone:"15555555555",
    fileList: [],
  },
  onEdit(){
    this.setData({
      editing: true
    })
  },
  onCancel(){
    this.setData({
      editing: false
    })
  },
  onSubmit(){
    this.setData({
      editing: false
    })
  }
})