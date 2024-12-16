import java.util.Scanner;

public class FindTheThimble {
    public void startGame(Players player) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Find the Thimble, " + player.getName() + "!");

        int rounds = getBestOutOf(scanner);
        int playerWins = 0, computerWins = 0;

        while (playerWins < rounds / 2 + 1 && computerWins < rounds / 2 + 1) {
            System.out.println("Guess which hand the thimble is in (left/right):");
            String playerGuess = scanner.next().toLowerCase();

            while (!playerGuess.equals("left") && !playerGuess.equals("right")) {
                System.out.println("Invalid input. Please enter 'left' or 'right':");
                playerGuess = scanner.next().toLowerCase();
            }

            String thimbleLocation = Math.random() < 0.5 ? "left" : "right";
            System.out.println("Thimble was in the " + thimbleLocation + " hand.");

            if (playerGuess.equals(thimbleLocation)) {
                System.out.println("You guessed correctly!");
                playerWins++;
            } else {
                System.out.println("Computer wins this round!");
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
