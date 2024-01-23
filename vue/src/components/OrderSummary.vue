<template>
    <div class="order-summary">
      <!-- <h2>Your Order</h2> -->
      <ul>
        <li v-for="(pizza, index) in pizzas" :key="index" class="order-item">
          <div class="pizza-details">
            <span>{{ pizza.type }} - {{ pizza.size }}</span>
            <span>Toppings: {{ pizza.toppings.join(', ') }}</span>
          </div>
          <div class="pizza-actions">
            <button @click="editPizza(index)">Edit</button>
            <button @click="removePizza(index)">Remove</button>
          </div>
        </li>
      </ul>
    </div>
  </template>
  
  <script>
  export default {
    props: {
      pizzas: Array
    },
    methods: {
      editPizza(index) {
        this.$emit('editPizza', index);
      },
      removePizza(index) {
        this.$emit('removePizza', index);
      }
    }
  };
  </script>
  
  <style scoped>
  .order-summary {
    margin-top: 20px;
  }
  
  .order-item {
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-bottom: 10px;
    background: #f3f3f3;
    padding: 10px;
    border-radius: 8px;
  }
 
  .pizza-details {
    font-size: 0.9em;
  }
  
  .pizza-actions button {
    background-color: #4CAF50;
    color: white;
    border: none;
    border-radius: 4px;
    padding: 5px 10px;
    margin-left: 10px;
    cursor: pointer;
  }
  
  .pizza-actions button:hover {
    background-color: #45A049;
  }
  </style>
  