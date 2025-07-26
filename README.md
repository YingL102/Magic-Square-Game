# Magic Square Game

This project implements a Magic Square game in Java. The game starts by generating a magic square and then shuffling it. The player's objective is to reassemble the magic square by swapping adjacent numbers until all rows, columns, and diagonals add up to the same value.

## Files

- **[MagicSquare.java](MagicSquare.java)**  
  Implements the creation of a magic square using the Siamese method.

- **[MSGame.java](MSGame.java)**  
  Extends `MagicSquare` to provide functionality for shuffling the square, processing user input for swapping values, and checking if the puzzle is solved.

- **[Main.java](Main.java)**  
  Contains the main method that drives the game. It handles user input, initiates the game, and manages the game loop.

## How It Works

1. **Setup:**  
   The program prompts the user to enter an odd number, which determines the size of the magic square.

2. **Magic Square Generation:**  
   The magic square is generated using the Siamese method in [`MagicSquare.java`](MagicSquare.java).

3. **Shuffling:**  
   The generated magic square is shuffled in [`MSGame.java`](MSGame.java) to create the puzzle.

4. **Gameplay:**  
   The user inputs moves in the format `row col direction` (for example, `1 1 R` to move the element at row 1, column 1 to the right).  
   The moves swap adjacent elements, and the game counts these moves.

5. **Win Condition:**  
   After every move, the game checks whether the magic square property holds (i.e., every row, column, and both diagonals sum to the same magic number). When the condition is met, the puzzle is complete and the game ends, displaying the number of moves taken.

## How to Compile and Run

1. **Compile:**  
   Open a terminal in the project directory and run:
   ```sh
   javac *.java
   ```

2. **Run:**  
   Execute the game by running:
   ```sh
   java Main
   ```

Enjoy solving the magic square puzzle!
