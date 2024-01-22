<template>
  <div class="order-confirmation">
    <h1>Thank You for Your Order!</h1>
    <div v-if="orderDetails">
      <h2>Order Summary</h2>
      <ul>
        <li v-for="(pizza, index) in orderDetails.pizzaSelections" :key="index">
          {{ pizza.type }} - {{ pizza.size }} - {{ pizza.toppings.join(', ') }}
        </li>
      </ul>
      <h3>Delivery Details</h3>
      <p>Name: {{ orderDetails.customerInfo.name }}</p>
      <p>Address: {{ orderDetails.customerInfo.address }}</p>
      <p>Phone: {{ orderDetails.customerInfo.phone }}</p>
      <p>Email: {{ orderDetails.customerInfo.email }}</p>
      <img src="../assets/thank-you.jpg" alt="Thank You" class="thank-you-image"/>
    </div>
    <div v-else>
      <p>Fetching your order details...</p>
    </div>
  </div>
</template>

<script>
export default {
  name: 'OrderConfirmationView',
  props: {
    orderId: {
      type: String,
      required: true
    }
  },
  data() {
    return {
      orderDetails: null 
    };
  },
  created() {
    this.fetchOrderDetails(this.orderId);
  },
  methods: {
    sendOrderToEmployeeSide(orderDetails) {
      // Implement the logic to send order details to the employee side
      // This could be an API call to your backend
      // Example:
      // OrderService.sendOrderToEmployee(orderDetails)
      //   .then(response => {
      //     // Handle successful sending here
      //   })
      //   .catch(error => {
      //     // Handle errors here
      //   });
    }
  }
};
</script>


<style scoped>
.order-confirmation {
  max-width: 600px;
  margin: 0 auto;
  padding: 20px;
  text-align: center;
  background: #fff;
  border-radius: 8px;
  box-shadow: 0 2px 4px rgba(0,0,0,0.1);
}

.thank-you-image {
  max-width: 100%;
  height: auto;
  margin-top: 20px;
  border-radius: 8px;
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
</style>
