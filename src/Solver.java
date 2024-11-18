public class Solver {
    public static int solve(int index, char sign, char[] board) {
        if (board[index] != ' ') return 2;


        board[index] = sign;


        boolean winInAnyRow = checkRow(0, board) || checkRow(1, board) || checkRow(2, board);
        boolean winInAnyCol = checkColumn(0, board) || checkColumn(1, board) || checkColumn(2, board);
        boolean winInAnyDia = checkDiagonals(board);

        if (winInAnyRow || winInAnyCol || winInAnyDia) {
            return 1;
        }

        if (draw(board)) {
            return 3;
        }

        return 0;

    }

    private static boolean draw(char[] board) {
        return board[0] != ' ' && board[1] != ' ' && board[2] != ' ' &&
                board[3] != ' ' && board[4] != ' ' && board[5] != ' ' &&
                board[6] != ' ' && board[7] != ' ' && board[8] != ' ';
    }

    private static boolean checkRow(int row, char[] board) {
        return board[row * 3] != ' ' && board[row * 3] == board[row * 3 + 1] && board[row * 3] == board[row * 3 + 2];
    }


    private static boolean checkColumn(int column, char[] board) {
        return board[column] != ' ' && board[column] == board[column + 3] && board[column] == board[column + 6];
    }

    private static boolean checkDiagonals(char[] board) {
        boolean firstDiagonal = board[0] != ' ' && board[0] == board[4] && board[0] == board[8];
        boolean secondDiagonal = board[2] != ' ' && board[2] == board[4] && board[2] == board[6];

        return firstDiagonal || secondDiagonal;
    }

}
