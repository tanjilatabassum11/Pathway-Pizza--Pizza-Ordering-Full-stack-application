<template>
    <div class="topping-selection">
      <h3>Select Toppings:</h3>
      <div class="toppings">
        <div class="topping" v-for="topping in toppings" :key="topping.id">
          <input 
            type="checkbox" 
            :id="'topping-' + topping.id"
            :value="topping"
            @change="handleToppingChange"
          />
          <label :for="'topping-' + topping.id">
            {{ topping.name }} - ${{ topping.price.toFixed(2) }}
          </label>
        </div>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    name: "ToppingComponent",
    data() {
      return {
        toppings: [
          { id: 1, name: "Pepperoni", price: 0.5 },
          { id: 2, name: "Mushrooms", price: 0.4 },
          { id: 3, name: "Onions", price: 0.3 },
        ],
        selectedToppings: []
      };
    },
    methods: {
      handleToppingChange(event) {
        const topping = JSON.parse(event.target.value);
        if (event.target.checked) {
          this.selectedToppings.push(topping);
        } else {
          this.selectedToppings = this.selectedToppings.filter(t => t.id !== topping.id);
        }
        this.$emit('updateToppings', this.selectedToppings);
      }
    }
  };
  </script>
  
  <style scoped>
  .topping-selection {
    margin: 20px 0;
  }
  
  .toppings {
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
  }
  
  .topping {
    margin-right: 15px;
    margin-bottom: 10px;
    display: flex;
    align-items: center;
  }
  
  .topping input[type="checkbox"] {
    margin-right: 5px;
  }
  
  .topping label {
    cursor: pointer;
  }
  
  @media (min-width: 600px) {
    .toppings {
      justify-content: flex-start;
    }
  }
  </style>
  