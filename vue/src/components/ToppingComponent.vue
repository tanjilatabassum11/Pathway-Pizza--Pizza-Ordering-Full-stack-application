<template>
  <form v-on:submit.prevent="submitToppingsForm">
    <div class="topping-card">

      

      <h1 class="select-header">Select Additional Toppings:</h1>

      <br />
      <span> Choose Your Sauce: </span>
      <div
        class="toppings sauce"
        v-for="topping in sauces"
        :key="topping.topping_id"
      >
        <label :for="topping.topping_id" class="sauce-option">
          {{ topping.topping_name }}
        </label>
        
          <input type="radio"
            :id="topping.topping_name"
            v-bind:checked="topping.isOnPizza"
            v-on:change="changeSauce(topping.topping_id)"
            name="sauceToppings"
          /> 
          
     
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
       
          <input type="radio"
            :id="topping.topping_name"
            v-bind:checked="topping.isOnPizza"
            v-on:change="changeCrust(topping.topping_id)"
            name="crustOptions"
          />

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
          v-model="topping.isOnPizza"
         
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
          v-model="topping.isOnPizza"
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
          v-model="topping.isOnPizza"
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
          v-model="topping.isOnPizza"
          :value="topping.topping_id"
        />
      </div>

     
      <div class="buttons">
        <button id="back" v-on:click="changePizzaId">Go Back</button>

        
        <input
          id="submit"
          value="submit"
          type="submit"
           />
        
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
    // currentSauceId() {
    //   return this.currentPizzaId
    // }
    crust(){
      return this.allToppings.filter((topping) => {
        return topping.type == 'crust';
      });
    },
    sauces(){
      return this.allToppings.filter((topping) => {
        return topping.type == 'sauce';
      });
    },
    fruitToppings(){
      return this.allToppings.filter((topping) => {
        return topping.type == 'fruit';
      });
    },
    veggieToppings(){
      return this.allToppings.filter((topping) => {
        return topping.type == 'veggies';
      });
    },
   cheeseToppings(){
      return this.allToppings.filter((topping) => {
        return topping.type == 'cheese';
      });
    },
    meatToppings(){
      return this.allToppings.filter((topping) => {
        return topping.type == 'meat';
      });
    },
    selectedToppingIds(){
      let selectedToppings = [];
      this.allToppings.forEach((topping) => {
       if(topping.isOnPizza){
         selectedToppings.push(topping.topping_id)
       }
      })
      return selectedToppings;
    }


  },

  methods: {

    
//updates the store with the current pizza selections ("in cart")
    submitToppingsForm() {
      this.$store.commit("SAVE_PIZZA_SELECTION", this.selectedToppingIds);
      this.$router.push({ name: "start-order" });
    },
// changes pizzaID currently being stored in ("cart")
    changePizzaId(value) {
      this.$store.commit("UPDATE_CURRENT_ORDER_ID", value);
      this.$router.push({ name: "start-order" });
    },
    changeSauce(sauceId){
      this.sauces.forEach((sauce) => {
        if(sauceId == sauce.topping_id){
          sauce.isOnPizza = true;
        } else {
          sauce.isOnPizza = false;
        }
      })
    },
    changeCrust(crustId){
      this.sauces.forEach((crust) => {
        if(crustId == crust.topping_id){
          crust.isOnPizza = true;
        } else {
          crust.isOnPizza = false;
        }
      })
    },

 /* ****Below Methods are for when the page loads**** */
 /* ********************************************************* */

 //gets toppings that are specific to the pizza id
    async getToppings() {
      try {
        const response = await ToppingService.getToppingsByPizzaId(this.currentPizzaId);
          this.includedToppings = response.data;
          this.allToppings.forEach((topping) => {
            let contains = this.includedToppings.find((pizzaTopping) => {
              return topping.topping_id == pizzaTopping.topping_id;
            })
            if(contains != undefined){
              topping.isOnPizza = true;
            }
            else {
              topping.isOnPizza = false;
            }
          })
          
      } catch (error) {
            console.error('There was an error getting the pizza or toppings', error)
      }
       },
  //gets all available toppings from the database 
    async getAllToppings() {
      try {
        const response = await ToppingService.getAvailableToppings();
        this.allToppings = response.data;

      } catch (error) {
        console.erorr('Unexpected Error Getting Toppings', error)
      }
     
     
    },
   //should add includedToppings on pizza to currentToppings
   //comes back 'undefined'  
    addCurrentToppings() {
      this.includedToppings.forEach((topping) => {
          this.currentToppings.push(topping.topping_id);
      });
    },
  },
 async mounted() {
   
   await  this.getAllToppings();
   await this.getToppings();
  },

  created() {
    
    

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
  