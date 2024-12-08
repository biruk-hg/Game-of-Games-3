// package gameofgames;
import java.util.Scanner;

public class GameOfGames{
    /* detect gamemode for developer purposes */
    public Boolean DEBUG = false;
    /* scanner(sc) to keep track of inputs */
    Scanner sc;
    /* selected game */
    public int SELECTED_GAME;
    /* keeping track of players */
    Player TESTER;
    Player P1;
    Player P2;

    /* list of available games */
    String GAME_1 = "Coin Flip";
    String GAME_2 = "Find the Thimble";
    String GAME_3 = "Guess the Number";
    String GAME_4 = "Even and Odd";
    String GAME_5 = "Find the Red Thread";

    /* start a game of games */
    public GameOfGames() {
        sc = new Scanner(System.in);
    }

    /* display main menu + start game and select game options */
    void game_select() {
        int selected_game;
        System.out.println("Please enter a game to select and play: \n1-" + GAME_1 + "\n2-" + GAME_2 + "\n3-" + GAME_3 + "\n4-" + GAME_4 + "\n5-" + GAME_5 + "\n\nChoose from 1-5: ");
        selected_game = sc.nextInt();
        if (selected_game == 0) {
            DEBUG = true;
            System.out.println("Debug mode enabled\n");
            game_select();
        }
        else if (selected_game == 1 || selected_game == 2 || selected_game == 3 || selected_game == 4 || selected_game == 5 ){
            // System.out.println("\nYou have chosen Game " + selected_game + "\n");
            SELECTED_GAME = selected_game;
        }
        else {
            System.out.println("Invalid input detected. Please try again\n");
            game_select();
        }
    }

    /* allow players to quit game if desired */
    Boolean game_quit() {
        String input;
        System.out.println("Quit game? y/n\n");
        input = sc.nextLine();
        if (input.equals("y")) {
            // GAME_QUIT = true;
            return true;
        }
        else if (input.equals("n")) {
            // GAME_QUIT = false; 
            return false;
        }
        else {
            // GAME_QUIT = false;
            return false;
        }
    }

    /* compare player scores to find the winner */
    void get_winner() {
        if (P1.get_score() > P2.get_score()) {
            System.out.println(P1.get_name() + " wins!\n");
        }
        else if (P2.get_score() < P1.get_score()) {
            System.out.println(P2.get_name() + " wins!\n");
        }
        else {
            System.out.println("It looks like this Game of Games ended in a tie!\n");
        }
    }

    /* display scoreboard information to players */
    void show_scoreboard() {
        System.out.println("******** SCOREBOARD ********\n");
        System.out.println("*****PLAYER*******SCORE*****\n");
        System.out.printf("   %s\t %d\n", P1.get_name(), P1.get_score());
        System.out.printf("   %s\t %d\n\n", P2.get_name(), P2.get_score());
    
    }
}