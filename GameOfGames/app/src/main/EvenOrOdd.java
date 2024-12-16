import java.util.Scanner;

public class EvenOrOdd {
    public void startGame(Players player) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Even or Odd, " + player.getName() + "!");

        int rounds = getBestOutOf(scanner);
        int playerWins = 0, computerWins = 0;

        System.out.print("Do you want to be 'even' or 'odd'? ");
        String playerChoice = scanner.next().toLowerCase();
        while (!playerChoice.equals("even") && !playerChoice.equals("odd")) {
            System.out.print("Invalid input. Please enter 'even' or 'odd': ");
            playerChoice = scanner.next().toLowerCase();
        }

        String computerChoice = playerChoice.equals("even") ? "odd" : "even";
        System.out.println("You chose: " + playerChoice + " | Computer is: " + computerChoice);

        while (playerWins < rounds / 2 + 1 && computerWins < rounds / 2 + 1) {
            System.out.print("Enter a number between 1 and 5: ");
            int playerNumber = scanner.nextInt();
            while (playerNumber < 1 || playerNumber > 5) {
                System.out.print("Invalid number. Please enter a number between 1 and 5: ");
                playerNumber = scanner.nextInt();
            }

            int computerNumber = (int) (Math.random() * 5) + 1;
            System.out.println("Computer chose: " + computerNumber);

            int sum = playerNumber + computerNumber;
            System.out.println("Sum is: " + sum);

            if ((sum % 2 == 0 && playerChoice.equals("even")) || (sum % 2 != 0 && playerChoice.equals("odd"))) {
                System.out.println("You win this round!");
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
