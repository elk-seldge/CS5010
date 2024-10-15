package tictactoe;

// TicTacToeModel
/*
FIELDS
 .this.board: Player[][]
 .this.turn: Player
 METHODS
 ..this.move(int r, int c): void
 ..this.getTurn(): Player
 ..this.isGameOver(): boolean
 ..this.getWinner(): Player
 ..this.getBoard(): Player[][]
 ..this.getMarkAt(int r, int c): Player
 ..this.toString(): String
 */
import java.util.Arrays;
import java.util.stream.Collectors;


public class TicTacToeModel implements TicTacToe {
  // add your implementation here
  private final Player[][] board;
  private Player turn;

  /**
   * Creates a new instance of the TicTacToeModel class.
   * Initializes an empty game board and sets the turn to Player X.
   */
  public TicTacToeModel() {
    this.board = new Player[3][3];
    this.turn = Player.X;
  }

  /**
   * Execute a move in the position specified by the given row and column.
   *
   * @param r the row of the intended move
   * @param c the column of the intended move
   */
  @Override
  public void move(int r, int c) {
    //
    if (this.isValidMove(r, c)) {
      if (!this.isGameOver()){
        this.board[r][c] = this.turn;
        this.turn = (this.turn == Player.X) ? Player.O : Player.X;
      } else {
        throw new IllegalStateException("The game is already over");
      }

    } else {
      throw new IllegalArgumentException("The position is full or invalid row/col value");
    }

  }

  /**
   * Checks if the given move is valid.
   *
   * @param r The row index of the move.
   * @param c The column index of the move.
   * @return True if the move is valid, false otherwise.
   */
  private boolean isValidMove(int r, int c) {
    return r >= 0 && r < board.length && c >= 0 && c < board[r].length && board[r][c] == null;
  }

  /**
   * Get the current turn, i.e., the player who will mark on the next call to move().
   *
   * @return the {@link Player} whose turn it is
   */
  @Override
  public Player getTurn() {
    return (this.turn == Player.X) ? Player.X : Player.O;
  }

  /**
   * Return whether the game is over. The game is over when either the board is full, or
   * one player has won.
   *
   * @return true if the game is over, false otherwise
   */
  @Override
  public boolean isGameOver() {
    return getWinner() != null || isBoardFull();
  }

  /**
   * Checks if the game board is full.
   *
   * @return True if the game board is full, otherwise false.
   */
  private boolean isBoardFull() {
    for (Player[] row : board) {
      for (Player p : row) {
        if (p == null) {
          return false;
        }
      }
    }
    return true;
  }


  /**
   * Gets the winner of the tic-tac-toe game.
   *
   * @return the player who won the game, or null if there is no winner yet
   */
  @Override
  public Player getWinner() {
    Player winner = null;
    for (Player[] players : board) {
      // check for ends like X X X or O O O
      if (players[0] != null && players[0] == players[1] && players[0] == players[2]) {
        winner = (players[0] == Player.X)  ? Player.X : Player.O;;
        break;
      }
    }
    for (int i = 0; i < board[0].length; i++) {
      //check for ends like:
      // X      O
      // X  or  O
      // X      O
      if (board[0][i] != null && board[0][i] == board[1][i] && board[0][i] == board[2][i]) {
        winner = (board[0][i] == Player.X) ? Player.X : Player.O;
        break;
      }
    }
    if (board[0][0] != null && board[0][0] == board[1][1] && board[0][0] == board[2][2]) {
      // Check for ends like:
      /*
      X           O
        X     or    O
          X           O
       */
      winner = (board[0][0] == Player.X) ? Player.X : Player.O;
    } else if (board[0][2] != null && board[0][2] == board[1][1] && board[0][2] == board[2][0]) {
      // Check for ends like:
      /*
             X           O
           X     or    O
         X           O
       */
      winner = (board[0][2] == Player.X) ? Player.X : Player.O;
    }
    return winner;
  }

  /**
   * Retrieves the current game board.
   *
   * @return The game board represented as a two-dimensional array of Player objects.
   */
  @Override
  public Player[][] getBoard() {
    Player[][] result =  new Player[this.board.length][];
    for (int i = 0; i < this.board.length; i++) {
      result[i] = new Player[this.board[i].length];
      System.arraycopy(this.board[i], 0, result[i], 0, this.board[i].length);
    }
    return result;
  }

  /**
   * Return the current Player mark at the given row and column.
   *
   * @param r the row
   * @param c the column
   * @return the Player at the given position, or null if it's empty
   */
  @Override
  public Player getMarkAt(int r, int c) {
    if (r >= 0 && r <= 2 && c >= 0 && c <= 2) {
      return (board[r][c] == Player.X) ? Player.X : Player.O;
    } else {
      throw new IllegalArgumentException("row and column should be in [0, 2]");
    }
  }


  /**
   * Returns a string representation of the TicTacToe game board.
   *
   * @return The game board represented as a string.
   */
  @Override
  public String toString() {
    // Using Java stream API to save code:
    return Arrays.stream(getBoard()).map(
                    row -> " " + Arrays.stream(row).map(
                            p -> p == null ? " " : p.toString()).collect(Collectors.joining(" | ")))
            .collect(Collectors.joining("\n-----------\n"));
    // This is the equivalent code as above, but using iteration, and still using
    // the helpful built-in String.join method.
  }
}
