<template>
    <form>
      <div class="form-group">
        <label for="fullName">Full Name: </label>
        <input v-on:change="saveOrder" id="fullName" v-model="customerOrder.orderName" type="text" required placeholder="(ex: John Doe)" />
      </div>

      <div class="form-group">
        <label for="phoneNumber">Phone Number:</label>
        <input id="phoneNumber" v-model="customerOrder.phoneNumber" type="tel" required />
      </div>
      <div class="form-group">
        <label for="email">Email Address:</label>
        <input id="email" v-model="customerOrder.emailAddress" type="email" required  placeholder="example@example.com"/>
      </div>
      <div class="form-group">
        <label for="address">Full Address:</label>
        <input id="address" v-model="customerOrder.address" type="text" required placeholder="123 Example pl. Example, Ohio 43231" />
      </div>
      <div class="form-group">
        <label for="paymentInfo">Please Enter Your Card #: </label>
        <input id="paymentInfo" v-model="customerOrder.paymentInfo" type="text" placeholder="1234567" />
      </div>
      <div>
        <button value="Save Personal Info" @click="saveCustomerInfo">Save Personal Information Before Selecting Pizzas</button>
      </div>
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
        },
        customerOrder: {
          orderName: '',
          phoneNumber: '',
          orderDateTime: '',
          isDelivery: '',
          address: '',
          deliveryDateTime: '',
          paymentInfo: '',
          totalCost: '',
          orderStatus: '',
          emailAddress: ''
        }
      };
    },
    computed : {
      
    },
    methods: {
      saveCustomerInfo(){
        this.$store.commit('SET_ORDER', this.customerOrder);
      },
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
  