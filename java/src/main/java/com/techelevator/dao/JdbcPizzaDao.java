package com.techelevator.dao;

import com.techelevator.model.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcPizzaDao implements PizzaDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Pizza createSpecialtyPizza(Pizza pizza) {
        Pizza newPizza = null;

        String sql = "insert INTO pizzas(pizza_name, pizza_size, is_available, pizza_cost, max_toppings, is_specialty, note)\n" +
                "VALUES(?, ?, ?, ?, ?, true, ?) RETURNING pizza_id;";

        try{

            int pizzaId = jdbcTemplate.queryForObject(sql, int.class, pizza.getPizzaName(), pizza.getPizzaSize(), pizza.getIsAvailable(), pizza.getPizzaCost(),
            pizza.getMaxToppings(), pizza.getNote());

            newPizza = getPizza(pizzaId);

        }catch(Exception e) {
            System.out.println("Something went wrong with: createSpecialtyPizza" + e.getMessage());
        }
        return newPizza;
    }

    @Override
    public List<Pizza> getAvailableSpecialtyPizzas() {
        List<Pizza> specialtyPizzas = new ArrayList<>();

        String sql = "SELECT pizza_id, pizza_name, pizza_size, is_available, pizza_cost, max_toppings, is_specialty, note\n" +
                "FROM pizzas\n" +
                "WHERE is_specialty\n" +
                "AND is_available;";

        try{
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while(results.next()) {
                Pizza pizza = mapRowToPizza(results);
                specialtyPizzas.add(pizza);
            }
        }catch(Exception e){
            System.out.println("Something went wrong with: getAvailableSpecialtyPizzas");
        }

        return specialtyPizzas;
    }

    @Override
    public Pizza getPizza(int id) {
        Pizza pizza = null;

        String sql = "SELECT pizza_id, pizza_name, pizza_size, is_available, pizza_cost, max_toppings, is_specialty, note\n" +
                "FROM pizzas\n" +
                "WHERE pizza_id = ?;";

        try{

            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);

            while(results.next()) {
                pizza = mapRowToPizza(results);
            }
        }catch(Exception e) {
            System.out.println("Something went wrong with: getPizza");
        }
        return pizza;
    }

    @Override
    public Pizza updatePizza(Pizza pizza) {

        Pizza updatedPizza = null;

        String sql = "UPDATE pizzas\n" +
                "SET pizza_name = ?, pizza_size = ?, is_available = ?, pizza_cost = ?, max_toppings = ?, is_specialty = ?, note = ?\n" +
                "WHERE pizza_id = ?;";

        try{
            int numberOfRows = jdbcTemplate.update(sql, pizza.getPizzaName(), pizza.getPizzaSize(), pizza.getIsAvailable(),
                    pizza.getPizzaCost(), pizza.getMaxToppings(), pizza.getIsSpecialty(), pizza.getNote(), pizza.getPizzaId());

            if(numberOfRows == 0){
                throw new Exception();
            }else{
                updatedPizza = getPizza(pizza.getPizzaId());
            }

        }catch(Exception e) {
            System.out.println("Something went wrong with: updatePizza" + e.getMessage());
        }

        return updatedPizza;
    }

    @Override
    public List<Pizza> getAllSpecialtyPizzas() {

        List<Pizza> allPizzas = new ArrayList<>();

        String sql = "SELECT pizza_id, pizza_name, pizza_size, is_available, pizza_cost, max_toppings, is_specialty, note\n" +
                "FROM pizzas\n" +
                "WHERE is_specialty;";

        try{
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while(results.next()) {
                Pizza pizza = mapRowToPizza(results);
                allPizzas.add(pizza);
            }
        }catch(Exception e){
            System.out.println("Something went wrong with: getAvailableSpecialtyPizzas");
        }

        return allPizzas;
    }

    @Override
    public Pizza getAvailablePizza(int id) {
        Pizza pizza = null;

        String sql = "SELECT pizza_id, pizza_name, pizza_size, is_available, pizza_cost, max_toppings, is_specialty, note\n" +
                "FROM pizzas\n" +
                "WHERE pizza_id = ?\n" +
                "AND is_available;";

        try{

            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);

            while(results.next()) {
                pizza = mapRowToPizza(results);
            }
        }catch(Exception e) {
            System.out.println("Something went wrong with: getPizza");
        }
        return pizza;
    }

    private Pizza mapRowToPizza(SqlRowSet results) {

        Pizza pizza = new Pizza();

        pizza.setPizzaId(results.getInt("pizza_id"));
        pizza.setPizzaName(results.getString("pizza_name"));
        pizza.setPizzaSize(results.getString("pizza_size"));
        pizza.setAvailable(results.getBoolean("is_available"));
        pizza.setPizzaCost(results.getBigDecimal("pizza_cost"));
        pizza.setMaxToppings(results.getInt("max_toppings"));
        pizza.setSpecialty(results.getBoolean("is_specialty"));
        pizza.setNote(results.getString("note"));

        return pizza;
    }
}
