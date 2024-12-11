package gameofgames;

// Guess the Number Game
import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Specify the range (e.g., 1 to 10):");
        int range = scanner.nextInt();
        while (range <= 1) {
            System.out.println("Invalid range. Enter a number greater than 1:");
            range = scanner.nextInt();
        }

        System.out.println("Specify the number of guesses (must be less than or equal to half the range):");
        int maxGuesses = scanner.nextInt();
        while (maxGuesses <= 0 || maxGuesses > range / 2) {
            System.out.println("Invalid number of guesses. Try again:");
            maxGuesses = scanner.nextInt();
        }

        int secretNumber = random.nextInt(range) + 1;
        boolean isWin = false;

        for (int i = 0; i < maxGuesses; i++) {
            System.out.println("Enter your guess:");
            int guess = scanner.nextInt();

            if (guess == secretNumber) {
                System.out.println("You Won!");
                isWin = true;
                break;
            } else if (guess < secretNumber) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }
        }

        if (!isWin) {
            System.out.println("You lost! The number was: " + secretNumber);
        }
    }
}
