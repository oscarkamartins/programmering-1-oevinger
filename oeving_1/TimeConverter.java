public class TimeConverter {
    public static void main(String[] args) {
        int[] secondsList = {3600, 1021, 9};

        for (int seconds : secondsList) {
            int[] timeValue = TimeConverter.convert(seconds);
            TimeConverter.print(seconds, timeValue);
        }

    }

    public static int[] convert(int seconds) {
        int[] timeValue = new int[3];
        timeValue[0] = seconds / 3600;
        timeValue[1] = seconds % 3600 / 60;
        timeValue[2] = seconds % 60;
        return timeValue;
    }

    public static void print(int seconds, int[] timeValue) {
        System.out.printf("%ds = %dh %dm %ds%n", seconds, timeValue[0], timeValue[1], timeValue[2]);
    }
}
