package com.techelevator.dao;

import com.techelevator.model.Order;
import com.techelevator.model.Pizza;

import java.util.List;
import java.util.Optional;

public interface OrderDao {
    List<Order> getOrders();

     Optional<Order> getOrderById(int orderId);

    Order createOrder(Order order);
    Order updateOrder(Order order);
    boolean deleteOrder(int orderId);

    public void addPizzasToOrder(int orderId, int pizzaId, int quantity);

}
