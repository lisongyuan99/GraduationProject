import req from '../../utils/req'
import util from '../../utils/util'
const app = getApp();

Page({

  /**
   * 页面的初始数据
   */
  data: {
    parameter: {
      'navbar': '1',
      'return': '1',
      'title': '个人资料',
      'color': true,
      'class': '0'
    },
    nickname: '',
    motto: '',
    email: '',
    images: [],
    phone: ''
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.getProfile()
  },

  getProfile() {
    req.get({
      url: '/user/getProfile'
    }).then(res => {
      console.log(res)
      this.setData({
        nickname: res.data.name,
        motto: res.data.motto,
        phone: res.data.phone,
        email: res.data.email,
        images: [{
          url: res.data.avatar
        }]
      })
    })
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
    console.log(this.data.images)
    let values = e.detail.value
    let image
    if (this.data.images[0].url) {
      await req.uploadFiles([this.data.images[0].url]).then(res => {
        image = res[0]
      })
    }
    req.post({
      url: '/user/updateProfile',
      data: {
        name: values.nickname,
        motto: values.motto,
        avatar: image,
        email: values.email
      }
    }).then(res=>{
      console.log(res)
    })


  }
})