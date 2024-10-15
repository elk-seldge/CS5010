package tictactoe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.swing.*;

public class SwingTicTacToeViewTest {

    private SwingTicTacToeView view;
    private SwingTicTacToeController controller;
    private TicTacToe m;

    /*
    * Any try of modifying the JButton or JLabel from outside the class will fail, for the
    * JButton or JLabel objects being seen outside the class are only reference.
    * Try to modify a null object will throw error.
    * However, this situation proves the success of data protection.
    * No users can access game data invalidly.
    * So, to compose a test for SwingTicTacToeView seems impossible.
    * */


    /**
     * Sets up the test fixture.
     * This method is called before every test case method.
     */
    @Before
    public void setUp() {
        m = new TicTacToeModel();
        view = new SwingTicTacToeView("test");
        controller = Mockito.mock(SwingTicTacToeController.class);
    }

    /**
     * Tests setting a button's text.
     */
    @Test
    public void testSetButtonText() {
        // Set the text of the first button,
        // However,
        // if we do not modify the setButtonText, any try to modify the button text from
        // outside the class will fail, for the JButton it passed is just a copy.
        this.controller.playGame(m);
        this.view.setButtonText(0, "X");
        JButton button = this.view.buttons[0];
        
        // Check the text of the button
        Assert.assertEquals("X", button.getText());
    }

    /**
     * Tests resetting all buttons.
     */
    @Test
    public void testResetButtons() {
        // Set the text of the first button
        view.setButtonText(0, "X");
        
        // Check that the button's text was set
        Assert.assertEquals("X", view.buttons[0].getText());
        
        // Reset the buttons
        view.resetButtons();
        
        // Check the button's text has been reset
        Assert.assertEquals("", view.buttons[0].getText());
    }

    /**
     * Tests setting the turn label.
     */
    @Test
    public void testSetTurnLabel() {
        Player player = Player.X;
        view.setTurnLabel(player);
        
        // Check the turn label's text
        Assert.assertEquals("Turn: X", view.turnLabel.getText());
    }
}