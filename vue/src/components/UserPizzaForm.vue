<template>
    <h1>Specialty Pizzas</h1>
    <button @click="isAddPizzaVisible = !isAddPizzaVisible">{{addPizzaButtonText}}</button>
    <table>
        
        <thead>
            <tr>
                <th>Name</th>
                <th>Size</th>
                <th>Cost</th>
                <th>Max Toppings</th>
                <th>Note</th>
                <th>available</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <tr id="add-pizza" v-show="isAddPizzaVisible">
                <td><input type="text" v-model="pizzaToAdd.pizza_name"></td>
                <td><select v-model="pizzaToAdd.pizza_size">
                    <option value="small">Small</option>
                    <option value="medium">Medium</option>
                    <option value="large">Large</option>
                </select></td>
                <td><input type="number" v-model="pizzaToAdd.pizza_cost"></td>
                <td><input type="number" v-model="pizzaToAdd.max_toppings"></td>
                <td><input type="text" v-model="pizzaToAdd.note"></td>
                <td><label for="">y/n</label><input type="checkbox" v-model="pizzaToAdd.is_available"></td>
                <td><button>add</button></td>
            </tr>
            <tr v-for="pizza in pizzas" :key="pizza.pizza_id">
                <td>
                    <span v-show="!pizza.isPizzaEdit">{{ pizza.pizza_name }}</span> 
                    <input type="text" v-model="pizza.pizza_name" v-show="pizza.isPizzaEdit">
                </td>
                <td>{{ pizza.pizza_size }}</td>
                <td>${{ pizza.pizza_cost }}</td>
                <td>{{ pizza.max_toppings }}</td>
                <td>{{ pizza.note }}</td>
                <td>{{ pizza.is_available }}</td>
                <td><button @click="editPizza(pizza.pizza_id)">{{ pizza.isPizzaEdit ? 'Update':'Edit'  }}</button></td>

            </tr>
        </tbody>
    </table>
  
</template>

<script>
import PizzaService from '../services/PizzaService';
export default {
    created(){
        PizzaService.getAllSpecialtyPizzas()
        .then((response)=>{
            this.pizzas = response.data;
        });
    },
    data(){
        return{
            pizzas:[],
            pizzaToAdd:{},
            isAddPizzaVisible: false,
            pizzaToUpdate: {},
            isPizzaBeingUpdated: false
        }
    },
    computed:{
        addPizzaButtonText(){
            return this.isAddPizzaVisible ?
                        'hide add pizza':
                        'add pizza';
        }
    },
    methods:{
        editPizza(pizzaId){
            let indexOfPizza = this.pizzas.findIndex((pizza)=>{
                return pizza.pizza_id == pizzaId;
            });
            if(!this.pizzas[indexOfPizza].isPizzaEdit){
                this.pizzas[indexOfPizza].isPizzaEdit = true;
            }
            this.pizzaToUpdate = this.pizzas[indexOfPizza];

        }
    }

}
</script>

<style>
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