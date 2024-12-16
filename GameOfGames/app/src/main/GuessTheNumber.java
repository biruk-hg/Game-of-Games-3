import java.util.Scanner;

public class GuessTheNumber {
    public void startGame(Players player) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Guess the Number, " + player.getName() + "!");

        int rounds = getBestOutOf(scanner);
        int playerWins = 0, computerWins = 0;

        while (playerWins < rounds / 2 + 1 && computerWins < rounds / 2 + 1) {
            int targetNumber = (int) (Math.random() * 10) + 1;
            System.out.println("Guess the number (between 1 and 10):");

            int attempts = 0;
            boolean playerGuessed = false;

            while (attempts < 5) {
                int playerGuess = scanner.nextInt();
                attempts++;

                if (playerGuess == targetNumber) {
                    System.out.println("You guessed correctly!");
                    playerGuessed = true;
                    playerWins++;
                    break;
                } else if (playerGuess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!playerGuessed) {
                System.out.println("You ran out of attempts. The correct number was: " + targetNumber);
                computerWins++;
            }

            System.out.println("Score: You - " + playerWins + " | Computer - " + computerWins);
        }

        if (playerWins > computerWins) {
            System.out.println("Congratulations, " + player.getName() + "! You won the game.");
            player.incrementScore();
        } else {
            System.out.println("Computer wins! Better luck next time.");
        }
    }

    private int getBestOutOf(Scanner scanner) {
        System.out.print("Enter an odd number for the Best out of value: ");
        int rounds = scanner.nextInt();

        while (rounds % 2 == 0 || rounds <= 0) {
            System.out.print("Invalid input. Please enter a positive odd number: ");
            rounds = scanner.nextInt();
        }

        return rounds;
    }
}
