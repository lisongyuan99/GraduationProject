import Vue from 'vue'
import Vuex from 'vuex'
import createVuexAlong from 'vuex-along'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    token: ''
  },
  mutations: {
    setToken(state, token){
      state.token = token
    },
    deleteToken(state){
      state.token = ''
    }
  },
  actions: {},
  modules: {},
  plugins: [createVuexAlong()]
})
