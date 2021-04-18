import req from '../../utils/req'
import {
  wxp
} from '../../utils/wxp'
import area from '../../utils/area'
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
      'title': '商铺资料审核',
      'color': true,
      'class': '0'
    },
    nickname: '',
    motto: '',
    email: '',
    images: [],
    phone: '',
    region: ['不限', '不限', '不限'],
    regionCode: 0,
    showAreaPicker: false,
    areaList:{},
    address: '',
    location: {},
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.setData({
      areaList: area
    })
    chooseLocation.setLocation(null);
    this.getProfile()
  },
  onShow() {
    let key = 'HOMBZ-XYPC4-JONU6-DXDR7-DYONE-CPBF7';
    const location = chooseLocation.getLocation();
    console.log(location)
    if (location) {
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
    wx.navigateTo({
      url: '/pages/boss_main/boss_main',
    })
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
})