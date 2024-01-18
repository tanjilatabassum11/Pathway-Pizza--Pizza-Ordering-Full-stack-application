<template>
    <div class="pizza_selection">
      <h2>Choose Your Pizza</h2>
      <div class="pizza-type">
        <label for="pizzaType">Pizza Type:</label>
        <select id="pizzaType" v-model="pizzaSelection.type">
          <option disabled value="">Please select one</option>
          <option v-for="type in pizzaTypes" :key="type" :value="type">{{ this.type }}</option>
        </select>
      </div>
  
      <div class="pizza-size">
        <label for="pizzaSize">Pizza Size:</label>
        <select id="pizzaSize" v-model="pizzaSelection.size">
          <option disabled value="">Please select one</option>
          <option v-for="size in pizzaSizes" :key="size" :value="size">{{ size }}</option>
        </select>
      </div>
  
      <div class="toppings-selection">
        <h3>Select Toppings:</h3>
        <div v-for="topping in toppings" :key="topping">
          <input type="checkbox" :id="topping" :value="topping" v-model="pizzaSelection.toppings">
          <label :for="topping">{{ topping }}</label>
        </div>
      </div>
  
      <button @click="submitPizzaSelection">Add Pizza</button>
    </div>
  </template>
<script>
export default {
  data() {
    return {
      pizzaSelection: {
        type: '',
        size: '',
        toppings: []
      },
      pizzaTypes: ['Margherita', 'Pepperoni', 'Vegetarian', 'Hawaiian'],
      pizzaSizes: ['Small', 'Medium', 'Large'],
      toppings: ['Pepperoni', 'Mushrooms', 'Onions', 'Sausage', 'Bacon', 'Extra cheese', 'Peppers']
    };
  },
  methods: {
    submitPizzaSelection() {
      this.$emit('selectPizza', {...this.pizzaSelection});
      this.resetPizzaSelection();
    },
    resetPizzaSelection() {
      this.pizzaSelection = { type: '', size: '', toppings: [] };
    },
  }
};
</script>
<style scoped>
.pizza-selection {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-top: 20px;
}

.pizza-type, .pizza-size, .toppings {
  margin-bottom: 15px;
}

label {
  display: block;
  margin-bottom: 5px;
}

select, input[type="checkbox"] {
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
  background-color: #45a049;
}
</style>

  