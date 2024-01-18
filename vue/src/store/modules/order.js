export default {
    namespaced: true,
  
    state: {
      customerDetails: {},
      selectedPizzas: [],
      currentOrder: null
    },
  
    getters: {
      isOrderComplete: state => {
        return state.customerDetails && state.selectedPizzas.length > 0;
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
      }
    },
  
    actions: {
      submitOrder({ commit, state }) {
        // Here, you would typically make an API call to submit the order
        // For this example, we'll just simulate order submission
        return new Promise((resolve) => {
          setTimeout(() => {
            const orderData = {
              customerDetails: state.customerDetails,
              pizzas: state.selectedPizzas
            };
            commit('SET_CURRENT_ORDER', orderData);
            commit('CLEAR_ORDER');
            resolve(orderData);
          }, 1000);
        });
      }
    }
  };
  