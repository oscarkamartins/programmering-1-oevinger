package restaurantRegister;

import java.util.ArrayList;
import java.util.Scanner;

public class Client {
    private static final Scanner scanner = new Scanner(System.in);

    public static MenuRegister init() {
        ArrayList<Dish> menu1Dishes = new ArrayList<Dish>();

        menu1Dishes.add(new Dish("Salad", "Appetizer", "idk", 40));
        menu1Dishes.add(new Dish("Garlic Bread", "Appetizer", "idk", 60));
        menu1Dishes.add(new Dish("Pizza", "Main", "idk", 130));
        menu1Dishes.add(new Dish("Pasta", "Main", "idk", 90));
        menu1Dishes.add(new Dish("Brownies", "Dessert", "idk", 1000));
        menu1Dishes.add(new Dish("Chocolate", "Dessert", "idk", 1000));
        menu1Dishes.add(new Dish("Coca cola", "Drink", "idk", 30));
        menu1Dishes.add(new Dish("Classic Brown Sugar Boba Tea", "Drink", "idk", 200));

        Menu menu1 = new Menu(menu1Dishes, 0);

        ArrayList<Dish> menu2Dishes = new ArrayList<Dish>();

        menu2Dishes.add(new Dish("Sawdust", "Appetizer", "idk", 10));
        menu2Dishes.add(new Dish("Air", "Appetizer", "idk", 5));
        menu2Dishes.add(new Dish("Sludge", "Main", "idk", 30));
        menu2Dishes.add(new Dish("Grass", "Main", "idk", 40));
        menu2Dishes.add(new Dish("Fentanyl", "Dessert", "idk", 400));
        menu2Dishes.add(new Dish("Galaxy Gas", "Dessert", "idk", 200));
        menu2Dishes.add(new Dish("Lean", "Drink", "idk", 90));
        menu2Dishes.add(new Dish("Moonshine", "Drink", "idk", 0));

        Menu menu2 = new Menu(menu2Dishes, 1);

        ArrayList<Menu> menus = new ArrayList<Menu>();
        menus.add(menu1);
        menus.add(menu2);

        return new MenuRegister(menus);
    }

    public static String getNonEmptyString(String message) {
        String validString = "";

        while (true) {
            System.out.println(message);
            validString = scanner.nextLine();

            if (validString.equals("")) {
                System.out.println("Empty input");
            }
            else {
                break;
            }
        }

        return validString;
    }

    public static double getValidDouble(String message) {
        double validDouble = 0;

        while (true) {
            System.out.println(message);
            try {
                validDouble = Double.parseDouble(scanner.nextLine());
                break;
            }
            catch (NumberFormatException e) {
                System.out.println("Invalid input");
            }
        }

        return validDouble;
    }

    public static int getValidInt(String message) {
        int validInt = 0;

        while (true) {
            System.out.println(message);
            try {
                validInt = Integer.parseInt(scanner.nextLine());
                break;
            }
            catch (NumberFormatException e) {
                System.out.println("Invalid input");
            }
        }

        return validInt;
    }

    public static Dish newDish() {
        String name = getNonEmptyString("Name:");
        String type = getNonEmptyString("Type:");
        String recipe = getNonEmptyString("Recipe:");
        double price = getValidDouble("Price:");

        return new Dish(name, type, recipe, price);
    }

    public static int pickOption() {
        while (true) {
            int option = getValidInt("Pick an option:\n1. New dish\n2. Find dish by name\n3. Find dishes by type\n4. New menu\n5. Find menus in price interval\n6. List all menus\n7. Quit");

            if (option > 0 && option < 8) {
                return option;
            }
            else {
                System.out.println("Pick a valid option");
            }
        }
    }

    public static void client(MenuRegister menuRegister) {
        while (true) {
            int option = pickOption();

            switch (option) {
                case 1:
                    int menuId = getValidInt("Menu id:");
                    menuRegister.addDishToMenu(menuId, newDish());

                    break;
                case 2:
                    String name = getNonEmptyString("Dish name");
                    System.out.println(menuRegister.findDishByName(name));
                    
                    break;
                case 3:
                    String type = getNonEmptyString("Dish type:");
                    ArrayList<Dish> dishesOfType = menuRegister.findDishByType(type);

                    for (Dish dish : dishesOfType) {
                        System.out.println(dish + "\n");
                    }

                    break;
                case 4:
                    int dishCount = getValidInt("How many dishes");
                    ArrayList<Dish> newMenuDishes = new ArrayList<>(dishCount);

                    for (int i = 0; i < dishCount; i++) {
                        newMenuDishes.add(newDish());
                    }

                    menuRegister.addMenu(newMenuDishes);

                    break;
                case 5:
                    ArrayList<Menu> menusInPriceInterval = menuRegister.menusInPriceInterval(getValidDouble("Lowest price:"), getValidDouble("Highest price:"));

                    for (Menu menu : menusInPriceInterval) {
                        System.out.println("Menu " + menu.getId() + " has a total price of " + menu.price());
                    }

                    break;
                case 6:
                    for (Menu menu : menuRegister.getMenus()) {
                        System.out.println(menu);
                    }

                    break;
                case 7:
                    return;
                default:
                    System.out.println("Pick a valid option");
                    
                    break;
            }
        }
    }
    public static void main(String[] args) {
        MenuRegister menuRegister = init();
        
        client(menuRegister);
    }
}
