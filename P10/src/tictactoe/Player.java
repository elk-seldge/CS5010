package tictactoe;

/**
 * The Player enum represents the two players in a Tic Tac Toe game, X and O.
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
  };
}
