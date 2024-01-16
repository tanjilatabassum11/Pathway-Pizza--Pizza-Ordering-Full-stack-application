package com.techelevator.dao;

import com.techelevator.model.Order;

import java.util.List;

public interface OrderDao {
    List<Order> getOrders();

     Order getOrderById(int orderId);

    Order createOrder(Order order);

}
