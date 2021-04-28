import Vue from 'vue'
import VueRouter from 'vue-router'
import store from "@/store";
import Main from '@/views/Main.vue'
import Shop from '@/views/Shop'
import Activity from '@/views/Activity';
import Login from '@/views/Login'


Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    component: Main
  },
  {
    path: '/shop',
    component: Shop
  },
  {
    path: '/activity',
    component: Activity
  },
  {
    path: '/login',
    component: Login
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

router.beforeEach((to, from, next) => {
      // console.log(to, from)
      if (!store.state.token && to.path !== '/login'){
        next('/login')
        // next()
      }
      else next()
    }
)

export default router
