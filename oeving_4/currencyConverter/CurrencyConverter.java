package currencyConverter;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CurrencyConverter {

    static Valuta usd = new Valuta("USD", 10.68);
    static Valuta gbp = new Valuta("GBP", 13.82);
    static Valuta dkk = new Valuta("DKK", 1.58);
    static Valuta[] currencies = {usd, gbp, dkk};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int currency = getCurrencyChoice(scanner);
            if (currency == 3) break;

            int direction = getConversionDirection(scanner);
            double amount = getAmount(scanner);

            double result = convertCurrency(currencies[currency], direction, amount);
            print(currencies[currency], direction, amount, result);
        }

        scanner.close();
    }

    public static int getCurrencyChoice(Scanner scanner) {
        int choice = -1;
        while (true) {
            try {
                System.out.println("Pick currency:");
                System.out.println("1. USD");
                System.out.println("2. GBP");
                System.out.println("3. DKK");
                System.out.println("4. Quit");
                choice = scanner.nextInt() - 1;
                if (choice >= 0 && choice <= 3) break;
                System.out.println("Pick a valid option");
            } catch (InputMismatchException e) {
                System.out.println("Pick a valid option");
                scanner.nextLine();
            }
        }
        return choice;
    }

    public static int getConversionDirection(Scanner scanner) {
        int direction = -1;
        while (true) {
            try {
                System.out.println("Convert:");
                System.out.println("1. From NOK");
                System.out.println("2. To NOK");
                direction = scanner.nextInt();
                if (direction == 1 || direction == 2) break;
                System.out.println("Pick a valid option");
            } catch (InputMismatchException e) {
                System.out.println("Pick a valid option");
                scanner.nextLine();
            }
        }
        return direction;
    }

    public static double getAmount(Scanner scanner) {
        double amount = 0;
        while (true) {
            try {
                System.out.println("Amount to convert:");
                amount = scanner.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Pick a valid number");
                scanner.nextLine();
            }
        }
        return amount;
    }

    public static double convertCurrency(Valuta currency, int direction, double amount) {
        return direction == 1 ? currency.fromNok(amount) : currency.toNok(amount);
    }

    public static void print(Valuta currency, int direction, double amount, double result) {
        if (direction == 1) {
            System.out.printf("%.2f NOK = %.2f %s%n", amount, result, currency.getName());
        } else {
            System.out.printf("%.2f %s = %.2f NOK%n", amount, currency.getName(), result);
        }
    }
}
