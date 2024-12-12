import java.util.Scanner;

public class CoinFlip {

    public void startGame(Players player) {
        System.out.println("Welcome to Coin Flip, " + player.getName() + "!");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of rounds to play (odd number): ");
        int rounds = scanner.nextInt();

        while (rounds % 2 == 0 || rounds <= 0) {
            System.out.print("Enter an odd number for the best out of value: ");
            rounds = scanner.nextInt();
            if (rounds % 2 == 0 || rounds <= 0)
                System.out.println("Invalid input. Please enter a positive odd number.");
            else
                System.out.println("Valid Number Entered.");
        }

        System.out.println("Let's play best out of " + rounds + " rounds!");
        int playerWins = 0, computerWins = 0;
        String[] outcomes = {"Heads", "Tails"};

        for (int i = 1; i <= rounds; i++) {
            System.out.println();
            System.out.println("Round " + i + ": Heads or Tails?");
            String playerGuess = scanner.next();
            String coinResult = outcomes[(int) (Math.random() * 2)];
            System.out.println("Coin landed on: " + coinResult);

            if (playerGuess.equalsIgnoreCase(coinResult)) {
                System.out.println("You won this round!");
                System.out.println();
                playerWins++;
            } else {
                System.out.println("Computer won this round!");
                System.out.println();
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
