import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RedThread {
    private int computerWins = 0;

    public int getComputerWins() {
        return computerWins;
    }

    public void startGame(Players player) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Find the Red Thread, " + player.getName() + "!");

        System.out.print("Enter the total number of spools (must be at least 20): ");
        int totalSpools = scanner.nextInt();
        while (totalSpools < 20) {
            System.out.print("Invalid input. Total spools must be at least 20. Try again: ");
            totalSpools = scanner.nextInt();
        }

        System.out.print("Enter the number of spools you can pull per turn (must be less than half of total spools): ");
        int spoolsPerTurn = scanner.nextInt();
        while (spoolsPerTurn <= 0 || spoolsPerTurn >= totalSpools / 2) {
            System.out.print("Invalid input. Enter a valid number of spools to pull: ");
            spoolsPerTurn = scanner.nextInt();
        }

        int redThreadPosition = (int) (Math.random() * totalSpools) + 1;
        boolean gameOver = false;

        while (!gameOver) {
            System.out.println("Choose " + spoolsPerTurn + " numbers between 1 and " + totalSpools + ":");
            List<Integer> playerChoices = new ArrayList<>();
            for (int i = 0; i < spoolsPerTurn; i++) {
                int choice = scanner.nextInt();
                while (choice < 1 || choice > totalSpools || playerChoices.contains(choice)) {
                    System.out.print("Invalid choice. Enter a unique number between 1 and " + totalSpools + ": ");
                    choice = scanner.nextInt();
                }
                playerChoices.add(choice);
            }

            if (playerChoices.contains(redThreadPosition)) {
                System.out.println("Congratulations! You found the red thread. You win!");
                player.incrementScore();
                gameOver = true;
                continue;
            } else {
                System.out.println("Red thread was not among your choices.");
            }

            System.out.println("Computer is choosing...");
            List<Integer> computerChoices = new ArrayList<>();
            for (int i = 0; i < spoolsPerTurn; i++) {
                int choice;
                do {
                    choice = (int) (Math.random() * totalSpools) + 1;
                } while (computerChoices.contains(choice));
                computerChoices.add(choice);
            }
            System.out.println("Computer chose: " + computerChoices);

            if (computerChoices.contains(redThreadPosition)) {
                System.out.println("The computer found the red thread. You lose!");
                computerWins++;
                gameOver = true;
            } else {
                System.out.println("Red thread was not among the computer's choices.");
            }
        }

        System.out.println("\nScoreboard:");
        System.out.println(player.getName() + "'s Score: " + player.getScore());
        System.out.println("Computer's Score: " + computerWins);
    }
}
