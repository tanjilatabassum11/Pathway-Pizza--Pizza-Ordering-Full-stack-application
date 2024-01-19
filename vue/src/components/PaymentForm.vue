<template>
    <form class="payment-form" @submit.prevent="submitPaymentForm">
      <div class="form-group">
        <label for="card-number">Card Number:</label>
        <input id="card-number" v-model="paymentDetails.cardNumber" type="text" required>
      </div>
  
      <div class="form-group">
        <label for="expiry-date">Expiry Date:</label>
        <input id="expiry-date" v-model="paymentDetails.expiryDate" type="month" required>
      </div>
  
      <div class="form-group">
        <label for="cvv">CVV:</label>
        <input id="cvv" v-model="paymentDetails.cvv" type="text" required>
      </div>
  
      <button type="submit">Save Payment Info</button>
    </form>
  </template>
  
  <script>
  export default {
    data() {
      return {
        paymentDetails: {
          cardNumber: '',
          expiryDate: '',
          cvv: ''
        }
      };
    },
    methods: {
      submitPaymentForm() {
        this.$emit('updatePaymentInfo', this.paymentDetails);
      }
    }
  };
  </script>
  
  <style scoped>
  .payment-form {
  }
  
  .form-group {
    margin-bottom: 15px;
  }
  
  label {
    display: block;
    margin-bottom: 5px;
  }
  
  input[type="text"],
  input[type="month"] {
    width: 100%;
    padding: 8px;
    border: 1px solid #ccc;
    border-radius: 4px;
  }
  
  button {
  }
  </style>
  