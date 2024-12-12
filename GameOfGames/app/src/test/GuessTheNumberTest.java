import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class GuessTheNumberTest {

    @Test
    void testValidRounds() {
        Players player = new Players("TestPlayer");
        GuessTheNumber game = new GuessTheNumber();

        // Assume valid round input is 5
        assertDoesNotThrow(() -> game.startGame(player));
    }

    @Test
    void testInitialScores() {
        Players player = new Players("TestPlayer");
        assertEquals(0, player.getScore());
    }

    @Test
    void testPlayerScoreIncrement() {
        Players player = new Players("TestPlayer");
        player.incrementScore();
        assertEquals(1, player.getScore());
    }
}
