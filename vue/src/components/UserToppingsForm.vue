<template>
  <h1>Toppings</h1>
  <button @click="isAddToppingVisible = !isAddToppingVisible" :disabled="isToppingBeingUpdated">{{addToppingButtonText}} </button>
  <table>
    <thead>
        <tr>
            <th id="thead-meats">Type</th>
            <th id="thead-meats">Name</th>
            <th id="thead-meats">Cost</th>
            <th></th>
        </tr>
    </thead>
    <tbody>

        <tr id="add-topping" v-show="isAddToppingVisible">
            
        </tr>
        <tr v-for="topping in allToppings" :key="topping.topping_id"> 
            <td>

            </td>
            <td>{{topping.topping_name}}
            </td>
        </tr>
    </tbody>
  </table>
</template>

<script>
import ToppingService from '../services/ToppingService'
export default {
    created(){
        ToppingService.getAllToppings()
        .then((response) => {
            this.allToppings = response.data;
        });
        ToppingService.getToppingByType("meats")
        .then((response) => {
            this.allMeatToppings = response.data;
        });
        ToppingService.getToppingByType("veggies")
        .then((response) => {
            this.allVeggieToppings = response.data;
        });
        ToppingService.getToppingByType("cheese")
        .then((response) => {
            this.allCheeseToppings = response.data;
        });
        ToppingService.getToppingByType("fruit")
        .then((response) => {
            this.allFruitToppings = response.data;
        });
    },
    data(){
        return{
            allToppings: [],
            toppingsToAdd: {},
            allMeatToppings: [],
            allVeggieToppings: [],
            allCheeseToppings: [],
            allFruitToppings: [],
            isAddToppingVisible: false,
        }
    },
    computed:{
        addToppingButtonText(){
            // let toppingsArray = this.allToppings.filter((topping) =>{

            //     let contains = this.toppingsToAdd.find((toppingsToAdd) => {
            //     return topping.topping_id == toppingsToAdd.topping_id;
            //     });
            //     if(contains != undefined){
            //         topping.toppingToBeAdded = true;
            //     }else{
            //         topping.toppingToBeAdded - false;
            //     }
            // return topping.toppingToBeAdded;
            // });
            return this.isAddToppingVisible ?
                        'confirm topping addition':
                        'add topping';
        },

    },
}
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

*{
    font-family: 'Mandalore Laser Title';

}

</style>