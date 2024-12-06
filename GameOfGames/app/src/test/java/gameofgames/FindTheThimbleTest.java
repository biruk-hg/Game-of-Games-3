package gameofgames;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FindTheThimbleTest {

    private FindTheThimble game;

    @BeforeEach
    public void setUp() {
        game = new FindTheThimble();
        game.p1Score = 0;
        game.computerScore = 0;
        game.numOfRounds = 0;
    }

    @Test
    public void testInitialScores() {
        assertEquals(0, game.p1Score, "Player's initial score should be 0");
        assertEquals(0, game.computerScore, "Computer's initial score should be 0");
    }

    @Test
    public void testDetermineWinnerPlayerWins() {
        game.p1Score = 3;
        game.computerScore = 1;
        assertEquals("Congratulations! You won the game!", game.determineWinner(), "Player should win with a higher score");
    }

    @Test
    public void testDetermineWinnerComputerWins() {
        game.p1Score = 2;
        game.computerScore = 3;
        assertEquals("The computer won the game! Better luck next time.", game.determineWinner(), "Computer should win with a higher score");
    }

    @Test
    public void testDetermineWinnerTie() {
        game.p1Score = 2;
        game.computerScore = 2;
        assertEquals("It's a tie!", game.determineWinner(), "Game should result in a tie with equal scores");
    }

    @Test
    public void testInvalidNumberOfRounds() {
        game.numOfRounds = 0;
        assertFalse(isValidRoundInput(game.numOfRounds), "Zero rounds should not be valid");
        game.numOfRounds = 6;
        assertFalse(isValidRoundInput(game.numOfRounds), "Even number of rounds should not be valid");
        game.numOfRounds = -1;
        assertFalse(isValidRoundInput(game.numOfRounds), "Negative rounds should not be valid");
    }

    @Test
    public void testValidNumberOfRounds() {
        game.numOfRounds = 5;
        assertTrue(isValidRoundInput(game.numOfRounds), "Odd positive number of rounds should be valid");
    }

    private boolean isValidRoundInput(int numOfRounds) {
        return numOfRounds > 0 && numOfRounds % 2 != 0;
    }

    @Test
    public void testScoreUpdatePlayer() {
        game.p1Score = 0;
        game.p1Score++;
        assertEquals(1, game.p1Score, "Player's score should increase by 1");
    }

    @Test
    public void testScoreUpdateComputer() {
        game.computerScore = 0;
        game.computerScore++;
        assertEquals(1, game.computerScore, "Computer's score should increase by 1");
    }
}
