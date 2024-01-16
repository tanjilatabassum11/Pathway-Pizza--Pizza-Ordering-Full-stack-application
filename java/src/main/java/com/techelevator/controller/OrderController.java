package com.techelevator.controller;

import com.techelevator.model.Order;
import com.techelevator.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderDao orderDao;

    @GetMapping
    public List<Order> listOrders() {
        return orderDao.getOrders();
    }
    @GetMapping("/{id}")

    public ResponseEntity<Order> getOrderById(@PathVariable int id){
        Order order = orderDao.getOrderById(id);
        if (order == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(order);
    }
//    @PostMapping
//    public ResponseEntity<Order> createOrder(@RequestBody Order order){
//
//    }
}