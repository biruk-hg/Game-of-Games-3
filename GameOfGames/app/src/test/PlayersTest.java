import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlayersTest {
    private Players player;

    @BeforeEach
    void setUp() {
        player = new Players("TestPlayer");
    }

    @Test
    void testGetName() {
        assertEquals("TestPlayer", player.getName());
    }

    @Test
    void testInitialScore() {
        assertEquals(0, player.getScore());
    }

    @Test
    void testIncrementScore() {
        player.incrementScore();
        assertEquals(1, player.getScore());
    }

    @Test
    void testResetScore() {
        player.incrementScore();
        player.resetScore();
        assertEquals(0, player.getScore());
    }
}
