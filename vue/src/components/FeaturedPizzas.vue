<template>
    <div class="featured-pizzas">
      <h1 class="menu-section-title">Featured Pizzas</h1>
      <div class="pizza-card-parent">
        <div class="pizza-card" v-for="(pizza, index) in featuredPizzas" :key="index">
          <img :src="pizza.imageUrl" alt="Image of pizza" class="pizza-image" />
          <h2>{{ pizza.pizza_name }}</h2>
          <p>{{ pizza.description }}</p>
          <div class="pizza-details">
            <span class="pizza-price">${{ pizza.pizza_cost.toFixed(2) }}</span>
            <button class="add-to-cart-button" @click="addToCart(pizza)">Add to Cart</button>
          </div>
        </div>
      </div>
    </div>
  </template>
  <script>
  import PizzaService from '../services/PizzaService.js'; 
  
  export default {
    data() {
      return {
        featuredPizzas: []
      };
    },
    created() {
      this.fetchFeaturedPizzas();
    },
    methods: {
      fetchFeaturedPizzas() {
        PizzaService.getFeaturedPizzas() 
          .then(response => {
            this.featuredPizzas = response.data;
          })
          .catch(error => {
            console.error('Error fetching featured pizzas:', error);
          });
      },
      addToCart(pizza) {
        this.$emit('addToCart', pizza);
      }
    }
  };
  </script>
  <style scoped>
  .featured-pizzas {
    display: flex;
    flex-direction: column;
    align-items: center;
  }
  
  .menu-section-title {
    font-size: 1.8em;
    margin-bottom: 15px;
  }
  
  .pizza-card-parent {
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
  }
  
  .pizza-card {
    background-color: #e6ee741a;
    border-radius: 8px;
    margin: 10px;
    padding: 20px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    transition: transform 0.3s ease-in-out;
    text-align: center;
  }
  
  .pizza-card:hover {
    transform: scale(1.05);
  }
  
  .pizza-card h2 {
    font-size: 1.2em;
    margin-bottom: 10px;
  }
  
  .pizza-card p {
    margin-bottom: 15px;
  }
  
  .pizza-image {
    width: 100%;
    height: auto;
    border-radius: 8px;
  }
  
  .pizza-details {
    display: flex;
    justify-content: space-between;
    align-items: center;
  }
  
  .pizza-price {
    font-weight: bold;
  }
  
  .add-to-cart-button {
    background-color: #af844c;
    color: white;
    border: none;
    padding: 8px 16px;
    border-radius: 4px;
    cursor: pointer;
    transition: background-color 0.2s ease-in-out;
  }
  
  .add-to-cart-button:hover {
    background-color: #a08545fb;
  }
  </style>
  