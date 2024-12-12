import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;

public class RedThread {
    public void startGame(Players player) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Find the Red Thread, " + player.getName() + "!");

        System.out.print("Enter the number of rounds to play (odd number): ");
        int rounds = scanner.nextInt();

        while (rounds % 2 == 0 || rounds <= 0) {
            System.out.print("Enter a positive odd number for rounds: ");
            rounds = scanner.nextInt();
        }

        int playerWins = 0, computerWins = 0;

        for (int i = 1; i <= rounds; i++) {
            System.out.println();
            System.out.println("Round " + i + ": Guess the position of the red thread (1-3).");
            int playerGuess = scanner.nextInt();

            int redThreadPosition = (int) (Math.random() * 3) + 1;
            System.out.println("The red thread was at position: " + redThreadPosition);

            if (playerGuess == redThreadPosition) {
                System.out.println("You guessed correctly!");
                playerWins++;
            } else {
                System.out.println("Computer wins this round!");
                computerWins++;
            }

            if (playerWins > rounds / 2 || computerWins > rounds / 2) {
                break;
            }
        }

        if (playerWins > computerWins) {
            System.out.println("Congratulations, " + player.getName() + "! You won the game.");
            System.out.println();
            player.incrementScore();
        } else {
            System.out.println("Computer wins! Better luck next time.");
            System.out.println();
        }
    }
}