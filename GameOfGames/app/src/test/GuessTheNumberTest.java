import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GuessTheNumberTest {
    private GuessTheNumber guessTheNumber;
    private Players player;

    @BeforeEach
    void setUp() {
        guessTheNumber = new GuessTheNumber();
        player = new Players("TestPlayer");
    }

    @Test
    void testInitialPlayerScore() {
        assertEquals(0, player.getScore());
    }

    @Test
    void testPlayerGuessesNumberCorrectly() {
        int randomNumber = guessTheNumber.generateRandomNumber();
        boolean correct = guessTheNumber.checkGuess(randomNumber, randomNumber);
        assertTrue(correct);
    }

    @Test
    void testSimulateGuessTheNumberGame() {
        int randomNumber = guessTheNumber.generateRandomNumber();
        assertTrue(randomNumber >= 1 && randomNumber <= 100);
    }
}
