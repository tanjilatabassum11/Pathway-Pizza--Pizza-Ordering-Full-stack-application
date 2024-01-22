package com.techelevator.model;

import java.math.BigDecimal;

public class Menu {
    private int menuId;
    private int pizzaId;
    private String specialOffer;
    private boolean comboDeal;
    private BigDecimal dealCost;

    // Getters and setters

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public int getPizzaId() {
        return pizzaId;
    }

    public void setPizzaId(int pizzaId) {
        this.pizzaId = pizzaId;
    }

    public String getSpecialOffer() {
        return specialOffer;
    }

    public void setSpecialOffer(String specialOffer) {
        this.specialOffer = specialOffer;
    }

    public boolean isComboDeal() {
        return comboDeal;
    }

    public void setComboDeal(boolean comboDeal) {
        this.comboDeal = comboDeal;
    }

    public BigDecimal getDealCost() {
        return dealCost;
    }

    public void setDealCost(BigDecimal dealCost) {
        this.dealCost = dealCost;
    }
}
