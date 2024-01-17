package com.techelevator.controller;

import com.techelevator.model.Order;
import com.techelevator.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderDao orderDao;

    @Autowired
    public OrderController(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @GetMapping
    public List<Order> listOrders() {
        return orderDao.getOrders();
    }

    @RequestMapping(path = "/{orderId}", method = RequestMethod.GET)
    public Order getOrderById(@PathVariable("orderId") int orderId) {
        return orderDao.getOrderById(orderId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found"));
    }

//    @RequestMapping(path = "/create", method = RequestMethod.POST)
//    @ResponseStatus(HttpStatus.CREATED)
//    public Order createOrder(@RequestBody Order order) {
//        return orderDao.createOrder(order)
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "created order not found"));



    }

