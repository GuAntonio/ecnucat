import Vue from 'vue'
import Home from '../components/Home'

import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
// 导入刚才编写的组件
import AppIndex from '@/components/AppIndex'
import Login from '@/components/Login'
import LibraryIndex from'@/components/library/LibraryIndex'
import Register from'@/components/Register'

Vue.use(Router)

export default new Router({
  mode: 'history',

  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: Home
    },
    {
      path: '/home',
      name: 'Home',
      component: Home,

      // home页面并不需要被访问
      redirect: '/index',
      children: [
        {
          path: '/index',
          name: 'AppIndex',
          component: AppIndex,
          meta: {
            requireAuth: true
          }

        },
        {
          path: '/library',
          name: 'Library',
          component: LibraryIndex,
          meta: {
            requireAuth: true
          }},
        {
          path: '/jotter',
          name: 'jotter',
          component: () => import('../components/content/Articles'),
          meta: {
            requireAuth: true
          }
        },
        ,
        {
          path: '/jotter/article',
          name: 'Article',
          component: () => import('../components/content/ArticleDetails')
        },

        {
          path: '/admin/content/editor',
          name: 'Editor',
          component: () => import('../components/content/ArticleEditor'),
          meta: {
            requireAuth: true
          }
        }

      ]
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    },{path: '/register',
      name: 'Register',
      component:Register
    }
    ,

    {path: '/gaodemap',
      name: 'Gaodemap',
      component: () => import('../components/GaodeMap'),

    },
    {
      path: '/admin',
      name: 'Admin',
      component: () => import('../components/admin/AdminIndex'),
    meta: {
  requireAuth: true
},
children: [
//   {
//     path: '/admin/dashboard',
//     name: 'Dashboard',
//     component: () => import('../components/admin/dashboard/admin/index'),
//   meta: {
//   requireAuth: true
// }
// }
  {
    path: '/admin/user/profile',
    name: 'UserProfile',
    component: () => import('../components/admin/UserProfile'),
    meta: {
      requireAuth: true
    }},
  {
    path: '/admin/content/book',
    name: 'BooksCanEdit',
    component: () => import('../components/library/Books'),
    meta: {
      requireAuth: true
    }}
]
},

  ]

})
