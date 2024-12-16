import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RedThreadTest {
    private RedThread redThread;
    private Players player;

    @BeforeEach
    void setUp() {
        redThread = new RedThread();
        player = new Players("TestPlayer");
    }

    @Test
    void testInitialPlayerScore() {
        assertEquals(0, player.getScore());
    }

    @Test
    void testPlayerFindsRedThread() {
        boolean found = redThread.checkForRedThread("red");
        assertTrue(found);
    }

    @Test
    void testSimulateRedThreadGame() {
        String threadColor = redThread.generateThreadColor();
        assertTrue(threadColor.equals("red") || threadColor.equals("blue") || threadColor.equals("green"));
    }
}
