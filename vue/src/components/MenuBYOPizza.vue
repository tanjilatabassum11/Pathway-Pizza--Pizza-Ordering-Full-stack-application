<template>
    <div class="topping-card">
        <div class="header">
  <h2 id="BYOP">Build Your Own Pizza!</h2>
        </div>
  <div class="container" id="container">
    <div class="topping-style">
        <h3 
            class="Crust type"> Crust Style
        </h3>
        <div class="toppings"
            v-for="topping in crustToppings" :key="topping.topping_id">{{ topping.topping_name }} {{ topping.cost == 0 ? '':'- $' + topping.cost + ' extra' }}
        </div>
    </div>
    <div class="topping-style">
        <h3 
            class="Sauce type"> Pizza Sauces
        </h3>
        <div class="toppings"
            v-for="topping in sauceToppings" :key="topping.topping_id">{{ topping.topping_name }}{{ topping.cost == 0 ? '':'-$' + topping.cost + ' extra' }}
        </div>
    </div>
    <div class="topping-style">
        <h3 
            class="Cheese type"> Cheeses
        </h3>
        <div class="toppings"
            v-for="topping in cheeseToppings" :key="topping.topping_id">{{ topping.topping_name }} - ${{ topping.cost }}
        </div>
    </div>
    <div class="topping-style">
        <h3 
            class="Meat type"> Meat Toppings
        </h3>
        <div class="toppings"
            v-for="topping in meatToppings" :key="topping.topping_id">{{ topping.topping_name }} - ${{ topping.cost }}
        </div>
    </div>
    <div class="topping-style">
        <h3 
            class="Fruit type"> Fruit Toppings
        </h3>
        
        <div class="toppings"
            v-for="topping in fruitToppings" :key="topping.topping_id">{{ topping.topping_name }} - ${{ topping.cost }}
        </div>
        
        <br/>
        <br/>
        <br/>
    </div>
    <div class="topping-style">
        <h3 
            class="Veggie type"> Veggie Toppings
        </h3>
        
        <div class="toppings"
            v-for="topping in veggieToppings" :key="topping.topping_id">{{ topping.topping_name }} - ${{ topping.cost }} 
        </div>
        
      
    </div>
  </div>
</div>

</template>

<script>
import ToppingService from '../services/ToppingService'
export default {
    created(){
        ToppingService.getAvailableToppings()
        .then((response) => {
             this.availableToppings = response.data });
    },
    data(){
        return{
            availableToppings: [],
        }
        // isToppingFree(){

        // }
    },
    computed: {
        crustToppings(){
            return this.availableToppings.filter((topping) => {
                return topping.type =="crust"
            })
        },
        sauceToppings(){
            return this.availableToppings.filter((topping) => {
                return topping.type =="sauce"
            })
        },
        cheeseToppings(){
            return this.availableToppings.filter((topping) => {
                return topping.type == "cheese"
            })
        },
        meatToppings(){
            return this.availableToppings.filter((topping) => {
                return topping.type == "meat"
            })
        },
        fruitToppings(){
            return this.availableToppings.filter((topping) => {
                return topping.type == "fruit"
            })
        },
        veggieToppings(){
            return this.availableToppings.filter((topping) => {
                return topping.type == "veggies"
            })
        }
    }

}
</script>

<style scoped>
@import url('https://fonts.cdnfonts.com/css/cooper-hewitt-book');
@font-face {
    font-family: 'Mandalore Laser Title';
    src: url('../fonts/MandaloreLaserTitle.woff2') format('woff2'),
        url('../fonts/MandaloreLaserTitle.woff') format('woff');
    font-weight: normal;
    font-style: normal;
    font-display: swap;
}
.topping-card {
    box-sizing: border-box;
    background-color: #a18f6380;
}
.container {
    width: 100%;
    height: 50vh;
    display: flex;
    box-sizing: border-box;
    flex-wrap: wrap;
    justify-content: space-evenly;
    align-items: baseline;
    align-content: center;
    row-gap: 1rem;
    column-gap: 1rem;
    flex-grow: 1;
    flex-shrink: 0;
    padding-left: 15px;
    padding-right: 15px;
}
#container > * {
    width: 25%;
    flex-grow: 1;
}
    
.topping-style{
    border-radius: 8px;
    box-shadow: 0 2px 4px rgba(0,0,0, .01);
    width: 50%;
    display: flex;
    flex-direction: column;
    flex-wrap: wrap;
    box-sizing: border-box;
    border: 2px inset #BB554A;
}
.toppings{
   margin: auto;
   padding: 5px 1px;
    text-transform: uppercase;
}
#BYOP {
    font-family: 'Mandalore Laser Title';
    color: #BB554A;
    background: linear-gradient(45deg, #a18f6380 50%, white 100%);
    height: 100%;
}

.type {
    font-family: 'Mandalore Laser Title';
    text-decoration: underline;
    color: white;
    padding: 14px;
    border-bottom: 1px inset black;
    margin: 5px;
}
.toppings:not(:last-child){
    border-bottom: 1px solid black;
}

.type {
    background-color: #a18f6380;
    color: #BB554A;
    border: #5FA873 2px inset;
    border-radius: 5px;
}



</style>