public class Board {
    int rows;
    char[] data;

    public Board(int rows) {
        this.rows = rows;
        data = new char[rows * rows];
        reset();
    }

    public void reset() {
        for (int i = 0; i < rows * rows; i++) {
            data[i] = ' ';
        }
    }

    public boolean isSlotOccupied(int slot) {
        return data[slot] != ' ';
    }

    public String buildBoard() {
        StringBuilder boardString = new StringBuilder();

        for (int i = 0; i < rows; i++) {
            boardString.append(buildRow(i));
            if (i != rows - 1) {
                boardString.append(buildBoundary());
            }
        }

        boardString.deleteCharAt(boardString.length() - 1);

        return boardString.toString();
    }

    private String buildRow(int row) {
        StringBuilder rowString = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            if (i == 0) {
                rowString.append(" ").append(data[i + rows * row]).append(" | ");
            } else if (i == rows - 1) {
                rowString.append(data[i + rows * row]).append("\n");
            } else {
                rowString.append(data[i + rows * row]).append(" | ");
            }
        }

        return rowString.toString();
    }

    private String buildBoundary() {
        StringBuilder boundary = new StringBuilder();
        boundary.append("---+".repeat(rows));
        boundary.deleteCharAt(boundary.length() - 1);
        boundary.append("\n");

        return boundary.toString();
    }
}
