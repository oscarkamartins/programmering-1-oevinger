import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a year:");

        if (scanner.hasNextInt()) {
            int year = scanner.nextInt();
            scanner.close();

            if (isLeapYear(year)) {
                System.out.println(year + " is a leap year");
            }
            else {
                System.out.println(year + " is not a leap year");
            }
        }
        else {
            System.out.println("Invalid input");
        }
    }

    public static boolean isLeapYear(int year) {
        return (year % 400 == 0) || (year % 100 != 0 && year % 4 == 0);
    }
}
