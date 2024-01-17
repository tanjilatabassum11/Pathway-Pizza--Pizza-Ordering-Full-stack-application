<template>
  <div class="home">
    <section class="Welcome-section">
    <h1>Welcome to Our Pizza Service!</h1>
    <p>Discover our wide range of delicious pizzas, customize your own, and enjoy fast delivery services.</p>

    <div class="navigation">
      <router-link to="/order">Order Now</router-link>
      <router-link to="/menu">View Menu</router-link>
    </div>
  </section>
  <section class=" specialty-pizzas">
    <h2>Specialty Pizzas</h2>
  </section>
  </div>
</template>

<script>
export default {

  name: 'HomeView',
};
</script>

<style scoped>
.home {
  text-align: center;
  padding: 20px;
}

.navigation {
  margin-top: 20px;
}

.navigation a {
  margin: 10px;
  padding: 10px;
  background-color: #ffcc00;
  color: black;
  text-decoration: none;
  border-radius: 5px;
  transition: background-color 0.3s;
}

.navigation a:hover {
  background-color: #ffd633;
}
</style>
