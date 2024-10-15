package tictactoe;

public interface TicTacToeView {
    /**
     * Sets the text of a button.
     *
     * @param i the index of the button
     * @param text the text to set
     */
    void setButtonText(int i, String text);

    /**
     * Resets the text of all buttons and enables them.
     */
    void resetButtons();

    /**
     * Sets the button listener for the buttons.
     *
     * @param c the controller
     */
    void setButtonListener(SwingTicTacToeController c);

    /**
     * Disables a button.
     *
     * @param row the row of the button
     * @param col the column of the button
     */
    void disableButton(int row, int col);

    /**
     * Sets the turn label to the current player.
     *
     * @param player the current player
     */
    void setTurnLabel(Player player);

    /**
     * Starts the game.
     */
    void start();

}
