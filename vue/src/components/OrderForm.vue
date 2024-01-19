<template>
    <form @submit.prevent="saveCustomerInfo">
      <div class="form-group">
        <label for="fullName">Full Name:</label>
        <input id="fullName" v-model="orderData.orderName" type="text" required placeholder="(ex: John Doe)" />
      </div>
  
      <div class="form-group">
        <label for="phoneNumber">Phone Number:</label>
        <input id="phoneNumber" v-model="orderData.phoneNumber" type="tel" required />
      </div>
  
      <div class="form-group">
        <label for="email">Email Address:</label>
        <input id="email" v-model="orderData.emailAddress" type="email" required placeholder="example@example.com" />
      </div>
  
      <div class="form-group">
        <label for="address">Full Address:</label>
        <input id="address" v-model="orderData.address" type="text" required placeholder="123 Example St, City, State 12345" />
      </div>
  
      <div class="form-group">
        <label for="paymentInfo">Payment Card #:</label>
        <input id="paymentInfo" v-model="orderData.paymentInfo" v-mask="['xxxx xxxx xxxx xxxx']" type="text" placeholder="1234567890123456" />
      </div>
  
      <button type="submit" >Save Personal Information</button>
    </form>
  </template>
 <script>
 export default {
   data() {
     return {
       orderData: {
         orderName: '',
         phoneNumber: '',
         orderDateTime: '',
         isDelivery: '',
         deliveryDateTime: '',
         address: '',
         paymentInfo: '',
         totalCost: '',
         orderStatus: 'pending',
         emailAddress: '',
       }
     };
   },
   methods: {
     saveCustomerInfo() {
       this.$store.commit('SET_ORDER', this.customerOrder);
       alert('Customer information saved');
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
