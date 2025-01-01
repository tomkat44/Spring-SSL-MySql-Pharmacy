import { createApp } from 'vue'
import App from './App.vue'
import router from './router/index.js'
import './axios'
import store from './store'

createApp(App).use(router).use(store).mount('#app')
