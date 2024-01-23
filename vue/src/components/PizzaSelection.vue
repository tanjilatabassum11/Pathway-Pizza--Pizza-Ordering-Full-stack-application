<template>

  <div id="pizza-menu">
    <section id="specialty-pizzas">
       
      <h1 class="menu-section-title">Specialty Pizzas :</h1>
      <div class="pizza-card-parent">
        <div class="pizza-card" v-for="pizza in availablePizzas" :key="pizza.pizza_id">
          <h2>{{ pizza.pizza_name }}</h2>
          <p>{{ pizza.note }}</p>
          <div class="pizza-details">
            <!--toFixed(2) shows decimal number by 2 precision after decimal -->
            <span class="pizza-price">${{ pizza.pizza_cost.toFixed(2) }}</span>
            <button class="add-to-cart-button show-toppings" v-bind:="currentPizzaId"
           @click="changeCurrentPizzaId(pizza.pizza_id); changeStoredCurrentPizza(pizza.pizza_id)" >Add to Cart</button>
          </div>
        </div>
        
      </div>
    </section>


     <section >
     <!-- <div>
        <h4 id="toppingsPopUp">Select your toppings: </h4>
     
        <button>Close</button>
      </div>
    </section>
    <ToppingsView />
    <section>
      <h1 class="menu-section-title">Build Your Own</h1>
      <p v-bind:="getPizza"> {{ $store.state.currentPizzaId  }} </p>
      -->
      <!-- Add your Build Your Own pizza content here -->
      
    </section>



   

  </div>
</template>
<script>
import PizzaService from '../services/PizzaService.js';
//import ToppingsView from '../views/ToppingsView.vue';
export default {
  components: {},
  data() {
    return {
      availablePizzas: [],
      selectedPizzas: [],
      currentPizzaId: 0,
    };
  },
  methods: {
     changeCurrentPizzaId(pizza_id){
      this.currentPizzaId = pizza_id;
      this.$router.push( {name: 'topping'})
    },
    changeStoredCurrentPizza(currentPizzaId){
       this.$store.commit('CHANGE_CURRENT_PIZZA_ID', currentPizzaId);
    },

  },
   created() {
     PizzaService.getAvailableSpecialtyPizzas()
        .then((response) => {
          this.availablePizzas = response.data
        });
  },
  computed: {
    getPizza() {
      return this.$store.state.currentPizzaId;
    }
  }
};
</script>
<style scoped>
@import url('https://fonts.cdnfonts.com/css/cooper-hewitt-book');
*{
    font-family: 'Cooper Hewitt Book', sans-serif;
}
.pizza-menu {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-top: 20px;
}

.menu-section-title {
  font-size: 1.8em;
  margin-bottom: 15px;
  color: #333;
}



.pizza-card-parent {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
}

.pizza-card {
  background-color: #e6ee741a;
  border-radius: 8px;
  margin: 10px;
  padding: 20px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  transition: transform 0.3s ease-in-out;
}

.pizza-card:hover {
  transform: scale(1.05);
}

.pizza-card h2 {
  font-size: 1.2em;
  margin-bottom: 10px;
  color: #333;
}

.pizza-card p {
  margin-bottom: 15px;
  color: #666;
}

.pizza-details {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.pizza-price {
  font-weight: bold;
  color: #e44c26ec; /* Red color for price */
}

.add-to-cart-button {
  background-color: #af844c;
  color: #fff;
  border: none;
  padding: 8px 16px;
  border-radius: 4px;
  cursor: pointer;
  transition: background-color 0.2s ease-in-out;
}

.add-to-cart-button:hover {
  background-color: #a08545fb;
}

</style>
