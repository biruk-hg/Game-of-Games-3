import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;

class RedThreadTest {
    @Test
    public void testSpoolsPicked() {
        // Simulate user input for picking quantity (10 spools)
        String input1 = "10\n";  // First line is the picking quantity
        System.setIn(new ByteArrayInputStream(input1.getBytes()));  // Redirecting input for game setup
        RedThread.gameSetup();
        assertTrue(RedThread.pickingquantity > 0 && RedThread.pickingquantity >= 10);
    }
    @Test
    public void testWinner() {
        // Simulate input for picking 10 spools and the spool picks
        String input = "10\n1\n2\n3\n4\n5\n6\n7\n8\n9\n10\n11\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));  // Set input for both game setup and picking spools

        int res = RedThread.playingvsComputer();

        // Assert that the result is either 1 (player wins) or 0 (computer wins)
        assertTrue(res == 1 || res == 0, "The game should return 1 (player wins) or 0 (computer wins).");
    }
    @Test
    public void Testpvp()
    {
        String input = "10\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        RedThread.gameSetup();
        String input2 = "1\n2\n3\n4\n5\n6\n7\n8\n9\n10\n";
        String input3 = "11\n12\n13\n14\n15\n16\n17\n18\n19\n20\n";
        System.setIn(new ByteArrayInputStream(input2.getBytes()));  // Redirecting input for game setup
        System.setIn(new ByteArrayInputStream(input3.getBytes()));  // Redirecting input for game setup
        RedThread.pvp();
        assertTrue(RedThread.pvp() == 1 || RedThread.pvp() == 0);
    }




    @org.junit.jupiter.api.Test
    void playingvsComputer() {
    }

    @org.junit.jupiter.api.Test
    void totalgame() {
    }
}