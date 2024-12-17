# 🎮 **Game of Games**

## **Overview**
Welcome to **Game of Games**! This project offers a selection of fun, interactive console games designed to provide entertainment and showcase fundamental Java programming concepts. Each game challenges you to compete against the computer and keeps track of your scores.

The games included in this collection are:

1. **Coin Flip**: Predict the outcome of a coin toss.  
2. **Find the Thimble**: Guess which hand is hiding the thimble.  
3. **Even or Odd**: Determine if a randomly generated number is even or odd.  
4. **Guess the Number**: Guess the randomly generated number.  
5. **Red Thread**: Identify the position of the hidden red thread.

You can select any of these games from the **Game of Games** menu.

---

## **Game Descriptions**

### **1. Coin Flip**
- **Objective**: Predict whether the coin will land on "Heads" or "Tails."
- **Gameplay**:  
  - Choose a positive odd number of rounds to play.  
  - Make your guess ("Heads" or "Tails").  
  - Win by correctly guessing the outcome of the coin flip.

### **2. Find the Thimble**
- **Objective**: Guess which hand (left or right) contains the hidden thimble.
- **Gameplay**:  
  - Choose a positive odd number of rounds to play.  
  - Guess the hand where the thimble is hidden.  
  - Win by making more correct guesses of where the thimble is hidden.

### **3. Even or Odd**
- **Objective**: Predict if the sum of two numbers will be even or odd.
- **Gameplay**:  
  - Choose a positive odd number of rounds to play.
  - Decide if you want to be even or odd.
  - Select a number (while computer does the same).  
  - Win if the sum of your number and the computer's number is the parity you chose.

### **4. Guess the Number**
- **Objective**: Guess the number the computer randomly selects (between 1 and 10).
- **Gameplay**:  
  - Choose a positive odd number of rounds to play.  
  - Guess the number the computer has selected.  
  - Win by correctly guessing more times than the computer.

### **5. Red Thread**
- **Objective**: Identify the position of the hidden red thread.
- **Gameplay**:  
  - Choose a positive odd number of rounds to play.  
  - Guess the position of the red thread.  
  - Win by correctly identifying the position more times than the computer.

---

## **How to Play**

1. Run the **Game of Games** program.
2. Select one of the games by entering the corresponding number.
3. Follow the on-screen instructions for the chosen game.
4. After completing a game, you can choose to replay or return to the main menu to pick another game.

---

## **Project Structure**

### **Main Classes**

| **Class**            | **Description**                                        |
|----------------------|--------------------------------------------------------|
| `CoinFlip.java`      | Implements the Coin Flip game.                         |
| `FindTheThimble.java`| Implements the Find the Thimble game.                  |
| `EvenOrOdd.java`     | Implements the Even or Odd game.                       |
| `GuessTheNumber.java`| Implements the Guess the Number game.                  |
| `RedThread.java`     | Implements the Red Thread game.                        |
| `Players.java`       | Represents the player and tracks the score.            |
| `GameController.java` | Implements all the Games.                             |

### **Test Classes**

| **Class**                 | **Description**                                        |
|----------------------------|--------------------------------------------------------|
| `PlayersTest.java`        | Unit tests for the Players class.                      |
| `CoinFlipTest.java`       | Unit tests for the Coin Flip game.                     |
| `FindTheThimbleTest.java` | Unit tests for the Find the Thimble game.              |
| `EvenOrOddTest.java`      | Unit tests for the Even or Odd game.                   |
| `GuessTheNumberTest.java` | Unit tests for the Guess the Number game.              |
| `RedThreadTest.java`      | Unit tests for the Red Thread game.                    |
| `GameControllerTest.java` | Unit tests for the Game Controller.                    |

---

## **Setup and Installation**

### **Prerequisites**

- **Java JDK 11 or higher**
- **Gradle** (for building and testing)
- **Visual Studio Code** (recommended IDE)

### **Clone the Repository**

Make sure to complie all the classes (CoinFlip.java, FindTheThimble.java, etc.) before attempting to compile and run the GameController.java 

```bash
git clone https://github.com/biruk-hg/Game-of-Games-3.git
cd location_of_GameOfGames_folder/GameOfGames/app/src/main (for the main classes)
cd location_of_GameOfGames_folder/GameOfGames/app/src/test (for the test classes)

