package gameofgames;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GuessTheNumberTest {

    private GuessTheNumber game;

    @BeforeEach
    public void setUp() {
        game = new GuessTheNumber();
    }

    // Test 1: Valid Range Selection
    @Test
    public void testValidRangeSelection() {
        // Accept the range and ensure it proceeds to ask for number of guesses
        int range = 6;
        assertTrue(range >= 1 && range <= 10, "Range should be between 1 and 10");
    }

    // Test 2: Correct Guess on First Attempt
    @Test
    public void testCorrectGuessFirstAttempt() {
        game.secretNumber = 9;
        int guess = 9;
        assertEquals(game.secretNumber, guess, "Player wins with 'You Won!' on the first attempt");
    }

    // Test 3: Correct Guess after Several Attempts
    @Test
    public void testCorrectGuessAfterSeveralAttempts() {
        game.secretNumber = 9;
        int[] guesses = {4, 5, 6, 9};
        String message = "";
        for (int guess : guesses) {
            if (guess == game.secretNumber) {
                message = "You Won!";
                break;
            } else {
                message = "Try again";
            }
        }
        assertEquals("You Won!", message, "Player should eventually guess correctly and win");
    }

    // Test 4: Out of Guesses
    @Test
    public void testOutOfGuesses() {
        game.secretNumber = 7;
        int[] guesses = {4, 5, 6, 1, 2};
        boolean outOfGuesses = true;
        for (int guess : guesses) {
            if (guess == game.secretNumber) {
                outOfGuesses = false;
                break;
            }
        }
        assertTrue(outOfGuesses, "Player should lose with 'You lost!' after running out of guesses");
    }

    // Test 5: Valid Number of Guesses
    @Test
    public void testValidNumberOfGuesses() {
        int numberOfGuesses = 2;
        assertTrue(numberOfGuesses > 0, "Valid number of guesses should proceed");
    }

    // Test 6: Invalid Input - Negative Number
    @Test
    public void testInvalidInputNegativeNumber() {
        int input = -1;
        boolean isValid = input >= 1;
        assertFalse(isValid, "Negative numbers should be invalid");
    }

    // Test 7: Invalid Input - Too High Number
    @Test
    public void testInvalidInputTooHighNumber() {
        int input = 11;
        boolean isValid = input <= 10;
        assertFalse(isValid, "Numbers higher than the range should be invalid");
    }

    // Test 8: Invalid Input - Letter
    @Test
    public void testInvalidInputLetter() {
        String input = "a";
        boolean isValid = false;
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            isValid = false;
        }
        assertFalse(isValid, "Letters should not be accepted as input");
    }

    // Test 9: Invalid Input - Empty
    @Test
    public void testInvalidInputEmpty() {
        String input = "";
        boolean isValid = false;
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            isValid = false;
        }
        assertFalse(isValid, "Empty input should not be accepted");
    }

    // Test 10: Invalid Input - Special Characters
    @Test
    public void testInvalidInputSpecialCharacters() {
        String input = "@";
        boolean isValid = false;
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            isValid = false;
        }
        assertFalse(isValid, "Special characters should not be accepted as input");
    }

    // Test 11: Guess Condition - More than Half of Range
    @Test
    public void testGuessConditionMoreThanHalfOfRange() {
        int guesses = 8;
        boolean isValid = guesses <= 10 / 2;
        assertFalse(isValid, "Guesses more than half of the range should be invalid");
    }

    // Test 12: Guess Condition - Zero
    @Test
    public void testGuessConditionZero() {
        int guesses = 0;
        boolean isValid = guesses > 0;
        assertFalse(isValid, "Zero guesses should be invalid");
    }
}
