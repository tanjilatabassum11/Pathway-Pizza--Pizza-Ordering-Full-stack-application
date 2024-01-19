import axios from 'axios';

const API_URL = 'http://localhost:9000';

export default {
  createOrder(orderData) {
    return axios.post(API_URL, orderData)
                .then(response => {
                  return response.data;
                })
                .catch(error => {
                  console.error('Error creating order:', error);
                  throw error;
                });
  },
  getOrders(){
    return axios.get('/orders');
  },
  updateOrder(order){
    return axios.put(`/orders/${order.order_id}`, order);
  }
};
