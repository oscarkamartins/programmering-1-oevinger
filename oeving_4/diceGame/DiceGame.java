package diceGame;

public class DiceGame {
    public static void main(String[] args) {
        Player player1 = new Player(0, "Player 1");
        Player player2 = new Player(0, "Player 2");
        Player[] players = {player1, player2};
        boolean gameFinished = false;
        String gameWinner = "none";
        int round = 1;
        int turn = 0;

        while (!gameFinished) {
            System.out.printf("Round %d:%n", round);
            players[turn].doTurn();
            System.out.printf("%n");

            if (players[turn].getScore() == 100) {
                gameFinished = true;
                gameWinner = players[turn].getName();
            }

            round += 1;
            turn = round % players.length;   
        }

        System.out.printf("%s has won the game!", gameWinner);
    }
}
