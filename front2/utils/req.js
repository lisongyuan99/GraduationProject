import {wxp} from './wxp'
const baseUrl = "http://localhost:8080"
const tokenHeader = 'Token'
export default {
  req (options) {
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
    options.url = baseUrl + options.url
    return wxp.request(options)
  },
  get (options) {
    options.method = 'GET'
    return this.req(options)
  },
  post (options) {
    options.method = 'POST'
    return this.req(options)
  },
  uploadFile(options){
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
    options.url = baseUrl + options.url
    return wxp.uploadFile(options)
  }
}