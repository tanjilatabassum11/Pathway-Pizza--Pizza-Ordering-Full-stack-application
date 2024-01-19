import { createStore as _createStore } from 'vuex';
import axios from 'axios';

export function createStore(currentToken, currentUser) {
  let store = _createStore({
    state: {
      token: currentToken || '',
      user: currentUser || {},
      orderData: {

      },
      pizzaSelection: {

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
      }
    },
      SET_PIZZA_ORDER(state, payload){
        state.pizzaSelection = payload;
      },
      UPDATE_ORDER_DATA(state, newData){
        state.orderData = {...state.orderData, ...newData};
       }

  });
  return store;
}
