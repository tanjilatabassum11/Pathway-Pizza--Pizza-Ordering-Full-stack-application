<template>
    <div class="pizza-builder">
      <h2>Build Your Own Pizza</h2>
  
      <div class="options">
        <div class="option">
          <h3>Select Size</h3>
          <select class = "option-color" v-model="pizza.size">
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
  padding: 60px;
  border: 1px solid #ccc;
  border-radius: 4px;
  background-color:   #e6ee741a;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}
input[type="checkbox" i]{
    accent-color: #BB554A;
}

.pizza-builder h2{
  margin-top: 5px;
  font-weight: bold;
  color: #af7c4c;
}

.options {
  margin-bottom: 20px;
}

.option {
  margin-bottom: 15px;
}
.option h3{
  color: #666;
}
.option-color{
  background-color: #af7c4c;
  color: white;
}

option,select {
  padding: 5px;
  margin-right: 10px;
}

button {
  background-color: #af7c4c;
  color: white;
  padding: 10px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

button:hover {
  background-color: #a08545fb;
}

.cart {
  margin-top: 20px;
  padding: 15px;
  background-color: #f5f5f5;
  border: 1px solid #ddd;
  border-radius: 4px;
}

.cart h2 {
  font-size: 1.2em;
  margin-bottom: 10px;

}

.cart ul {
  list-style: none;
  padding: 0;
}

.cart li {
  margin-bottom: 8px;
  
}
</style> 
  