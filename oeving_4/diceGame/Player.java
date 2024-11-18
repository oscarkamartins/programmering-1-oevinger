package diceGame;

import java.util.Random;

public class Player {
    private int score;
    private String name;

    public Player(int score, String name) {
        this.score = score;
        this.name = name;
    }

    public int getScore() {
        return this.score;
    }

    public String getName() {
        return this.name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int rollDice() {
        Random dice = new Random();
        return dice.nextInt(6) + 1;
    }

    public boolean isDone() {
        return (this.score >= 100);
    }

    public void doTurn() {
        int roll = rollDice();

        if (roll == 1) {
            setScore(0);
            System.out.printf("%s's score has reset%n", getName());
        }
        else {
            if (score < 100) {
                setScore(getScore() + roll);
            }
            else {
                setScore(getScore() - roll);
            }
        }
        printScore();
    }

    public void printScore() {
        System.out.printf("%s's score: %d%n", getName(), getScore());
    }
}