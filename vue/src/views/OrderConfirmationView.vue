
 

<template>

<div class="confirmation">

<!-- This will need to be fixed, the information doesn't show up on the page
but it will be the page that's linked after the "confirm order" button so we have
a trigger event for sending the orderData and Pizzas from the $store to the database
We could try to get the Pizza Name, Cost, Quantity and any topping adjustments from the database
since it will be stored there when they make it to this page.


  


      <h1> Thank you for your order! </h1>
    <div class="order-details">
        <h3> Order Details: </h3>
        <div class="inner-details">
         <p> {{ $store.state.orderData.orderDateTime }} </p>   
        <p> {{ $store.state.orderData.orderName }} </p>
        <p> {{ $store.state.orderData.emailAddress }} </p>
         <p> {{ $store.state.orderData.isDelivery }} </p>
        <p> {{ $store.state.orderData.address }} </p>
        <p> {{ $store.state.orderData.deliveryDateTime }} </p>
        <p> {{ $store.state.orderData.paymentInfo }} </p>
        
        
        <div class="pizza-details">
            <div v-for="pizza in $store.state.selectedPizzas" :key="pizza">
            <p><b> {{pizza.name}}  </b></p>
            <p><b> {{pizza.pizza_cost}} </b></p>
            </div>
        </div>


        <p> {{ $store.state.orderData.totalCost }} </p>

       
         </div>
    </div>

 -->   


  </div>

</template>

<script>
export default {
    data(){
        return {

        }
    }
    

}
</script>

<style>
.order-details {
    background-color: #5FA873;
    border-radius: 5px;
}
.inner-details {
    background-color: #ffff;
    border-radius: 5px;
    text-align: center;
}

</style>