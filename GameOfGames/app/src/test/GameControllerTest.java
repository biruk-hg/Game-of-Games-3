import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameControllerTest {
    private GameController gameController;

    @BeforeEach
    void setUp() {
        gameController = new GameController();
    }

    @Test
    void testGameInitialization() {
        assertNotNull(gameController);
    }

    @Test
    void testAddPlayer() {
        Players player = new Players("TestPlayer");
        gameController.addPlayer(player);
        assertEquals(1, gameController.getPlayers().size());
    }

    @Test
    void testStartGame() {
        Players player = new Players("TestPlayer");
        gameController.addPlayer(player);
        assertDoesNotThrow(() -> gameController.startGame());
    }

    @Test
    void testGameFlow() {
        Players player1 = new Players("Player1");
        Players player2 = new Players("Player2");
        gameController.addPlayer(player1);
        gameController.addPlayer(player2);

        assertEquals(2, gameController.getPlayers().size());
        assertDoesNotThrow(() -> gameController.startGame());
    }
}
