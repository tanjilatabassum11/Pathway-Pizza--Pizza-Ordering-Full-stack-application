<template>
    <div class="confirmation-dialog" v-if="visible">
      <div class="dialog-content">
        <h2>Confirm Your Order</h2>
        <h3>Customer Details:</h3>
        <p><strong>Name:</strong> {{ orderDetails.customerInfo.firstName }} {{ orderDetails.customerInfo.lastName }}</p>
        <p><strong>Phone:</strong> {{ orderDetails.customerInfo.phoneNumber }}</p>
        <p><strong>Email:</strong> {{ orderDetails.customerInfo.email }}</p>
        <p><strong>Address:</strong> {{ orderDetails.customerInfo.address }}</p>
  
        <h3>Selected Pizza:</h3>
        <p><strong>Type:</strong> {{ orderDetails.pizzaSelection.type }}</p>
        <p><strong>Size:</strong> {{ orderDetails.pizzaSelection.size }}</p>
        <p><strong>Toppings:</strong> {{ orderDetails.pizzaSelection.toppings.join(", ") }}</p>
  
        <div class="dialog-actions">
          <button @click="confirmOrder">Confirm Order</button>
          <button @click="cancelOrder">Cancel</button>
        </div>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    props: {
      orderDetails: {
        type: Object,
        required: true
      },
      visible: {
        type: Boolean,
        default: false
      }
    },
    methods: {
      confirmOrder() {
        this.$emit('confirm');
      },
      cancelOrder() {
        this.$emit('cancel');
      }
    }
  };
  </script>
  
  <style scoped>
  .confirmation-dialog {
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background-color: rgba(0, 0, 0, 0.5);
    display: flex;
    align-items: center;
    justify-content: center;
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
  
  button {
    background-color: #4CAF50;
    color: white;
    padding: 10px 20px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
  }
  
  button:hover {
    background-color: #45a049;
  }
  </style>
  