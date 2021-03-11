// pages/activity_new/activity_new.js
let dayjs = require('dayjs')
import req from '../../utils/req'
import {
  wxp
} from '../../utils/wxp'
Page({

  /**
   * 页面的初始数据
   */
  data: {
    parameter: {
      'navbar': '1',
      'return': '1',
      'title': '新建活动',
      'color': true,
      'class': '0'
    },
    placeholder: '在此输入……',
    allCategory: [{
      'id': 1,
      'name': '默认'
    }],
    date: '',
    time: '',
    category: '0',
    region: ['不限', '不限', '不限'],
    regionCode: '',
    regionCustomItem: '不限',
    images: []
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    let now = dayjs()
    this.setData({
      date: now.format('YYYY-MM-DD'),
      time: now.format('HH:mm')
    })
    // this.setLocation()
    // this.getAllCategory()
  },

  // 提交表单
  async formSubmit(e) {
    // console.log(e.detail.value)
    // console.log(this.data.images)
    let imageList = [] // fileList中的索引
    let fileList = [] // 不重复的文件
    // console.log(this.data.images)
    for (let image of this.data.images) {
      await wxp.getFileInfo({
        filePath: image.url,
      }).then(res => {
        console.log(res)
        let addToFileList = true
        let addIndex = -1
        for (let index = 0; index < fileList.length; index++) {
          let file = fileList[index]
          if (res.size === file.size && res.digest === file.digest) {
            addToFileList = false
            addIndex = index
          }
        }
        if (addToFileList) {
          fileList.push({
            url: res.url,
            size: res.size,
            digest: res.digest
          })
          imageList.push(fileList.length - 1)
        } else {
          imageList.push(addIndex)
        }
        console.log(fileList)
        console.log(imageList)
      })
    }
  },

  // 获取当前位置信息
  setLocation() {
    wxp.getLocation().then(res => {
        console.log(res.latitude, res.longitude)
        return wxp.request({
          method: 'get',
          url: 'https://apis.map.qq.com/ws/geocoder/v1',
          data: {
            key: 'PYVBZ-FZFLU-KFXVJ-4JY5T-X4ORH-DZBYI',
            location: res.latitude + ',' + res.longitude
          }
        })
      }).then(res => {
        console.log(res)
        // TODO 其余判断
        if (res.data.status == 0) {
          this.setData({
            region: [
              res.data.result.ad_info.province,
              res.data.result.ad_info.city,
              res.data.result.ad_info.district
            ],
            regionCode: res.data.result.ad_info.adcode
          })
          // console.log(this.data)
        } else {
          console.log(res)
        }
      })
      .catch(res => {
        console.log('fail')
        console.log(res)
      })
  },

  // 获取所有活动分类
  getAllCategory() {
    req.get({
      url: '/activity/allCategory'
    }).then(res => {
      this.setData({
        allCategory: res.data
      })
    }).catch(res => {
      console.log(res)
    })
  },

  // 选择图片
  selectImage(e) {
    // console.log('select')
    // console.log(e)
    let temp = this.data.images
    for (let image of e.detail.tempFilePaths) {
      temp.push({
        url: image
      })
    }
    this.setData({
      images: temp
    })
  },
  // 删除图片
  deleteImage(e) {
    // console.log('delete')
    // console.log(e.detail.index)
    let index = e.detail.index
    this.data.images.splice(index, 1)
    // console.log(this.data.images)
  },
  // 活动分类改变
  onCategoryChange(e) {
    this.setData({
      category: e.detail.value
    })
  },
  // 日期改变
  onDateChange(e) {
    this.setData({
      date: e.detail.value
    })
  },
  // 时间改变
  onTimeChange(e) {
    this.setData({
      time: e.detail.value
    })
  },
  // 地区改变
  onRegionChange(e) {
    this.setData({
      region: e.detail.value,
      regionCode: e.detail.code ? e.detail.code[e.detail.code.length - 1] : '000000'
    })
    console.log(this.data)
  },
  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  },
})