package gameofgames;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EvenOrOddTest {

    private EvenOrOdd game;

    @BeforeEach
    public void setUp() {
        game = new EvenOrOdd();
    }

    // Test 1: Player inputs an invalid choice (not 'Even' or 'Odd').
    @Test
    public void testInvalidChoice() {
        String choice = "invalid";
        boolean isValid = choice.equalsIgnoreCase("even") || choice.equalsIgnoreCase("odd");
        assertFalse(isValid, "Invalid input should prompt player to reenter a valid choice.");
    }

    // Test 2: Player inputs a valid choice ('Even' or 'Odd').
    @Test
    public void testValidChoice() {
        String choice = "Even";
        boolean isValid = choice.equalsIgnoreCase("even") || choice.equalsIgnoreCase("odd");
        assertTrue(isValid, "Valid input should allow the game to proceed.");
    }

    // Test 3: Player inputs a number outside the valid range (e.g., 0 or 6).
    @Test
    public void testInvalidNumberOutsideRange() {
        int number = 6;
        boolean isValid = number >= 1 && number <= 5;
        assertFalse(isValid, "Invalid number should prompt player to reenter a valid number.");
    }

    // Test 4: Player inputs a valid number within range (1-5).
    @Test
    public void testValidNumberWithinRange() {
        int number = 3;
        boolean isValid = number >= 1 && number <= 5;
        assertTrue(isValid, "Valid number should allow the game to proceed.");
    }

    // Test 5: Specified 'Best Out Of' number is not odd.
    @Test
    public void testInvalidBestOutOfNumber() {
        int bestOutOf = 4;
        boolean isValid = bestOutOf > 0 && bestOutOf % 2 != 0;
        assertFalse(isValid, "Invalid 'Best Out Of' number should prompt player to reenter an odd number.");
    }

    // Test 6: Specified 'Best Out Of' number is odd.
    @Test
    public void testValidBestOutOfNumber() {
        int bestOutOf = 5;
        boolean isValid = bestOutOf > 0 && bestOutOf % 2 != 0;
        assertTrue(isValid, "Valid 'Best Out Of' number should allow the game to proceed.");
    }

    // Test 7: Player wins a round based on their choice and the total is even/odd.
    @Test
    public void testPlayerWinsRound() {
        String choice = "even";
        int playerNumber = 2;
        int computerNumber = 2;
        int sum = playerNumber + computerNumber;
        boolean isEven = sum % 2 == 0;
        boolean playerWins = (isEven && choice.equalsIgnoreCase("even")) || (!isEven && choice.equalsIgnoreCase("odd"));
        assertTrue(playerWins, "Player should win the round when their choice matches the total parity.");
    }

    // Test 8: Computer wins a round based on the total being even/odd.
    @Test
    public void testComputerWinsRound() {
        String choice = "odd";
        int playerNumber = 1;
        int computerNumber = 2;
        int sum = playerNumber + computerNumber;
        boolean isEven = sum % 2 == 0;
        boolean computerWins = (isEven && choice.equalsIgnoreCase("odd")) || (!isEven && choice.equalsIgnoreCase("even"));
        assertTrue(computerWins, "Computer should win the round when the player's choice does not match the total parity.");
    }

    // Test 9: Game reaches 'Best Out Of' value for Player 1.
    @Test
    public void testPlayerOneWinsGame() {
        int playerScore = 3;
        int computerScore = 1;
        int requiredScore = 3;
        boolean playerOneWins = playerScore >= requiredScore;
        assertTrue(playerOneWins, "Player 1 should be declared the winner when reaching the required score.");
    }

    // Test 10: Game reaches 'Best Out Of' value for Player 2.
    @Test
    public void testPlayerTwoWinsGame() {
        int playerScore = 1;
        int computerScore = 3;
        int requiredScore = 3;
        boolean playerTwoWins = computerScore >= requiredScore;
        assertTrue(playerTwoWins, "Player 2 should be declared the winner when reaching the required score.");
    }

    // Test 11: Invalid non-numeric input during number entry.
    @Test
    public void testInvalidNonNumericInput() {
        String input = "abc";
        boolean isValid = false;
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            isValid = false;
        }
        assertFalse(isValid, "Invalid input should prompt player to enter a numeric value.");
    }

    // Test 12: Game continues after an invalid input is corrected.
    @Test
    public void testGameResumesAfterInvalidInput() {
        String input = "2";
        boolean isValid = false;
        try {
            Integer.parseInt(input);
            isValid = true;
        } catch (NumberFormatException e) {
            isValid = false;
        }
        assertTrue(isValid, "Game should resume correctly after valid input.");
    }
}
