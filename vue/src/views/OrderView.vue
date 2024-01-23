<template>
<div id="back-button">
<button id="back-button" v-on:click="this.$router.push({name: 'home'})">Go Back</button>
<button><font-awesome-icon :icon="['fas', 'cart-plus']" /></button>
</div>
    
  
  <div class="order-view">
    <h1>Place Your Pizza Order</h1>
    
    <!-- Specialty Pizza Selection -->
    <PizzaSelection @selectPizza="selectPizza" />

    <!-- Build Your Own Pizza -->
    <PizzaBuilder @pizzaCreated="handleAddToCart"/>

    <!-- Toppings Selection 
    <ToppingsSelection @selectTopping="selectTopping" />
-->

    <!-- Order Form -->
    <OrderForm @updateCustomerInfo="updateCustomerInfo" />

    <!-- Order Summary and Confirmation -->
    <OrderSummary :pizzaSelections="orderDetails.pizzaSelections" />

    <!-- Confirm Order Button -->
    <button @click="confirmOrder" :disabled="!isOrderReady">Confirm Order</button>
    
    <!-- Confirmation Dialog -->
    <ConfirmationDialog
      v-if="showConfirmation"
      :orderDetails="orderDetails"
      @closeDialog="closeConfirmation" 
    />
  </div>
</template>

<script>
import { library } from '@fortawesome/fontawesome-svg-core';
import { fas } from '@fortawesome/free-solid-svg-icons';
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome';
// Add the solid icons to the library
library.add(fas);


import OrderForm from '../components/OrderForm.vue';
import PizzaSelection from '../components/PizzaSelection.vue';
import PizzaBuilder from '../components/PizzaBuilder.vue';
//import ToppingsSelection from '../components/ToppingComponent.vue';
import OrderSummary from '../components/OrderSummary.vue';
import DeliveryForm from '../components/DeliveryForm.vue';
import ConfirmationDialog from '../components/ConfirmationDialog.vue';

export default {
  components: {
    OrderForm,
    PizzaSelection,
    PizzaBuilder,
   // ToppingsSelection,
    OrderSummary,
    ConfirmationDialog,
    FontAwesomeIcon,
  },
  data() {
    return {
      currentOrderId: 0,
      selectedPizzaSize: 'medium',
      orderDetails: {
        customerInfo: null, 
        deliveryInfo: null,
        pizzaSelections: []
      },
      showConfirmation: false
    };
  },
  computed: {
    isOrderReady() {
      return this.orderDetails.customerInfo &&
             this.orderDetails.deliveryInfo &&
             this.orderDetails.pizzaSelections.length > 0;
    }
  },
  methods: {
    updateCustomerInfo(customerInfo) {
      this.orderDetails.customerInfo = customerInfo;
    },
    updateDeliveryDetails(deliveryInfo) {
      this.orderDetails.deliveryInfo = deliveryInfo;
    },
    selectPizza(pizza) {
      this.orderDetails.pizzaSelections.push({...pizza, size: this.selectedPizzaSize});
    },
   // selectTopping(topping) {
      // Logic to handle topping selection
      // Here, you'll need to define how you want to integrate selected toppings with your orderDetails
   // },
    confirmOrder() {
      if (this.isOrderReady) {
        this.showConfirmation = true;
        // You might want to handle order submission to backend here
      } else {
        alert('Please complete all sections of the order form.');
      }
    },
    closeConfirmation() {
      this.showConfirmation = false;
      // Optionally, reset order details or redirect to another page
    }
  }
};
</script>
<style scoped>
 .order-view {
  /* display: flex; */
  flex-direction: column;
  align-items: center;
  margin-top: 20px;
  padding: 20px;
  border-radius: 8px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  background-color: #fff;
}
 .order-view h1{
   text-align: center;
 }
.back-button{
  margin-left: auto;
}

h1 {
  color: #333;
  margin-bottom: 20px;
  font-size: 2rem;
}

button {
  background-color: #da3327;
  color: white;
  border: none;
  border-radius: 4px;
  padding: 12px 24px;
  cursor: pointer;
  transition: background-color 0.3s ease-in-out;
  font-weight: bold;
  
}

button:hover {
  background-color: #690e04f3;
  
}

/* button:disabled {
  background-color: #ccc;
  cursor: not-allowed;
} */

ul {
  list-style-type: none;
  padding: 0;
}

li {
  margin-top: 10px;
  background: #f9f9f9;
  padding: 10px;
  border: 1px solid #ddd;
  border-radius: 4px;
}

.OrderForm, .DeliveryForm, .OrderSummary {
  width: 100%;
  max-width: 600px;
  margin-bottom: 20px;
} 



/* Additional styles can be added as per your design preference */
</style>
