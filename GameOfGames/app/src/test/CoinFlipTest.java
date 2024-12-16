import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CoinFlipTest {
    private CoinFlip coinFlip;
    private Players player;

    @BeforeEach
    void setUp() {
        coinFlip = new CoinFlip();
        player = new Players("TestPlayer");
    }

    @Test
    void testInitialComputerWins() {
        assertEquals(0, coinFlip.getComputerWins());
    }

    @Test
    void testPlayerWins() {
        player.incrementScore();
        assertEquals(1, player.getScore());
    }

    @Test
    void testSimulateCoinFlipGame() {
        String result = coinFlip.flipCoin("heads");
        assertTrue(result.equals("heads") || result.equals("tails"));
    }

    @Test
    void testComputerWinInCoinFlip() {
        coinFlip.incrementComputerWins();
        assertEquals(1, coinFlip.getComputerWins());
    }
}
