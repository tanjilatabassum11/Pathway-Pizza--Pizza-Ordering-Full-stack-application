import axios from "axios";

export default {
    getAllPizzas() {
        return axios.get('/pizzas');
    },
      
    getAllSpecialtyPizzas() {
        return axios.get('/pizzas/specialty');
    },

    addToppingToPizza(pizzaId, toppingId) {
        return axios.post(`/pizzas/${pizzaId}/add/${toppingId}`);
    },

    removeToppingFromPizza(pizzaId, toppingId) {
        return axios.delete(`/pizzas/${pizzaId}/remove/${toppingId}`);
    },

    updatePizza(pizza) {
        return axios.put('/pizzas/update', pizza);
    },

    createSpecialtyPizza(pizza) {
        return axios.post('/pizzas/specialty', pizza);
    },

    getAvailableSpecialtyPizzas() {
        return axios.get('/pizzas/specialty/available');
    },

    getAllToppings() {
        return axios.get('/toppings');
    },

    createCustomPizza(pizza) {
        return axios.post('/pizzas/custom', pizza);
    },

    placeOrder(order) {
        return axios.post('/orders', order);
    },

    getOrderConfirmation(orderId) {
        return axios.get(`/orders/confirmation/${orderId}`);
    }
}
