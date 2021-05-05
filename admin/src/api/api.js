import axios from "./http"

export default {
  test() {
    return axios.get('/admin/test')
  },
  login(name, password) {
    return axios.post('/admin/login', {
      name: name,
      password: password
    })
  },
  getAllShop() {
    return axios.get('/admin/getShopToVerify')
  },
  passShop(shopId) {
    return axios.post('admin/passShop/' + shopId)
  },
  denyShop(shopId) {
    return axios.post('admin/denyShop/' + shopId)
  },
  getAllActivity() {
    return axios.get('/admin/getActivityToVerify')
  },
  passActivity(activityId) {
    return axios.post('admin/passActivity/' + activityId)
  },
  denyActivity(activityId) {
    return axios.post('admin/denyActivity/' + activityId)
  },

}
