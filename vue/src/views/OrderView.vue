<template>
  <div class="order-view">
    <h1>Place Your Pizza Order:</h1>
    <PizzaSelection @selectPizza="selectPizza" />
    <OrderForm @submitOrder="submitOrder" />
    <button @click="confirmOrder">Confirm Order</button>
    <ConfirmationDialog
      v-if="showConfirmation"
      :orderDetails="orderDetails"
      @closeDialog="showConfirmation = false"
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
      this.orderDetails.pizzaSelections.push(pizzaSelection);
    },
    confirmOrder() {
      if (this.orderDetails.customerInfo && this.orderDetails.pizzaSelections.length) {
        this.showConfirmation = true;
      } else {
        alert('Please complete the order form and select at least one pizza.');
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
</style>
