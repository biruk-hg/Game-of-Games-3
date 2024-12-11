package gameofgames;

// Even or Odd Game
import java.util.Random;
import java.util.Scanner;

public class EvenOrOdd {
    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Choose 'Even' or 'Odd':");
        String playerChoice = scanner.next().toLowerCase();
        while (!playerChoice.equals("even") && !playerChoice.equals("odd")) {
            System.out.println("Invalid choice. Enter 'Even' or 'Odd':");
            playerChoice = scanner.next().toLowerCase();
        }

        System.out.println("Specify 'Best Out Of' value (must be an odd number):");
        int bestOutOf = scanner.nextInt();
        while (bestOutOf % 2 == 0 || bestOutOf <= 0) {
            System.out.println("Invalid value. Enter an odd number greater than 0:");
            bestOutOf = scanner.nextInt();
        }

        int playerScore = 0;
        int computerScore = 0;
        int rounds = (bestOutOf / 2) + 1;

        while (playerScore < rounds && computerScore < rounds) {
            System.out.println("Enter a number (1-5):");
            int playerNumber = scanner.nextInt();
            while (playerNumber < 1 || playerNumber > 5) {
                System.out.println("Invalid input. Enter a number between 1 and 5:");
                playerNumber = scanner.nextInt();
            }

            int computerNumber = random.nextInt(5) + 1;
            System.out.println("Computer chose: " + computerNumber);

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

        if (playerScore > computerScore) {
            System.out.println("Congratulations! You won the game.");
        } else {
            System.out.println("You lost the game. Better luck next time!");
        }
    }
}
