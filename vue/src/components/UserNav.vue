<template>
    <div>
        <button id="pizzas" @click="pizzaClick()">Pizzas</button>
        <button id="toppings" @click="toppingClick()">Toppings</button>
        <button id="orders" @click="ordersClick()">Orders</button>
        <!-- <button id="users">Users</button> -->
    </div>
  
</template>

<script>
export default {
    methods:{
        pizzaClick(){
            this.$router.push({name: 'user-pizzas'})
        },
        toppingClick(){
            this.$router.push({name: 'user-toppings'})

        },
        ordersClick(){
            this.$router.push({name: 'UserOrderView'})

        },
    }

}
</script>

<style scoped>
@font-face {
    font-family: 'Mandalore Laser Title';
    src: url('../fonts/MandaloreLaserTitle.woff2') format('woff2'),
        url('../fonts/MandaloreLaserTitle.woff') format('woff');
    font-weight: normal;
    font-style: normal;
    font-display: swap;
}
*{
    font-family: 'Mandalore Laser Title';

}
button{
    margin: 10px;
    background-color: #a18f6380;
    color: #BB554A;
    border: #5FA873 5px solid;
    border-radius: 10px;
    height: 50px;
    width: 150px;
    font-size: 1.1em;
}
div{
    display: flex;
    justify-content: center;
}
</style>