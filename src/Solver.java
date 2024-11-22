public class Solver {
    int numberOfPopulatedSlots;

    public String solve(int index, char sign, Board board) {
        char[] data = board.data;
        int rows = board.rows;

        data[index] = sign;

        boolean winInAnyRowOrColumn = checkWinInRowsAndColumns(rows, data);
        boolean winInAnyDia = checkFirstDiagonal(rows, data) || checkSecondDiagonal(rows, data);

        if (winInAnyRowOrColumn || winInAnyDia) {
            return "win";
        }

        this.numberOfPopulatedSlots++;
        if (this.numberOfPopulatedSlots == rows * rows) {
            return "draw";
        }

        return "continue";

    }

    public void reset() {
        this.numberOfPopulatedSlots = 0;
    }

    private static boolean checkWinInRowsAndColumns(int rows, char[] board) {
        for (int i = 0; i < rows; i++) {
            if (checkRow(i, rows, board) || checkColumn(i, rows, board)) {
                return true;
            }
        }

        return false;
    }

    private static boolean checkRow(int n, int rows, char[] board) {
        for (int i = 0; i < rows - 1; i++) {
            // character N and N+1 must be equal, and also character N must not be ' '
            boolean same = board[n * rows + i] == board[n * rows + i + 1] && board[n * rows + i] != ' ';
            if (!same) {
                return false;
            }
        }

        return true;
    }

    private static boolean checkColumn(int n, int rows, char[] board) {
        for (int i = 0; i < rows - 1; i++) {
            // character N and N+1 must be equal, and also character N must not be ' '
            boolean same = board[i * rows + n] == board[(i + 1) * rows + n] && board[i * rows + n] != ' ';
            if (!same) {
                return false;
            }
        }

        return true;
    }

    private static boolean checkFirstDiagonal(int rows, char[] board) {
        for (int i = 0; i < rows - 1; i++) {
            // character N and N+1 on diagonal must be equal, and also character N must not be ' '
            boolean same = board[i * (rows + 1)] == board[(i + 1) * (rows + 1)] && board[i * (rows + 1)] != ' ';
            if (!same) {
                return false;
            }
        }

        return true;
    }

    private static boolean checkSecondDiagonal(int rows, char[] board) {
        for (int i = 0; i < rows - 1; i++) {
            // character N and N+1 on diagonal must be equal, and also character N must not be ' '
            boolean same = board[(i + 1) * (rows - 1)] == board[(i + 2) * (rows - 1)] && board[(i + 1) * (rows - 1)] != ' ';
            if (!same) {
                return false;
            }
        }

        return true;
    }

}
