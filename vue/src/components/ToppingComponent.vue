<template>
  <form v-on:submit.prevent="submitForm">
    <div class="topping-card">
      <h1 class="select-header">Included Toppings:</h1>

      <div
        class="toppings"
        v-for="topping in includedToppings"
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
          v-model="currentToppings"
          :value="topping.topping_id"
        />
      </div>

      <h1 class="select-header">Select Additional Toppings:</h1>
      <!-- <div
        class="toppings"
        v-for="topping in allToppings"
        :key="topping.topping_id"
      > -->

      <br />
      <span> Choose Your Sauce: </span>
      <div
        class="toppings sauce"
        v-for="topping in sauces"
        v-bind:key="topping.type"
      >
        <label for="sauce-options" id="sauces">
          {{ topping.topping_name }}
        </label>
        <select name="sauce-options" id="sauces">
          <option
            id="{{topping.topping_name}}"
            v-bind:select="addToppingsToCurrentToppings"
            :value="topping.topping_id"
          >
            {{ topping.topping_name }}
          </option>
        </select>
      </div>
      <br /><br />

      <span> Choose Your Crust: </span>
      <div
        class="toppings crust"
        v-for="topping in crust"
        v-bind:key="topping.type"
      >
        <label for="crust-options" id="crust">
          {{ topping.topping_name }}
        </label>
        <select name="crust-options" id="crust">
          <option
            id="{{topping.topping_name}}"
            v-bind:select="addToppingsToCurrentToppings"
            :value="topping.topping_id"
          >
            {{ topping.topping_name }}
          </option>
        </select>
      </div>

      <br /><br />

      <span> Choose Your Meats: </span>
      <div
        class="toppings meat"
        v-for="topping in meatToppings"
        v-bind:key="topping.type"
      >
        <label for="{{topping.topping_name}}">
          {{ topping.topping_name }}
        </label>

        <input
          type="checkbox"
          id="{{topping.topping_name}}"
          v-model="currentToppings"
          :value="topping.topping_id"
        />
      </div>
      <br />
      <span> Choose Your Cheese: </span>
      <div
        class="toppings cheese"
        v-for="topping in cheeseToppings"
        v-bind:key="topping.type"
      >
        <label for="{{topping.topping_id}}">
          {{ topping.topping_name }}
        </label>

        <input
          type="checkbox"
          id="{{topping.topping_name}}"
          v-model="currentToppings"
          :value="topping.topping_id"
        />
      </div>
      <br />
      <span> Choose Your Veggies: </span>
      <div
        class="toppings veggies"
        v-for="topping in veggieToppings"
        v-bind:key="topping.type"
      >
        <label for="{{topping.topping_name}}">
          {{ topping.topping_name }}
        </label>

        <input
          type="checkbox"
          id="{{topping.topping_name}}"
          v-model="currentToppings"
          :value="topping.topping_id"
        />
      </div>

      <br />
      <br />
      <span> Choose Your Fruit: </span>
      <div
        class="toppings fruit"
        v-for="topping in fruitToppings"
        v-bind:key="topping.type"
      >
        <label for="{{topping.topping_name}}">
          {{ topping.topping_name }}
        </label>

        <input
          type="checkbox"
          id="{{topping.topping_id}}"
          v-model="currentToppings"
          :value="topping.topping_id"
        />
      </div>

      <!-- </div> -->
      <div class="buttons">
        <button id="back" v-on:click="changePizzaId">Go Back</button>

        <!-- This button doesn't work yet, but it will send the data to the ("cart")-->
        <input
          id="submit"
          value="submit"
          type="submit"
          v-on:click="savePizzaSelection" />
        
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
      //allToppings holds all available toppings and they get filterd 
      //through the arrays below by "type"
      //includedToppings are the getToppingsByPizzaId() result
      //currentToppings holds the current customer selection for the 
      //topping choices selected. It will need to be sent to the store
      //upon clicking "submit"


      allToppings: [],
      includedToppings: [],
      currentToppings: [],

      meatToppings: [],
      cheeseToppings: [],
      veggieToppings: [],
      fruitToppings: [],
      sauces: [],
      crust: [],

      
    };
  },
  computed: {
    //Not currently using this. Got available toppings from
    //the database instead, but might use it for future.
    // allAvailableToppings() {
    //   return this.allToppings.filter((topping) => {
    //     return topping.isAvailable;
    //   });
    // },
  },

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
          this.includedToppings = response.data;
        }
      );
    },
    getAllToppings() {
      //gets all available toppings from the database
      ToppingService.getAvailableToppings().then((response) => {
        this.allToppings = response.data;
      });
    },
    addCurrentToppings() {
      //should display all of the current toppings on the pizza
      this.currentToppings.push(this.currentPizzaId.getToppings());
      return this.currentToppings;
    },
  },

  beforeMount() {
    //gets the available toppings before the page loads
  },
  created() {
    this.getToppings();
    this.getAllToppings();
    this.includedToppings.forEach((topping) => {
      this.currentToppings.push(topping.id);
    });
    ToppingService.getToppingByType("meat").then((response) => {
      this.meatToppings = response.data;
    });
    ToppingService.getToppingByType("veggies").then((response) => {
      this.veggieToppings = response.data;
    });
    ToppingService.getToppingByType("cheese").then((response) => {
      this.cheeseToppings = response.data;
    });
    ToppingService.getToppingByType("fruit").then((response) => {
      this.fruitToppings = response.data;
    });
    ToppingService.getToppingByType("sauce").then((response) => {
      this.sauces = response.data;
    });
    ToppingService.getToppingByType("crust").then((response) => {
      this.crust = response.data;
    });
  },
};
</script>
  
  <style scoped>
@import url("https://fonts.cdnfonts.com/css/cooper-hewitt-book");
* {
  font-family: "Cooper Hewitt Bold", sans-serif;
}
input[type="checkbox" i] {
  accent-color: #bb554a;
}

#submit {
  padding: 10px 15px 10px 15px;
  margin: 8px;
  border-radius: 5px;
  background-color: #a18f63;
  color: #fff;
  border: none;
  cursor: pointer;
  transition: background-color 0.2s ease-in-out;
}
.buttons {
  padding-left: 25%;
}

.topping-card {
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
  