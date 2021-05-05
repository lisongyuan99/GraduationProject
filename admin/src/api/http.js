import axios from 'axios'
import store from '@/store'
import router from "@/router"

axios.defaults.baseURL = '/api/project'
axios.interceptors.request.use(
    config => {
      // console.log(config)
      if (store.state.token) {
        // console.log(store.state.token)
        config.headers.token = store.state.token
      }
      return config
    },
    error => {
      return Promise.reject(error)
    }
)
axios.interceptors.response.use(
    response => {
      return Promise.resolve(response)
    },
    async error => {
      let response = error.response
      // 需要重新登录
      let loginCode = ['NoToken', 'InvalidToken', 'TokenExpired']
      if (response.status === 401 || response.status === 403) {
        if (loginCode.indexOf(response.data.code) !== -1) {
          await router.push('/login')
        }
      }
      return Promise.reject(error)
    }
)
export default axios