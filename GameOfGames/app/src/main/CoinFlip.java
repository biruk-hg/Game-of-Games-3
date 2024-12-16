import java.util.Scanner;

public class CoinFlip {
    public void startGame(Players player) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Coin Flip, " + player.getName() + "!");

        int rounds = getBestOutOf(scanner);
        int playerWins = 0, computerWins = 0;
        String[] outcomes = {"Heads", "Tails"};

        while (playerWins < rounds / 2 + 1 && computerWins < rounds / 2 + 1) {
            System.out.println("Choose Heads or Tails (H/T):");
            String playerChoice = scanner.next().toUpperCase();

            while (!playerChoice.equals("H") && !playerChoice.equals("T")) {
                System.out.println("Invalid choice. Please enter H for Heads or T for Tails:");
                playerChoice = scanner.next().toUpperCase();
            }

            String coinResult = outcomes[(int) (Math.random() * 2)];
            System.out.println("Coin flip result: " + coinResult);

            if ((playerChoice.equals("H") && coinResult.equals("Heads")) ||
                (playerChoice.equals("T") && coinResult.equals("Tails"))) {
                System.out.println("You won this round!");
                playerWins++;
            } else {
                System.out.println("Computer won this round!");
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
