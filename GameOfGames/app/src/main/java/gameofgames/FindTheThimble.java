package gameofgames;
import java.util.Random;
import java.util.Scanner;

public class FindTheThimble {
    public void startGame(Players player) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Find The Thimble, " + player.getName() + "!");
        System.out.print("Enter the number of rounds to play (odd number): ");
        int rounds = scanner.nextInt();

        // Get valid number of rounds
        while (rounds % 2 == 0 || rounds <= 0) {
            System.out.print("Enter an odd number for the best out of value: ");
            rounds = input.nextInt();

            if (rounds % 2 == 0 || rounds <= 0) 
                System.out.println("Invalid input. Please enter a positive odd number.");
            else 
                System.out.println("Valid Number Enter.");
        }

        System.out.println("Let's play best out of " + rounds + " rounds!");

        int playerWins = 0, computerWins = 0;
        String[] outcomes = {"Right", "Left"};

        for (int i = 1; i <= rounds; i++) {
            System.out.println("Round " + i + ": Right or Left?");
            String playerGuess = scanner.next();

            String thimbleResult = outcomes[(int) (Math.random() * 2)];
            System.out.println("Thimble hidden in: " + thimbleResult);

            if (playerGuess.equalsIgnoreCase(thimbleResult)) {
                System.out.println("You won this round!");
                playerWins++;
            } else {
                System.out.println("Computer won this round!");
                computerWins++;
            }

            if (playerWins > rounds / 2 || computerWins > rounds / 2) {
                break;
            }
        }

        if (playerWins > computerWins) {
            System.out.println("Congratulations, " + player.getName() + "! You won the game.");
            player.incrementScore();
        } else {
            System.out.println("Computer wins! Better luck next time.");
        }
    }
}
