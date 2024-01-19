<template>
    <h1>Orders</h1>
    <table>
        <thead>
            <tr>
                <th>Name</th>
                <th>Phone Number</th>
                <th>Date Ordered</th>
                <th>Delivery</th>
                <th>Address</th>
                <th>Delivery Date</th>
                <th>Total Cost</th>
                <th>Order Status</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td></td>

            </tr>

        </tbody>
    </table>
  
</template>

<script>
import OrderService from '../services/OrderService';

export default {
    data(){
        return {
            orders:[],

        }
    },
    created(){
        OrderService.getOrders().then((response)=>{
            this.orders = response.data;
        });
    }

}
</script>

<style>

</style>