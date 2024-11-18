import java.util.Scanner;

public class MeatPrice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter meat A price: ");
        double meatAPrice = readPositiveValue(scanner);

        System.out.print("Enter meat A weight (in grams): ");
        double meatAWeight = readPositiveValue(scanner);

        System.out.print("Enter meat B price: ");
        double meatBPrice = readPositiveValue(scanner);

        System.out.print("Enter meat B weight (in grams): ");
        double meatBWeight = readPositiveValue(scanner);

        scanner.close();

        double pricePerGramA = meatAPrice / meatAWeight;
        double pricePerGramB = meatBPrice / meatBWeight;
            
        if (pricePerGramA > pricePerGramB) {
            System.out.println("Meat A is more expensive");
        }
        else if (pricePerGramA < pricePerGramB) {
            System.out.println("Meat B is more expensive");
        }
        else {
            System.out.println("They're the same price");
        }
    }

    public static double readPositiveValue(Scanner scanner) {
        while (true) {
            try {
                double value = Double.parseDouble(scanner.nextLine());
                if (value > 0) {
                    return value;
                } else {
                    System.out.print("Please enter a positive value: ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a valid number: ");
            }
        }
    }
}
