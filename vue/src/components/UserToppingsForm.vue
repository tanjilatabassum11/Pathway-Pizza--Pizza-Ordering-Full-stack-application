<template>
  <h1>Toppings</h1>
  <button> @click="isAddToppingVisible = !isAddToppingVisible" :disabled="isToppingBeingUpdated">{{addPizzaButtonText}} </button>
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
            <td><input type = "text" v-model="toppingToAdd.topping_name"></td>
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
            this.getAllToppings = response.data;
        });
    }

}
</script>

<style>

</style>