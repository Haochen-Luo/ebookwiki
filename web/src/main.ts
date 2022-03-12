import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import Antd from 'ant-design-vue';
import 'ant-design-vue/dist/antd.css';
import * as Icons from '@ant-design/icons-vue';
import axios from "axios";
axios.defaults.baseURL = process.env.VUE_APP_SERVER;

const app = createApp(App);
app.use(store).use(router).use(Antd).mount('#app');

const icons: any = Icons;
for (const i in Icons) {
    app.component(i,icons[i]);
}

console.log('environment is :',process.env.NODE_ENV);
console.log('the server is:', process.env.VUE_APP_SERVER);
console.log(process.env)


// axios 拦截器
//第一个拦截请求
axios.interceptors.request.use(
  function (config){
      console.log('request param', config);
      return config;
  },error => {
      return Promise.reject(error);
    }
);
//这个返回结果
axios.interceptors.response.use(
    function (response) {
        console.log('return result',response);
        return response;

    },error => {
        return Promise.reject(error);
    }
)