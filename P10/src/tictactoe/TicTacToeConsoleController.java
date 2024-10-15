package tictactoe;

import java.io.IOException;
import java.util.Scanner;

public class TicTacToeConsoleController implements TicTacToeController {
  private final Readable in;
  private final Appendable out;

  public TicTacToeConsoleController(Readable in, Appendable out) {
    this.in = in;
    this.out = out;
  }

  // "Enter a move for " + model.getTurn().toString() + ":\n"
  @Override
  public void playGame(TicTacToe m) {

    try (Scanner scanner = new Scanner(this.in)){
      this.displayBoard(m);
      while (!m.isGameOver()) {
        this.out.append("Enter a move for ").append(m.getTurn().toString()).append(":\n");
          if (!this.processMove(scanner, m)){
            break;
          }
          this.displayBoard(m);
      }

    }catch(IOException ex){
      throw new IllegalStateException("Failed to append output", ex);
    }
  }

  /**
   * Processes user moves in the Tic Tac Toe game and updates the game state accordingly.
   *
   * @param scanner the input scanner to read user moves
   * @param model the Tic Tac Toe model object representing the game state
   * @return true if the game should continue, false if the game should end
   */
  private boolean processMove(Scanner scanner, TicTacToe model) {
    if (scanner.hasNextLine()) {
      String line = scanner.nextLine().trim(); // Read the entire line of moves
      String[] moves = line.split(" ");

      for (int i = 0; i < moves.length; i += 2) {
        // Check for the quit command among the moves
        if ("q".equalsIgnoreCase(moves[i])) {
          try {
            out.append("Game quit! Ending game state:\n").append(model.toString()).append("\n");
          } catch (IOException e) {
            throw new IllegalStateException("Failed to append output", e);
          }
          return false; // Exit the method if quit command is found
        }

        // Process each move
        if (i + 1 < moves.length) { // Ensure there is a pair of numbers
          try {
            int row = Integer.parseInt(moves[i]) - 1;
            int col = Integer.parseInt(moves[i + 1]) - 1;
            model.move(row, col);
            if (model.isGameOver()) {
              displayBoard(model); // Display board state if the game is over after this move
              return false; // Exit if the game is over
            }
          } catch (NumberFormatException e) {
            try {
              out.append("Not a valid number: ").append(moves[i]).append(", ").append(moves[i + 1]).append("\n");
            } catch (IOException ex) {
              throw new IllegalStateException("Failed to append output", ex);
            }
          } catch (IllegalArgumentException | IllegalStateException | IOException e) {
            try {
              out.append(e.getMessage()).append("\n");
            } catch (IOException ex) {
              throw new IllegalStateException("Failed to append output", ex);
            }
          }
        }
      }
    }
    // After processing all moves in the line, display the current board state
    try {
      displayBoard(model);
    } catch (IOException e) {
      throw new IllegalStateException("Failed to append output", e);
    }
    String input = scanner.hasNextLine() ? scanner.nextLine().trim() : "";
    System.out.println(input);

    return true; // Otherwise, continue the game
  }

  /**
   * Display the current state of the tic-tac-toe game board.
   * If the game is over, display the winner or tie game message.
   * Otherwise, display the current game board.
   *
   * @param model the tic-tac-toe game model
   * @throws IOException if there is an error writing to the output
   */
  private void displayBoard(TicTacToe model) throws IOException {
    if (model.isGameOver()){
      if (model.getWinner() == null){
        System.out.append("Game is over! ").append(" Tie game.").append("\n");
      } else {
        System.out.append("Game is over! ").append(model.getWinner().toString()).append(" wins\n");
      }
    } else {
      System.out.append(model.toString()).append("\n");
    }

  }
}
