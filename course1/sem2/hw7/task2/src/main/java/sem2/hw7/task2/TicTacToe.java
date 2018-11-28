package sem2.hw7.task2;

/** Tic-tac-toe logic. */
public class TicTacToe {
    private boolean isMoveX;
    private boolean isWin;
    private int[][] matrix;

    /** Create game. */
    public TicTacToe() {
        isMoveX = true;
        isWin = false;

        matrix = new int[3][3];
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                matrix[i][j] = -1;
            }
        }
    }

    /** Make a game move. */
    public String toMove(int row, int column) {
        if (isWin || (matrix[row][column] != -1)) {
            return getText(matrix[row][column]);
        }

        matrix[row][column] = isMoveX ? 1 : 0;
        isMoveX = !isMoveX;

        checkWin();
        return getText(isMoveX ? 0 : 1);
    }

    private String getText(int position) {
        switch (position){
            case 0:
                return "O";
            case 1:
                return "X";
        }

        return "";
    }

    private void checkWin() {
        if (matrix[1][1] != -1) {
            boolean firstDiagonal = true;
            boolean secondDiagonal = true;

            for (int i = 0; i < 2; i++) {
                if (matrix[i][i] != matrix[i + 1][i + 1]) {
                    firstDiagonal = false;
                }

                if (matrix[2 - i][i] != matrix[1 - i][i + 1]) {
                    secondDiagonal = false;
                }
            }

            if (firstDiagonal || secondDiagonal) {
                isWin = true;
                return;
            }
        }

        for (int i = 0; i < 3; i++){
            if ((matrix[0][i] == matrix[1][i]) && (matrix[1][i] == matrix[2][i]) && (matrix[0][i] != -1)) {
                isWin = true;
                return;
            }

            if ((matrix[i][0] == matrix[i][1]) && (matrix[i][1] == matrix[i][2]) && (matrix[i][0] != -1)) {
                isWin = true;
                return;
            }
        }
    }
}