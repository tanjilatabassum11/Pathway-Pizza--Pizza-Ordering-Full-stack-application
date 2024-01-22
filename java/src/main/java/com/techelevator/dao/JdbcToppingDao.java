package com.techelevator.dao;

import com.techelevator.model.Topping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcToppingDao implements ToppingDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Topping> getToppings() {

        List<Topping> toppings = new ArrayList<>();

        String sql = "SELECT topping_id, topping_name, type, cost, is_available\n" +
                "FROM toppings\n" +
                "order by type;";

        try{

            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

            while (results.next()){
                Topping topping = mapRowToTopping(results);
                toppings.add(topping);
            }

        }catch (Exception e){
            System.out.println("Something went wrong with: getToppings " + e.getMessage());
        }
        return toppings;
    }

    @Override
    public Topping getToppingById(int id) {

        Topping topping = null;

        String sql = "SELECT topping_id, topping_name, type, cost, is_available\n" +
                "FROM toppings\n" +
                "WHERE topping_id = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);

            if (results.next()){
                topping = mapRowToTopping(results);
            }

        }catch (Exception e){
            System.out.println("Something went wrong with: getToppingById " + e.getMessage());
        }
        return topping;
    }

    @Override
    public List<Topping> getToppingsByType(String type) {
        List<Topping> toppings = new ArrayList<>();

        String sql = "SELECT topping_id, topping_name, type, cost, is_available\n" +
                "FROM toppings\n" +
                "WHERE type = ?;";

        try{

            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, type);

            while (results.next()){
                Topping topping = mapRowToTopping(results);
                toppings.add(topping);
            }

        }catch (Exception e){
            System.out.println("Something went wrong with: getToppingsByType " + e.getMessage());
        }
        return toppings;
    }

    @Override
    public Topping createTopping(Topping topping) {

        Topping newTopping = null;

        String sql = "INSERT INTO toppings(topping_name, type, cost, is_available)\n" +
                "VALUES(?, ?, ?, ?)\n" +
                "RETURNING topping_id;";

        try{

            int toppingId = jdbcTemplate.queryForObject(sql, int.class,
                    topping.getToppingName(), topping.getType(), topping.getCost(), topping.isAvailable());

            newTopping = getToppingById(toppingId);

        }catch (Exception e){
            System.out.println("Something went wrong with: createTopping " + e.getMessage());
        }
        return newTopping;
    }

    @Override
    public Topping updateTopping(Topping topping) {

        Topping updateTopping = null;

        String sql = "UPDATE toppings\n" +
                "SET topping_name = ?, type = ?, cost = ?, is_available = ?\n" +
                "WHERE topping_id = ?;";

        try{
            int numberOfRows = jdbcTemplate.update(sql, topping.getToppingName(),
                    topping.getType(), topping.getCost(), topping.isAvailable(), topping.getToppingId());
            if(numberOfRows == 0){
                throw new Exception();
            }else {
                updateTopping = getToppingById(topping.getToppingId());
            }
        }catch (Exception e){
            System.out.println("Something went wrong with: updateTopping " + e.getMessage());
        }
        return updateTopping;
    }

    @Override
    public List<Topping> getToppingsByPizzaId(int pizzaId) {

        List<Topping> pizzaToppings = new ArrayList<>();

        String sql = "SELECT toppings.topping_id, toppings.topping_name, toppings.type, toppings.cost, toppings.is_available\n" +
                "FROM toppings\n" +
                "JOIN pizzas_toppings ON pizzas_toppings.topping_id = toppings.topping_id\n" +
                "JOIN pizzas ON pizzas.pizza_id = pizzas_toppings.pizza_id\n" +
                "WHERE pizzas.pizza_id = ?\n" +
                "order by type;";

        try{

            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, pizzaId);

            while (results.next()){
                Topping topping = mapRowToTopping(results);
                pizzaToppings.add(topping);
            }

        }catch (Exception e){
            System.out.println("Something went wrong with: getToppingsByPizzaId " + e.getMessage());
        }
        return pizzaToppings;
    }

    @Override
    public void addToppingToPizza(int toppingId, int pizzaId) {
        String sql = "INSERT INTO pizzas_toppings(pizza_id, topping_id) " +
                "VALUES(?,?);";

        try{
            jdbcTemplate.update(sql, pizzaId, toppingId);

        }catch (Exception e){
            System.out.println("Something went wrong with: addToppingToPizza " + e.getMessage());
        }
    }

    @Override
    public void deleteToppingFromPizza(int toppingId, int pizzaId) {
        String sql = "DELETE\n" +
                "FROM pizzas_toppings\n" +
                "WHERE pizza_id = ?\n" +
                "AND topping_id = ?;";

        try{

            jdbcTemplate.update(sql, pizzaId, toppingId);

        }catch (Exception e){
            System.out.println("Something went wrong with: addToppingToPizza " + e.getMessage());
        }
    }

    @Override
    public List<Topping> getAvailableToppings() {
        List<Topping> availableToppings = new ArrayList<>();

        String sql = "SELECT topping_id, topping_name, type, cost, is_available\n" +
                "FROM toppings\n" +
                "WHERE is_available\n" +
                "order by type;";

        try{

            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

            while(results.next()) {
                Topping topping = mapRowToTopping(results);
                availableToppings.add(topping);
            }
        }catch(Exception e) {
            System.out.println("Something went wrong with: isAvailable");
        }
        return availableToppings;
    }

    public Topping mapRowToTopping(SqlRowSet results){
        Topping topping = new Topping();

        topping.setToppingId(results.getInt("topping_id"));
        topping.setToppingName(results.getString("topping_name"));
        topping.setType(results.getString("type"));
        topping.setCost(results.getBigDecimal("cost"));
        topping.setAvailable(results.getBoolean("is_available"));

        return topping;
    }
}
