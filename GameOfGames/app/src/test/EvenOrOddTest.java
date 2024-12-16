import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EvenOrOddTest {
    private EvenOrOdd evenOrOdd;
    private Players player;

    @BeforeEach
    void setUp() {
        evenOrOdd = new EvenOrOdd();
        player = new Players("TestPlayer");
    }

    @Test
    void testInitialComputerWins() {
        assertEquals(0, evenOrOdd.getComputerWins());
    }

    @Test
    void testPlayerGuessesCorrectly() {
        evenOrOdd.playerGuess(2, 4); // Assume both numbers are even
        assertEquals(1, evenOrOdd.getPlayerWins());
    }

    @Test
    void testSimulateEvenOrOddGame() {
        String result = evenOrOdd.determineResult(3);
        assertTrue(result.equals("odd") || result.equals("even"));
    }

    @Test
    void testComputerWinInEvenOrOdd() {
        evenOrOdd.incrementComputerWins();
        assertEquals(1, evenOrOdd.getComputerWins());
    }
}
