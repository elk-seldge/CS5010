package tictactoe;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * This class represents a tic-tac-toe game
 */
public class TicTacToeModel implements TicTacToe {
  private final Player[][] board;
  private Player turn;

  /**
   * Constructor for the TicTacToeModel class, initializes the board and sets the first turn to X
   */
  public TicTacToeModel() {
    board = new Player[3][3];
    turn = Player.X;
  }

  @Override
  public String toString() {
    // Using Java stream API to save code:
    return Arrays.stream(getBoard()).map(
      row -> " " + Arrays.stream(row).map(
        p -> p == null ? " " : p.toString()).collect(Collectors.joining(" | ")))
          .collect(Collectors.joining("\n-----------\n"));
    // This is the equivalent code as above, but using iteration, and still using 
    // the helpful built-in String.join method.
    /**********
    List<String> rows = new ArrayList<>();
    for(tictactoe.Player[] row : getBoard()) {
      List<String> rowStrings = new ArrayList<>();
      for(tictactoe.Player p : row) {
        if(p == null) {
          rowStrings.add(" ");
        } else {
          rowStrings.add(p.toString());
        }
      }
      rows.add(" " + String.join(" | ", rowStrings));
    }
    return String.join("\n-----------\n", rows);
    ************/
  }

  @Override
  public void move(int r, int c) throws IllegalArgumentException, IllegalStateException {
    if(r<0 || r>=3 || c<0 || c>=3)
      throw new IllegalArgumentException("Invalid cell position.");
    if(board[r][c] != null)
      throw new IllegalArgumentException("The cell is already occupied.");
    if(isGameOver())
      throw new IllegalStateException("The game is already over.");

    board[r][c] = getTurn();
    turn = getTurn() == Player.X ? Player.O : Player.X;
  }

  @Override
  public Player getTurn() {
    return turn;
  }

  @Override
  public boolean isGameOver() {
    return getWinner() != null || Arrays.stream(board).allMatch(row -> Arrays.stream(row).allMatch(p -> p != null));
  }

  @Override
  public Player getWinner() {
    for(int i = 0; i < 3; i++) {
      if(board[i][0] != null && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
        return board[i][0];
      }
      if(board[0][i] != null && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
        return board[0][i];
      }
    }
    if(board[0][0] != null && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
      return board[0][0];
    }
    if(board[0][2] != null && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
      return board[0][2];
    }
    return null;
  }

  @Override
  public final Player[][] getBoard() {
    return Arrays.stream(board).map(row -> row.clone()).toArray(Player[][]::new);
  }

  @Override
  public Player getMarkAt(int r, int c) throws IllegalArgumentException{
    if(r<0 || r>=3 || c<0 || c>=3)
      throw new IllegalArgumentException("Invalid cell position.");
    return board[r][c];
  }
}
