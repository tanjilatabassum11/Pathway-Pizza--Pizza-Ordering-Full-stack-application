import axios from "axios";

export default{

    getAllSpecialtyPizzas(){
        return axios.get('/pizzas/specialty');
    },
    addToppingToPizza(pizzaId, toppingId){
        return axios.post(`/pizzas/${pizzaId}/add/${toppingId}`);
    },
    removeToppingFromPizza(pizzaId, toppingId){
        return axios.delete(`/pizzas/${pizzaId}/remove/${toppingId}`);
    },
    updatePizza(pizza){
        return axios.put(`/pizzas/update`, pizza);
    },
    createSpecialtyPizza(pizza){
        return axios.post(`/pizzas/specialty`, pizza);
    }
}