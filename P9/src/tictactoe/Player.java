package tictactoe;

/**
 * Represents a player in a Tic Tac Toe game.
 */
public enum Player {
  X {
    @Override
    public String toString() {
      return "X";
    }
  },
  O {
    @Override
    public String toString() {
      return "O";
    }
  }
}
