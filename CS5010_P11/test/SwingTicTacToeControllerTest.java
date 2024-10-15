import org.junit.jupiter.api.Test;

import tictactoe.Player;
import tictactoe.SwingTicTacToeController;
import tictactoe.SwingTicTacToeView;
import tictactoe.TicTacToe;
import tictactoe.TicTacToeView;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

// Test class for SwingTicTacToeController. This class tests the functionality of the different
// methods in the SwingTicTacToeController class, ensuring that they handle the Tic Tac Toe game
// processes correctly as intended.
public class SwingTicTacToeControllerTest {

    // Test the correct control of a move in the game by the SwingTicTacToeController.
    @Test
    void testMove() {
        TicTacToe modelMock = mock(TicTacToe.class);
        SwingTicTacToeView viewMock = mock(SwingTicTacToeView.class);

        int row = 1;
        int col = 2;
        Player turn = Player.O;

        when(modelMock.getTurn()).thenReturn(turn);

        SwingTicTacToeController controller = new SwingTicTacToeController(viewMock);
        controller.playGame(modelMock);

        controller.move(row, col);

        verify(modelMock, times(2)).getTurn();
        verify(modelMock, times(1)).move(row, col);
        verify(viewMock, times(1)).setButtonText(row * 3 + col, turn.toString());
        verify(viewMock, times(1)).disableButton(row, col);

        verify(modelMock, times(1)).isGameOver();
        verify(viewMock, times(1)).setTurnLabel(modelMock.getTurn());
    }

    // Test the reset game function to ensure that it resets the game model as expected.
    @Test
    void testResetGame() {
        TicTacToe modelMock = mock(TicTacToe.class);
        SwingTicTacToeView viewMock = mock(SwingTicTacToeView.class);

        SwingTicTacToeController controller = new SwingTicTacToeController(viewMock);
        controller.playGame(modelMock);

        controller.resetGame();

        assertNotNull(controller.model);
    }

    // Test the TicTacToeController construction to ensure that it throws an exception if the view
    // passed as its argument is not of the type SwingTicTacToeView.
    @Test
    void testConstruction() {
        TicTacToeView ticTacToeView = mock(TicTacToeView.class);

        assertThrows(IllegalArgumentException.class, () -> {
            new SwingTicTacToeController(ticTacToeView);
        });
    }
}