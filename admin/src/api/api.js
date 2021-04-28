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
    return axios.get('/admin/getShopsToVerify')
  },
  passShop(shopId) {
    return axios.post('admin/passShop', {shopId})
  },
  denyShop(shopId){
    return axios.post('admin/denyShop', {shopId})
  }
}
