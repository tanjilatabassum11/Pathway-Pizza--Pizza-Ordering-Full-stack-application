import axios from 'axios';

export default {

    createOrder(order, orderId){
        const url = "/orders/create";
        return axios.post(url,order);
    }

}