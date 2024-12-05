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

    /* start a game of games */
    public GameOfGames() {
        sc = new Scanner(System.in);
    }

    /* display main menu + start game and select game options */
    void game_select() {
        int selected_game;
        System.out.println("Please enter a game to select and play: \n1-Coin Flip \n2-Find the Thimble \n3-Guess the Number \n4-Even and Odd \n5-Find the Red Thread \n\nChoose from 1-5: ");
        selected_game = sc.nextInt();
        if (selected_game == 0) {
            DEBUG = true;
            System.out.println("Debug mode enabled\n");
            game_select();
        }
        else if (selected_game == 1 || selected_game == 2 || selected_game == 3 || selected_game == 4 || selected_game == 5 ){
            SELECTED_GAME = selected_game;
        }
        else {
            System.out.println("Invalid input detected. Please try again \n");
            game_select();
        }
    }

    /* allow players to quit game if desired */
    boolean game_quit() {
        String game_quit;
        System.out.println("Quit game? y/n\n");
        game_quit = sc.nextLine();
        if (game_quit == "y") {
            return true;
        }
        else if (game_quit == "n") {
            return false;
        }
        else {
           return false;
        }
    }

    /* display scoreboard information to players */
    void show_scoreboard() {
        System.out.println("******** SCOREBOARD ********\n");
        System.out.println("*****PLAYER*******SCORE*****\n");
        System.out.printf("\t%s\t%d", P1.get_name(), P1.get_score());
        System.out.printf("\t%s\t%d", P2.get_name(), P2.get_score());
    
    }
}