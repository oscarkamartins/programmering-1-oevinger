public class SecConverter {
    public static void main(String[] args) {
        int[][] timeValues = {{1, 2, 3}, {4, 5, 6}};

        for (int[] timeValue : timeValues) {
            int totalSeconds = SecConverter.convert(timeValue[0], timeValue[1], timeValue[2]);
            SecConverter.print(timeValue[0], timeValue[1], timeValue[2], totalSeconds);
        }
    }

    public static int convert(int hours, int minutes, int seconds) {
        return hours * 3600 + minutes * 60 + seconds;
    }

    public static void print(int hours, int minutes, int seconds, int totalSeconds) {
        System.out.printf("%dh %dm %ds = %ds%n", hours, minutes, seconds, totalSeconds);
    }
}
