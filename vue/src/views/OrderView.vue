
<template>
  <h1>Order Details</h1>
  <form v-on:submit.prevent="createOrder()">
      <div>
          <label>First Name :</label>
          <input type="text" />
      </div>
      <div>
          <label>Last Name :</label>
          <input type="text"  />
      </div>
      <div>
          <label>Phone Number :</label>
          <input type="number"  />
      </div>
      <div>
          <label>Email Address :</label>
          <input type="email"  />
      </div>
      <div>
          <label>Address :</label>
          <input type="text"  />
      </div>
      <div>
          <label>Zipcode :</label>
          <input type="number" />
      </div>
     <div>
      <input type="submit" />
     </div>
  </form>
</template>

<script>
import OrderService from '../services/OrderService.js'
export default {
    data(){
        return {
            order: {}
        }
    },
    
    methods: {
        createOrder(){
            OrderService.createOrder(this.order)
                         .then(
                             (response) => {
                                 this.$router.push({name: "HomeView"})
                             }
                         )
        }
        
    }
}

</script>

<style>

</style>
