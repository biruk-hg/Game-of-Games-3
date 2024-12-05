public class GameLoop extends GameOfGames{
    public static void main(String args[]) {
        /* determine if winner has been chosen to close the game/end loop */
        Boolean WINNER_CHOSEN = false;
        Boolean GAME_QUIT = false;
        
        System.out.println("Welcome to the Game of Games!");
        
        /* enter main game loop */
        while (WINNER_CHOSEN && GAME_QUIT != true) {
            GameOfGames maingame = new GameOfGames();

            /* potentially skip the player initialization stage if in debug mode */
            Player P1 = new Player();
            Player P2 = new Player();
            
            //*******************************************************************************
            // NOT FINAL CODE. TESTING CURRENT METHODS/CLASSES TO SIMULATE THE FINAL GAMELOOP
            //*******************************************************************************

            /* current player selects a game */
            maingame.game_select();
            /* plays game1, player 1 wins */
            P1.increase_score();
            maingame.show_scoreboard();
            maingame.game_quit();
        }
    }
}