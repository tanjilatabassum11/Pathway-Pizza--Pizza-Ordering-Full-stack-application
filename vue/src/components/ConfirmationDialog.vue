<template>
    <div class="order-view">
      <h1>Place Your Pizza Order</h1>
      <PizzaSelection @selectPizza="selectPizza" />
      <OrderForm @submitOrder="submitOrder" />
      <button @click="confirmOrder">Confirm Order</button>
      <ConfirmationDialog 
        v-if="showConfirmation" 
        :orderDetails="orderDetails" 
        @closeDialog="closeConfirmation" 
      />
      <div v-if="orderDetails.pizzaSelections.length">
        <h2>Your Pizza Selections:</h2>
        <ul>
          <li v-for="(pizza, index) in orderDetails.pizzaSelections" :key="index">
            {{ pizza.type }} - {{ pizza.size }} - {{ pizza.toppings.join(', ') }}
          </li>
        </ul>
      </div>
    </div>
  </template>
 <script>
 import OrderForm from '../components/OrderForm.vue';
 import PizzaSelection from '../components/PizzaSelection.vue';
 
 
 export default {
   components: {
     OrderForm,
     PizzaSelection,
   },
   data() {
     return {
       orderDetails: {
         customerInfo: null,
         pizzaSelections: []
       },
       showConfirmation: false
     };
   },
   methods: {
     submitOrder(customerInfo) {
       this.orderDetails.customerInfo = customerInfo;
     },
     selectPizza(pizzaSelection) {
       this.orderDetails.pizzaSelections.push({...pizzaSelection});
     },
     confirmOrder() {
       if (this.orderDetails.customerInfo && this.orderDetails.pizzaSelections.length) {
         this.showConfirmation = true;
       } else {
         alert('Please complete the order form and select at least one pizza.');
       }
     },
     closeConfirmation() {
       this.showConfirmation = false;
     }
   }
 };
 </script>
 
<style scoped>
.order-view {
  display: flex;
  flex-direction: column;
  align-items: center;
  max-width: 600px;
  margin: 0 auto;
  padding: 20px;
  box-shadow: 0 2px 4px rgba(0,0,0,0.1);
  background: #fff;
  border-radius: 8px;
}

h1 {
  margin-bottom: 20px;
}

button {
  background-color: #4CAF50;
  color: white;
  padding: 10px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  margin-top: 15px;
}

button:hover {
  background-color: #45a049;
}

ul {
  list-style-type: none;
  padding: 0;
}

li {
  background: #f9f9f9;
  padding: 10px;
  margin-top: 10px;
  border: 1px solid #ddd;
  border-radius: 4px;
}

.form-group label {
  display: block;
  margin-bottom: 5px;
}

.form-group input[type="text"],
.form-group input[type="email"],
.form-group input[type="tel"] {
  width: 100%;
  padding: 8px;
  border: 1px solid #ccc;
  border-radius: 4px;
  margin-bottom: 10px;
}

.pizza-selection {
  margin-top: 20px;
}

.pizza-type, .pizza-size, .toppings {
  margin-bottom: 15px;
}

.pizza-type label, 
.pizza-size label, 
.toppings label {
  display: block;
  margin-bottom: 5px;
}

select, input[type="checkbox"] {
  margin-right: 10px;
}

.dialog-content {
  background: white;
  padding: 20px;
  border-radius: 10px;
  box-shadow: 0 2px 12px rgba(0, 0, 0, 0.4);
}

.dialog-actions {
  margin-top: 20px;
  display: flex;
  justify-content: space-around;
}
.dialog-content {
  background: white;
  padding: 20px;
  border-radius: 10px;
  box-shadow: 0 2px 12px rgba(0, 0, 0, 0.4);
}

.dialog-actions {
  margin-top: 20px;
  display: flex;
  justify-content: space-around;
}
</style>
