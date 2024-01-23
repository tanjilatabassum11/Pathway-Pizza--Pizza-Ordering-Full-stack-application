<template>
  <div class="form-container">
    <form @submit.prevent="saveCustomerInfo" class="customer-form">
      <div class="form-group">
        <label for="fullName">Full Name:</label>
        <input id="fullName" v-model.trim="orderData.orderName" type="text" required placeholder="John Doe" />
      </div>
      <div class="form-group">
        <label for="phoneNumber">Phone Number:</label>
        <input id="phoneNumber" v-model.trim="orderData.phoneNumber" type="tel" required pattern="[0-9]{10}" title="Phone number should be 10 digits" />
      </div>
      <div class="form-group">
        <label for="email">Email Address:</label>
        <input id="email" v-model.trim="orderData.emailAddress" type="email" required placeholder="example@example.com" />
      </div>
      <div class="form-group">
        <label for="address">Full Address:</label>
        <input id="address" v-model.trim="orderData.address" type="text" required placeholder="123 Example St, City, State 12345" />
      </div>

      <div class="form-group">
        <label for="paymentInfo">Payment Card #:</label>
        <input id="paymentInfo" v-model="orderData.paymentInfo" type="text" placeholder="1234 5678 9012 3456" />
      </div>
      <button type="submit">Save Personal Information</button>
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
        emailAddress: '',
        address: '',
        paymentInfo: '', 
      }
    };
  },
  methods: {
    saveCustomerInfo() {
      // You might want to handle the form submission here
      // For example, sending data to a parent component or an API
      this.$emit('updateCustomerInfo', this.orderData);
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
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  background-color: rgb(250, 247, 247); 
}

.customer-form {
  display: flex;
  flex-direction: column;
}

.form-group {
  margin-bottom: 20px; 
}

label {
  display: block;
  margin-bottom: 10px;
  font-weight: bold;
  color: #333; 
}

input[type="text"],
input[type="email"],
input[type="tel"] {
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 5px;
  transition: border-color 0.3s ease-in-out; 
}

input[type="text"]:focus,
input[type="email"]:focus,
input[type="tel"]:focus {
  border-color: #4CAF50; 
}

button {
  background-color: #494747;
  color: white;
  padding: 14px 20px;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  transition: background-color 0.3s ease-in-out;
  box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
}

button:hover {
  background-color: #141414f3;
}
</style>
