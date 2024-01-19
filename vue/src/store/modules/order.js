export default {
  namespaced: true,

  state: {
    customerDetails: {},
    selectedPizzas: [],
    currentOrder: null,
    orderStatus: ''
  },

  getters: {
    isOrderComplete: state => {
      return state.customerDetails && state.selectedPizzas.length > 0;
    },
    getOrderStatus: state => {
      return state.orderStatus;
    }
  },

  mutations: {
    SET_CUSTOMER_DETAILS(state, details) {
      state.customerDetails = details;
    },
    ADD_PIZZA(state, pizza) {
      state.selectedPizzas.push(pizza);
    },
    REMOVE_PIZZA(state, pizzaIndex) {
      state.selectedPizzas.splice(pizzaIndex, 1);
    },
    SET_CURRENT_ORDER(state, order) {
      state.currentOrder = order;
    },
    CLEAR_ORDER(state) {
      state.customerDetails = {};
      state.selectedPizzas = [];
      state.currentOrder = null;
      state.orderStatus = '';
    },
    SET_ORDER_STATUS(state, status) {
      state.orderStatus = status;
    }
  },

  actions: {
    submitOrder({ commit, state, dispatch }) {
      return new Promise((resolve, reject) => {
        setTimeout(() => {
          const orderData = {
            customerDetails: state.customerDetails,
            pizzas: state.selectedPizzas
          };
          commit('SET_CURRENT_ORDER', orderData);
          commit('SET_ORDER_STATUS', 'submitted');
          dispatch('clearOrderAfterSubmission');
          resolve(orderData);
        }, 1000);
      });
    },
    clearOrderAfterSubmission({ commit }) {
      setTimeout(() => {
        commit('CLEAR_ORDER');
      }, 5000); 
    }
  }
};
