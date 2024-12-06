package gameofgames;
import java.util.Random;
import java.util.Scanner;

public class CoinFlipGame {

    public int numOfRounds = 0;
    public int playerScore = 0;
    public int computerScore = 0;

    public static void main(String[] args) {
        CoinFlipGame game = new CoinFlipGame();
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
            //Computer flips coin
            String coinFlipResult = random.nextBoolean() ? "h" : "t";
            System.out.println("The coin has landed. Player, make your guess.");

            System.out.print("Player, guess the coin flip ('h' for heads or 't' for tails): ");
            String playerGuess = input.next().toLowerCase();

            while (!playerGuess.equals("h") && !playerGuess.equals("t")) {
                System.out.print("Invalid input. Please enter 'h' or 't': ");
                playerGuess = input.next().toLowerCase();
            }

            // Check the result
            if (playerGuess.equals(coinFlipResult)) {
                System.out.println("You guessed correctly!");
                playerScore++;
            } else {
                System.out.println("You guessed incorrectly.");
                computerScore++;
            }

            roundsPlayed++;
            System.out.println("Score: Player - " + playerScore + " | Computer - " + computerScore);
            System.out.println();
        }

        // Determine the winner
        System.out.println(determineWinner());
        input.close();
    }

    public String determineWinner() {
        if (playerScore > computerScore) {
            return "Congratulations! You won the game!";
        } else if (computerScore > playerScore) {
            return "The computer won the game! Better luck next time.";
        } else {
            return "It's a tie!";
        }
    }
}

