import Vue from 'vue'
import App from './App.vue'
import router from './router'
import './plugins/element.js'
import './assets/css/global.css' //引入全局样式
import './assets/icon/iconfont.css'           //引入图标
import axios from 'axios'

Vue.prototype.$http = axios
axios.defaults.baseURL = "http://localhost:9000"
axios.defaults.withCredentials = true



Vue.config.productionTip = false

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
