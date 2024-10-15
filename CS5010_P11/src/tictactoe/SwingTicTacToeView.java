package tictactoe;

import javax.swing.*;

/**
 * A Swing-based TicTacToe view.
 * The view is responsible for displaying the game state and handling user input.
 * The view is also responsible for displaying the game over a message.
 * The view is also responsible for displaying the current player's turn.
 */
public class SwingTicTacToeView implements TicTacToeView{
  JFrame frame;
  JButton[] buttons;
  JLabel turnLabel;

  /**
   * Constructs a SwingTicTacToeView object.
   *
   * @param title the title of the window
   */
  public SwingTicTacToeView(String title) {
    this.frame = new JFrame(title);
    this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.frame.setSize(1000, 1000);
    this.buttons = new JButton[10];
  }

  /**
   * Sets the text of a button.
   *
   * @param i the index of the button
   * @param text the text to set
   */
  public void setButtonText(int i, String text) {
    this.buttons[i].setText(text);
  }

  /**
   * Resets the text of all buttons and enables them.
   */
  public void resetButtons() {
    for (int i = 0; i < 9; i++) {
      this.setButtonText(i, "");
      this.buttons[i].setEnabled(true);
    }
  }

  /**
   * Sets the button listener for the buttons.
   *
   * @param c the controller
   */
  public void setButtonListener(SwingTicTacToeController c) {
    for (int i = 0; i < 9; i++) {
      int row = i / 3;
      int col = i % 3;
      this.buttons[i].addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent e) {
          c.move(row, col);
        }
      });
    }

    this.buttons[9].addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent e) {
        resetButtons();
        c.resetGame();
      }
    });
  }

  /**
   * Disables a button.
   *
   * @param row the row of the button
   * @param col the column of the button
   */
  public void disableButton(int row, int col) {
    this.buttons[row * 3 + col].setEnabled(false);
  }

  public void displayGameOverMessage(Player winner) {
    if(winner == null)
      JOptionPane.showMessageDialog(this.frame, "Game Over, It's a draw!");
    else {
      JOptionPane.showMessageDialog(this.frame, "Game Over, " + winner + " wins!");
    }
  }

  /**
   * Sets the text of the turn label.
   *
   * @param player the current player
   */
  public void setTurnLabel(Player player) {
    this.turnLabel.setText("Turn: " + player);
  }

  /**
   * Starts the game.
   */
  public void start() {
    JPanel panel = new JPanel();

    this.frame.add(panel);
    panel.setLayout(new java.awt.GridLayout(3, 3));

    // Add 9 buttons to the panel
    for (int i = 0; i < 9; i++) {
      JButton button = new JButton();
      panel.add(button);
      this.buttons[i] = button;
    }
    resetButtons();

    // Add the reset button
    JButton resetButton = new JButton("Reset");
    this.frame.add(resetButton, java.awt.BorderLayout.SOUTH);
    this.buttons[9] = resetButton;

    // Display the ture message
    this.turnLabel = new JLabel("Turn: X");
    this.frame.add(turnLabel, java.awt.BorderLayout.NORTH);

    this.frame.pack();
    this.frame.setVisible(true);
  }
}
