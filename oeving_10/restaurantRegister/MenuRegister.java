package restaurantRegister;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class MenuRegister {
    private ArrayList<Menu> menus;

    public MenuRegister(ArrayList<Menu> menus) {
        this.menus = menus;
    }

    public ArrayList<Menu> getMenus() {
        return menus;
    }

    public void addDishToMenu(int menuId, Dish dish) {
        menus.stream()
        .filter(menu -> menu.getId() == menuId)
        .findFirst().orElse(null)
        .addDish(dish);
    }

    public Dish findDishByName(String dishName) {
        return menus.stream()
            .flatMap(menu -> menu.getDishes().stream())
            .filter(dish -> dish.getName().equals(dishName))
            .findFirst()
            .orElse(null);
    }

    public ArrayList<Dish> findDishByType(String dishType) {
        return menus.stream()
            .flatMap(menu -> menu.getDishes().stream())
            .filter(dish -> dish.getType().equals(dishType))
            .collect(Collectors.toCollection(ArrayList :: new));
    }

    public void addMenu(ArrayList<Dish> dishes) {
        menus.add(new Menu(dishes, menus.size()));
    }

    public ArrayList<Menu> menusInPriceInterval(double lowest, double highest) {
        return menus.stream()
            .filter(menu -> (menu.price() >= lowest && menu.price() <= highest))
            .collect(Collectors.toCollection(ArrayList :: new));
    }
}
