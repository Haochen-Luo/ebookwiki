<template>
  <a-layout>
    <a-layout-sider width="200" style="background: #fff">
      <a-menu
          mode="inline"

          :style="{ height: '100%', borderRight: 0 }"
      >
<!--        v-model:selectedKeys="selectedKeys2"-->
<!--        v-model:openKeys="openKeys"-->
        <a-sub-menu key="sub1">
          <template #title>
            <span><user-outlined />subnav 1</span>
          </template>
          <a-menu-item key="1">option1</a-menu-item>
          <a-menu-item key="2">option2</a-menu-item>
          <a-menu-item key="3">option3</a-menu-item>
          <a-menu-item key="4">option4</a-menu-item>
        </a-sub-menu>
        <a-sub-menu key="sub2">
          <template #title>
            <span><laptop-outlined />subnav 2</span>
          </template>
          <a-menu-item key="5">option5</a-menu-item>
          <a-menu-item key="6">option6</a-menu-item>
          <a-menu-item key="7">option7</a-menu-item>
          <a-menu-item key="8">option8</a-menu-item>
        </a-sub-menu>
        <a-sub-menu key="sub3">
          <template #title>
            <span><notification-outlined />subnav 3</span>
          </template>
          <a-menu-item key="9">option9</a-menu-item>
          <a-menu-item key="10">option10</a-menu-item>
          <a-menu-item key="11">option11</a-menu-item>
          <a-menu-item key="12">option12</a-menu-item>
        </a-sub-menu>
      </a-menu>
    </a-layout-sider>
    <a-layout-content
        :style="{ background: '#fff', padding: '24px', margin: 0, minHeight: '280px' }"
    >
<!--      <pre>-->
<!--        {{ebooks}}-->
<!--      </pre>-->
<!--      {{ebooks}}-->
<!--                                                   : pagination="pagination"-->
      <a-list item-layout="vertical" size="large" :grid="{gutter:20, column:3}" :data-source="ebooks">
<!--        <template #footer>-->
<!--          <div>-->
<!--            <b>ant design vue</b>-->
<!--            footer part-->
<!--          </div>-->
<!--        </template>-->
<!--        注意这里{item}会自动循环每一个类-->
        <template #renderItem="{ item }">
          <a-list-item key="item.name">
            <template #actions>
          <span v-for="{ type, text } in actions" :key="type">
            <component v-bind:is="type" style="margin-right: 8px" />
            {{ text }}
          </span>
            </template>
<!--            <template #extra>-->
<!--              <img-->
<!--                  width="272"-->
<!--                  alt="logo"-->
<!--                  src="https://gw.alipayobjects.com/zos/rmsportal/mqaQswcyDLcXyDKnZfES.png"-->
<!--              />-->
<!--            </template>-->



            <a-list-item-meta :description=item.description+item.cover>
              <template #title>
                <a :href="item.href">{{ item.name}}</a>
              </template>

              <template #avatar><a-avatar :src="item.cover" /><a-avatar :src="item.cover" /></template>

            </a-list-item-meta>
          </a-list-item>
        </template>
      </a-list>
    </a-layout-content>
  </a-layout>
</template>

<script lang="ts">
import {defineComponent, onMounted, reactive, ref, toRef} from 'vue';
// import HelloWorld from '@/components/HelloWorld.vue'; // @ is an alias to /src

import axios from 'axios';

const listData: Record<string, string>[] = [];

for (let i = 0; i < 23; i++) {
  listData.push({
    href: 'https://www.antdv.com/',
    title: `ant design vue part ${i}`,
    avatar: 'https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png',
    description:
        'Ant Design, a design language for background applications, is refined by Ant UED Team.',
    content:
        'We supply a series of design principles, practical patterns and high quality design resources (Sketch and Axure), to help people create their product prototypes beautifully and efficiently.',
  });
}

export default defineComponent({
  name: 'Home',
  setup(){
    console.log('mounted');

    const ebooks = ref()
    const ebooks1 = reactive({bookdata:[]})
    const pagination = {
      onChange: (page: number) => {
        console.log(page);
      },
      pageSize: 3,
    };
    const actions: Record<string, string>[] = [
      { type: 'StarOutlined', text: '156' },
      { type: 'LikeOutlined', text: '156' },
      { type: 'MessageOutlined', text: '2' },
    ];
    //reactive里是空对象
    onMounted(()=> {
          axios.get("ebook/list").then(
              (response) => {
                const data = response.data;
                ebooks.value = data.content;
                ebooks1.bookdata = data.content;
                console.log('\n\n\n\n\n\n\n\n\n\n');
                console.log();
                console.log();
                console.log();
                console.log(response);
              })
        })
    return{

      ebooks,
      whatevername:toRef(ebooks1,"bookdata"),
      listData,
      pagination,
      actions
    //whatevername是无所谓的
    }
   }

});
</script>


<style scoped>
.ant-avatar {
  width: 50px;
  height: 50px;
  line-height: 50px;
  border-radius: 8%;
  margin: 5px 0;
}
</style>

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
