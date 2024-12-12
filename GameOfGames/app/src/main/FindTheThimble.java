import java.util.Scanner;

public class FindTheThimble {
    public void startGame(Players player) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Find the Thimble, " + player.getName() + "!");

        System.out.print("Enter the number of rounds to play (odd number): ");
        int rounds = scanner.nextInt();

        while (rounds % 2 == 0 || rounds <= 0) {
            System.out.print("Enter a positive odd number for rounds: ");
            rounds = scanner.nextInt();
        }

        int playerWins = 0, computerWins = 0;

        for (int i = 1; i <= rounds; i++) {
            System.out.println();
            System.out.println("Round " + i + ": Guess which hand (left or right) has the thimble?");
            String playerGuess = scanner.next();

            String thimbleLocation = Math.random() < 0.5 ? "left" : "right";
            System.out.println("Thimble was in the " + thimbleLocation + " hand.");

            if (playerGuess.equalsIgnoreCase(thimbleLocation)) {
                System.out.println("You guessed correctly!");
                playerWins++;
            } else {
                System.out.println("Computer wins this round!");
                computerWins++;
            }

            if (playerWins > rounds / 2 || computerWins > rounds / 2) {
                break;
            }
        }

        if (playerWins > computerWins) {
            System.out.println("Congratulations, " + player.getName() + "! You won the game.");
            System.out.println();
            player.incrementScore();
        } else {
            System.out.println("Computer wins! Better luck next time.");
            System.out.println();
        }
    }
}