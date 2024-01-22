import axios from "axios";

export default{
    getOrders(){
        return axios.get('/orders');
    },
    getOrderById(orderId){
        return axios.get(`/orders/${orderId}`);
    },
    updateOrder(order){
        return axios.put(`/orders/${order.orderId}`, order);
    }
}