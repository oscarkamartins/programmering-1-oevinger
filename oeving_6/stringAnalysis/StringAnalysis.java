package stringAnalysis;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StringAnalysis {
    HashMap<Character, Integer> charCounter = new HashMap<Character, Integer>();
    int nonLetter = 0;


    public StringAnalysis(String text) {

        for (char letter = 'a'; letter <= 'z'; letter++) {
            charCounter.put(letter, 0);
        }
        for (char letter = 'æ'; letter <= 'å'; letter++) {
            charCounter.put(letter, 0);
        }

        for (int i = 0; i < text.length(); i++) {
            char letter = text.toLowerCase().charAt(i);
            if (charCounter.containsKey(letter)) {
                charCounter.replace(letter, charCounter.get(letter) + 1);
            }
            else {
                nonLetter++;
            }
        }
    }

    public int numOfLetters() {
        int numOfLetters = 0;

        for (int value : charCounter.values()) {
            if (value > 0) {
                numOfLetters++;
            }
        }

        return numOfLetters;
    }

    public int totalLetters() {
        int totalLetters = 0;

        for (int value : charCounter.values()) {
            totalLetters += value;
        }

        return totalLetters;
    }

    public double charPercentage() {
        int totalLetters = 0;

        for (int value : charCounter.values()) {
            totalLetters += value;
        }

        try {
            return 100 * nonLetter / totalLetters;
        }
        catch (ArithmeticException e) {
            return 0;
        }
    }

    public int howMany(char letter) {
        if (charCounter.containsKey(letter)) {
            return charCounter.get(letter);
        }
        else {
            return nonLetter;
        }
    }

    public ArrayList<Character> mostFrequent() {
        ArrayList<Character> mostFrequent = new ArrayList<Character>();

        int topLetter = Collections.max(charCounter.values());

        for (char letter : charCounter.keySet()) {
            if (charCounter.get(letter) == topLetter) {
                mostFrequent.add(letter);
            }
        }

        return mostFrequent;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("String to analyze (type quit to quit):");
            String myString = scanner.nextLine();

            if (myString.toLowerCase().equals("quit")) {
                break;
            }

            StringAnalysis analyzedString = new StringAnalysis(myString);

            System.out.println("Which letter in " + myString + " do you want to analyze (non letter will analyze all non letters):");
            String letter = scanner.nextLine();

            System.out.printf("%s has %d unique letters%n", myString, analyzedString.numOfLetters());
            System.out.printf("%s has %d letters%n", myString, analyzedString.totalLetters());
            System.out.printf("%s has %f%% non letters%n", myString, analyzedString.charPercentage(), 3);
            System.out.printf("%s has %d instances of the letter %s%n", myString, analyzedString.howMany(letter.charAt(0)), letter);
            
        }

        scanner.close();
    }
}