package com.techelevator.dao;

import com.techelevator.model.Menu;
import java.util.List;

public interface MenuDao {
    Menu createMenu(Menu menu);
    List<Menu> getAllMenus();
    Menu getMenuById(int menuId);
    Menu updateMenu(Menu menu);
    void deleteMenu(int menuId);
}
