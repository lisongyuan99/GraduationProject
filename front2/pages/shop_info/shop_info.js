import req from '../../utils/req'
import {
  wxp
} from '../../utils/wxp'
import area from '../../utils/area'
import util from '../../utils/util'
const app = getApp();
const chooseLocation = requirePlugin('chooseLocation');

Page({

  /**
   * 页面的初始数据
   */
  data: {
    parameter: {
      'navbar': '1',
      'return': '1',
      'title': '店铺资料',
      'color': true,
      'class': '0'
    },
    id: 0,
    name: '',
    description: '',
    avatar: [],
    picture: [],
    license: [],
    phone: '',
    region: ['不限', '不限', '不限'],
    regionCode: 0,
    showAreaPicker: false,
    areaList: {},
    address: '',
    location: {},
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad(options) {
    this.setData({
      areaList: area
    })
    this.getProfile()
    chooseLocation.setLocation(null);
  },
  onShow() {
    
    // 设置地址相关
    let key = 'HOMBZ-XYPC4-JONU6-DXDR7-DYONE-CPBF7';
    const location = chooseLocation.getLocation();
    if (location) {
      console.log(location)
      this.setData({
        location: {
          lat: location.latitude,
          lng: location.longitude
        },
        address: location.name
      })
      wxp.request({
        url: `https://apis.map.qq.com/ws/geocoder/v1/?location=${location.latitude},${location.longitude}&key=${key}`,
        method: 'GET'
      }).then(res => {
        console.log(res.data)
        this.setData({
          regionCode: res.data.result.ad_info.adcode,
          region: [res.data.result.address_component.province, res.data.result.address_component.city, res.data.result.address_component.district]
        })
      })
    }
  },

  getProfile() {
    req.get({
      url: '/shop/getShopModifyInfo'
    }).then(res => {
      let picList = []
      for(let pic of res.data.picture){
        picList.push({url:pic})
      }
      this.setData({
        id: res.data.id,
        name: res.data.name,
        description: res.data.description,
        avatar: [{
          url: res.data.avatar
        }],
        license: [{
          url: res.data.license
        }],
        picture: picList,
        region: util.getRegion2(res.data.regionCode),
        regionCode: res.data.regionCode,
        address: res.data.address,
        location:{
          lat: res.data.lat,
          lng: res.data.lng
        }
      })
      console.log(this.data)
    })
  },

  // 更改头像
  selectAvatar(e) {
    let temp = this.data.avatar
    for (let image of e.detail.tempFilePaths) {
      temp.push({
        url: image
      })
    }
    this.setData({
      avatar: temp
    })
  },
  deleteAvatar(e) {
    let index = e.detail.index
    this.data.avatar.splice(index, 1)
  },
  // 更改执照
  selectLicense(e) {
    let temp = this.data.license
    for (let image of e.detail.tempFilePaths) {
      temp.push({
        url: image
      })
    }
    this.setData({
      license: temp
    })
  },
  deleteAvatar(e) {
    let index = e.detail.index
    this.data.license.splice(index, 1)
  },
  // 更改店铺照片
  selectPicture(e) {
    let temp = this.data.picture
    for (let image of e.detail.tempFilePaths) {
      temp.push({
        url: image
      })
    }
    this.setData({
      picture: temp
    })
  },
  deletePicture(e) {
    let index = e.detail.index
    this.data.picture.splice(index, 1)
  },
  // 提交表单
  formSubmit(e) {
    console.log(e)
    console.log(this.data)
    wx.showToast({
      title: '上传中',
      icon: 'loading'
    }).then(async () => {
      let avatar = await req.uploadFiles(this.getFileUrl(this.data.avatar))
      let license = await req.uploadFiles(this.getFileUrl(this.data.license))
      let picture = await req.uploadFiles(this.getFileUrl(this.data.picture))
      if (avatar.length === 1) {
        avatar = avatar[0]
      } else {
        avatar = ''
      }
      if (license.length === 1) {
        license = license[0]
      } else {
        license = ''
      }
      let info = {
        name: e.detail.value.name,
        description: e.detail.value.description,
        avatar: avatar,
        license: license,
        picture: picture,
        regionCode: this.data.regionCode,
        address: this.data.address,
        lat: this.data.location.lat,
        lng: this.data.location.lon,
      }
      return req.post({
        url: '/shop/modify',
        data: info
      })
    }).then(res => {
      console.log(res)
      return wx.hideToast()
    }).then(res=>{
      wx.showToast({
        title:'修改成功',
        icon: 'success'
      })
    })
    // .then(() => {
    //   wx.navigateBack()
    // })
  },
  //vant 选择地区
  openAreaPicker() {
    console.log('open')
    this.setData({
      showAreaPicker: true
    })
  },
  closeAreaPicker() {
    this.setData({
      showAreaPicker: false
    })
  },
  confirmArea(e) {
    console.log(e)
    let temp = []
    for (let value of e.detail.values) {
      temp.push(value.name)
    }
    // 需要重设详细地址
    this.setData({
      showAreaPicker: false,
      regionCode: e.detail.values[e.detail.values.length - 1].code,
      region: temp,
      location: {},
      address: ''
    })
    // console.log(this.data)
  },
  selectPosition() {
    let key = 'HOMBZ-XYPC4-JONU6-DXDR7-DYONE-CPBF7'; //使用在腾讯位置服务申请的key
    let referer = '毕业设计'; //调用插件的app的名称
    let location = JSON.stringify({
      latitude: 39.90517,
      longitude: 116.393822
    });
    if (this.data.regionCode !== 0) {
      wxp.request({
        url: `https://apis.map.qq.com/ws/district/v1/search?key=${key}&keyword=${this.data.regionCode}`,
        method: 'GET'
      }).then(res => {
        console.log(res.data)
        console.log(res.data.result[0][0].location)
        location = JSON.stringify({
          latitude: res.data.result[0][0].location.lat,
          longitude: res.data.result[0][0].location.lng
        })
        wx.navigateTo({
          url: `plugin://chooseLocation/index?key=${key}&referer=${referer}&location=${location}`
        });
      })
    } else {
      wx.navigateTo({
        url: `plugin://chooseLocation/index?key=${key}&referer=${referer}&location=${location}`
      });
    }
  },
  // 绑定的图片数组种中图片url数组
  getFileUrl(origin) {
    let fileList = []
    for (let file of origin) {
      fileList.push(file.url)
    }
    return fileList
  },
})