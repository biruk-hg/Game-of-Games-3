
package gameofgames;

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Step S01: Specify the range
        System.out.println("Specify the range (e.g., 1 to 10):");
        int range = scanner.nextInt();
        while (range < 1 || range > 10) {
            System.out.println("Invalid range. Enter a number between 1 and 10:");
            range = scanner.nextInt();
        }

        // Step S02: Determine the number of guesses
        System.out.println("Specify the number of guesses (must be less than or equal to half the range):");
        int maxGuesses = scanner.nextInt();
        while (maxGuesses <= 0 || maxGuesses > range / 2) {
            System.out.println("Invalid number of guesses. Enter a value less than or equal to half the range:");
            maxGuesses = scanner.nextInt();
        }

        // Generate the secret number
        int secretNumber = random.nextInt(range) + 1;
        boolean isWin = false;
        int attempts = 0;

        // Step S03: Player makes guesses
        while (attempts < maxGuesses) {
            System.out.println("Enter your guess:");
            int guess = scanner.nextInt();
            attempts++;

            // Step A03: Check if the guess is correct
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

        // Step S04: Player wins or loses
        if (!isWin) {
            System.out.println("You lost! The number was: " + secretNumber);
        }
    }
}
