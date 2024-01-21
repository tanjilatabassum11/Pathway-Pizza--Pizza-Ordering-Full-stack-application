<template>
  <form class="delivery-form" @submit.prevent="submitDeliveryForm">
    <!-- Delivery Address Field -->
    <div class="form-group">
      <label for="address">Delivery Address:</label>
      <input id="address" v-model.trim="deliveryDetails.address" type="text" required placeholder="123 Main St, City, State, Zip">
    </div>

    <!-- Delivery Time Field -->
    <div class="form-group">
      <label for="delivery-time">Preferred Delivery Time:</label>
      <input id="delivery-time" v-model="deliveryDetails.deliveryTime" type="time" required>
    </div>

    <!-- Additional Information (Optional) -->
    <div class="form-group">
      <label for="additional-info">Additional Instructions (Optional):</label>
      <textarea id="additional-info" v-model="deliveryDetails.additionalInfo" placeholder="E.g., Leave at front door."></textarea>
    </div>

    <!-- Submit Button -->
    <button type="submit">Save Delivery Details</button>
  </form>
</template>

<script>
export default {
  data() {
    return {
      deliveryDetails: {
        address: '',
        deliveryTime: '',
        additionalInfo: '' 
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
  max-width: 500px;
  margin: 0 auto;
  padding: 20px;
  border: 1px solid #ccc;
  border-radius: 8px;
  background-color: #f9f9f9;
}

.form-group {
  margin-bottom: 15px;
}

label {
  display: block;
  margin-bottom: 5px;
  font-weight: bold;
}

input[type="text"],
input[type="time"],
textarea {
  width: 100%;
  padding: 8px;
  border: 1px solid #ccc;
  border-radius: 4px;
}

textarea {
  resize: vertical;
}

button {
  background-color: #4CAF50;
  color: white;
  padding: 10px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  transition: background-color 0.3s ease-in-out;
}

button:hover {
  background-color: #45A049;
}
</style>
