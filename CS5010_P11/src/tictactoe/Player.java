package tictactoe;

/**
 * Enum representing the two players in the game.
 */
public enum Player {
  X,
  O;

  /**
   * Returns the string representation of the player, X and O respectively.
   */
  public String toString(){
    return this.name();
  }
}
