package restaurantRegister;

public class Dish {
    private String name;
    private String type;
    private String recipe;
    private double price;

    public Dish(String name, String type, String recipe, double price) {
        this.name = name;
        this.type = type;
        this.recipe = recipe;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getRecipe() {
        return recipe;
    }

    public double getPrice() {
        return price;
    }

    public String toString() {
        String string = "Name: " + name + "\n"
            + "Type: " + type + "\n"
            + "Recipe: " + recipe + "\n"
            + "Price: " + price + "\n";
        
        return string;
    }
}
