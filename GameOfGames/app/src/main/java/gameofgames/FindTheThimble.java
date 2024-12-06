package gameofgames;

import java.util.Random;
import java.util.Scanner;

public class FindTheThimble {

    public int numOfRounds = 0;
    public int p1Score = 0; // Player's score
    public int computerScore = 0; // Computer's score

    public static void main(String[] args) {
        FindTheThimble game = new FindTheThimble();
        game.startGame();
    }

    public void startGame() {
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        // Get valid number of rounds
        while (numOfRounds % 2 == 0 || numOfRounds <= 0) {
            System.out.print("Enter an odd number for the best out of value: ");
            numOfRounds = input.nextInt();

            if (numOfRounds % 2 == 0 || numOfRounds <= 0) 
                System.out.println("Invalid input. Please enter a positive odd number.");
            else 
                System.out.println("Valid Number Enter.");
        }

        System.out.println("Let's play best out of " + numOfRounds + " rounds!");

        int roundsPlayed = 0;

        // Main game loop
        while (roundsPlayed < numOfRounds) {
            // Computer randomly decides where to hide the thimble
            String computerChoice = random.nextBoolean() ? "r" : "l";
            System.out.println("The computer hid the thimble. Player, guess where the thimble is hidden.");

            System.out.print("Enter 'l' for right rand or 'l' for left hand: ");
            String playerGuess = input.next().toLowerCase();

            while (!playerGuess.equals("r") && !playerGuess.equals("l")) {
                System.out.println("Invalid input. Please enter 'r' for right rand or 'l' for left hand: ");
                playerGuess = input.next().toLowerCase();
            }

            // Check the result
            if (playerGuess.equals(computerChoice)) {
                System.out.println("You guessed correctly!");
                p1Score++;
            } else {
                System.out.println("You guessed incorrectly.");
                computerScore++;
            }

            roundsPlayed++;
            System.out.println("Score: Player - " + p1Score + " | Computer - " + computerScore);
            System.out.println();
        }

        // Determine the winner
        System.out.println(determineWinner());
        input.close();
    }

    public String determineWinner() {
        if (p1Score > computerScore) 
            return "Congratulations! You won the game!";
        else if (computerScore > p1Score) 
            return "The computer won the game! Better luck next time.";
        else 
            return "It's a tie!";
    }
}
