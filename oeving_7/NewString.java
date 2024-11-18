import java.util.Scanner;

final class NewString {
    private final String string;

    public NewString(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }

    public String abbreviate() {
        String[] stringList = getString().split(" ");
        String abbreviated = "";

        for (int i = 0; i < stringList.length; i++) {
            abbreviated += stringList[i].charAt(0);
        }

        return abbreviated;
    }

    public String removeChar(String character) {
        String result = getString().replace(character, "");
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {

            System.out.println("Pick an option:");
            System.out.println("1. Abbreviate");
            System.out.println("2. Remove character");
            System.out.println("3. Quit");

            String option = scanner.nextLine();

            if (option.equals("3")) {
                break;
            }

            System.out.println("Enter string:");
            String string = scanner.nextLine();
            NewString newString = new NewString(string);

            if (option.equals("1")) {
                System.out.println(newString.abbreviate());
            } else if (option.equals("2")) {
                System.out.println("Character to remove:");
                String remove = scanner.nextLine();
                System.out.println(newString.removeChar(remove));
            } else {
                System.out.println("Pick a valid option");
            }
        }
        scanner.close();
    }
}