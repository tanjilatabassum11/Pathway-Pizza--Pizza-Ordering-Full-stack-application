<template>
  <div class="order-view">
    <h1>Place Your Pizza Order</h1>
    
    <PizzaSelection @selectPizza="selectPizza" />
    <OrderSummary :pizzaSelections="orderDetails.pizzaSelections" />
    <DeliveryForm @updateDeliveryDetails="updateDeliveryDetails" />
    <PaymentForm @updatePaymentInfo="updatePaymentInfo" />

    <button @click="confirmOrder" :disabled="!isOrderReady">Confirm Order</button>
    
    <ConfirmationDialog
      v-if="showConfirmation"
      :orderDetails="orderDetails"
      @closeDialog="closeConfirmation" 
    />
  </div>
</template>

<script>
import OrderSummary from '../components/OrderSummary.vue';
import DeliveryForm from '../components/DeliveryForm.vue';
import PaymentForm from '../components/PaymentForm.vue';
import PizzaSelection from '../components/PizzaSelection.vue'; 
import ConfirmationDialog from '../components/ConfirmationDialog.vue';

export default {
  components: {
    OrderSummary,
    DeliveryForm,
    PaymentForm,
    PizzaSelection,
    ConfirmationDialog
  },
  data() {
    return {
      orderDetails: {
        customerInfo: null, 
        deliveryInfo: null,
        paymentInfo: null,
        pizzaSelections: []
      },
      showConfirmation: false
    };
  },
  computed: {
    isOrderReady() {
      // Check if all necessary information is filled out
      return this.orderDetails.deliveryInfo &&
             this.orderDetails.paymentInfo &&
             this.orderDetails.pizzaSelections.length > 0;
    }
  },
  methods: {
    updateDeliveryDetails(deliveryInfo) {
      this.orderDetails.deliveryInfo = deliveryInfo;
    },
    updatePaymentInfo(paymentInfo) {
      this.orderDetails.paymentInfo = paymentInfo;
    },
    selectPizza(pizza) {
      this.orderDetails.pizzaSelections.push(pizza);
    },
    confirmOrder() {
      if (this.isOrderReady) {
        // Process order submission
        this.showConfirmation = true;
      } else {
        alert('Please complete all sections of the order form.');
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
  margin-top: 20px;
}

h1 {
  color: #333;
  margin-bottom: 20px;
}

button {
  background-color: #4CAF50;
  color: white;
  border: none;
  border-radius: 4px;
  padding: 10px 20px;
  cursor: pointer;
  transition: background-color 0.3s ease-in-out;
}

button:hover {
  background-color: #45A049;
}

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

.PizzaSelection {
  margin-bottom: 20px;
}

.PizzaSelection select,
.PizzaSelection input[type="checkbox"] {
  margin-bottom: 10px;
  padding: 5px;
  border: 1px solid #ccc;
  border-radius: 4px;
}

.OrderForm {
  width: 100%;
  max-width: 500px;
}

.OrderForm .form-group {
  margin-bottom: 15px;
}

.OrderForm label {
  display: block;
  margin-bottom: 5px;
}

.OrderForm input[type="text"],
.OrderForm input[type="email"],
.OrderForm input[type="tel"] {
  width: 100%;
  padding: 8px;
  border: 1px solid #ccc;
  border-radius: 4px;
}
button:disabled {
  background-color: #ccc;
  cursor: not-allowed;
}
button:disabled {
  background-color: #ccc;
  cursor: not-allowed;
}
</style>
