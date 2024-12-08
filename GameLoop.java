// package gameofgames;
public class GameLoop extends GameOfGames{
    public static void main(String args[]) {
        // Boolean WINNER_CHOSEN = false;
        Boolean GAME_QUIT = false;
        GameOfGames game = new GameOfGames();

        System.out.println("Welcome to the Game of Games!");
        
        /* enter main game loop, determines if players choose to quite game before closing */
        while (GAME_QUIT != true) {

            /* potentially skip the player initialization stage if in debug mode */
            Player P1 = new Player();
            game.P1 = P1;
            /* Enable both players on the interface at the same time */
            Player P2 = new Player();
            game.P2 = P2;

            
            //*******************************************************************************
            // NOT FINAL CODE. TESTING CURRENT METHODS/CLASSES TO SIMULATE THE FINAL GAMELOOP
            //*******************************************************************************

            /* current player selects a game */
            game.game_select();
            /* plays game1, player 1 wins */
            P1.increase_score();
            game.show_scoreboard();
            GAME_QUIT = game.game_quit();
            /* game continues, next game is selected, player 1 wins again*/
            game.game_select();
            P1.increase_score();
            game.show_scoreboard();
            GAME_QUIT = game.game_quit();
            /* running one more game, player 2 wins, but the player chooses to quit */
            game.game_select();
            P2.increase_score();
            game.show_scoreboard();
            GAME_QUIT = true;
        }
        game.get_winner();
        System.out.println("Thanks for playing!");
    }
}