import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class PlayersTest {

    @Test
    void testInitialScore() {
        Players player = new Players("TestPlayer");
        assertEquals(0, player.getScore());
    }

    @Test
    void testIncrementScore() {
        Players player = new Players("TestPlayer");
        player.incrementScore();
        assertEquals(1, player.getScore());
    }

    @Test
    void testResetScore() {
        Players player = new Players("TestPlayer");
        player.incrementScore();  // Increment the score first
        player.resetScore();
        assertEquals(0, player.getScore());
    }
}
