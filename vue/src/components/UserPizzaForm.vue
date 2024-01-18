<template>
    <h1>Specialty Pizzas</h1>
    <button @click="isAddPizzaVisible = !isAddPizzaVisible" :disabled="isPizzaBeingUpdated">{{addPizzaButtonText}}</button>
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
                <td><label for="addAvailable">y/n</label><input name="addAvailable" type="checkbox" v-model="pizzaToAdd.is_available"></td>
                <td><button :disabled="isPizzaBeingUpdated">add</button></td>
            </tr>
            <tr class="pizza-row" v-for="pizza in pizzas" :key="pizza.pizza_id">
                
                <td>
                    <span v-show="!pizza.isPizzaEdit">{{ pizza.pizza_name }}</span> 
                    <input type="text" v-model="pizzaToUpdate.pizza_name" v-if="pizza.isPizzaEdit">
                </td>
                <td>
                    <span v-show="!pizza.isPizzaEdit">{{ pizza.pizza_size }}</span>
                    <select v-if="pizza.isPizzaEdit" v-model="pizzaToUpdate.pizza_size">
                        <option value="small">Small</option>
                        <option value="medium">Medium</option>
                        <option value="large">Large</option>
                    </select>
                </td>
                <td>
                    <span v-show="!pizza.isPizzaEdit">${{ pizza.pizza_cost }}</span>
                    <input type="number" v-model="pizzaToUpdate.pizza_cost" v-if="pizza.isPizzaEdit">
                </td>
                <td>
                    <span v-show="!pizza.isPizzaEdit">{{ pizza.max_toppings }}</span>
                    <input type="number" v-model="pizzaToUpdate.max_toppings" v-if="pizza.isPizzaEdit">
                </td>
                <td>
                    <span v-show="!pizza.isPizzaEdit">{{ pizza.note }}</span>
                    <input type="text" v-model="pizzaToUpdate.note" v-if="pizza.isPizzaEdit">
                </td>
                <td>
                    <span v-show="!pizza.isPizzaEdit">{{ pizza.is_available }}</span>
                    <label for="updateAvailable" v-if="pizza.isPizzaEdit">y/n</label><input name="updateAvailable" type="checkbox" v-model="pizzaToUpdate.is_available" v-if="pizza.isPizzaEdit">


                </td>
                <td>
                    <button :disabled="computeIsPizzaBeingUpdated && !pizza.isPizzaEdit" @click="editPizza(pizza.pizza_id)">{{ pizza.isPizzaEdit ? 'Update':'Edit'  }}</button>
                    <button @click="cancelUpdate(pizza.pizza_id)" v-if="pizza.isPizzaEdit">Cancel</button>
                </td>
                
                

            </tr>
            <div v-if="pizza.isPizzaEdit" class="pizza-toppings">
                    <div v-for="topping in allToppings" :key="topping.topping_id">
                        <input type="checkbox" v-model="topping.isOnPizza">
                        <span>{{ topping.topping_name }}</span> |
                        <span>${{ topping.cost }}</span> |
                        <span>{{ topping.type }}</span>
                        
                    </div>
                </div>
        </tbody>
    </table>

  
</template>

<script>
import PizzaService from '../services/PizzaService';
import ToppingService from '../services/ToppingService';

export default {
    created(){
        PizzaService.getAllSpecialtyPizzas()
        .then((response)=>{
            this.pizzas = response.data;
        });
        ToppingService.getAllToppings()
        .then((response)=>{
            this.allToppings = response.data;
        });
    },
    data(){
        return{
            pizzas:[],
            pizzaToAdd:{},
            isAddPizzaVisible: false,
            pizzaToUpdate: {},
            isPizzaBeingUpdated: false,
            pizzaToppings: [],
            allToppings:[]
        }
    },
    computed:{
        addPizzaButtonText(){
            let toppingsArray = this.allToppings.filter((topping)=>{

                let contains = this.pizzaToppings.find((pizzaTopping)=>{
                    return topping.topping_id == pizzaTopping.topping_id;
                });
                if(contains != undefined){
                    topping.isOnPizza = true;
                }else{
                    topping.isOnPizza = false;
                }
            return topping.isOnPizza;
            });
            return this.isAddPizzaVisible ?
                        'hide add pizza':
                        'add pizza';
        },
        computeIsPizzaBeingUpdated(){
            let toppingsArray = this.allToppings.filter((topping)=>{

                let contains = this.pizzaToppings.find((pizzaTopping)=>{
                    return topping.topping_id == pizzaTopping.topping_id;
                });
                if(contains != undefined){
                    topping.isOnPizza = true;
                }else{
                    topping.isOnPizza = false;
                }
            return topping.isOnPizza;
            });
            return this.isPizzaBeingUpdated;
        }
        // availableToppings(){
        //     let toppingsArray = this.allToppings.filter((topping)=>{

        //         let contains = this.pizzaToppings.find((pizzaTopping)=>{
        //             return topping.topping_id == pizzaTopping.topping_id;
        //         });
        //         if(contains != undefined){
        //             topping.isOnPizza = true;
        //         }else{
        //             topping.isOnPizza = false;
        //         }
        //         return topping.isOnPizza;
        //     });

            // this.allToppings.forEach((topping)=>{
            //     if(this.pizzaToppings.includes())
            // })

        //     return toppingsArray;
        // }
    },
    methods:{
        editPizza(pizzaId){
            let indexOfPizza = this.pizzas.findIndex((pizza)=>{
                return pizza.pizza_id == pizzaId;
            });
            if(!this.pizzas[indexOfPizza].isPizzaEdit){
                this.isPizzaBeingUpdated = true;
                this.pizzas[indexOfPizza].isPizzaEdit = true;
                this.pizzaToUpdate = {...this.pizzas[indexOfPizza]};
                ToppingService.getToppingsByPizzaId(pizzaId)
                .then((response)=>{
                    this.pizzaToppings = response.data;
                });

            }else{
                this.isPizzaBeingUpdated = false;
                this.pizzas[indexOfPizza].isPizzaEdit = false;

                // add some stuff here to send the updated pizza to the server
                this.pizzaToUpdate = {};
                this.pizzaToppings = [];
            }

        },
        cancelUpdate(pizzaId){
            let indexOfPizza = this.pizzas.findIndex((pizza)=>{
                return pizza.pizza_id == pizzaId;
            });
            if(!this.pizzas[indexOfPizza].isPizzaEdit){
                this.isPizzaBeingUpdated = true;
                this.pizzas[indexOfPizza].isPizzaEdit = true;
                this.pizzaToUpdate = this.pizzas[indexOfPizza];
            }else{
                this.isPizzaBeingUpdated = false;
                this.pizzas[indexOfPizza].isPizzaEdit = false;
                this.pizzaToUpdate = {};
                this.pizzaToppings = [];
            }
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
.pizza-row{
    
}

.pizza-toppings{

}
</style>