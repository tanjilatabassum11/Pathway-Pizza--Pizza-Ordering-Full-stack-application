import { createRouter, createWebHistory } from 'vue-router';
import { useStore } from 'vuex';

import HomeView from '../views/HomeView.vue';
import LoginView from '../views/LoginView.vue';
import LogoutView from '../views/LogoutView.vue';
import RegisterView from '../views/RegisterView.vue';
import OrderView from '../views/OrderView.vue';
import UserView from '../views/UserView.vue';
import UserPizzaView from '../views/UserPizzasView.vue';
import UserToppingsView from '../views/UserToppingsView.vue';
import OrderConfirmationView from '../views/OrderConfirmationView.vue';
import UserOrdersView from '../views/UserOrdersView.vue';

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: '/user',
    name: 'user-home',
    component: UserView,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: '/user/pizzas',
    name: 'user-pizzas',
    component: UserPizzaView,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: '/user/toppings',
    name: 'user-toppings',
    component: UserToppingsView,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: '/user/orders',
    name: 'user-orders',
    component: UserOrdersView,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: '/start-order',
    name: 'start-order',
    component: OrderView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: '/orders/create',
    name: 'confirm-order',
    component: OrderConfirmationView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: '/login',
    name: 'login',
    component: LoginView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: '/logout',
    name: 'logout',
    component: LogoutView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: '/register',
    name: 'register',
    component: RegisterView,
    meta: {
      requiresAuth: false
    }
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes
});

router.beforeEach((to, from, next) => {
  const store = useStore();
  const requiresAuth = to.matched.some(route => route.meta.requiresAuth);

  if (requiresAuth && !store.getters.isAuthenticated) {
    next({ name: 'login' });
  } else {
    next();
  }
});

export default router;
