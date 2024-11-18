public class InchConverter {
    public static void main(String[] args) {
        double[] inchValues = {50, 2, 8.7};
        for (double inchValue : inchValues) {
            double cmValue = convert(inchValue);
            print(inchValue, cmValue);
        }
    }

    public static double convert(double inches) {
        return inches * 2.54;
    }

    public static void print(double inches, double centimeters) {
        System.out.printf("%.2fin = %.2fcm%n", inches, centimeters);
    }
}
