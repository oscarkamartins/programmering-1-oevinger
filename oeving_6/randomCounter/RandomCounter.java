package randomCounter;

import java.util.Random;

public class RandomCounter {
    static Random random = new Random();
    static int[] counter = new int[10];

    public static void runRandom() {
        for (int i = 0; i < 1000; i++) {
            counter[random.nextInt(10)] += 1;
        }
    }

    public static void printTable() {
        for (int i = 0; i < counter.length; i++) {
            System.out.printf("%d: %d%n", i, counter[i]);
        }
    }

    public static void main(String[] args) {
        runRandom();
        printTable();
    }
}