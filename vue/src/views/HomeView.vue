<template>
    <div id="home">
      <div>
          <button v-on:click="$router.push({name: 'start-order'})" >Place order</button>
      </div>
      <PizzaCard />
      <PizzaCard />
      <PizzaCard />
    </div>
</template>

<script>

import PizzaCard from '../components/PizzaCard.vue';
export default {
  components:{PizzaCard},

  name: 'HomeView',
  methods: {
      createOrder(orderId){
          console.log('Order created in HomeView', orderId);
      },
  },
};
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

:root{
    --brand-green-color: #5FA873;
    --brand-brown-color: #A18F63;
    --brand-lightred-color: #AC685B;
    --brand-darkred-color: #BB554A;
    --brand-white-color: #FFFFFF;
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
#home{
  display: flex;
  flex-direction: column;
  align-items: center;
}
</style>
