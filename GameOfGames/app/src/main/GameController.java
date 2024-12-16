import java.util.Scanner;

public class GameController {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Game of Games!");
        System.out.print("Enter your name: ");
        String playerName = scanner.nextLine();
        Players player = new Players(playerName);

        int computerScore = 0;

        while (true) {
            System.out.println("\nChoose a game to play:");
            System.out.println("1. Coin Flip");
            System.out.println("2. Find the Thimble");
            System.out.println("3. Even or Odd");
            System.out.println("4. Guess the Number");
            System.out.println("5. Find the Red Thread");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    CoinFlip coinFlipGame = new CoinFlip();
                    coinFlipGame.startGame(player);
                    computerScore += coinFlipGame.getComputerWins();
                    break;
                case 2:
                    FindTheThimble findTheThimbleGame = new FindTheThimble();
                    findTheThimbleGame.startGame(player);
                    computerScore += findTheThimbleGame.getComputerWins();
                    break;
                case 3:
                    EvenOrOdd evenOrOddGame = new EvenOrOdd();
                    evenOrOddGame.startGame(player);
                    computerScore += evenOrOddGame.getComputerWins();
                    break;
                case 4:
                    GuessTheNumber guessTheNumberGame = new GuessTheNumber();
                    guessTheNumberGame.startGame(player);
                    computerScore += guessTheNumberGame.getComputerWins();
                    break;
                case 5:
                    RedThread redThreadGame = new RedThread();
                    redThreadGame.startGame(player);
                    computerScore += redThreadGame.getComputerWins();
                    break;
                case 6:
                    System.out.println("Thank you for playing, " + player.getName() + "!");
                    System.out.println("Final Scoreboard:");
                    System.out.println(player.getName() + "'s Score: " + player.getScore());
                    System.out.println("Computer's Score: " + computerScore);
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
