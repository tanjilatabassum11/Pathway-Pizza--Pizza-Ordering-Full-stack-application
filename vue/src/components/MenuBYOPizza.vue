<template>
    <div class="topping-card">
  <h2 id="BYOP">Build Your Own Pizza!</h2>
  <div id="container">
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
.topping-card{
    box-sizing: border-box;
    background-color: #a18f6380;
}
.type{
    font-family: "Cooper Hewitt Bold", sans-serif;
    text-decoration: underline;
    color: white;
    padding: 4px;
    border-bottom: 1px solid black;
}
.toppings:not(:last-child){
    border-bottom: 1px solid black;
}
.toppings:last-child selector{
    border-bottom: none;
}
div{
    
}
h2{
    font-family: 'Mandalore Laser Title';
    color: #BB554A;
}
#BYOP{
    font-family: 'Mandalore Laser Title';
    color: #BB554A;
    background: linear-gradient(45deg, #a18f6380 50%, white 100%)
;
}
#container{
    /* display: flex;
    flex-direction: row;
    justify-content: space-between;
    flex-wrap: wrap; */
}
.topping-style{
    /* margin: auto; */
    padding-top: 5px;
    padding-bottom: 5px;
    border-radius: 8px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, .9999999999999999999999);
    /* display: flex; */
    /* flex-direction: column;
    justify-content: space-around;
    flex-wrap: wrap;
    align-items: flex-start; */
    width: 100px;
    text-transform: uppercase;
    text-align: left;
}
.Crust{
    /* background-color: #A18F63; */
    box-sizing: border-box;
    background-color: #a18f6380;
    color: #BB554A;
    border: #5FA873 2px solid;
    border-radius: 5px;
    transition: 250ms;
}
.Sauce{
    background-color: #BB554A;
}
.Cheese{
    background-color: #5FA873;
}
.Meat{
    background-color: #A18F63;
}
.Fruit{
    background-color: #BB554A;
}
.Veggie{
    background-color: #5FA873;
}
@media only screen and (max-width: 678px) {
    #container{
        flex-direction: column;
        flex-wrap: nowrap;
        padding-left: 25%;
        padding-right: 25%;
    }
}
@media only screen and (max-width: 767px) {
    #container{
        flex-direction: row;
        flex-wrap: wrap;
    }
}
#container{
    display: flex;
    flex-wrap: wrap;
}
.toppings-style{
    flex: 1 0 30%;
    margin: 10px;
    box-sizing: border-box;
}
</style>