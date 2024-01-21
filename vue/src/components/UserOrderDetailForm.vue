<template>
    <h1>{{ order.orderName }}</h1>
    <h3>Phone Number: {{ order.phoneNumber }}</h3>
    <div v-if="order.delivery">
        <h2>Delivery Info:</h2>
        <p>Address: {{ order.address }}</p>
        <p>Delivery Time: {{ order.deliveryDateTime }}</p>
    </div>
    <div class="order">


    </div>
  
</template>

<script>
import UserOrderService from '../services/UserOrderService';

export default {
    data(){
        return{
            order: {},
            pizzas:[]
        }
    },
    created(){
        const id = this.$route.params.orderId;
        
        UserOrderService.getOrderById(id).then((response)=>{
            this.order = response.data;
        });
    }

}
</script>

<style>
@import url('https://fonts.cdnfonts.com/css/cooper-hewitt-book');
@font-face {
    font-family: 'Mandalore Laser Title';
    src: url('../fonts/MandaloreLaserTitle.woff2') format('woff2'),
        url('../fonts/MandaloreLaserTitle.woff') format('woff');
    font-weight: normal;
    font-style: normal;
    font-display: swap;
}
*{
    font-family: 'Cooper Hewitt Book', sans-serif;
}
h1, button{
    font-family: 'Mandalore Laser Title';
}
</style>