package tictactoe;

/**
 * Controller for a TicTacToe game.
 * Handles user moves by executing them using the model and conveys move outcomes to the user in some form.
 */
public class SwingTicTacToeController implements TicTacToeController {
  public SwingTicTacToeView view;
  public TicTacToe model;

  /**
   * Constructs a SwingTicTacToeController object.
   *
   * @param v the Tic Tac Toe view
   * @throws IllegalArgumentException if the view is not a SwingTicTacToeView
   */
  public SwingTicTacToeController(TicTacToeView v) throws IllegalArgumentException {
    if (v.getClass() != SwingTicTacToeView.class) {
      throw new IllegalArgumentException("Expected SwingTicTacToeView");
    }
    view = (SwingTicTacToeView) v;
  }

  /**
   * Plays a game of Tic Tac Toe.
   *
   * @param m the Tic Tac Toe model
   */
  public void playGame(TicTacToe m) {
    model = m;
    view.start();
    view.setButtonListener(this);
  }

  /**
   * Handles a move in the game.
   *
   * @param row the row of the move
   * @param col the column of the move
   */
  public void move(int row, int col) {
    Player turn = model.getTurn();
    model.move(row, col);
    view.setButtonText(row * 3 + col, turn.toString());
    view.disableButton(row, col);

    if (model.isGameOver()) {
      view.displayGameOverMessage(model.getWinner());
    }
    view.setTurnLabel(model.getTurn());
  }

  /**
   * Resets the game.
   */
  public void resetGame() {
    model = new TicTacToeModel();
  }
}
