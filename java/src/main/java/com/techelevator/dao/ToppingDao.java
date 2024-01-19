package com.techelevator.dao;

import com.techelevator.model.Topping;

import java.util.List;

public interface ToppingDao {
    public List<Topping> getToppings();
    public Topping getToppingById(int id);
    public List<Topping> getToppingsByType(String type);
    public Topping createTopping(Topping topping);
    public Topping updateTopping(Topping topping);
    public List<Topping> getToppingsByPizzaId(int pizzaId);
    public void addToppingToPizza(int toppingId, int pizzaId);
    public  void deleteToppingFromPizza(int toppingId, int pizzaId);
    public List<Topping> getAvailableToppings();
}
