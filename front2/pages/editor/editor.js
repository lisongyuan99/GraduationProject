const {
  default: req
} = require("../../utils/req")
const {
  wxp
} = require("../../utils/wxp")

Page({
  data: {
    formats: {},
    readOnly: false,
    placeholder: '开始输入...',
    editorHeight: 300,
    keyboardHeight: 0,
    isIOS: false,
    parameter: {
      'navbar': '1',
      'return': '1',
      'title': '编辑详情',
      'color': true,
      'class': '0'
    },
    navH: '',
    content: ''
  },
  readOnlyChange() {
    this.setData({
      readOnly: !this.data.readOnly
    })
  },
  onLoad() {
    this.setData({
      navH: getApp().globalData.navHeight
    });
  },
  onEditorReady() {
    const that = this
    wx.createSelectorQuery().select('#editor').context(function (res) {
      that.editorCtx = res.context
    }).exec(res => {
      let editorContent = getApp().globalData.editorContent
      if (editorContent) {
        this.editorCtx.setContents(editorContent)
      }
    })

  },

  undo() {
    this.editorCtx.undo()
  },
  redo() {
    this.editorCtx.redo()
  },
  format(e) {
    let {
      name,
      value
    } = e.target.dataset
    if (!name) return
    // console.log('format', name, value)
    this.editorCtx.format(name, value)

  },
  onStatusChange(e) {
    const formats = e.detail
    this.setData({
      formats
    })
  },
  insertDivider() {
    this.editorCtx.insertDivider({
      success: function () {
        console.log('insert divider success')
      }
    })
  },
  clear() {
    this.editorCtx.clear({
      success: function (res) {
        console.log("clear success")
      }
    })
  },
  removeFormat() {
    this.editorCtx.removeFormat()
  },
  insertDate() {
    const date = new Date()
    const formatDate = `${date.getFullYear()}/${date.getMonth() + 1}/${date.getDate()}`
    this.editorCtx.insertText({
      text: formatDate
    })
  },
  insertImage() {
    // 宽度
    const that = this
    wx.chooseImage({
      count: 1,
      success: function (res) {
        that.editorCtx.insertImage({
          src: res.tempFilePaths[0],
          data: {
            id: 'abcd',
            role: 'god'
          },
          width: '80%',
          success: function () {
            console.log('insert image success')
          }
        })
      }
    })
  },
  return () {
    let indexList = [] // 有图片的delta数组下标 该数组的下标对应fileList下标
    let delta
    wxp.showToast({
      title: '上传中',
      icon: 'loading'
    }).then(() => {
      return this.editorCtx.getContents()
    }).then(res => {
      // console.log(res)
      delta = res.delta
      let ops = res.delta.ops
      let fileList = []
      // console.log(ops)
      for (let index in ops) {
        let tempUrl = ops[index].insert.image
        if (tempUrl != undefined && tempUrl != null) {
          // if (tempUrl.startsWith("http://tmp/")) {
          indexList.push(index)
          fileList.push(tempUrl)
          // }
        }
      }
      // console.log(indexList)
      // console.log(fileList)
      return req.uploadFiles(fileList)
    }).then(res => {
      for (let index in indexList) {
        delta.ops[indexList[index]].insert.image = res[index]
      }
      return this.editorCtx.setContents({
        delta: delta
      })
    }).then(() => {
      return this.editorCtx.getContents()
    }).then(res => {
      getApp().globalData.editorContent = res
      return wxp.hideToast()
    }).then(() => {
      wx.navigateBack()
    }).catch(() => {
      wx.navigateBack()
    })
  },

})