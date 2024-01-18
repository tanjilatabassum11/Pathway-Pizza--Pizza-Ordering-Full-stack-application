<template>
    <form @submit.prevent="submitForm">
      <div class="form-group">
        <label for="firstName">First Name:</label>
        <input id="firstName" v-model="order.firstName" type="text" required />
      </div>
      <div class="form-group">
        <label for="lastName">Last Name:</label>
        <input id="lastName" v-model="order.lastName" type="text" required />
      </div>
      <div class="form-group">
        <label for="phoneNumber">Phone Number:</label>
        <input id="phoneNumber" v-model="order.phoneNumber" type="tel" required />
      </div>
      <div class="form-group">
        <label for="email">Email Address:</label>
        <input id="email" v-model="order.email" type="email" required />
      </div>
      <div class="form-group">
        <label for="address">Address:</label>
        <input id="address" v-model="order.address" type="text" required />
      </div>
      <div class="form-group">
        <label for="zipcode">Zipcode:</label>
        <input id="zipcode" v-model="order.zipcode" type="text" required />
      </div>
      <button type="submit">Submit Order</button>
    </form>
  </template>
  
  <script>
  export default {
    data() {
      return {
        order: {
          firstName: '',
          lastName: '',
          phoneNumber: '',
          email: '',
          address: '',
          zipcode: ''
        }
      };
    },
    methods: {
      submitForm() {
        this.$emit('submitOrder', this.order);
      }
    }
  };
  </script>
  
  <style scoped>
  .form-group {
    margin-bottom: 15px;
  }
  
  label {
    display: block;
    margin-bottom: 5px;
  }
  
  input[type="text"],
  input[type="email"],
  input[type="tel"] {
    width: 100%;
    padding: 8px;
    border: 1px solid #ccc;
    border-radius: 4px;
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
  