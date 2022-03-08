<template>
  <div class="home">
    <img alt="Vue logo" src="../assets/logo.png">
    <HelloWorld msg="Welcome to Your Vue.js + TypeScript App"/>
  </div>
</template>

<script lang="ts">
import { defineComponent } from 'vue';
import HelloWorld from '@/components/HelloWorld.vue'; // @ is an alias to /src

export default defineComponent({
  name: 'Home',
  components: {
    HelloWorld,
  },
});
</script>

<!--<template>-->
<!--  <div class="home">-->
<!--    <a-button type="primary" :size="size">Primary</a-button>-->
<!--    <img alt="Vue logo" src="../assets/logo.png">-->
<!--    <HelloWorld msg="Welcome to Your Vue.js + TypeScript App"/>-->
<!--  </div>-->
<!--</template>-->

<!--<script lang="ts">-->
<!--import { defineComponent } from 'vue';-->
<!--// import HelloWorld from '@/components/HelloWorld.vue'; // @ is an alias to /src-->

<!--import axios from 'axios';-->
<!--export default{-->
<!--  // name: 'Home',-->
<!--  // methods:{-->
<!--  //   printSth(){-->
<!--  //     console.log("setup1")-->
<!--  //   }-->
<!--  // },-->
<!--  // created: function() {-->
<!--  //   this.printSth()-->
<!--  // }-->
<!--  // // setup(){-->
<!--  // //   // console.log('setup');-->
<!--  // //   const printStr = () => {-->
<!--  // //     console.log("setup")-->
<!--  // //   }-->
<!--  // //   printStr()-->
<!--  // //   // axios.get("http://localhost:8881/ebook/list?name=Spring").then(-->
<!--  // //   //     (response) =>{-->
<!--  // //   //       console.log(response);-->
<!--  // //   //     }-->
<!--  // //   // )-->
<!--  // //   return {printStr}-->
<!--  // // }-->
<!--  // setup(){-->
<!--  //   onMounted(() => {-->
<!--  //     console.log("123")-->
<!--  //   })-->
<!--  // }-->

<!--  created() {-->
<!--    console.log("123")-->
<!--  }-->
<!--}-->
<!--</script>-->
