// pages/auth/register.js
Page({
  data: {
    username: '',
    password: '',
    passwordRepeat: '',
    isPassword: true,
    icon: "closed-eye",
    isPasswordRepeat: true,
    iconRepeat: "closed-eye",
    errorMessage: '',
  },
  passwordIconClick: function () {
    if (this.data.isPassword) {
      this.setData({
        isPassword: false,
        icon: "eye-o"
      })
    } else {
      this.setData({
        isPassword: true,
        icon: "closed-eye"
      })
    }
  },
  passwordIconClickRepeat: function () {
    if (this.data.isPasswordRepeat) {
      this.setData({
        isPasswordRepeat: false,
        iconRepeat: "eye-o"
      })
    } else {
      this.setData({
        isPasswordRepeat: true,
        iconRepeat: "closed-eye"
      })
    }
  }
})