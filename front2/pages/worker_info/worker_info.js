import req from '../../utils/req'
import {
  wxp
} from '../../utils/wxp'
const app = getApp();

Page({

  /**
   * 页面的初始数据
   */
  data: {
    parameter: {
      'navbar': '1',
      'return': '1',
      'title': '我的资料',
      'color': true,
      'class': '0'
    },
    nickname: '',
    images: [],
    phone: '',
    next: '',
    showAreaPicker: false,
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.setData({
      next: options.next
    })
    console.log(this.data.next)
    if(this.data.next){
      this.getProfile()
    }
  },
  onShow() {

  },

  getProfile() {

  },

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

  deleteImage(e) {
    // console.log('delete')
    // console.log(e.detail.index)
    let index = e.detail.index
    this.data.images.splice(index, 1)
    // console.log(this.data.images)
  },

  async formSubmit(e) {
    console.log(e.detail.value)
    let values = e.detail.value
    let image
    if (this.data.images[0] && this.data.images[0].url) {
      await req.uploadFiles([this.data.images[0].url]).then(res => {
        image = res[0]
      })
    }
    console.log(image)
    req.post({
      url: '/user/modifyInfo',
      data: {
        name: values.nickname,
        avatar: image,
      }
    }).then(res => {
      console.log(res)
      console.log(this.data.next)
      if (this.data.next === 'wait') {
        wx.navigateTo({
          url: '/pages/wait/wait'
        })
      } else if(this.data.next === 'qr') {
        wx.navigateTo({
          url: '/pages/worker_scan_qr/worker_scan_qr'
        })
      }
      else {
        wx.navigateBack()
      }
    })
  },
})