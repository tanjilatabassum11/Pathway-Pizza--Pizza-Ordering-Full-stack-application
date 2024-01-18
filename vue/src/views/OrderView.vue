<template>
    <div class="order-view">
      <h1>Place Your Pizza Order</h1>
      <OrderForm @submitOrder="submitOrder" />
      <PizzaSelection @selectPizza="selectPizza" />
      <button @click="confirmOrder">Confirm Order</button>
      <ConfirmationDialog 
        v-if="showConfirmation" 
        :orderDetails="orderDetails" 
        @closeDialog="showConfirmation = false" 
      />
    </div>
  </template>
  
  <script>
  import OrderForm from '../components/OrderForm.vue';
  import PizzaSelection from '../components/PizzaSelection.vue';
  import ConfirmationDialog from '../components/ConfirmationDialog.vue';
  
  export default {
    components: {
      OrderForm,
      PizzaSelection,
      ConfirmationDialog
    },
    data() {
      return {
        orderDetails: {
          customerInfo: null,
          pizzaSelection: null
        },
        showConfirmation: false
      };
    },
    methods: {
      submitOrder(customerInfo) {
        this.orderDetails.customerInfo = customerInfo;
      },
      selectPizza(pizzaSelection) {
        this.orderDetails.pizzaSelection = pizzaSelection;
      },
      confirmOrder() {
        if (this.orderDetails.customerInfo && this.orderDetails.pizzaSelection) {
          this.showConfirmation = true;
        } else {
          alert('Please complete the order form and select your pizza.');
        }
      }
    }
  };
  </script>
  
  <style scoped>
  .order-view {
    display: flex;
    flex-direction: column;
    align-items: center;
  }
  </style>
  