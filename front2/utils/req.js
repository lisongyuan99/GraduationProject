import {
  wxp
} from './wxp'
export default {
  request (options) {
    var baseUrl = "http://localhost:8080"
    var tokenHeader = 'Token'
    if (getApp().globalData.token) {
      var token = getApp().globalData.token
      if (options.header) {
        if(!options.header.token){
          options.header[tokenHeader] = token
        }
      } else {
        options.header = {}
        options.header[tokenHeader] = token
      }
    }
    return new Promise((resolve, reject) => {
      wx.request({
        url: baseUrl + options.url, //服务器接口地址
        header: options.header,
        method: options.method || 'GET', //请求方法
        data: options.data || {}, //请求参数
        success: function (res) {
          if (res.statusCode === 200) {
            resolve(res)
          } else {
            reject(res)
          }
        }, //接口调用成功回调函数
        fail: reject //接口调用失败回调函数
      })
    })
  },
  req (options) {
    var baseUrl = "http://localhost:8080"
    options.url = baseUrl + options.url
    return wxp.request(options)
  },
  get (options) {
    options.method = 'GET'
    return this.request(options)
  },
  post (options) {
    options.method = 'POST'
    return this.request(options)
  }
}