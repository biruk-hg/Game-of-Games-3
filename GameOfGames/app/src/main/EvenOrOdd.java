import java.util.Scanner;

public class EvenOrOdd {
    public void startGame(Players player) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Even or Odd, " + player.getName() + "!");

        System.out.print("Enter the number of rounds to play (odd number): ");
        int rounds = scanner.nextInt();

        while (rounds % 2 == 0 || rounds <= 0) {
            System.out.print("Enter a positive odd number for rounds: ");
            rounds = scanner.nextInt();
        }

        int playerWins = 0, computerWins = 0;

        for (int i = 1; i <= rounds; i++) {
            System.out.println();
            System.out.println("Round " + i + ": Guess if the number is even or odd.");
            String playerGuess = scanner.next();

            int randomNumber = (int) (Math.random() * 100);
            System.out.println("Generated number: " + randomNumber);
            String actualResult = randomNumber % 2 == 0 ? "even" : "odd";

            if (playerGuess.equalsIgnoreCase(actualResult)) {
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
            player.incrementScore();
            System.out.println();
        } else {
            System.out.println("Computer wins! Better luck next time.");
            System.out.println();
        }
    }
}