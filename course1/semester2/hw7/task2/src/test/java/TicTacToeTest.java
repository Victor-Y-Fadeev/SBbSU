import static org.junit.Assert.*;
import spbu.hw7.task2.TicTacToe;
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

        assertEquals("Error with toMove() function!", "X", game.toMove(""));
        assertEquals("Error with toMove() function!", "O", game.toMove(""));
    }

    /** Test of incorrect tic-tac-toe move. */
    @Test
    public void testIncorrectToMove() {
        TicTacToe game = new TicTacToe();

        assertEquals("Error in toMove(), incorrect output!", "X", game.toMove("X"));
        assertEquals("Error with toMove(), incorrect output!", "X", game.toMove("X"));
    }
}
