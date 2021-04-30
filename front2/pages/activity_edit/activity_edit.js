// pages/activity_new/activity_new.js

import req from '../../utils/req'
import {
  wxp
} from '../../utils/wxp'
import area from '../../utils/area'
import time from '../../utils/time'
import util from '../../utils/util';
const chooseLocation = requirePlugin('chooseLocation');
Page({

  /**
   * 页面的初始数据
   */
  data: {
    parameter: {
      'navbar': '1',
      'return': '1',
      'title': '编辑活动',
      'color': true,
      'class': '0'
    },
    placeholder: '在此输入……',
    allCategory: [{
      'id': 1,
      'name': '默认'
    }],
    id: 0,
    name: '',
    introduction: '',
    address: '',
    date: '',
    time: '',
    category: '0',
    region: ['不限', '不限', '不限'],
    regionCode: 0,
    images: [],
    updatedImages: [],
    detail: '',
    detailText: '',
    areaList: {},
    showAreaPicker: false,
    address: '',
    location: null,
    free: true
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    chooseLocation.setLocation(null);
    let key = 'HOMBZ-XYPC4-JONU6-DXDR7-DYONE-CPBF7';
    console.log(options.id)
    this.getAllCategory()
    this.setData({
      areaList: area
    })
    this.setData({
      id: options.id
    })
    req.post({
      url: "/activity/getByIdForEdit",
      data: this.data.id
    }).then(res => {
      console.log(res)
      let tempImage = []
      for (let url of res.data.pictures) {
        tempImage.push({
          url: url
        })
      }
      let date = time.utcToDate(res.data.date)
      this.setData({
        id: res.data.activityId,
        name: res.data.name,
        introduction: res.data.introduction,
        address: res.data.address,
        images: tempImage,
        category: res.data.category,
        date: time.dateToDateString(date),
        time: time.dateToTimeString(date),
        regionCode: res.data.regionCode,
        region: util.getRegion2(res.data.regionCode),
        detail: res.data.detail
      })
      if (res.data.detail) {
        this.setData({
          detailText: '点击编辑'
        })
      }
      getApp().globalData.editorContent = {
        html: res.data.detail
      }
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
    })
    // this.setLocation()
    // this.getAllCategory()
  },
  // 生命周期 显示时 获取editor中的文字 或者获取地址
  onShow() {
    // console.log('show')
    // console.log(!!getApp().globalData.editorContent)
    let editorContent = getApp().globalData.editorContent
    let key = 'HOMBZ-XYPC4-JONU6-DXDR7-DYONE-CPBF7';
    if (editorContent) {
      console.log(editorContent)
      // let temp = editorContent.text.replace(/\s+/, '')
      this.setData({
        detail: editorContent.html,
        detailText: '点击编辑'
      })
    } else {
      this.setData({
        detailText: '尚未填写，点击编辑'
      })
    }
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
        // console.log(res.data)
        this.setData({
          regionCode: res.data.result.ad_info.adcode,
          region: [res.data.result.address_component.province, res.data.result.address_component.city, res.data.result.address_component.district]
        })
        console.log
      })
    }
  },
  // 提交表单
  formSubmit(e) {
    // console.log(this.data.images)
    wxp.showToast({
        title: '上传中',
        icon: 'loading'
      }).then(() => {
        let fileList = []
        for (let file of this.data.images) {
          fileList.push(file.url)
        }
        console.log(fileList)
        return req.uploadFiles(fileList)
      }).then((res) => {
        console.log(res)
        this.setData({
          uploadFiles: res
        })
        console.log(this.data)
        console.log(e)
        let formData = e.detail.value
        // let date = dayjs(formData.date + ' ' + formData.time, 'YYYY-MM-DD hh:mm').format()
        let date = date = time.StringToDate(formData.date, formData.time)
        let uploadInfo = {
          activityId:this.data.id,
          name: formData.name,
          introduction: formData.introduction,
          pictures: this.data.uploadFiles,
          category: formData.category,
          date: date,
          regionCode: this.data.regionCode,
          address: this.data.address,
          detail: this.data.detail,
          free: this.data.free,
          count: formData.count,
          price: formData.price,
          ori: formData.ori,
          lat: this.data.location.lat,
          lng: this.data.location.lng
        }
        console.log(uploadInfo)
        return req.post({
          url: '/activity/edit',
          data: uploadInfo
        })
      })
      .then(res => {
        console.log(res)
        wxp.hideToast()
      }).then(() => {
        wx.navigateBack()
      }).catch((res) => {
        wxp.showToast({
          title: res.message,
          icon: 'error'
        })
      })
  },
  getShopPosition() {
    req.get({
      url: '/activity/shopAddress'
    }).then(res => {
      console.log(res)
      this.setData({
        regionCode: res.data.regionCode,
        region: util.getRegion2(res.data.regionCode),
        address: res.data.address,
        location: {
          lat: res.data.lat,
          lng: res.data.lng
        }
      })
    })
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
    console.log(e)
    this.setData({
      region: e.detail.value,
      regionCode: e.detail.code.length != 0 ? e.detail.code[e.detail.code.length - 1] : '000000'
    })
    console.log(this.data)
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
    console.log(this.data.regionCode)
    if (this.data.location) {
      let location = JSON.stringify({
        latitude: this.data.location.lat,
        longitude: this.data.location.lng
      });
      wx.navigateTo({
        url: `plugin://chooseLocation/index?key=${key}&referer=${referer}&location=${location}`
      });
    } else if (this.data.regionCode !== 0) {
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
  onChange() {
    let temp = this.data.free
    this.setData({
      free: !temp
    })
  }
})