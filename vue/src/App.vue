<template>
  <div id="capstone-app">
    <!-- <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div> -->
    <LogoComponent />
    
    <router-view />

    <div id="foot">
      <FooterComponent />
    </div>
  </div>
</template>

<script>
import LogoComponent from './components/LogoComponent.vue';
import FooterComponent from './components/FooterComponent.vue';
export default{
  components:{LogoComponent, FooterComponent}

}
</script>

<style scoped>

#capstone-app{
  display: flex;
  flex-direction: column;
  align-items: center;
  height: 100vh;
}
#foot{
  margin-top: auto;
}


</style>
