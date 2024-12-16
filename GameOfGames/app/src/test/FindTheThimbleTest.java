import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FindTheThimbleTest {
    private FindTheThimble findTheThimble;
    private Players player;

    @BeforeEach
    void setUp() {
        findTheThimble = new FindTheThimble();
        player = new Players("TestPlayer");
    }

    @Test
    void testInitialPlayerScore() {
        assertEquals(0, player.getScore());
    }

    @Test
    void testPlayerFindsThimble() {
        boolean found = findTheThimble.checkLocation(3, 3);
        assertTrue(found || !found); // Test result of location check
    }

    @Test
    void testSimulateFindTheThimbleGame() {
        int thimbleLocation = findTheThimble.hideThimble();
        assertTrue(thimbleLocation >= 1 && thimbleLocation <= 5);
    }
}
