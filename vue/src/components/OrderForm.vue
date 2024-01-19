<template>
  <div class="form-container">
    <form @submit.prevent="saveCustomerInfo" class="customer-form">

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
    </div>
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
.form-container {
  max-width: 400px;
  margin: 25px auto;
  padding: 40px;
  border: 1px solid #ddd;
  border-radius: 10px;
  box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
  background-color: #fff; /* Added a white background for contrast */
}

.customer-form {
  display: flex;
  flex-direction: column;
}

.form-group {
  margin-bottom: 20px; /* Increased margin for more spacing */
}

label {
  display: block;
  margin-bottom: 10px;
  font-weight: bold;
  color: #333; /* Darkened label color */
}

input[type="text"],
input[type="email"],
input[type="tel"] {
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 5px;
  transition: border-color 0.3s ease-in-out; /* Smooth border color transition */
}

input[type="text"]:focus,
input[type="email"]:focus,
input[type="tel"]:focus {
  border-color: #4CAF50; /* Highlight border color on focus */
}

button {
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  transition: background-color 0.3s ease-in-out;
}

button:hover {
  background-color: #45a049;
}
</style>