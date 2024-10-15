// Queen
/*
FIELDS
 ..this.row: int
 ..this.col: int
 ..this.color: Color
 METHODS
 ..this.canMove(int row, int col): boolean
 ..this.getRow(): int
 ..this.getColumn(): int
 ..this.getColor(): Color
 ..this.canKill(ChessPiece piece): boolean
 */
public class Queen implements ChessPiece {

  private int row;
  private int col;

  private Color color;

  /**
   * Queen constructor, place queen on the board
   * @param row int value stands for the row queen at
   * @param col int value stands for the column queen at
   * @param color Enum Color value stands for the color of queen
   * @throws IllegalArgumentException throw IllegalArgumentException("Illegal position"), when 
   * try to place queen outside the board
   */
  public Queen(int row, int col, Color color) throws IllegalArgumentException {
    if ((row < 0) || (col < 0) || (row >= 8) || (col >= 8)) { // add a check for placing chess
      // outside the board
      throw new IllegalArgumentException("Illegal position");
    }
    this.row = row;
    this.col = col;
    this.color = color;
  }

  /**
   * Check if queen can move to given int row and int col
   * @param row the row to which this chess piece can be moved
   * @param col the col to which this chess piece can be moved
   * @return ture if queen can move to the given row and col; else, false
   */
  @Override
  public boolean canMove(int row, int col) {
    if ((row < 0) || (col < 0) || (row >= 8) || (col >= 8)) {
      return false;
    }
    return ((this.row == row) || (this.col == col)
            || (Math.abs(this.row - row) == Math.abs(this.col - col)));
  }

  /*
  Except changing them from return row/col/color to this.row/col/color
  I didn't change the below part because:
  1. They act properly
  2. THe chess game need to know the column, row, and color, unless we will let the chessboard
  class to do this job.
   */
  /**
   * get row of this chess piece
   * @return int value stands for the row of this chess piece
   */
  @Override
  public int getRow() {
    return this.row;
  }

  /**
   * get column of this chess piece
   * @return int value stands for the column of this chess piece
   */
  @Override
  public int getColumn() {
    return this.col;
  }

  /**
   * get color of this chess piece
   * @return Enum Color value stands for the color of this chess piece
   */
  @Override
  public Color getColor() {
    return this.color;
  }

  /**
   * check to see if this chess piece can kill the given chess piece or not
   * @param piece the piece that may or may not be killed by this piece
   * @return ture for this chess can kill the given chess piece; else, false
   */
  @Override
  public boolean canKill(ChessPiece piece) {
    return (this.getColor() != piece.getColor()) && canMove(
            piece.getRow(),
            piece.getColumn());
  }
}
