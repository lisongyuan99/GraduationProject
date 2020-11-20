export default function request(options) {
  var baseUrl = "http://localhost:8080"
  return new Promise((resolve, reject) => {
    wx.request({
      url: baseUrl + options.url,
      filePath: options.filePath,
      name: options.name,
      header: options.header,
      formData: options.formData,
      timeout: options.timeout,
      success: resolve,
      fail: reject
    })
  })
}