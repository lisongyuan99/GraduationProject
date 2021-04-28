import Vue from 'vue'
import router from './router'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import App from './App.vue'
import store from './store'
import http from '@/api/http'
import api from '@/api/api'
import util from "@/util/util";

Vue.config.productionTip = false
Vue.use(ElementUI);
Vue.prototype.$http = http
Vue.prototype.$api = api
Vue.prototype.$util = util

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
