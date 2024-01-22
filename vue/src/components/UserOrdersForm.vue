<template>
    <h1>Orders</h1>
    <button class="show-hide" @click="showHide()">{{showCompletedAndCanceled ? 'Show': 'Hide'}} Completed and Canceled orders</button>
    <table>
        <thead>
            <tr>
                <th id="thead-name">Name</th>
                <th id="thead-ph">Phone Number</th>
                <th id="thead-date-ordered">Date Ordered</th>
                <th id="thead-delivery">Delivery</th>
                <th id="thead-address">Address</th>
                <th id="thead-delivery-date">Delivery Date</th>
                <th id="thead-cost">Total Cost</th>
                <th id="thead-status">Order Status</th>
            </tr>
        </thead>
        <tbody>
            <tr class="order" :class="{'complete': order.orderStatus == 'complete', 
                                        'pending': order.orderStatus == 'pending',
                                        'in-kitchen': order.orderStatus == 'in kitchen',
                                        'delivered': order.orderStatus == 'delivered',
                                        'awaiting-pickup': order.orderStatus == 'awaiting pickup',
                                        'canceled': order.orderStatus == 'canceled',
                                        'out-for-delivery': order.orderStatus == 'out for delivery'}" 
                                        v-for="order in ordersToShow" :key="order.orderId"
                                        @click="goToDetails(order.orderId)">
                <td class="uppercase">{{ order.orderName }}</td>
                <td>{{ order.phoneNumber }}</td>
                <td>{{ order.orderDateTime }}</td>
                <td>{{ order.delivery ? 'Delivery' : 'Pickup' }}</td>
                <td>{{ order.delivery ? order.address : '--' }}</td>
                <td>{{ order.delivery ? order.deliveryDateTime : '--' }}</td>
                <td>${{ order.totalCost }}</td>
                <td class="uppercase status" >{{ order.orderStatus }}</td>

            </tr>

        </tbody>
    </table>
  
</template>

<script>
import OrderService from '../services/OrderService';
import UserOrderService from '../services/UserOrderService';

export default {
    data(){
        return {
            orders:[],
            showCompletedAndCanceled: true,


        }
    },
    computed:{
        ordersToShow(){
            let displayedOrders = [];
            if(this.showCompletedAndCanceled){
                displayedOrders = this.orders.filter((order)=>{
                    return order.orderStatus != 'complete' && order.orderStatus != 'canceled';
                });
            }else{
                displayedOrders = this.orders;
            }
            return displayedOrders;
        }
    },
    created(){
        UserOrderService.getOrders().then((response)=>{
            this.orders = response.data;
        });
        // OrderService.getOrders().then((response)=>{
        //     this.orders = response.data;
        // });
    },
    methods:{
        showHide(){
            this.showCompletedAndCanceled = !this.showCompletedAndCanceled;
        },
        goToDetails(orderId){
            this.$router.push({name:'user-orders-details', params:{orderId: orderId}})
        }
    }

}
</script>

<style scoped>
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
h1, th, button{
    font-family: 'Mandalore Laser Title';
}

h1{
    
    color: #A18F63;
}
th{
    color: white;
}
.uppercase{
    text-transform: uppercase;
}
table {
  border-collapse: collapse;
  border-bottom: #5FA873 1px solid;
}
.order{
    
    border-top: #5FA873 1px solid;
    cursor: pointer;
    color: white;
    margin-top: 10px;
    margin-bottom: 10px;
}
.order>td{
    text-align: center;
}
.status{
    font-family: 'Cooper Hewitt Bold', sans-serif;
}
/* 'complete': order.orderStatus == 'complete', 
'pending': order.orderStatus == 'pending',
'in-kitchen': order.orderStatus == 'in kitchen',
'delivered': order.orderStatus == 'delivered',
'awaiting-pickup': order.orderStatus == 'awaiting pickup',
'out-for-delivery': order.orderStatus == 'out for delivery'}"  */
.complete{
    background-color: #5FA873;
}
.pending{
    background-color: #a18f6380;
    color: #BB554A;
}
.canceled{
    background-color: #BB554A;
}
.in-kitchen{
    background: linear-gradient(45deg, #5FA873 25%, #a18f6380 50%);
    
}
.awaiting-pickup{
    background: linear-gradient(45deg, #5FA873 90%, #a18f6380 100%);
}
.out-for-delivery{
    background: linear-gradient(45deg, #5FA873 75%, #a18f6380 100%);
}
.delivered{
    background-color: #5FA873;
}
/* <th id="thead-name">Name</th>
<th id="thead-ph">Phone Number</th>
<th id="thead-date-ordered">Date Ordered</th>
<th id="thead-delivery">Delivery</th>
<th id="thead-address">Address</th>
<th id="thead-delivery-date">Delivery Date</th>
<th id="thead-cost">Total Cost</th>
<th id="thead-status">Order Status</th> */
#thead-name{
    background-color: #5FA873;
    width: 100px;
}
#thead-ph{
    background-color: #A18F63;
    width: 75px;
}
#thead-date-ordered{
    background-color: #AC685B;
    width: 100px;
}
#thead-delivery{
    background-color: #5FA873;
    width: 75px;
}
#thead-address{
    background-color: #A18F63;
    width: 100px;
}
#thead-delivery-date{
    background-color: #BB554A;
    width: 100px;
}
#thead-cost{
    background-color: #5FA873;
    width: 75px;
}
#thead-status{
    background-color: #A18F63;
    width: 150px;
}
button{
    box-sizing: border-box;
    background-color: #a18f6380;
    color: #BB554A;
    border: #5FA873 2px solid;
    border-radius: 5px;
    transition: 250ms;
    cursor: pointer;
}
button:hover,
button:active{
    background-color: #ffffff;
    color: #BB554A;
    border-radius: 5px;
    transition: 250ms;
}
.show-hide{
    margin: 10px;
    font-size: 1.1em;
    padding: 10px;
}
</style>