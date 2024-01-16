package com.techelevator.controller;

import com.techelevator.dao.PizzaDao;
import com.techelevator.model.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path="/pizzas")

public class PizzaController {
    @Autowired
    private PizzaDao pizzaDao;
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(path="/specialty", method= RequestMethod.POST)
    public Pizza createSpecialtyPizza(@RequestBody Pizza pizza) {
        return pizzaDao.createSpecialtyPizza(pizza);
    }

    @RequestMapping(path="/specialty/available", method=RequestMethod.GET)
    public List<Pizza> getAvailableSpecialtyPizzas(){
        return pizzaDao.getAvailableSpecialtyPizzas();
    }
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(path="/{id}", method=RequestMethod.GET)
    public Pizza getPizza(@PathVariable int id) {
        return pizzaDao.getPizza(id);
    }
    @RequestMapping(path="/{id}/customer", method=RequestMethod.GET)
    public Pizza getAvailablePizza(@PathVariable int id) {
        return pizzaDao.getPizza(id);
    }
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(path="/update", method=RequestMethod.PUT)
    public Pizza updatePizza(@RequestBody Pizza pizza){
        return pizzaDao.updatePizza(pizza);
    }
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(path="/specialty", method=RequestMethod.GET)
    public List<Pizza> getAllSpecialtyPizzas(){
        return pizzaDao.getAllSpecialtyPizzas();
    }
}
