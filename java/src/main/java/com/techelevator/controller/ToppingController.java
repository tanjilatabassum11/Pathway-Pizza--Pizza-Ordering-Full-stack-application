package com.techelevator.controller;

import com.techelevator.dao.ToppingDao;
import com.techelevator.model.Topping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "/toppings")
public class ToppingController {

    @Autowired
    private ToppingDao toppingDao;

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Topping> getToppings(){
        return toppingDao.getToppings();
    }

    @RequestMapping(path = "/type/{type}", method = RequestMethod.GET)
    public List<Topping> getToppingsByType(@PathVariable String type){
        return toppingDao.getToppingsByType(type);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Topping getToppingById(@PathVariable int id){
        return toppingDao.getToppingById(id);
    }

    @RequestMapping(path = "/pizza/{pizzaId}", method = RequestMethod.GET)
    public List<Topping> getToppingsByPizzaId(@PathVariable int pizzaId){
        return toppingDao.getToppingsByPizzaId(pizzaId);
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(path = "", method = RequestMethod.POST)
    public Topping createTopping(@RequestBody Topping topping){
        return toppingDao.createTopping(topping);
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(path = "", method = RequestMethod.PUT)
    public Topping updateTopping(@RequestBody Topping topping){
        return toppingDao.updateTopping(topping);
    }



}
