package com.techelevator.controller;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Order;
import com.techelevator.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Order createOrder(@RequestBody Order order) {
        Order newOrder = orderDao.createOrder(order);
        if (newOrder == null) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Order creation failed");
        }
        return newOrder;
    }

    @RequestMapping(path = "/update/{orderId}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Order updateOrder(@PathVariable int orderId, @RequestBody Order order){
        try {
            order.setOrderId(orderId);
            return orderDao.updateOrder(order);
        } catch(DaoException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "We could not find the order");
        }
    }

    //delete
    @RequestMapping(path="/delete/{orderId}", method=RequestMethod.DELETE)
    public void deleteOrder(@PathVariable int orderId){
        orderDao.deleteOrder(orderId);
    }
}

