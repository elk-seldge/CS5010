import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Sets up the game before each test case.
 */
public class MarbleSolitaireModelImplTest {

  private MarbleSolitaireModelImpl game;

  @Before
  public void setUp() {
    this.game = new MarbleSolitaireModelImpl();
  }

  /**
   * Test the initial score of the game.
   * The initial score should be 32.
   */
  @Test
  public void testInitialScore() {
    assertEquals("Initial score should be 32", 32, game.getScore());
  }

  /**
   * This method tests the initial game state of the {@link MarbleSolitaireModelImpl}.
   * The expected layout of the game state is:
   *   X X O O O X X
   *   X X O O O X X
   *   O O O O O O O
   *   O O O _ O O O
   *   O O O O O O O
   *   X X O O O X X
   *   X X O O O X X
   *
   * The method asserts that the initial game state matches the expected layout.
   */
  @Test
  public void testInitialGameState() {
    String expected =
            "X X O O O X X\n" +
                    "X X O O O X X\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "X X O O O X X\n" +
                    "X X O O O X X";
    assertEquals("Initial game state should match expected layout", expected, game.getGameState());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove() {
    // Attempt an invalid move (out of bounds)
    this.game.move(0, 0, 0, 3);
  }

  /**
   * Tests the validity of a move in the Marble Solitaire game.
   *
   * @throws IllegalArgumentException if the move is invalid
   */
  @Test
  public void testValidMove() {
    this.game.move(3, 1, 3, 3);
    System.out.println(this.game.getGameState());
    String expectedAfterMove =
                    "X X O O O X X\n" +
                    "X X O O O X X\n" +
                    "O O O O O O O\n" +
                    "O _ _ O O O O\n" +
                    "O O O O O O O\n" +
                    "X X O O O X X\n" +
                    "X X O O O X X";
    assertEquals("Game state should match expected layout after valid move", expectedAfterMove, game.getGameState());
    assertEquals("Score should decrease by one after a valid move", 31, game.getScore());
  }

  /**
   * Checks if the game is over.
   * The game is over if there are no possible valid moves left on the board.
   * return true if the game is over, false otherwise
   */
  @Test
  public void testIsGameOver() {
    assertFalse(this.game.isGameOver());
    this.game.move(3, 1, 3, 3);
    System.out.println("\n");
    System.out.println(this.game.getGameState());

    this.game.move(1, 2, 3, 2);
    System.out.println("\n");
    System.out.println(this.game.getGameState());

    this.game.move(3, 3, 3, 1);
    System.out.println("\n");
    System.out.println(this.game.getGameState());

    this.game.move(3, 0, 3, 2);
    System.out.println("\n");
    System.out.println(this.game.getGameState());

    this.game.move(2, 0, 2, 2);
    System.out.println("\n");
    System.out.println(this.game.getGameState());

    this.game.move(3, 2, 1, 2);
    System.out.println("\n");
    System.out.println(this.game.getGameState());

    this.game.move(0, 2, 2, 2);
    System.out.println("\n");
    System.out.println(this.game.getGameState());

    this.game.move(0, 4, 0, 2);
    System.out.println("\n");
    System.out.println(this.game.getGameState());

    this.game.move(1, 4, 1, 2);
    System.out.println("\n");
    System.out.println(this.game.getGameState());

    this.game.move(2, 3, 2, 1);
    System.out.println("\n");
    System.out.println(this.game.getGameState());

    this.game.move(0, 2, 2, 2);
    System.out.println("\n");
    System.out.println(this.game.getGameState());

    this.game.move(5, 2, 3, 2);
    System.out.println("\n");
    System.out.println(this.game.getGameState());

    this.game.move(4, 0, 4, 2);
    System.out.println("\n");
    System.out.println(this.game.getGameState());

    this.game.move(2, 1, 2, 3);
    System.out.println("\n");
    System.out.println(this.game.getGameState());

    this.game.move(3, 2, 5, 2);
    System.out.println("\n");
    System.out.println(this.game.getGameState());

    this.game.move(2, 4, 2, 2);
    System.out.println("\n");
    System.out.println(this.game.getGameState());

    this.game.move(3, 5, 3, 3);
    System.out.println("\n");
    System.out.println(this.game.getGameState());

    this.game.move(4, 3, 2, 3);
    System.out.println("\n");
    System.out.println(this.game.getGameState());

    this.game.move(6, 2, 4, 2);
    System.out.println("\n");
    System.out.println(this.game.getGameState());

    this.game.move(2, 6, 2, 4);
    System.out.println("\n");
    System.out.println(this.game.getGameState());

    this.game.move(2, 3, 2, 5);
    System.out.println("\n");
    System.out.println(this.game.getGameState());

    this.game.move(4, 6, 2, 6);
    System.out.println("\n");
    System.out.println(this.game.getGameState());

    this.game.move(2, 6, 2, 4);
    System.out.println("\n");
    System.out.println(this.game.getGameState());

    this.game.move(5, 4, 5, 2);
    System.out.println("\n");
    System.out.println(this.game.getGameState());

    this.game.move(6, 4, 6, 2);
    System.out.println("\n");
    System.out.println(this.game.getGameState());

    this.game.move(4, 5, 4, 3);
    System.out.println("\n");
    System.out.println(this.game.getGameState());

    this.game.move(4, 2, 4, 4);
    System.out.println("\n");
    System.out.println(this.game.getGameState());

    this.game.move(6, 2, 4, 2);
    System.out.println("\n");
    System.out.println(this.game.getGameState());

    assertTrue(this.game.isGameOver());
  }
}
