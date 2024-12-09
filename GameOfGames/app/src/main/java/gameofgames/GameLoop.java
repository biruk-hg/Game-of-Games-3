package gameofgames;
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
            game.gameSelect();
            /* plays game1, player 1 wins */
            P1.increaseScore();
            game.show_scoreboard();
            GAME_QUIT = game.gameQuit();
            /* game continues, next game is selected, player 1 wins again*/
            game.gameSelect();
            P1.increaseScore();
            game.show_scoreboard();
            GAME_QUIT = game.gameQuit();
            /* running one more game, player 2 wins, but the player chooses to quit */
            game.gameSelect();
            P2.increaseScore();
            game.show_scoreboard();
            GAME_QUIT = true;
        }
        game.getWinner();
        System.out.println("Thanks for playing!");
    }
}