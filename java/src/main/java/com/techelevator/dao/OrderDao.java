package com.techelevator.dao;

import com.techelevator.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderDao {
    List<Order> getOrders();

     Optional<Order> getOrderById(int orderId);

    Order createOrder(Order order);
    Order updateOrder(Order order);
    boolean deleteOrder(int orderId);

}
