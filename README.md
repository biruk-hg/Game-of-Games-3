# **Game of Games**

## **Overview**
Welcome to **Game of Games**! This project offers a selection of fun, interactive games designed to enhance your Java programming skills. You can play these games directly from the console, with each offering a unique challenge. The games included in this collection are:

1. **Find the Thimble**: Guess where the thimble is hidden among the cups.  
2. **Coin Flip**: Try to predict the outcome of a coin flip.   
3. **Guess the Number**: Guess the secret number that the computer has selected.  
4. **Even or Odd**: Predict whether a randomly generated number will be even or odd.  
5. **Find the Red Thread**: Spot the "red thread" hidden within a sequence of shuffled strings.

You can choose any of these games to play from the **Game of Games** menu.

## **Game Descriptions**

### **1. Find the Thimble**
- **Objective:** Guess which cup is hiding the thimble.  
- **Gameplay:**  
  - One of the cups hides the thimble, and the computer will attempt to guess the correct one.  
  - The first player to win the most rounds wins the game.

### **2. Coin Flip**
- **Objective:** Predict whether the coin will land on "heads" or "tails."  
- **Gameplay:**  
  - Choose the number of rounds (must be a positive odd number).  
  - Make your guess ("heads" or "tails").  
  - Play against the computer, where the winner of each round is determined by the coin flip. The first player to win the majority of rounds wins the game.

### **3. Guess the Number**
- **Objective:** Guess the secret number the computer has randomly chosen.  
- **Gameplay:**  
  - The computer selects a random number within a predefined range.  
  - The player guesses the number and is given hints like "too high" or "too low" until they guess correctly.

### **4. Even or Odd**
- **Objective:** Predict whether a randomly generated number will be even or odd.  
- **Gameplay:**  
  - A random number is generated.  
  - The player guesses if the number will be even or odd.  
  - The player wins the round if the guess matches the result.

### **5. Red Thread**
- **Objective:** Identify the hidden "red thread" in a scrambled list of strings.  
- **Gameplay:**  
  - A set of strings is presented to the player.  
  - The player must correctly identify the position of the "red thread" to win the round.

---

## **How to Play**

1. Run the **Game of Games** program.
2. Choose one of the games by entering its corresponding number.
3. Follow the on-screen instructions for the selected game.
4. After finishing a game, you can choose to replay or go back to the main menu to pick another game.

---

## **Project Structure**

### **Main Classes**
- `GameOfGames.java`: The main entry point of the project. It displays the game selection menu and directs the player to the selected game.  
- `CoinFlipGame.java`: Implements the Coin Flip game mechanics.  
- `FindTheThimble.java`: Implements the Find the Thimble game.  
- `GuessTheNumber.java`: Implements the Guess the Number game.  
- `EvenOrOdd.java`: Implements the Even or Odd game.  
- `RedThread.java`: Implements the Find the Red Thread game.

### **Test Classes**
- `CoinFlipTest.java`: Unit tests for the Coin Flip game.  
- `FindTheThimbleTest.java`: Unit tests for the Find the Thimble game.  
- `GuessTheNumberTest.java`: Unit tests for the Guess the Number game.  
- `EvenOrOddTest.java`: Unit tests for the Even or Odd game.  
- `RedThreadTest.java`: Unit tests for the Find the Red Thread game.

---

## **Setup and Installation**

1. Clone this repository to your local machine: git clone <https://github.com/biruk-hg/Game-of-Games-3.git>
2. Open the project in your favorite Java IDE or navigate to the project folder via the terminal.
3. Compile the Java files: javac GameOfGames.java
4. Run the program: java GameOfGames
