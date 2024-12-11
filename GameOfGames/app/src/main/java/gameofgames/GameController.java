package gameofgames;

import java.util.Scanner;

public class GameController {
    /* detect gamemode for developer purposes */
    static Boolean DEBUG = false;

    /* scanner(sc) to keep track of inputs */
    Scanner sc = new Scanner(System.in);

    /* keeping track of the current game */
    static int SELECTED_GAME;

    /* keeping track of players */
    // Player TESTER;
    Player P1;
    Player P2;

    /* list of available games */
    String GAME_1 = "Coin Flip";
    String GAME_2 = "Find the Thimble";
    String GAME_3 = "Guess the Number";
    String GAME_4 = "Even and Odd";
    String GAME_5 = "Find the Red Thread";

    public GameController() {}

    /* check desired user mode */
    void checkMode() {
        String input = "";
        System.out.println("Press Enter to Start!");
        input = sc.nextLine();
        System.out.println("Preparing the Game of Games...\n");
        /* 3 second timer to wait for debug mode input */
        for (int i = 3; i > 0; i--) {
            System.out.println(i); // Display the countdown
            try {
                Thread.sleep(1000); // Wait for 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // if Enter is pressed, enable the debug mode
        if (input.equals("d")) {
            System.out.println("Entering Debug Mode...");
            DEBUG = true; // Call a method that contains the debug logic
        }
        System.out.println();
    }

    /* compare player scores to find the winner */
    void getWinner() {
        if (P1.getScore() > P2.getScore()) {
            System.out.println(P1.getName() + " wins!\n");
        } else if (P2.getScore() < P1.getScore()) {
            System.out.println(P2.getName() + " wins!\n");
        } else {
            System.out.println("It looks like this Game of Games ended in a tie!\n");
        }
    }

    /* display scoreboard information to players */
    void showScoreboard() {
        System.out.println("******** SCOREBOARD ********\n");
        System.out.println("*****PLAYER*******SCORE*****\n");
        System.out.printf("   %s\t %d\n", P1.getName(), P1.getScore());
        System.out.printf("   %s\t %d\n\n", P2.getName(), P2.getScore());

    }

    /* display main menu + start game and select game options */
    void gameSelect() {
        int selected_game;
        System.out.println("Please enter a game to select and play: \n1-" + GAME_1 + "\n2-" + GAME_2 + "\n3-" + GAME_3
                + "\n4-" + GAME_4 + "\n5-" + GAME_5 + "\n\nChoose from 1-5: ");
        selected_game = sc.nextInt();
        if (selected_game == 1 || selected_game == 2 || selected_game == 3 || selected_game == 4
                || selected_game == 5) {
            // System.out.println("\nYou have chosen Game " + selected_game + "\n");
            SELECTED_GAME = selected_game;
        } else {
            System.out.println("Invalid input detected. Please try again\n");
            gameSelect();
        }
    }

    /* allow players to quit game if desired */
    Boolean gameQuit() {
        String input;
        System.out.println("Quit game? y/n\n");
        input = sc.nextLine();
        if (input.equals("y")) {
            // GAME_QUIT = true;
            return true;
        } else if (input.equals("n")) {
            // GAME_QUIT = false;
            return false;
        } else {
            // GAME_QUIT = false;
            return false;
        }
    }

    /* checks the SELECTED_GAME to create an instance of a game to be played */
    void playGame(int SELECTED_GAME) {
        if (SELECTED_GAME == 1) {
            System.out.println("\nYou have selected " + GAME_1 + "!\n");
            CoinFlipGame coinfFlipGame = new CoinFlipGame();
            coinfFlipGame.startGame();
        } else if (SELECTED_GAME == 2) {
            System.out.println("\nYou have selected " + GAME_2 + "!\n");
            FindTheThimble findTheThimble = new FindTheThimble();
            findTheThimble.startGame();
        }
        // else if (SELECTED_GAME == 3) {
        // System.out.println("\nYou have selected " + GAME_3 + "!\n");
        // [ENTER GAME] [ENTER GAME] = new [ENTER GAME]();
        // [ENTER GAME].startGame();
        // }
        // else if (SELECTED_GAME == 4) {
        // System.out.println("\nYou have selected " + GAME_4 + "!\n");
        // [ENTER GAME] [ENTER GAME] = new [ENTER GAME]();
        // [ENTER GAME].startGame();
        // }
        // else if (SELECTED_GAME == 5) {
        // System.out.println("\nYou have selected " + GAME_5 + "!\n");
        // [ENTER GAME] [ENTER GAME] = new [ENTER GAME]();
        // [ENTER GAME].startGame();
        // }
    }

    public static void main(String args[]) {
        // Boolean WINNER_CHOSEN = false;
        Boolean GAME_QUIT = false;

        /* mkaing a game controller */
        GameController game = new GameController();

        /* quickly check prompt testers for debug capabilities */
        game.checkMode();

        System.out.println("Welcome to the Game of Games!\n");

        if (DEBUG == false) {
            /* potentially skip the player initialization stage if in debug mode */
            Player P1 = new Player();
            /* Enable both players on the interface at the same time */
            Player P2 = new Player();
        }

        /*
         * enter main game loop, determines if players choose to quite game before
         * closing
         */
        while (GAME_QUIT != true) {

            game.gameSelect();
            System.out.println("zip");
            game.playGame(SELECTED_GAME);
            System.out.println("ideedodah");

            // *******************************************************************************
            // NOT FINAL CODE. TESTING CURRENT METHODS/CLASSES TO SIMULATE THE FINAL
            // GAMELOOP
            // *******************************************************************************
            // /* current player selects a game */
            // SELECTED_GAME = game.gameSelect();
            // /* plays game1, player 1 wins */
            // P1.increaseScore();
            // game.showScoreboard();
            // GAME_QUIT = game.gameQuit();
            // /* game continues, next game is selected, player 1 wins again*/
            // /* keeping track of the current game */
            // SELECTED_GAME = game.gameSelect();
            // P1.increaseScore();
            // game.showScoreboard();
            // GAME_QUIT = game.gameQuit();
            // /* running one more game, player 2 wins, but the player chooses to quit */
            // SELECTED_GAME = game.gameSelect();
            // P2.increaseScore();
            // game.showScoreboard();
            // GAME_QUIT = true;
        }
        game.getWinner();
        System.out.println("Thanks for playing!");
    }
}