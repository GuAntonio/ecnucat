import Vue from 'vue'
import App from './App'
import router from './router'
import store from './store'
import ElementUI from 'element-ui'
import mavonEditor from 'mavon-editor'
import AMap from 'vue-amap';
import Viewer from 'v-viewer'
import 'viewerjs/dist/viewer.css'
Vue.use(Viewer)
Viewer.setDefaults({
  Options: { 'inline': true, 'button': true, 'navbar': true, 'title': true, 'toolbar': true, 'tooltip': true, 'movable': true, 'zoomable': true, 'rotatable': true, 'scalable': true, 'transition': true, 'fullscreen': true, 'keyboard': true, 'url': 'data-source' }
})
Vue.use(AMap);


Vue.use(mavonEditor)

import 'element-ui/lib/theme-chalk/index.css'
import 'mavon-editor/dist/css/index.css'


var axios = require('axios')
axios.defaults.baseURL = 'http://www.ecnucat.top:8082/api'
Vue.prototype.$axios = axios
Vue.config.productionTip = false
axios.defaults.withCredentials = true//cookie


Vue.use(ElementUI)
router.beforeEach((to, from, next) => {
    if (store.state.user.username && to.path.startsWith('/admin')) {
      initAdminMenu(router, store)
    }
    // 已登录状态下访问 login 页面直接跳转到后台首页
    if (store.state.username && to.path.startsWith('/login')) {
      next({
        path: 'library',
        query: {redirect: to.fullPath}
      })
    }
    if (to.meta.requireAuth) {
      if (store.state.user.username) {
        axios.get('/authentication').then(resp => {
          if (resp) next()
        })
      } else {
        next({
          path: 'login',
          query: {redirect: to.fullPath}
        })
      }
    } else {
      next()
    }
  }
)


const formatRoutes = (routes) => {
  let fmtRoutes = []
  routes.forEach(route => {
    if (route.children) {
      route.children = formatRoutes(route.children)
    }

    let fmtRoute = {
      path: route.path,
      component: resolve => {
        require(['./components/admin/' + route.component + '.vue'], resolve)
      },
      name: route.name,
      nameZh: route.nameZh,
      iconCls: route.iconCls,
      children: route.children
    }
    fmtRoutes.push(fmtRoute)
  })
  return fmtRoutes
}
const initAdminMenu = (router, store) => {
  if (store.state.adminMenus.length > 0) {
    return
  }
  axios.get('/menu').then(resp => {
    if (resp && resp.status === 200) {
      var fmtRoutes = formatRoutes(resp.data)
      router.addRoutes(fmtRoutes)
      store.commit('initAdminMenu', fmtRoutes)
    }
  })
}
// 初始化vue-amap
AMap.initAMapApiLoader({
  // 高德key
  key: 'd52a8934992e9aa6e31d0b0f029fcdca',
  // 插件集合 （插件按需引入）
  plugin: ['AMap.Geolocation']
});



/* eslint-disable no-new */
new Vue({
  el: '#app',
  render: h => h(App),
  router,
  store,
  components: { App },
template: '<App/>'
})

