import axios from "axios";

export default{
    getToppingsByPizzaId(pizzaId){
        return axios.get(`/toppings/pizza/${pizzaId}`);
    },
    getAllToppings(){
        return axios.get('/toppings');
    },
    getToppingByType(type){
        return axios.get(`/toppings/type/${type}`)
    }
}