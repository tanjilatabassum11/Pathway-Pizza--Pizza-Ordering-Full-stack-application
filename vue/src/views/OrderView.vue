<template>
    <div class="order-view">
      <h1>Place Your Pizza Order: </h1>
      <PizzaSelection @selectPizza="selectPizza" />
      <OrderForm @submitOrder="submitOrder" />
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
  margin-top: 20px;
}

 h1 {
  color: #333;
  margin-bottom: 20px;
}

button {
  background-color: #4caf50;
  color: white;
  border: none;
  border-radius: 4px;
  padding: 10px 20px;
  cursor: pointer;
  transition: background-color 0.3s ease-in-out;
}

button:hover {
  background-color: #45a049;
}

/* Add styles for PizzaSelection and OrderForm components */
.PizzaSelection {
 
}

.OrderForm {

}
</style>