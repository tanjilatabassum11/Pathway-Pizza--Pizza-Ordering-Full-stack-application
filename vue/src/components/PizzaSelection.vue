<template>
    <div class="pizza_selection">

    <h1 class="pizza-type-specialty"> Specialty  </h1>
      <div class="pizza-type">
        
        <div class="pizzaCardParent">
        <div class="pizzaCard" v-for="pizza in availablePizzas" :key="pizza.pizza_id" > 
          <h1> {{pizza.pizza_name}} <span>{{pizza.pizza_cost}}</span> </h1>
          <h5> {{pizza.note}} </h5>
          <button id="pizzaCardButton" @click="submitPizzaSelection">Add Pizza</button>
        </div>
        </div>
    
    
    
  
     <!-- <div class="toppings-selection">
        <h3>Select Toppings:</h3>
        <div v-for="topping in toppings" :key="topping">
          <input type="checkbox" :id="topping" :value="topping" v-model="pizzaSelection.toppings">
          <label :for="topping">{{ topping }}</label>
        </div>
      </div>
      -->
    </div>
      <h1> Build Your Own</h1>
      
    </div>
  </template>
<script>

import PizzaService from '../services/PizzaService.js';

export default {
  data() {
    return {
      availablePizzas: [],
      selectedPizzas: [],
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
    savePizza(){
      this.selectedPizzas.add(this.pizza);
    },
    
  },
  created(){
      PizzaService.getAvailableSpecialtyPizzas()
        .then((response) => {
          this.availablePizzas = response.data
        });
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



#pizzaCardButton {
  display: flex;
  margin: 20px;
  border-radius: 15px;
}


button:hover {
  background-color: #45a049;
}


.pizzaCardParent {
  display: flex;
  padding-left: 25%;
  padding-right: 25px;
  flex-wrap: wrap;
}
.pizzaCard {
  background-color: #5FA873;
  border-radius: 15px;
  flex: 1;
  text-align: center;
  padding: 20px;
  border: 1px inset #A18F63; 
}
</style>

  