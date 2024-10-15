//Knight
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
public class Knight implements ChessPiece{
  private int row;
  private int col;

  private Color color;

  /**
   * Knight constructor, place knight on the board
   * @param row int value stands for the row knight at
   * @param col int value stands for the column knight at
   * @param color Enum Color value stands for the color of knight
   * @throws IllegalArgumentException throw IllegalArgumentException("Illegal position"), when
   * try to place knight outside the board
   */
  public Knight(int row, int col, Color color) throws IllegalArgumentException {
    if ((row < 0) || (col < 0) || (row >= 8) || (col >= 8)) { // add a check for placing chess
      // outside the board
      throw new IllegalArgumentException("Illegal position");
    }
    this.row = row;
    this.col = col;
    this.color = color;
  }

  /**
   * Check if knight can move to given int row and int col
   * @param row the row to which this chess piece can be moved
   * @param col the col to which this chess piece can be moved
   * @return ture if knight can move to the given row and col; else, false
   */
  @Override
  public boolean canMove(int row, int col) {
    if ((row < 0) || (col < 0) || (row >= 8) || (col >= 8)) {
      return false;
    }
    return ((this.row+2 == row && this.col + 1 == col) || (this.row+2 == row && this.col - 1 == col) || (this.row-2 == row && this.col + 1 == col) ||
            (this.row-2 == row && this.col - 1 == col) || (this.row+1 == row && this.col + 2 == col) || (this.row-1 == row && this.col + 2 == col) ||
            (this.row+1 == row && this.col - 2 == col) || (this.row-1 == row && this.col - 2 == col));
  }

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
