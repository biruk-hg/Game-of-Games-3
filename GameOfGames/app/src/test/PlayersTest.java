import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlayersTest {
    @Test
    void testPlayerInitialization() {
        Players player = new Players("TestPlayer");
        assertEquals("TestPlayer", player.getName());
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
        player.incrementScore();
        player.resetScore();
        assertEquals(0, player.getScore());
    }
}

