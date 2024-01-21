package com.techelevator.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class Pizza {
    @JsonProperty("pizza_id")
    private int pizzaId;
    @JsonProperty("pizza_name")
    private String pizzaName;
    @JsonProperty("pizza_size")
    private String pizzaSize;
    @JsonProperty("is_available")
    private boolean isAvailable;
    @JsonProperty("pizza_cost")
    private BigDecimal pizzaCost;
    @JsonProperty("max_toppings")
    private int maxToppings;
    @JsonProperty("is_specialty")
    private boolean isSpecialty;
    private int quantity;

    private String note;


    public int getPizzaId() {
        return pizzaId;
    }

    public void setPizzaId(int pizzaId) {
        this.pizzaId = pizzaId;
    }

    public String getPizzaName() {
        return pizzaName;
    }
    public void setPizzaName(String pizzaName) {
        this.pizzaName = pizzaName;
    }
    public String getPizzaSize() {
        return pizzaSize;
    }
    public void setPizzaSize(String pizzaSize) {
        this.pizzaSize = pizzaSize;
    }
    public boolean getIsAvailable() {
        return isAvailable;
    }
    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
    public BigDecimal getPizzaCost() {
        return pizzaCost;
    }
    public void setPizzaCost(BigDecimal pizzaCost) {
        this.pizzaCost = pizzaCost;
    }
    public int getMaxToppings() {
        return maxToppings;
    }
    public void setMaxToppings(int maxToppings) {
        this.maxToppings = maxToppings;
    }
    public boolean getIsSpecialty() {
        return isSpecialty;
    }
    public void setSpecialty(boolean isSpecialty) {
        this.isSpecialty = isSpecialty;
    }
    public String getNote() {
        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
