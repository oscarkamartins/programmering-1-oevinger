import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Start of multiplication table:");
            int start = scanner.nextInt();
            System.out.println("End of multiplication table:");
            int end = scanner.nextInt();
            scanner.close();

            if (end > start) {
                for (int i = start; i < end + 1; i++) {
                    System.out.println(i + "-times table:");
                    for (int j = 1; j < 11; j++) {
                        System.out.printf("%d x %d = %d%n", i, j, i * j);
                    }
                    System.out.println("---------");
                }
            }
        }
        catch (NumberFormatException e) {
            System.out.println("Invalid input");
        }
    }
}