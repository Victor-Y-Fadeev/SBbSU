import static org.junit.Assert.*;
import sem3.hw3.task1.TicTacToe;
import org.junit.Test;

/** Tic-tac-toe test class. */
public class TicTacToeTest {
    /** Test of creation tic-tac-toe. */
    @Test
    public void testCreationTicTacToe() {
        TicTacToe game = new TicTacToe();
    }

    /** Test of tic-tac-toe move. */
    @Test
    public void testToMove() {
        TicTacToe game = new TicTacToe();

        assertEquals("Error with toMove() function!", "X", game.toMove(0, 0));
        assertEquals("Error with toMove() function!", "O", game.toMove(0, 1));
    }

    /** Test of incorrect tic-tac-toe move. */
    @Test
    public void testIncorrectToMove() {
        TicTacToe game = new TicTacToe();

        assertEquals("Error in toMove(), incorrect output!", "X", game.toMove(0, 0));
        assertEquals("Error with toMove(), incorrect output!", "X", game.toMove(0, 0));
    }

    /** Test win. */
    @Test
    public void testWin() {
        TicTacToe game = new TicTacToe();
        game.toMove(0, 0);
        game.toMove(0, 1);
        game.toMove(1, 1);
        game.toMove(1, 2);
        game.toMove(2, 2);

        assertEquals("Win error, incorrect output!", "", game.toMove(0, 2));
    }
}
