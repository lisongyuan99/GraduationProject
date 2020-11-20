export default function request(options) {
  var baseUrl = "http://localhost:8080"
  return new Promise((resolve, reject) => {
    wx.request({
      url: baseUrl + options.url, //服务器接口地址
      header: options.header,
      method: options.method || 'GET', //请求方法
      data: options.data || {}, //请求参数
      success: function (res) {
        if (res.statusCode === 200) {
          resolve(res)
        } else if (res.statusCode === 500) {
          wx.showToast({title: "服务器内部错误"})
          reject(res)
        } else {
          reject(res)
        }
      }, //接口调用成功回调函数
      fail: reject //接口调用失败回调函数
    })
  })
}