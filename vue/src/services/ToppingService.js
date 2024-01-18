import axios from "axios";

export default{
    getToppingsByPizzaId(pizzaId){
        return axios.get(`/toppings/pizza/${pizzaId}`);
    },
    getAllToppings(){
        return axios.get('/toppings');
    }
}