package gameofgames;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    private Player player;

    @BeforeEach
    public void setUp() {
        player = new Player();
        player.player_name = "bubba";
        player.player_score = 0;
    }

    @Test
    public void testSetName() {
        assertEquals("bubba", player.getName(), "Player starting name should be 'bubba'");
    }

    @Test
    public void testScores() {
        
    }
}
