import axios from "axios";

export default{

    getAllSpecialtyPizzas(){
        return axios.get('/pizzas/specialty');
    },
    getAvailableSpecialtyPizzas(){
        return axios.get('/pizzas/specialty/available');
    }
}