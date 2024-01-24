<template>
  <h2>Cart</h2>
  <div class="cart-contents">
    <div class="item" v-for="pizza in pizzas" :key="pizza.pizza_id">
        <div>
            <span>{{ pizza.pizza_name }}</span>
            <span>{{ pizza.quantity }}</span>
            <span>${{ pizza.pizza_cost * pizza.quantity }}</span>
        </div>
        <div>
            <div v-for="topping in pizza.toppingsOnPizza" :key="topping.topping_id">
                <span>{{topping.topping_name}}</span>
            </div>
        </div>
    </div>
  </div>
</template>

<script>
import ToppingService from '../services/ToppingService';

export default {
    data(){
        return {
            pizzas:[],
            toppings:[]
        }
    },
    created(){
        this.pizzas = this.$store.state.orderData.pizzaSelection;

        ToppingService.getAvailableToppings().then((response)=>{
            this.toppings = response.data;

            this.pizzas.forEach((pizza)=>{
                pizza.toppingsOnPizza = this.toppings.filter((topping)=>{
                    return pizza.toppings.includes(topping.topping_id ); 
                });
            });
        });
    },
    computed:{

    }

}
</script>

<style>

</style>