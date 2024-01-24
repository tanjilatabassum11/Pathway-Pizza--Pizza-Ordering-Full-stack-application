<template>

  <div class="form-container">
    <form v-on:submit.prevent="saveCustomerInfo" class="customer-form">
   <h1> Please Enter Your Information: </h1>  
      <div class="form-group">
        <label for="fullName" id="customer-info">Full Name:</label>
        <input id="fullName" v-model="customerDetails.orderName" type="text" required placeholder="ex: John Doe" />
      </div>
      <div class="form-group" >
        <label for="phoneNumber" id="customer-info">Phone Number:</label>
        <input id="phoneNumber" v-model="customerDetails.phoneNumber" type="tel" required  title="Phone number should be 10 digits" />
      </div>
      <div class="form-group">
        <label for="email" id="customer-info">Email Address:</label>
        <input id="email" v-model="customerDetails.emailAddress" type="email" required placeholder="example@example.com" />
      </div>
    
    <div class="delivery-option">
   <h3> Please make a selection: </h3>
      <div class="form-group delivery">
        <label for="isDelivery" id="customer info" class="delivery-option">Delivery</label>
        <input type="radio" 
        :id="customerDetails.isDelivery"
        @click="deliverySelection(true)"
        name="deliveryOption" 
        value="delivery" />
      </div>
       <div class="form-group pickup">
        <label for="isDelivery" id="customer-info" class="delivery-option">Pick-Up</label>
        <input type="radio" 
        :id="customerDetails.isDelivery"
       @click="deliverySelection(false)"
        name="deliveryOption" 
        value="pickup" />
      </div>
      </div>

      <div v-show="customerDetails.isDelivery" class="form-group">
        <label for="address" id="customer-info">Full Address:</label>
        <input id="address" v-model="customerDetails.address" type="text" placeholder="123 Example St, City, State 12345" />
      </div>

      <div v-show="customerDetails.isDelivery" class="form-group">
        <label for="paymentInfo" id="customer-info">Payment Card #:</label>
        <input id="paymentInfo" v-model="customerDetails.paymentInfo" type="text" placeholder="1234 5678 9012 3456" />
      </div>
      <button type="submit" id="submit" value="submit">Save Billing Information</button>
    </form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      customerDetails: {
          orderName: "",
          phoneNumber: "",
          orderDateTime: "",
          isDelivery: false,
          address: "",
          deliveryDateTime: '',
          paymentInfo: "",
          totalCost: 0,
          orderStatus: 'pending',
          emailAddress: ''
      }
   }
  },
  computed: {
  
  },
  methods: {
      deliverySelection(selection) {
        if(selection === true){
          this.customerDetails.isDelivery = true;
        } else{
          this.customerDetails.isDelivery = false;
        }
         return this.customerDetails.isDelivery;
    },
    saveCustomerInfo() {
     this.$store.commit('UPDATE_ORDER_DATA', this.customerDetails);
     //alert("Thanks! Please continue with your order");
    }
  }
};
</script>


<style scoped>
@import url("https://fonts.cdnfonts.com/css/cooper-hewitt-book");

* {
  font-family: "Cooper Hewitt Bold", sans-serif;
  font-size: 20px;
}
h1, h3 {
  font-size: 30px;
  margin-bottom: 38px;
  border-bottom: 1px solid lightgray;
}

.form-container {
  max-width: 50%;
  margin: auto;
  padding: 40px;
  border-radius: 8px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  background-color: #e6ee741a; 
}
.form-container {
  display: flex;
}

.customer-form {
  max-width: 75%;
  margin: auto;
}


.form-group {
  margin-bottom: 20px; 
}

form {
  display: block;
  margin-bottom: 10px;
  font-weight: bold;
  color: #333; 
}

input[type="text"],
input[type="email"],
input[type="tel"] {
  width: 100%;
  padding: 8px;
  border: 1px solid #ccc;
  border-radius: 5px;
  transition: border-color 0.3s ease-in-out; 
}

input[type="text"]:focus,
input[type="email"]:focus,
input[type="tel"]:focus {
  border-color: #4CAF50; 
}

input[type="radio"] {
    accent-color: #BB554A;
    display: inline;
  margin: 5px;
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

#submit {
  background-color: #AC685B;
  border: none;
  cursor: pointer;
  margin: 5px;
  font-size: 22px;
}
#submit:hover {
  background-color: #5FA873;
}


</style>
