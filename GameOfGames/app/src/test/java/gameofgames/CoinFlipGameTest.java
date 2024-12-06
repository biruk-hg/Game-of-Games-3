package gameofgames;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CoinFlipGameTest {

    private CoinFlipGame game;

    @BeforeEach
    public void setUp() {
        game = new CoinFlipGame();
        game.playerScore = 0;
        game.computerScore = 0;
        game.numOfRounds = 0;
    }

    @Test
    public void testInitialScores() {
        assertEquals(0, game.playerScore, "Player's initial score should be 0");
        assertEquals(0, game.computerScore, "Computer's initial score should be 0");
    }

    @Test
    public void testDetermineWinnerPlayerWins() {
        game.playerScore = 3;
        game.computerScore = 1;
        assertEquals("Congratulations! You won the game!", game.determineWinner(), "Player should win with a higher score");
    }

    @Test
    public void testDetermineWinnerComputerWins() {
        game.playerScore = 2;
        game.computerScore = 3;
        assertEquals("The computer won the game! Better luck next time.", game.determineWinner(), "Computer should win with a higher score");
    }

    @Test
    public void testDetermineWinnerTie() {
        game.playerScore = 2;
        game.computerScore = 2;
        assertEquals("It's a tie!", game.determineWinner(), "Game should result in a tie with equal scores");
    }

    @Test
    public void testInvalidNumberOfRounds() {
        game.numOfRounds = 0;
        assertFalse(isValidRoundInput(game.numOfRounds), "Zero rounds should not be valid");
        game.numOfRounds = 4;
        assertFalse(isValidRoundInput(game.numOfRounds), "Even number of rounds should not be valid");
        game.numOfRounds = -1;
        assertFalse(isValidRoundInput(game.numOfRounds), "Negative rounds should not be valid");
    }

    @Test
    public void testValidNumberOfRounds() {
        game.numOfRounds = 3;
        assertTrue(isValidRoundInput(game.numOfRounds), "Odd positive number of rounds should be valid");
    }

    private boolean isValidRoundInput(int numOfRounds) {
        return numOfRounds > 0 && numOfRounds % 2 != 0;
    }

    @Test
    public void testScoreUpdatePlayer() {
        game.playerScore = 0;
        game.playerScore++;
        assertEquals(1, game.playerScore, "Player's score should increase by 1");
    }

    @Test
    public void testScoreUpdateComputer() {
        game.computerScore = 0;
        game.computerScore++;
        assertEquals(1, game.computerScore, "Computer's score should increase by 1");
    }
}

