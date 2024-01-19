<template>
    <div id="home">
      <div>
        <button @click="$router.push({name: 'start-order'})">Place order</button>
      </div>
      <div class="featured-pizzas">
        <h2>Featured Pizzas</h2>
        <div class="pizza-list">
          <PizzaCard
            v-for="(pizza, index) in featuredPizzas" 
            :key="index" 
            :pizza="pizza"
            @addToCart="handleAddToCart"
          />
        </div>
      </div>
      <div class="all-pizzas">
        <h2>All Pizzas</h2>
        <div class="pizza-list">
          <PizzaCard
            v-for="(pizza, index) in pizzas" 
            :key="index" 
            :pizza="pizza" 
            @addToCart="handleAddToCart"
          />
        </div>
      </div>
    </div>
  </template>
  
  <script>
  import PizzaCard from '../components/PizzaCard.vue';
  import PizzaService from '../services/PizzaService';
  
  export default {
    components: { PizzaCard },
    name: 'HomeView',
    data() {
      return {
        pizzas: [],
        featuredPizzas: [], 
      };
    },
    created() {
      this.loadPizzas();
      this.loadFeaturedPizzas(); 
    },
    methods: {
      loadPizzas() {
        PizzaService.getAllPizzas()
          .then(response => {
            this.pizzas = response.data;
          })
          .catch(error => {
            console.error('Error fetching pizzas:', error);
          });
      },
      loadFeaturedPizzas() {
        // Implement logic to fetch featured pizzas
        // This can be a separate API call or a filtered list from all pizzas
      },
      handleAddToCart(pizza) {
        // Logic for adding pizza to cart
      }
    }
  };
  </script>
  
  <style scoped>
  @font-face {
    font-family: 'Mandalore Laser Title';
    src: url('../fonts/MandaloreLaserTitle.woff2') format('woff2'),
        url('../fonts/MandaloreLaserTitle.woff') format('woff');
    font-weight: normal;
    font-style: normal;
    font-display: swap;
}

:root{
    --brand-green-color: #5FA873;
    --brand-brown-color: #A18F63;
    --brand-lightred-color: #AC685B;
    --brand-darkred-color: #BB554A;
    --brand-white-color: #FFFFFF;
}

*{
    font-family: 'Mandalore Laser Title';

}
button{
    margin: 10px;
    background-color: #a18f6380;
    color: #BB554A;
    border: #5FA873 5px solid;
    border-radius: 10px;
    height: 50px;
    width: 150px;
    font-size: 1.1em;
}
#home{
  display: flex;
  flex-direction: column;
  align-items: center;
}

.pizza-list {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
}
  
  .featured-pizzas, .all-pizzas {
    margin-top: 20px;
  }
  
  .pizza-list {
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
  }
  
  .pizza-card {
  }
  </style>
  