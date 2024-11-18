import java.util.Scanner;

public class Prime {
    public static void main() {
        Scanner scanner = new Scanner(System.in);
        int number;
        do {
            try {
                System.out.println("Number (-1 to quit):");
                number = scanner.nextInt();

                if (number == -1) {
                    break;
                }

                if (isPrime(number)) {
                    System.out.println(number + " is a prime number");
                }
                else {
                    System.out.println(number + " is not a prime number");
                }
            }
            catch (NumberFormatException e) {
                System.out.println("Invalid input");
            }
        }
        while (true);
        scanner.close();
    }

    public static boolean isPrime(int number) {
        if (number <= 1) return false;
        if (number == 2) return true;
        if (number % 2 == 0) return false;
        
        for (int i = 3; i <= Math.sqrt(number); i += 2) {
            System.out.println("testing" + i);
            if (number % i == 0) return false;
        }
        return true;
    }
}
