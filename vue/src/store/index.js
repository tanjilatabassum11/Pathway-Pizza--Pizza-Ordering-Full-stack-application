import { createStore as _createStore } from 'vuex';
import axios from 'axios';

export function createStore(currentToken, currentUser) {
  let store = _createStore({
    state: {
      currentOrderId: 0,
      currentPizzaId: 0,
      token: currentToken || '',
      user: currentUser || {},
      //orderData is what will be sent back to the database
      //to update each - orderData.customerDetails will need to be
      //sent first and then we will recieve back an order_id
      //the pizza_id and order_id  can be sent back to database to
      //associate a pizza with an order. pizzaSelection is an array of selections
      //that will need to be iterated through - to add more than one pizza to an order -
      //and then the toppings (which holds an array of topping_ids) will
      //need to be iterated through and each should be sent back with the pizza_id 
      orderData: {
        customerDetails: {
          orderName: "",
          phoneNumber: "",
          orderDateTime: "",
          isDelivery: false,
          address: "",
          deliveryDateTime: '',
          paymentInfo: "",
          totalCost: 0,
          orderStatus: 'pending',
          emailAddress: ''
        },
        pizzaSelection: [
        //   {
        //   pizzaId: 0,
        //   toppings: [],
        //   quantity: 0
        // }
      ]

      }
      
    },
    mutations: {
      SET_AUTH_TOKEN(state, token) {
        state.token = token;
        localStorage.setItem('token', token);
        axios.defaults.headers.common['Authorization'] = `Bearer ${token}`;
      },
      SET_USER(state, user) {
        state.user = user;
        localStorage.setItem('user', JSON.stringify(user));
      },
      LOGOUT(state) {
        localStorage.removeItem('token');
        localStorage.removeItem('user');
        state.token = '';
        state.user = {};
        axios.defaults.headers.common = {};
      },
      SET_ORDER(state, payload){
        state.orderData = payload;
      },

       SET_PIZZA_ORDER(state, payload){
        state.orderData.pizzaSelection = payload;
      },
      // UPDATE_ORDER_DATA will be used for getting information for orders
      //on the OrderForm Component that gets customer billing info
      //and the PizzaSelection Component that gets isDelivery and totalCost info
      //The ... is a spread operator so that the newDataFields are the only 
      //ones that change. In the PizzaSelection Component this will need to be 
      //called, but someone else is making changes so I have to wait -B
      UPDATE_ORDER_DATA(state, newData){
        state.orderData = {...state.orderData, ...newData};
       },
       CHANGE_CURRENT_PIZZA_ID(state, selectedPizzaId){
        state.currentPizzaId = selectedPizzaId;
      },
       SAVE_PIZZA_SELECTION(state, currentToppings){
         let newPizzaSelection = {
        pizzaId : state.currentPizzaId,
        toppings : currentToppings,
        quantity : 1
         }

         state.orderData.pizzaSelection.unshift(newPizzaSelection);
         
         
       },
       ADD_PIZZA_TO_STORE(state, pizza){
        if(pizza.quantity > 0){
          state.orderData.pizzaSelection.unshift(pizza);
        }
       },
       DELETE_PIZZA(state, pizza_id){
        let pizzaIndex = state.orderData.pizzaSelection.findIndex((pizza) => {
          return pizza.pizza_id == pizza_id;
        });
        if(pizzaIndex > -1) {
          state.orderData.pizzaSelection.splice(pizzaIndex, 1)
        }
        // this.pizza = this.pizza.filter((pizza_id) => {
        // 
        // })
       },
       CLEAR_ORDER(state, payload){
          state.orderData = {};
          state.orderData = {
            customerDetails: {
              orderName: "",
              phoneNumber: "",
              orderDateTime: "",
              isDelivery: false,
              address: "",
              deliveryDateTime: '',
              paymentInfo: "",
              totalCost: 0,
              orderStatus: 'pending',
              emailAddress: ''
            },
            pizzaSelection: []
          }
       }

        //vv Not sure if we need this - orderId is auto-generated vv

      //  UPDATE_CURRENT_ORDER_ID(state, newData){
      //   state.currentOrderId = newData;
      // },
     
    },
     

  });
  return store;
}
