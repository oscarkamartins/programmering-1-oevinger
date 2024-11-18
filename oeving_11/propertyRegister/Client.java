package propertyRegister;

import java.util.Scanner;

/**
 * A client that allows the user to interact with the PropertyRegister and Property classes.
 */
public class Client {
    /** Scanner used for inputs. */
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Used by the client to get a non-empty string from the scanner.
     * 
     * @param message Gets logged in the console prior to input
     * @return A non empty string
     */
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

    /**
     * Used by the client to get a double from the scanner.
     * 
     * @param message Gets logged in the console prior to input
     * @return A double
     */
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

    /**
     * Used by the client to get an integer from the scanner.
     * 
     * @param message Gets logged in the console prior to input
     * @return A integer
     */
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

    /**
     * Used to pick an option in the menu.
     * 
     * @return an integer between 1 and 5
     */
    public static int pickOption() {
        int option;
        do {
            option = getValidInt("Pick an option:\n1. Register new property\n2. List all properties\n3. Retrieve property\n4. Calculate mean area\n5. Quit");
        }
        while (option < 1 && option > 5);

        return option;
    }

    /**
     * Let's user interact with the property register.
     * 
     * @param propertyRegister A property register with test data
     */
    public static void client(PropertyRegister propertyRegister) {
        while (true) {
            int option = pickOption();

            switch (option) {
                case 1 -> {
                    propertyRegister.registerProperty(newProperty());
                }
                case 2 -> {
                    System.out.println(propertyRegister.toString());
                }
                case 3 -> {
                    int municipalityNumber;
                    do {
                        municipalityNumber = getValidInt("Municipality number (101-5054):");
                    }
                    while (municipalityNumber < 101 || municipalityNumber > 5054);

                    int lotNumber = getValidInt("Lot number:");
                    int sectionNumber = getValidInt("Section number:");

                    String key = municipalityNumber + "-" + lotNumber + "/" + sectionNumber;

                    System.out.println(propertyRegister.getPropertyByKey(key));
                }
                case 4 -> {
                    double meanArea = propertyRegister.meanArea();
                    System.out.println("Mean area: " + meanArea);
                }
                case 5 -> {
                    return;
                }
                default -> {
                    System.out.println("Pick a valid option");
                }
            }
        }
    }

    /**
     * Generates a property register with test data.
     * 
     * @return A property register
     */
    public static PropertyRegister testData() {
        PropertyRegister propertyRegister = new PropertyRegister();

        propertyRegister.registerProperty(new Property(1445, "Gloppen", 77, 631, null, 1017.6, "Jens Olsen"));
        propertyRegister.registerProperty(new Property(1445, "Gloppen", 77, 131, "Syningom", 661.3, "Nicolay Madsen"));
        propertyRegister.registerProperty(new Property(1445, "Gloppen", 75, 19, "Fugletun", 650.6, "Evilyn Jensen"));
        propertyRegister.registerProperty(new Property(1445, "Gloppen", 74, 188, null, 1457.2, "Karl Ove Bråten"));
        propertyRegister.registerProperty(new Property(1445, "Gloppen", 69, 47, "Høiberg", 1339.4, "Elsa Indregård"));

        return propertyRegister;
    }

    /**
     * Generates a new property object from user input.
     * 
     * @return A property
     */
    public static Property newProperty() {
        int municipalityNumber;
        do {
            municipalityNumber = getValidInt("Municipality number (101-5054):");
        }
        while (municipalityNumber < 101 || municipalityNumber > 5054);

        String municipalityName = getNonEmptyString("Municipality name:");
        int lotNumber = getValidInt("Lot number:");
        int sectionNumber = getValidInt("Section number:");
        
        System.out.println("Name:");
        String name = scanner.nextLine();

        double area = getValidDouble("Area:");
        String owner = getNonEmptyString("Owner:");

        return new Property(municipalityNumber, municipalityName, lotNumber, sectionNumber, name, area, owner);
    }

    /**
     * Starts the client.
     * 
     * @param args The command line arguments
     */
    public static void main(String[] args) {
        PropertyRegister propertyRegister = testData();
        client(propertyRegister);
    }
}