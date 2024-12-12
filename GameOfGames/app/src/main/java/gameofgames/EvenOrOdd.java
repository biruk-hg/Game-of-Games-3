package gameofgames;

import java.util.Random;
import java.util.Scanner;

public class EvenOrOdd {
    public void startGame(Players player) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Step S01: Player chooses Even or Odd
        System.out.print("Choose 'Even' or 'Odd': ");
        String playerChoice = scanner.next().toLowerCase();
        while (!playerChoice.equals("even") || !playerChoice.equals("odd")) {
            System.out.println("Invalid choice. Enter 'Even' or 'Odd':");
            playerChoice = scanner.next().toLowerCase();
        }

        // Step S02: Specify Best Out Of value
        System.out.println("Specify 'Best Out Of' value (must be an odd number):");
        int rounds = scanner.nextInt();
        while (rounds % 2 == 0 || rounds <= 0) {
            System.out.println("Invalid value. Enter an odd number greater than 0:");
            rounds = scanner.nextInt();
        }

        // Step S03: Begin the game rounds
        int playerScore = 0;
        int computerScore = 0;
        int roundsToWin = (rounds / 2) + 1;

        while (playerScore < roundsToWin && computerScore < roundsToWin) {
            // Step S04: Input throws for player
            System.out.println("Enter a number (1-5):");
            int playerNumber = scanner.nextInt();
            while (playerNumber < 1 || playerNumber > 5) {
                System.out.println("Invalid input. Enter a number between 1 and 5:");
                playerNumber = scanner.nextInt();
            }

            // Computer randomly selects a number
            int computerNumber = random.nextInt(5) + 1;
            System.out.println("Computer chose: " + computerNumber);

            // Step S05: Compare throw results
            int sum = playerNumber + computerNumber;
            boolean isEven = sum % 2 == 0;

            if ((isEven && playerChoice.equals("even")) || (!isEven && playerChoice.equals("odd"))) {
                playerScore++;
                System.out.println("You won this round!");
            } else {
                computerScore++;
                System.out.println("Computer won this round!");
            }

            System.out.println("Current Scores - You: " + playerScore + " Computer: " + computerScore);
        }

        // Step S06: Check Win Condition
        if (playerScore >= roundsToWin) {
            System.out.println("Great job, " + player.getName() + "! Your score has been updated.");
            player.incrementScore();
        } else {
            System.out.println("The computer won the game! Better luck next time.");
        }
    }
}
