<template>
  <a-layout-header  id="components-layout-demo-top-side-2">
    <div class="logo" />
    <a-menu
        theme="dark"
        mode="horizontal"

        :style="{ lineHeight: '64px' }"
    >
<!--      //v-model:selectedKeys="selectedKeys1"-->
      <a-menu-item key="/">
        <router-link to = "/">main</router-link>
      </a-menu-item>
      <a-menu-item key="/admin/ebook">
        <router-link to="/admin/ebook">admin</router-link>
      </a-menu-item>
      <a-menu-item key="/about">
        <router-link to="/about">about</router-link>
      </a-menu-item>
    </a-menu>
  </a-layout-header>
</template>

<script>
export default {
  name: "the-header"
}
</script>

<style scoped>

</style>