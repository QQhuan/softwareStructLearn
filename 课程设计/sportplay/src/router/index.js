import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '../components/Login.vue'
import Home from '../components/Home.vue'
import Welcome from '../components/Welcome'
import UserList from '../components/admin/UserList.vue'
import GoodList from '../components/admin/Goods.vue'
import TypeList from '../components/admin/Types.vue'
import Kalories from '../components/admin/kalories.vue'

Vue.use(VueRouter)

  const routes = [
  {
    path: "/",
    redirect: "/login"
  },
  {
    path: "/login",
    component: Login
  },
  {
    path: "/home",
    component: Home,
    redirect: "/welcome",
    children:[
      {path:"/welcome", component: Welcome},
      {path:"/user", component: UserList},
      {path:"/goods", component: GoodList},
      {path:"/types", component: TypeList},
      {path:"/calories", component: Kalories},
    ]
  }
]

//路由多次点击报错重写push方法，捕获重复跳转的报错
const originalPush = VueRouter.prototype.push
   VueRouter.prototype.push = function push(location) {
   return originalPush.call(this, location).catch(err => err)
}

const router = new VueRouter({
  routes
})

router.beforeEach((to, from, next)=>{
  //to将要访问
  //from从哪来
  //next接着next(url) 重定向到next上的url, 如果next()继续访问to
  if(to.path == '/login') return next();
  //获取user
  const userFlag = window.sessionStorage.getItem("user");
  if(!userFlag) return next('/login'); //null, 既无登录信息
  next();
});

export default router
