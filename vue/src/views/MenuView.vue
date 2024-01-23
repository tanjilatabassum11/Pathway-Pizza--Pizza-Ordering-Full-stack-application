<template>
  <div class="menu-view">
    <h1>Welcome to Our Menu</h1>

    <!-- Specialty Pizza List -->
    <h2>Specialty Pizzas</h2>
    <div class="pizza-list">
      <MenuPizzaCard v-for="pizza in pizzas" :key="pizza.pizza_id" :pizza="pizza"/>
    </div>
    <MenuBYOPizza></MenuBYOPizza>

    <!-- Toppings List
    <h2>Choose Your Toppings</h2>
    <UserToppingsForm />
    <div class="toppings-section">
      <ul class="toppings-list">
        <li v-for="topping in toppings" :key="topping.topping_id">
          {{ topping.topping_name }}
        </li>
      </ul>
    </div> -->

    <button @click="goToOrderPage" class="order-button">Place Your Order</button>
  </div>
</template>

<script>
import MenuPizzaCard from '../components/menupizzacard.vue';
import PizzaService from '../services/PizzaService';
import ToppingService from '../services/ToppingService.js';
import MenuBYOPizza from '../components/MenuBYOPizza.vue';

export default {
  components: {
    MenuPizzaCard,
    MenuBYOPizza
  },
  data() {
    return {
      pizzas: [],
      toppings: []
    };
  },
  created() {
    this.loadPizzas();
    this.loadToppings();
  },
  methods: {
    async loadPizzas() {
      try {
        const response = await PizzaService.getAllSpecialtyPizzas();
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
    }
  }
};
</script>

<style scoped>
.menu-view {
    text-align: center;
    max-width: 1200px;
    margin: auto;
    padding: 20px;
}

h1, h2 {
    color: var(--brand-darkred-color);
}

.pizza-list {
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
    gap: 20px;
    margin-top: 20px;
}

.pizza-card {
    background-color: var(--brand-lightred-color);
    color: var(--brand-white-color);
    padding: 10px;
    border-radius: 5px;
    text-align: center;
    flex-basis: calc(33.33% - 20px);
}

.toppings-section {
    margin-top: 40px;
}

.toppings-list {
    list-style-type: none;
    padding: 0;
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
    gap: 10px;
}

.toppings-list li {
    background-color: var(--brand-green-color);
    padding: 5px 15px;
    border-radius: 5px;
    font-size: 1em;
}

.order-button {
    margin-top: 30px;
    padding: 10px 20px;
    font-size: 1.2em;
    color: var(--brand-white-color);
    background-color: var(--brand-green-color);
    border: none;
    border-radius: 5px;
    cursor: pointer;
    transition: background-color 0.3s ease-in-out;
}

.order-button:hover {
    background-color: var(--brand-brown-color);
}

@media (max-width: 600px) {
    .pizza-card {
        flex-basis: 100%;
    }
}

@media (min-width: 601px) {
    .pizza-card {
        flex-basis: calc(50% - 20px);
    }
}

@media (min-width: 900px) {
    .pizza-card {
        flex-basis: calc(33.33% - 20px);
    }
}
</style>
