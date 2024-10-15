// MarbleSolitaireModelImpl
/*
FIELDS
 .this.board: String[][]
 .this.score: int
 METHODS
 ..this.move(int fromRow, int fromCol, int toRow, int toCol): void
 ..this.isGameOver(): boolean
 ..this.getGameState(): String
 ..this.getScore(): int
 */

import java.util.Objects;

/**
 * The MarbleSolitaireModelImpl class is an implementation of the MarbleSolitaireModel interface. It represents
 * the operations and state of a game of marble solitaire.
 */
public class MarbleSolitaireModelImpl implements MarbleSolitaireModel{

  private final String[][] board = new String[7][7];
  private int score;

  /**
   * Constructs a new instance of the MarbleSolitaireModelImpl class.
   * Initializes the game board with the initial configuration.
   */
  public MarbleSolitaireModelImpl(){
    for (int i=0; i <7; i++){
      for (int j=0; j<7; j++){
        if ((i < 2 && j < 2) || (i > 4 && j>4) || (i < 2 && j>4) || (i > 4 && j < 2)){
         this.board[i][j] = "X";
        } else if (i==3 && j==3) {
          this.board[i][j] = "_";
        } else {
          this.board[i][j] = "O";
        }
      }
    }
    this.score = 32;
  }

  /**
   * Moves a marble on the game board from one position to another.
   *
   * @param fromRow The row index of the marble's original position.
   * @param fromCol The column index of the marble's original position.
   * @param toRow The row index of the destination position.
   * @param toCol The column index of the destination position.
   * @throws IllegalArgumentException if the move is invalid.
   */
  /*
  +  0  1  2  3  4  5  6
  0  X  X  O  O  O  X  X
  1  X  X  O  O  O  X  X
  2  O  O  O  O  O  O  O
  3  O  O  O  _  O  O  O
  4  O  O  O  O  O  O  O
  5  X  X  O  O  O  X  X
  6  X  X  O  O  O  X  X
   */
  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    if ((fromRow < 2 && fromCol < 2) || (fromRow > 4 && fromCol > 4) || (fromRow < 2 && fromCol > 4) || (fromRow > 4 && fromCol < 2) ||
            (toRow < 2 && toCol < 2) || (toRow > 4 && toCol > 4) || (toRow < 2 && toCol > 4) || (toRow > 4 && toCol < 2)) {
      // Check invalid moves to/from four corners of the board
      throw new IllegalArgumentException("Invalid move (cannot move from/to outside of the board" +
              "). ");
    } else if (Objects.equals(this.board[toRow][toCol], "_")) {
      // regular moves
      if (Math.abs(toRow-fromRow) == 2 || Math.abs(toCol-fromCol) == 2){
        if ((toRow == fromRow && toCol != fromCol) || (toRow != fromRow && toCol == fromCol)){
          this.board[toRow][toCol] = "O";
          this.board[fromRow][fromCol] = "_";
          this.board[(fromRow + toRow) / 2][(fromCol + toCol) / 2] = "_";
          this.score--;
        } else {
          // Check invalid moves on diagonal direction on the board
          throw new IllegalArgumentException("Cannot move diagonally.");
        }
      } else {
        // Check invalid moves more than two rows/columns on the board
        throw new IllegalArgumentException("Cannot move more than two rows/columns.");
      }


    } else {
      // Check invalid move to a non-empty position on the board.
      throw new IllegalArgumentException("Invalid move (cannot move to a non-empty position).");
    }
  }

  /**
   * Determine and return whether the game is over or not.
   * The game is over if no more moves can be made.
   *
   * @return true if the game is over, false otherwise
   */
  @Override
  public boolean isGameOver() {
    for (int i = 0; i < this.board.length; i++) {
      for (int j = 0; j < this.board[i].length; j++) {
        // Check if there's a marble at the current position
        if (Objects.equals(this.board[i][j], "O")) {
          // Check for possible moves in all four directions
          // Ensure not to check outside the bounds of the board
          if (i > 1 && "O".equals(this.board[i - 1][j]) && "_".equals(this.board[i - 2][j]) ||
                  i < this.board.length - 2 && "O".equals(this.board[i + 1][j]) && "_".equals(this.board[i + 2][j]) ||
                  j > 1 && "O".equals(this.board[i][j - 1]) && "_".equals(this.board[i][j - 2]) ||
                  j < this.board[i].length - 2 && "O".equals(this.board[i][j + 1]) && "_".equals(this.board[i][j + 2])) {
            return false; // There is at least one valid move remaining.
          }
        }
      }
    }
    return true;
  }

  /**
   * Returns a string that represents the current state of the board. The string has one line per row
   * of the game board. Each slot on the game board is a single character (O, X, or space for a marble,
   * empty, and invalid position respectively). Slots in a row are separated by a space. Each row has
   * no space before the first slot and after the last slot.
   *
   * @return the game state as a string
   */
  @Override
  public String getGameState() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < this.board.length; i++) {
      for (int j = 0; j < this.board[i].length; j++) {
        sb.append(this.board[i][j]);
        // Append a space after each piece except the last one in a row
        if (j < this.board[i].length - 1) {
          sb.append(" ");
        }
      }
      // Append a newline after each row except the last one
      if (i < this.board.length - 1) {
        sb.append("\n");
      }
    }
    return sb.toString();
  }

  /**
   * Returns the number of marbles currently on the board.
   *
   * @return the number of marbles currently on the board
   */
  @Override
  public int getScore() {
    return this.score;
  }
}
