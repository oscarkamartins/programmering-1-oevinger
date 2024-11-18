package restaurantRegister;

import java.util.ArrayList;

public class Menu {
    private ArrayList<Dish> dishes;
    private int id;

    public Menu(ArrayList<Dish> dishes, int id) {
        this.id = id;
        this.dishes = dishes;
    }

    public ArrayList<Dish> getDishes() {
        return dishes;
    }

    public int getId() {
        return id;
    }

    public void addDish(Dish dish) {
        dishes.add(dish);
    } 

    public double price() {
       double price = dishes.stream()
            .mapToDouble(dish -> dish.getPrice())
            .sum();

        return price;
    }

    public String toString() {
        String string = "Menu " + id + ":\n";

        for (Dish dish : dishes) {
            string += dish.toString() + "\n";
        }

        return string;
    }
}
