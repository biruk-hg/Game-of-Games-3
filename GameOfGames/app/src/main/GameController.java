import java.util.Scanner;

public class GameController {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        Players player = new Players(scanner.nextLine());

        while (true) {
            System.out.println("\nChoose a game to play (1-6):");
            System.out.println("1. Coin Flip");
            System.out.println("2. Even or Odd");
            System.out.println("3. Find the Thimble");
            System.out.println("4. Guess the Number");
            System.out.println("5. Find the Red Thread");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();
            System.out.println();
            switch (choice) {
                case 1: new CoinFlip().startGame(player); break;
                case 2: new EvenOrOdd().startGame(player); break;
                case 3: new FindTheThimble().startGame(player); break;
                case 4: new GuessTheNumber().startGame(player); break;
                case 5: new RedThread().startGame(player); break;
                case 6: {
                    System.out.println("Thanks for playing, " + player.getName() + "! Your final score is: " + player.getScore());
                    scanner.close();
                    return;
                }
                default: System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

