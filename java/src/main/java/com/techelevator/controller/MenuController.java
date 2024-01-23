package com.techelevator.controller;

import com.techelevator.dao.MenuDao;
import com.techelevator.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/menu")
public class MenuController {

    private final MenuDao menuDao;

    @Autowired
    public MenuController(MenuDao menuDao) {
        this.menuDao = menuDao;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Menu createMenu(@RequestBody Menu menu) {
        return menuDao.createMenu(menu);
    }

    @GetMapping
    public List<Menu> getAllMenus() {
        return menuDao.getAllMenus();
    }

    @GetMapping("/{menuId}")
    public Menu getMenuById(@PathVariable int menuId) {
        return menuDao.getMenuById(menuId);
    }

    @PutMapping("/{menuId}")
    public Menu updateMenu(@PathVariable int menuId, @RequestBody Menu menu) {
        menu.setMenuId(menuId);
        return menuDao.updateMenu(menu);
    }

    @DeleteMapping("/{menuId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMenu(@PathVariable int menuId) {
        menuDao.deleteMenu(menuId);
    }
}
