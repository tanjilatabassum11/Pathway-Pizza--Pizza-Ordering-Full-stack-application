<template>
    <div class="cart">
      <h2>Your Cart</h2>
      <div v-if="cartItems.length">
        <ul>
          <li v-for="(item, index) in cartItems" :key="index">
            <PizzaCard :pizza="item" />
            <div class="cart-item-details">
              <h3>{{ item.name }}</h3>
              <p>{{ item.description }}</p>
              <p>Price: ${{ item.price.toFixed(2) }}</p>
              <div class="quantity">
                <label for="'quantity-' + index">Quantity:</label>
                <input type="number" :id="'quantity-' + index" v-model.number="item.quantity" min="1" @change="updateItem(index)">
              </div>
              <button @click="removeItem(index)">Remove</button>
            </div>
          </li>
        </ul>
        <OrderSummary :items="cartItems" :total="total" />
        <div class="cart-total">
          <p>Total: ${{ total.toFixed(2) }}</p>
          <button @click="checkout">Checkout</button>
        </div>
      </div>
      <p v-else>Your cart is empty.</p>
    </div>
  </template>
  
  <script>
  import PizzaCard from '../components/PizzaCard.vue';
  import OrderSummary from '../components/OrderSummary.vue';
  
  export default {
    components: {
      PizzaCard,
      OrderSummary
    },
    name: 'Cart',
    data() {
      return {
        cartItems: [] 
      };
    },
    computed: {
      total() {
        return this.cartItems.reduce((acc, item) => acc + item.price * item.quantity, 0);
      }
    },
    methods: {
      updateItem(index) {
      },
      removeItem(index) {
        this.cartItems.splice(index, 1);
      },
      checkout() {
      }
    }
  };
  </script>
  
  <style scoped>
  </style>
  
  <style scoped>
  .cart {
    max-width: 600px;
    margin: 0 auto;
    padding: 20px;
    background-color: #f9f9f9;
    border-radius: 8px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  }
  
  .cart-item-image {
    width: 100px;
    height: auto;
    border-radius: 4px;
  }
  
  .cart-item-details {
    display: flex;
    flex-direction: column;
    justify-content: space-around;
    padding: 10px;
  }
  
  .quantity {
    display: flex;
    align-items: center;
    margin-top: 10px;
  }
  
  .quantity label {
    margin-right: 10px;
  }
  
  .quantity input {
    width: 60px;
    padding: 5px;
    border: 1px solid #ccc;
    border-radius: 4px;
  }
  
  .cart-total {
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 20px;
    margin-top: 20px;
    background-color: #fff;
    border-top: 1px solid #eee;
  }
  
  .cart-total p {
    font-size: 1.2em;
    font-weight: bold;
  }
  
  button {
    background-color: #4CAF50;
    color: white;
    padding: 10px 20px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    transition: background-color 0.3s;
  }
  
  button:hover {
    background-color: #45a049;
  }
  </style>
  
  