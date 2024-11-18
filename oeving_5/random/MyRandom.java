package random;

import java.util.Random;

public class MyRandom {

    public MyRandom() {}

    public Random randomObject = new Random();

    public int nextInteger(int lower, int upper) {
        return randomObject.nextInt(upper - lower) + lower;
    }

    public double nextDouble(double lower, double upper) {
        double scalingFactor = upper - lower;
        return randomObject.nextDouble() * scalingFactor + lower;
    }

    public static void main(String[] args) {
        MyRandom randomTest = new MyRandom();

        for (int i = 0; i < 10; i++) {
            int[] bounds = createBounds();
            System.out.printf("Random integer between %d and %d: %d%n", bounds[0], bounds[1], randomTest.nextInteger(bounds[0], bounds[1]));
            System.out.printf("Random double between %d and %d: %f%n", bounds[0], bounds[1], randomTest.nextDouble(bounds[0], bounds[1]));
            System.err.println();

        }
    }

    public static int[] createBounds() {
        Random boundMaker = new Random();

        int[] bounds = {boundMaker.nextInt(100), boundMaker.nextInt(100)};
        if (bounds[0] > bounds[1]) {
            return new int[] {bounds[1], bounds[0]};
        }
        else {
            return bounds;
        }
    }

    
}
