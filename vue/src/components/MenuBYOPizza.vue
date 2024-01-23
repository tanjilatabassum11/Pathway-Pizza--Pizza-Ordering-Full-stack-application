<template>
  <h2 id="BYOP">Build Your Own Pizza!</h2>
  <div id="container">
    <div class="toppingStyle">
        <h3 
            class="Crust type"> Crust Style
        </h3>
        <div
            v-for="topping in crustToppings" :key="topping.topping_id">{{ topping.topping_name }} {{ topping.cost == 0 ? '':' -$' + topping.cost + ' extra' }}
        </div>
    </div>
    <div class="toppingStyle">
        <h3 
            class="Sauce type"> Pizza Sauces
        </h3>
        <div
            v-for="topping in sauceToppings" :key="topping.topping_id">{{ topping.topping_name }}{{ topping.cost == 0 ? '':'-$' + topping.cost + ' extra' }}
        </div>
    </div>
    <div class="toppingStyle">
        <h3 
            class="Cheese type"> Cheeses
        </h3>
        <div 
            v-for="topping in cheeseToppings" :key="topping.topping_id">{{ topping.topping_name }} - ${{ topping.cost }}
        </div>
    </div>
    <div class="toppingStyle">
        <h3 
            class="Meat type"> Meat Toppings
        </h3>
        <div 
            v-for="topping in meatToppings" :key="topping.topping_id">{{ topping.topping_name }} - ${{ topping.cost }}
        </div>
    </div>
    <div class="toppingStyle">
        <h3 
            class="Fruit type"> Fruit Toppings
        </h3>
        <div 
            v-for="topping in fruitToppings" :key="topping.topping_id">{{ topping.topping_name }} - ${{ topping.cost }}
        </div>
    </div>
    <div class="toppingStyle">
        <h3 
            class="Veggie type"> Veggie Toppings
        </h3>
        <div 
            v-for="topping in veggieToppings" :key="topping.topping_id">{{ topping.topping_name }} - ${{ topping.cost }}
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
.type{
  font-family: "Cooper Hewitt Bold", sans-serif;
  text-decoration: underline;
}
h2{
    font-family: 'Mandalore Laser Title';
    color: #BB554A;
}
#BYOP{
    font-family: 'Mandalore Laser Title';
    color: #A18F63;
}
h3{
    color: #5FA873
}
div{
    text-transform: uppercase;
    
}
#container{
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    flex-wrap: wrap;
}
.toppingStyle{
    margin: 10px;
}
@media only screen and (max-width: 675px) {
    #container{
        flex-direction: column;
        flex-wrap: nowrap;
    }
}
</style>