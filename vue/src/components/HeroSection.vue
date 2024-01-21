<template>
    <div class="hero-section">
      <h1>Welcome to Our Pizza World</h1>
      <p>Explore our wide range of delicious pizzas and make your day special!</p>
      <button @click="placeOrder">Place Your Order</button>
    </div>
  </template>
  
  <script>
  export default {
    name: "HeroSection",
    methods: {
      placeOrder() {
        this.$router.push({ name: 'MenuView' }); 
      }
    }
  };
  </script>
  
  <style scoped>
  .hero-section {
    background-image: url('C:\Users\Student\workspace\oct-blue-pizza-ordering\vue\src\images\Hero.png'); 
    background-size: cover;
    background-position: center;
    text-align: center;
    padding: 60px 20px;
    color: white;
  }
  
  .hero-section h1 {
    font-size: 2.5rem;
    margin-bottom: 20px;
  }
  
  .hero-section p {
    font-size: 1.2rem;
    margin-bottom: 30px;
  }
  
  button {
    background-color: var(--brand-green-color);
    color: var(--brand-white-color);
    border: none;
    padding: 10px 20px;
    border-radius: 5px;
    font-size: 1.1em;
    cursor: pointer;
    transition: background-color 0.3s;
  }
  
  button:hover {
    background-color: darken(var(--brand-green-color), 10%);
  }
  </style>
  