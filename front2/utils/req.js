import {
  wxp
} from './wxp'
const baseUrl = "http://localhost:50002"
// const baseUrl = "https://lsy99.cn:50002"
const tokenHeader = 'token'
export default {
  req(options) {
    options = this.processToken(options)
    options.url = baseUrl + options.url
    return new Promise((resolve, reject) => {
      wxp.request(options).then(res => {
        if (res.statusCode == 200) {
          resolve(res)
        } else {
          reject(res)
        }
      })
    })

  },
  get(options) {
    options.method = 'GET'
    return this.req(options)
  },
  post(options) {
    options.method = 'POST'
    return this.req(options)
  },
  uploadFile(options) {
    options = this.processToken(options)
    options.url = "https://lsy99.cn:50001/file/upload"
    return wxp.uploadFile(options)
  },
  async uploadFiles(files) {
    let indexList = [] // fileList中的索引
    let fileList = [] // 不重复的文件 地址是tmp中的
    for (let file of files) {
      if (file.startsWith("http://tmp/") || file.startsWith("wxfile://")) {
        // wxfile://
        await wxp.getFileInfo({
          filePath: file,
        }).then(res => {
          // 获取文件签名
          let addToFileList = true
          let addIndex = -1
          // 依次比对签名和大小
          for (let index = 0; index < fileList.length; index++) {
            let file = fileList[index]
            // 出现相同的
            if (res.size === file.size && res.digest === file.digest) {
              addToFileList = false
              addIndex = index
            }
          }
          // 添加到索引数组
          if (addToFileList) {
            fileList.push({
              url: file,
              size: res.size,
              digest: res.digest
            })
            indexList.push(fileList.length - 1)
          } else {
            indexList.push(addIndex)
          }
        })
      } else {
        // -1代表保留原路径
        indexList.push(-1)
      }
    }
    // console.log(indexList, fileList)
    let uploadedFileList = [] // 不重复的文件 地址是上传后的地址
    // 上传文件
    for (let file of fileList) {
      await this.uploadFile({
        filePath: file.url,
        name: "file"
      }).then(res => {
        // console.log(res)
        if (res.statusCode == 200) {
          uploadedFileList.push(res.data)
        } else {
          return Promise.reject(JSON.parse(res.data))
        }
      })
    }
    // 返回上传文件列表
    let returnList = []
    for (let index in indexList) {
      if (indexList[index] >= 0) {
        returnList.push(uploadedFileList[indexList[index]])
      } else {
        console.log(files)
        returnList.push(files[index])
      }
    }
    // console.log(returnList)
    return returnList
  },
  processToken(options) {
    let token = getApp().globalData.token
    token = "eyJhbGciOiJIUzUxMiJ9.eyJyb2xlIjoiMSIsInN1YiI6IjM2IiwiaWF0IjoxNjIwMDI5NTA1LCJleHAiOjE2MjAxMTU5MDV9.pfM_cUDcwdcNQMmymtBmL_2ALMVbt_qqOqaUse54ry0pJDN8rycLVHlQxXr2oL5eiek_0L-ecK-ioLe_G3X_5w"
    if (!(typeof token == "undefined" || token == null || token == "")) {
      if (options.header) {
        if (!options.header.token) {
          options.header[tokenHeader] = token
        }
      } else {
        options.header = {}
        options.header[tokenHeader] = token
      }
    }
    return options
  }
}