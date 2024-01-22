<template>
  <form v-on:submit.prevent="submitForm">
    <div class="topping-card">
      <h1 class="select-header">Included Toppings:</h1>

      <div
        class="toppings"
        v-for="topping in toppings"
        :key="topping.topping_id"
      >
        <label for="{{topping.topping_name}}">
          {{ topping.topping_name }}
        </label>
        <!--checkbox is connected to "currentOnPizza" if topping is on Pizza. Then, when form is submitted
  the pizza information and topping information gets sent to the store as a pizza selection object-->
        <input
          type="checkbox"
          id="{{topping.topping_name}}"
          value="{{topping.topping_name}}"
          v-bind:checked="addToppingsToCurrentToppings"
        />
        
      </div>

      <h1 class="select-header">Select Additional Toppings:</h1>
      <div
        class="toppings"
        v-for="topping in allToppings"
        :key="topping.topping_id"
      >
        <label for="{{topping.topping_name}}">
          {{ topping.topping_name }}
        </label>
        <input
          type="checkbox"
          id="{{topping.topping_name}}"
          value="{{topping.topping_name}}"
          v-bind:checked="addToppingsToCurrentToppings"
        />
      </div>
      <div class="buttons">
      <!-- This button doesn't work yet, but it will send the data to the ("cart")-->
      <input id="submit" value ="submit" type="submit" v-on:click="savePizzaSelection" />

      <button id="back" v-on:click="changePizzaId">Go Back</button>
      </div>

    </div>
  </form>
</template>

<script>
import ToppingService from "../services/ToppingService.js";

export default {
  props: ["currentPizzaId"],
  data() {
    return {
      allToppings: [],
      toppings: [],
      currentToppings: [],

      pizzaSelection: {
        pizza: {
          pizzaId: 0,
          pizzaName: "",
          pizzaSize: "",
          isAvailable: true,
          pizza_cost: 0,
          maxToppings: 0,
          isSpecialty: "",
          note: "",
        },
        toppings: {
          toppingId: 0,
          toppingName: "",
          type: "",
          cost: 0,
          isAvailable: true,
        },
      },
      currentTopping: {
        isOnPizza: false,
        toppingDetails: {
          topping_id: 0,
          topping_name: "",
          type: "",
          cost: 0,
          isAvailable: true,
        },
      },
    };
  },
  computed: {},

  methods: {
    submitForm(pizzaSelection) {
      this.$store.commit("SAVE_PIZZA_SELECTION", pizzaSelection);
      this.$router.push({ name: "start-order" });
    },
    addToppingsToCurrentToppings(currentTopping) {
      this.currentToppings.push(currentTopping);
      currentTopping.isOnPizza = true;
      return this.currentToppings;
    },
    changePizzaId(value) {
      value = 0;
      this.$store.commit("UPDATE_CURRENT_ORDER_ID", value);
      this.$router.push({ name: "start-order" });
    },
    updatePizzaSelection() {
      //saves the values to the pizza and topping objects
    },
    savePizzaSelection(pizzaSelection) {
      //updates the store with the current pizza selections ("in cart")
      this.$store.commit("SAVE_PIZZA_SELECTION", pizzaSelection);
    },
    getToppings() {
      //gets toppings that are specific to the pizza id
      ToppingService.getToppingsByPizzaId(this.currentPizzaId).then(
        (response) => {
          this.toppings = response.data;
        })
    },
    getAllToppings() {
      //gets all available toppings from the database
      ToppingService.getAllToppings()
      .then((response) => {
        this.allToppings = response.data;
      });
    },
    addCurrentToppings() {
      //should display all of the current toppings on the pizza
      this.currentToppings.push(this.currentPizzaId.getToppings());
      return this.currentToppings;
    }
  },

  beforeMount() {
    //gets the available toppings before the page loads
    this.getToppings();
    this.getAllToppings();
  },
};
</script>
  
  <style scoped>
  @import url('https://fonts.cdnfonts.com/css/cooper-hewitt-book');
* {
  font-family: 'Cooper Hewitt Bold', sans-serif;
}
input[type="checkbox" i]{
    accent-color: #BB554A;
}

#submit {
  padding: 10px 15px 10px 15px;
  margin: 8px;
  border-radius: 5px;
   background-color: #A18F63;
  color: #fff;
  border: none;
  cursor: pointer;
  transition: background-color 0.2s ease-in-out;
}
.buttons {
  padding-left: 25%;
}

.topping-card{
  color: #666;
  background-color: #e6ee741a;
  border-radius: 8px;
  margin: 10px;
  padding: 20px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  transition: transform 0.3s ease-in-out;
}

.topping-selection {
  margin: 20px 0;
}

.toppings {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  text-transform: uppercase;
}

.topping {
  margin-right: 15px;
  margin-bottom: 10px;
  display: flex;
  align-items: center;
}

.topping input[type="checkbox"] {
  margin-right: 5px;
}

.topping label {
  cursor: pointer;
}

@media (min-width: 600px) {
  .toppings {
    justify-content: flex-start;
  }
}
</style>
  