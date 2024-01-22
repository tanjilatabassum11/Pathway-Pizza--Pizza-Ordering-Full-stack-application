package com.techelevator.dao;

import com.techelevator.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcMenuDao implements MenuDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcMenuDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Menu createMenu(Menu menu) {
        String sql = "INSERT INTO menu (pizza_id, special_offer, combo_deal, deal_cost) VALUES (?, ?, ?, ?) RETURNING menu_id;";
        Integer newMenuId = jdbcTemplate.queryForObject(sql, Integer.class, menu.getPizzaId(), menu.getSpecialOffer(), menu.isComboDeal(), menu.getDealCost());
        return getMenuById(newMenuId);
    }

    @Override
    public List<Menu> getAllMenus() {
        List<Menu> menus = new ArrayList<>();
        String sql = "SELECT * FROM menu;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            menus.add(mapRowToMenu(results));
        }
        return menus;
    }

    @Override
    public Menu getMenuById(int menuId) {
        String sql = "SELECT * FROM menu WHERE menu_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, menuId);
        if (results.next()) {
            return mapRowToMenu(results);
        }
        return null;
    }

    @Override
    public Menu updateMenu(Menu menu) {
        String sql = "UPDATE menu SET pizza_id = ?, special_offer = ?, combo_deal = ?, deal_cost = ? WHERE menu_id = ?;";
        jdbcTemplate.update(sql, menu.getPizzaId(), menu.getSpecialOffer(), menu.isComboDeal(), menu.getDealCost(), menu.getMenuId());
        return getMenuById(menu.getMenuId());
    }

    @Override
    public void deleteMenu(int menuId) {
        String sql = "DELETE FROM menu WHERE menu_id = ?;";
        jdbcTemplate.update(sql, menuId);
    }

    private Menu mapRowToMenu(SqlRowSet rs) {
        Menu menu = new Menu();
        menu.setMenuId(rs.getInt("menu_id"));
        menu.setPizzaId(rs.getInt("pizza_id"));
        menu.setSpecialOffer(rs.getString("special_offer"));
        menu.setComboDeal(rs.getBoolean("combo_deal"));
        menu.setDealCost(rs.getBigDecimal("deal_cost"));
        return menu;
    }
}
