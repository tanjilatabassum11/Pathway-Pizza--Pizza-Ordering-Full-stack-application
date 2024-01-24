<template>
<div id="back-button">
<button id="back-button" v-on:click="this.$router.push({name: 'home'})">Go Back</button>
<button @click="showCart = !showCart"><font-awesome-icon :icon="['fas', 'cart-plus']" /></button>
</div>
    
  
  <div class="order-view">
    <OrderCart v-if="showCart" />


    <!-- Order Form -->
    <OrderForm @updateCustomerInfo="updateCustomerInfo" />

    <div>
      <h1>Place Your Pizza Order</h1>
      <!-- Specialty Pizza Selection -->
      <PizzaSelection @selectPizza="selectPizza" />
      <div>
        <h2>Custom Pizza</h2>
        <button @click="byoPizza()" id="byo-button">Build Your Own</button>
      </div>
    </div>
  <!-- need to add path button -->



    



    <!-- Confirm Order Button -->
    <button @click="confirmOrder">Confirm Order</button>
    
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


import ToppingService from '../services/ToppingService';
import UserOrderService from '../services/UserOrderService';


import OrderForm from '../components/OrderForm.vue';
import PizzaSelection from '../components/PizzaSelection.vue';
import OrderCart from '../components/OrderCart.vue';

//import ToppingsSelection from '../components/ToppingComponent.vue';
import OrderSummary from '../components/OrderSummary.vue';
import DeliveryForm from '../components/DeliveryForm.vue';
import ConfirmationDialog from '../components/ConfirmationDialog.vue';
import OrderCartVue from '../components/OrderCart.vue';
import PizzaService from '../services/PizzaService';

export default {
  components: {
    OrderForm,
    PizzaSelection,
    OrderCart,
  
    ConfirmationDialog,
    FontAwesomeIcon,
  },
  data() {
    return {
      showCartButton: false,
      showCart: false,

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
    byoPizza(){
      this.$router.push({name: 'topping', params:{pizzaId: ''}})

    },
  
    //everything after this might not be needed
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
      let order = this.$store.state.orderData;
      let totalCost = 0;
      let orderToSend = {};
      orderToSend.orderName = order.orderName;
      orderToSend.phoneNumber = order.phoneNumber;
      orderToSend.delivery = order.delivery;
      orderToSend.orderStatus = order.orderStatus;
      orderToSend.emailAddress = order.emailAddress;
      orderToSend.totalCost = totalCost;
      let orderRecieved = {};
      UserOrderService.createOrder(order).then((response)=>{
        orderRecieved = response.data;
        order.pizzaSelection.forEach((pizza)=>{
            let pizzaCost = pizza.pizza_cost * pizza.quantity;
            totalCost += pizzaCost;
            if(!pizza.is_specialty){
              PizzaService.createCustomPizza(pizza).then((response)=>{
                let customPizza = response.data;
                pizza.toppings.forEach((toppingId)=>{
                  PizzaService.addToppingToPizza(customPizza.pizza_id, toppingId);
                });
                UserOrderService.addPizzaToOrder(orderRecieved.orderId, customPizza.pizza_id, pizza.quantity);

              });
            } else{
              pizza.toppings.forEach((toppingId)=>{
                PizzaService.addToppingToPizza(pizza.pizza_id, toppingId);
              });
              UserOrderService.addPizzaToOrder(orderRecieved.orderId, pizza.pizza_id, pizza.quantity);
              
            }
          });
          orderRecieved.totalCost = totalCost;
          UserOrderService.updateOrder(orderRecieved);

      })
      

    },
    closeConfirmation() {
      this.showConfirmation = false;
      // Optionally, reset order details or redirect to another page
    }
  }
};
</script>
<style scoped>
@import url('https://fonts.cdnfonts.com/css/cooper-hewitt-book');
@font-face {
    font-family: 'Mandalore Laser Title';
    src: url('../fonts/MandaloreLaserTitle.woff2') format('woff2'),
        url('../fonts/MandaloreLaserTitle.woff') format('woff');
    font-weight: normal;
    font-style: normal;
    font-display: swap;
}
*{
  font-family: 'Cooper Hewitt Book', sans-serif;
}

h1, h2{
  font-family: 'Mandalore Laser Title';
}
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
  text-decoration: underline;
}

button {
  background-color: var(--brand-darkred-color);
  color: white;
  border: none;
  border-radius: 4px;
  padding: 12px 24px;
  cursor: pointer;
  transition: background-color 0.3s ease-in-out;
  font-weight: bold;
  
}

button:hover {
  background-color: var(--brand-green-color);
  
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
