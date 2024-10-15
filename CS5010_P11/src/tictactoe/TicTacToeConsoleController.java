package tictactoe;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Scanner;

/**
 * Controller for the Tic Tac Toe game.
 */
public class TicTacToeConsoleController implements TicTacToeController {
  private final Readable in;
  private final Appendable out;

  /**
   * Constructs a TicTacToeConsoleController object.
   *
   * @param in  the input source
   * @param out the output source
   */
  public TicTacToeConsoleController(Readable in, Appendable out) {
    this.in = in;
    this.out = out;
  }

  /**
   * Plays a game of Tic Tac Toe.
   *
   * @param m the Tic Tac Toe model
   * @throws IllegalStateException if the controller fails to write to the Appendable
   */
  @Override
  public void playGame(TicTacToe m) throws IllegalStateException {
    try {
      // Print the initial state of the game
      out.append(m.toString() + "\n");

      // Read the input from the user
      Scanner scanner = new Scanner(in);
      while (!m.isGameOver()) {
        String input = scanner.nextLine();
        String[] parts = input.split(" ");
        int index = 0;
        Player turn = null;
        // Play the game
        while (!m.isGameOver()) {
          // Print the current player's turn, if not already
          if (m.getTurn() != turn) {
            out.append("Enter a move for " + m.getTurn().toString() + ":\n");
            turn = m.getTurn();
          }
          String s1 = "";
          String s2 = "";

          // Get the next two inputs, if there isn't anymore, continue
          if (index < parts.length) {
            s1 = parts[index];
            if (s1.equals("q") || s1.equals("Q")) {
              out.append("Game quit! Ending game state:\n" + m + "\n");
              return;
            }
            index++;
          } else {
            break;
          }
          if (index < parts.length) {
            s2 = parts[index];
            if (s2.equals("q") || s2.equals("Q")) {
              out.append("Game quit! Ending game state:\n" + m + "\n");
              return;
            }
            index++;
          } else {
            break;
          }

          // Move the player, catch exceptions when the input is invalid
          try {
            int num1 = Integer.parseInt(s1);
            int num2 = Integer.parseInt(s2);
            m.move(num1 - 1, num2 - 1);
            out.append(m + "\n");
          } catch (NumberFormatException e) {
            out.append("Not a valid number: " + s1 + "\n");
          } catch (IllegalArgumentException e) {
            out.append("Not a valid move: " + s1 + ", " + s2 + "\n");
          }
        }
      }
      // Print the final state of the game
      Player winner = m.getWinner();
      if (winner == null) {
        out.append("Game is over! Tie game.\n");
      } else {
        out.append("Game is over! " + winner + " wins.\n");
      }
    } catch (IOException e) {
      throw new IllegalStateException("Failed to write to Appendable");
    }
  }
}
