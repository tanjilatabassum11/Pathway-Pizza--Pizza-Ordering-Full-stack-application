<template>
  <div id="capstone-app">
    <!-- <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div> -->
    <router-link :to="{name: 'home'}"></router-link>
    <LogoComponent />
    <router-view />
    <FooterComponent />
  </div>
</template>

<script>
import LogoComponent from './components/LogoComponent.vue';
import FooterComponent from './components/FooterComponent.vue';
export default{
  components:{LogoComponent, FooterComponent}

}
</script>
