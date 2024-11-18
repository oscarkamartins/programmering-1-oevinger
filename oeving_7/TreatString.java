import java.util.Scanner;

class TreatString {
    private String string;

    public TreatString(String string) {
        this.string = string;
    }

    public int wordCount() {
        return getString().split(" ").length;
    }

    public double meanLength() {
        String onlyLetters = getString().replaceAll("[^a-zA-Zæøå ]", "");
        System.out.println(onlyLetters);
        String[] wordList = onlyLetters.split(" ");

        double totalLength = 0;

        for (int i = 0; i < wordList.length; i++) {
            totalLength += wordList[i].length();
        }

        return totalLength / wordList.length;
    }

    public double meanPeriodLength() {
        String[] periodList = getString().split("[.!:?]");
        String[] wordList = getString().split(" ");

        double periodListLength = periodList.length;
        double wordListLength = wordList.length;

        return wordListLength / periodListLength;
    }

    public String replaceWord(String checkString, String replaceString) {
        String[] wordList = getString().split(" ");
        String resultString = "";

        for (int i = 0; i < wordList.length; i++) {
            if (wordList[i].equals(checkString)) {
                wordList[i] = replaceString;
            }

            resultString += wordList[i] + " ";
        }

        return resultString;
    }

    public String getString() {
        return string;
    }

    public String getUpperCaseString() {
        return string.toUpperCase();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {

            System.out.println("Pick an option:");
            System.out.println("1. Word count");
            System.out.println("2. Average word length");
            System.out.println("3. Average period length");
            System.out.println("4. Replace word");
            System.out.println("5. Get string");
            System.out.println("6. Get uppercase string");
            System.out.println("7. Quit");



            String option = scanner.nextLine();

            if (option.equals("7")) {
                break;
            }

            System.out.println("Enter string:");
            String string = scanner.nextLine();
            TreatString treatString = new TreatString(string);

            if (option.equals("1")) {
                System.out.println(treatString.wordCount());
            }
            else if (option.equals("2")) {
                System.out.println(treatString.meanLength());
            }
            else if (option.equals("3")) {
                System.out.println(treatString.meanPeriodLength());
            }
            else if (option.equals("4")) {
                System.out.println("Which word do you want to remove:");
                String checkString = scanner.nextLine();
                System.out.println("What do you want to replace it with:");
                String replaceString = scanner.nextLine();

                System.out.println(treatString.replaceWord(checkString, replaceString));
            }
            else if (option.equals("5")) {
                System.out.println(treatString.getString());
            }
            else if (option.equals("6")) {
                System.out.println(treatString.getUpperCaseString());
            }
            else {
                System.out.println("Pick a valid option");
            }
        }
        scanner.close();
    }
}