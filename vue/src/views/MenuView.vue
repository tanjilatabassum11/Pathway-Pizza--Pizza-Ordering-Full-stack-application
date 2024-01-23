<template>
  <div class="menu-view">
    <h1>Welcome to Our Menu</h1>

    <!-- Specialty Pizza List -->
    <h2>Specialty Pizzas</h2>
    <div class="pizza-list">
      <PizzaCard 
        v-for="pizza in pizzas" 
        :key="pizza.pizza_id" 
        :pizza="pizza"
      />
    </div>

    <!-- Toppings List -->
    <h2>Choose Your Toppings</h2>
    <div class="toppings-section">
      <ul class="toppings-list">
        <li v-for="topping in toppings" :key="topping.topping_id">
          {{ topping.topping_name }}
        </li>
      </ul>
    </div>

    <!-- Sides and Drinks Sections Here -->

    <button @click="goToOrderPage" class="order-button">Place Your Order</button>
  </div>
</template>

<script>
import PizzaCard from '../components/PizzaCard.vue';
import PizzaService from '../services/PizzaService';
import ToppingService from '../services/ToppingService.js';

export default {
  components: {
    PizzaCard
  },
  data() {
    return {
      pizzas: [],
      toppings: [],
      
    };
  },
  created() {
    this.loadPizzas();
    this.loadToppings();
  },
  methods: {
    async loadPizzas() {
      try {
        const response = await PizzaService.getAllPizzas();
        this.pizzas = response.data;
      } catch (error) {
        console.error('Error fetching pizzas:', error);
      }
    },
    async loadToppings() {
      try {
        const response = await ToppingService.getAllToppings();
        this.toppings = response.data;
      } catch (error) {
        console.error('Error fetching toppings:', error);
      }
    },
    goToOrderPage() {
      this.$router.push({ name: 'OrderPage' });
    },
    // Add methods to load sides and drinks if needed
  }
};
</script>

<style scoped>
/* existing styles */

/* Add styles for sides and drinks sections */
</style>
