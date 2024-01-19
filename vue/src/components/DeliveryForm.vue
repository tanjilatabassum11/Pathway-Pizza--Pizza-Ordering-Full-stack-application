<template>
    <form class="delivery-form" @submit.prevent="submitDeliveryForm">
      <div class="form-group">
        <label for="address">Delivery Address:</label>
        <input id="address" v-model="deliveryDetails.address" type="text" required>
      </div>
  
      <div class="form-group">
        <label for="delivery-time">Preferred Delivery Time:</label>
        <input id="delivery-time" v-model="deliveryDetails.deliveryTime" type="time" required>
      </div>
  
      <button type="submit">Save Delivery Details</button>
    </form>
  </template>
  
  <script>
  export default {
    data() {
      return {
        deliveryDetails: {
          address: '',
          deliveryTime: ''
        }
      };
    },
    methods: {
      submitDeliveryForm() {
        this.$emit('updateDeliveryDetails', this.deliveryDetails);
      }
    }
  };
  </script>
  
  <style scoped>
  .delivery-form {
  }
  
  .form-group {
    margin-bottom: 15px;
  }
  
  label {
    display: block;
    margin-bottom: 5px;
  }
  
  input[type="text"],
  input[type="time"] {
    width: 100%;
    padding: 8px;
    border: 1px solid #ccc;
    border-radius: 4px;
  }
  
  button {
  }
  </style>
  