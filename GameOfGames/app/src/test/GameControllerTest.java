import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;

public class GameControllerTest {

    @Test
    void testGameLoopExit() throws IOException {
        // Simulate console input
        InputStream input = new ByteArrayInputStream("6\n".getBytes());
        System.setIn(input);
        
        // Redirect output stream to capture the printed result
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        // Call main method
        String[] args = {};
        GameController.main(args);

        // Check if output includes the correct exit message
        assertTrue(output.toString().contains("Thanks for playing"));
    }

    @Test
    void testInvalidChoice() throws IOException {
        // Simulate console input
        InputStream input = new ByteArrayInputStream("7\n6\n".getBytes());
        System.setIn(input);
        
        // Redirect output stream to capture the printed result
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        // Call main method
        String[] args = {};
        GameController.main(args);

        // Check if invalid input is handled
        assertTrue(output.toString().contains("Invalid choice. Please try again."));
    }
}
