// pages/activity_new/activity_new.js
let dayjs = require('dayjs')
let customParseFormat = require('dayjs/plugin/customParseFormat')
import req from '../../utils/req'
import {
  wxp
} from '../../utils/wxp'
import area from '../../utils/area'
import util from '../../utils/util'
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
    showAreaPicker: false
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
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
      let date = dayjs(res.data.date).tz(dayjs.tz.guess())

      this.setData({
        name: res.data.name,
        introduction: res.data.introduction,
        address: res.data.address,
        images: tempImage,
        category: res.data.category,
        date: date.format('YYYY-MM-DD'),
        time: date.format('HH:mm'),
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
    })
    // this.setLocation()
    // this.getAllCategory()
  },
  // 生命周期 显示时 获取editor中的文字
  onShow() {
    // console.log('show')
    // console.log(!!getApp().globalData.editorContent)
    let editorContent = getApp().globalData.editorContent
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
        return req.uploadFiles(fileList)
      }).then((res) => {
        console.log(res)
        this.setData({
          uploadFiles: res
        })
        console.log(this.data)
        console.log(e)
        let formData = e.detail.value
        dayjs.extend(customParseFormat)
        let date = dayjs(formData.date + ' ' + formData.time, 'YYYY-MM-DD hh:mm').format()
        let uploadInfo = {
          activityId:this.data.id,
          name: formData.name,
          introduction: formData.introduction,
          pictures: this.data.uploadFiles,
          category: formData.category,
          date: date,
          regionCode: this.data.regionCode,
          address: formData.address,
          detail: this.data.detail
        }
        console.log(uploadInfo)

        return req.post({
          url: '/activity/edit',
          data: uploadInfo
        })
      }).then(res => {
        console.log(res)
        return wxp.showToast({
          title:'修改成功',
          duration: 1500
        })
      }).then(res=>{
        return wxp.navigateBack()
      })
      .catch((res) => {
        wxp.hideToast()
        return wxp.showToast({
          title: res.message,
          icon: 'error'
        })
      }).then(() => {
        wxp.hideToast()
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
      // console.log(res)
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
  // onRegionChange(e) {
  //   // console.log(e)
  //   this.setData({
  //     region: e.detail.value,
  //     regionCode: e.detail.code.length != 0 ? e.detail.code[e.detail.code.length - 1] : '000000'
  //   })
  //   console.log(this.data)
  // },
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
    this.setData({
      showAreaPicker: false,
      regionCode: e.detail.values[e.detail.values.length - 1].code,
      region: temp
    })
    console.log(this.data)
  }
})