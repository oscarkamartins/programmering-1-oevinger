package fractions;

import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.List;
import java.util.Arrays;

public class Calculator {
    static Scanner scanner = new Scanner(System.in);
    static List<String> modes = Arrays.asList("+", "-", "*", "/", "q");

    public static void main(String[] args) {
        System.out.println();
        while (true) {
            String mode = mathMode();
            if (mode.equals("q")) {
                System.out.println("Quitting...");
                break;
            }
            else if (modes.contains(mode)) {
                System.out.println(mode);;
                mathOperation(mode);
            }

        }
    }

    public static String mathMode() {
        boolean validInput = false;
        String input = "";

        while (!validInput) {
            System.out.println("Pick an option:");
            System.out.println("+: Addition");
            System.out.println("-: Subtraction");
            System.out.println("*: Multiplication");
            System.out.println("/: Division");
            System.out.println("q: Quit");

            try {
                input = scanner.nextLine();
                System.out.println();

                if (modes.contains(input)) {
                    validInput = true;
                }
            }
            catch (InputMismatchException e) {
                System.out.println("You must pick a number between 1-4");
            }
        }
        return input;
    }

    public static void mathOperation(String mode) {
        Fraction f1 = makeFraction();
        Fraction f2 = makeFraction();

        Map<String, BiFunction<Fraction, Fraction, Fraction>> operations = new HashMap<>();
        operations.put("+", (a, b) -> a.addFraction(b));
        operations.put("-", (a, b) -> a.subtractFraction(b));
        operations.put("*", (a, b) -> a.multiplyFraction(b));
        operations.put("/", (a, b) -> a.divideFraction(b));

        Fraction f3 = operations.get(mode).apply(f1, f2);

        System.out.printf("%s %s %s = %s%n", f1.printString(), mode, f2.printString(), f3.printString());
    }

    public static Fraction makeFraction() {
        boolean validInput = false;

        Fraction fraction = new Fraction(1);

        while (!validInput) {
            System.out.println("Enter fraction (x/y):");
            String fString = scanner.nextLine();
            String[] fStringList = fString.split("/");

            if (fStringList.length == 2) {
                try {
                    fraction = new Fraction(Integer.parseInt(fStringList[0]), Integer.parseInt(fStringList[1]));
                    validInput = true;
                }
                catch (InputMismatchException e) {
                    System.out.println("Invalid fraction input");
                }
            }
            else {
                System.out.println("Invalid fraction input");
            }
        }

        return fraction;
    }
}
