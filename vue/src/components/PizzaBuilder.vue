<template>
    <div class="pizza-builder">
      <h2>Build Your Own Pizza</h2>
  
      <div class="options">
        <div class="option">
          <h3>Select Size</h3>
          <select v-model="pizza.size">
            <option value="small">Small</option>
            <option value="medium">Medium</option>
            <option value="large">Large</option>
          </select>
        </div>
  
        <div class="option">
          <h3>Select Toppings</h3>
          <div v-for="(topping, index) in toppings" :key="index">
            <input 
              type="checkbox" 
              :id="'topping-' + index" 
              :value="topping" 
              v-model="pizza.toppings"
            >
            <label :for="'topping-' + index">{{ topping }}</label>
          </div>
        </div>
      </div>
  
      <button @click="addToCart">Add to Cart</button>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        pizza: {
          size: 'medium',
          toppings: []
        },
        toppings: ['Pepperoni', 'Mushrooms', 'Onions', 'Sausage', 'Bacon'] // Example toppings
      };
    },
    methods: {
      addToCart() {
        // Emit an event with the pizza object
        this.$emit('addPizzaToCart', this.pizza);
        this.resetPizzaBuilder();
      },
      resetPizzaBuilder() {
        this.pizza = { size: 'medium', toppings: [] };
      }
    }
  };
  </script>
  
  <style scoped>
  .pizza-builder {
    max-width: 600px;
    margin: 20px auto;
    padding: 20px;
    border: 1px solid #ccc;
    border-radius: 4px;
  }
  
  .options {
    margin-bottom: 20px;
  }
  
  .option {
    margin-bottom: 15px;
  }
  
  option, select {
    padding: 5px;
    margin-right: 10px;
  }
  
  button {
    background-color: #4CAF50;
    color: white;
    padding: 10px 20px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
  }
  
  button:hover {
    background-color: #45A049;
  }
  </style>
  