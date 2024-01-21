<template>
    <div class="pizza-card" @click="showDetails">
      <img :src="pizza.imageUrl" alt="Pizza Image" class="C:\Users\Student\workspace\oct-blue-pizza-ordering\vue\src\images\pizzacard.png"/>
      <div class="content">
        <h3 class="pizza-name">{{ pizza.pizza_name }}</h3>
        <p class="pizza-desc">{{ pizza.note }}</p>
        <button class="add-to-cart-button" @click.stop="addToCart">Add to Cart</button>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    props: {
      pizza: {
        type: Object,
        required: true
      }
    },
    methods: {
      showDetails() {
        this.$emit('showDetails', this.pizza);
      },
      addToCart() {
        this.$emit('addToCart', this.pizza);
      }
    }
  }
  </script>
  
  <style scoped>
  .pizza-card {
    box-sizing: border-box;
    position: relative;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    margin: 10px;
    border-radius: 15px;
    width: 300px;
    height: 350px;
    background-color: white;
    transition: transform 0.3s ease;
    cursor: pointer;
    overflow: hidden;
  }
  
  .pizza-card:hover {
    transform: scale(1.05);
  }
  
  .pizza-card .content {
    padding: 5px;
  }
  
  .pizza-image {
    width: 100%;
    height: auto;
    border-top-left-radius: 15px;
    border-top-right-radius: 15px;
  }
  
  .pizza-name {
    margin: 10px 0 5px 0;
  }
  
  .pizza-desc {
    margin: 0;
    font-size: 0.9em;
  }
  
  .add-to-cart-button {
    display: none;
    position: absolute;
    bottom: 10px;
    left: 50%;
    transform: translateX(-50%);
    background-color: var(--brand-green-color);
    color: white;
    border: none;
    padding: 8px 16px;
    border-radius: 4px;
    cursor: pointer;
    transition: background-color 0.2s ease-in-out;
  }
  
  .pizza-card:hover .add-to-cart-button {
    display: block;
  }
  
  .add-to-cart-button:hover {
    background-color: darken(var(--brand-green-color), 10%);
  }
  </style>
  