package spbu.hw7.task2;

/** Tic-tac-toe logic. */
public class TicTacToe {
    private boolean isMoveX;

    /** Create game. */
    public TicTacToe() {
        isMoveX = true;
    }

    /** To move the game. */
    public String toMove(int row, int column) {
        isMoveX = !isMoveX;

        if (!isMoveX) {
            return "X";
        }else{
            return "O";
        }
    }
}