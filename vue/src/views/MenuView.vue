<template>
    <div class="menu-view">
      <h1>Our Pizza Menu</h1>
      <div class="specialty-pizzas">
        <h2>Specialty Pizzas</h2>
        <div class="pizza-list">
          <PizzaCard 
            v-for="(pizza, index) in specialtyPizzas" 
            :key="index" 
            :pizza="pizza"
            @addToCart="handleAddToCart"
          />
        </div>
      </div>
  
      <div class="build-your-own">
        <h2>Build Your Own Pizza</h2>
        <PizzaBuilder @pizzaCreated="handleAddToCart" />
      </div>
    </div>
  </template>
  
  <script>
  import PizzaCard from '../components/PizzaCard.vue';
  import PizzaBuilder from '../components/PizzaBuilder.vue';
  import PizzaService from '../services/PizzaService'; 
  
  export default {
    components: {
      PizzaCard,
      PizzaBuilder
    },
    data() {
      return {
        specialtyPizzas: [],
      };
    },
    created() {
      this.loadSpecialtyPizzas();
    },
    methods: {
      loadSpecialtyPizzas() {
        PizzaService.getSpecialtyPizzas()
          .then(response => {
            this.specialtyPizzas = response.data;
          })
          .catch(error => {
            console.error('Error fetching specialty pizzas:', error);
          });
      },
      handleAddToCart(pizza) {
      }
    }
  };
  </script>
  
  <style scoped>
  .menu-view {
    text-align: center;
  }
  
  .specialty-pizzas, .build-your-own {
    margin-top: 20px;
  }
  
  .pizza-list {
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
  }
  </style>
  