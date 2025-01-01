import { createRouter, createWebHistory } from 'vue-router'
import Home from '../views/HomePage.vue'
import LoginPage from '@/views/LoginPage.vue'
import RegisterPage from '@/views/RegisterPage.vue'
import UserList from '@/views/UserList.vue'
import LogoutPage from '@/views/LogoutPage.vue'
import store from '@/store'
import ForgotPassword from '@/views/ForgotPassword.vue'
import ResetPassword from '@/views/ResetPassword.vue'


const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/login',
    name: 'LoginPage',
    component: LoginPage
  },
  {
    path:'/logout',
    name:'LogoutPage',
    component:LogoutPage
  },
  {
    path:'/forgotpassword',
    name:'ForgotPassword',
  component: ForgotPassword
  },
  {
    path:'/resetpassword/:token',
    name:'ResetPassword',
    component:ResetPassword
  },
  
  {
    path: '/register',
    name: 'RegisterPage',
    component: RegisterPage
  },

{
  path:'/users',
  name:'UserList',
  component: UserList
}
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
});

router.beforeEach((to, from, next) => {
  if (to.meta.requiresAuth && !store.getters.isAuthenticated) {
    next('/login');
  } else {
    next();
  }
});

export default router
