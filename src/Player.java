abstract public class Player {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public char getSign() {
        return sign;
    }

    public void setSign(char sign) {
        this.sign = sign;
    }

    private String name;
    private int score;
    private char sign;

    public abstract int play(int maxIndex);
    public abstract boolean isSlotOccupied(int index, Board board);
    public abstract void writeInstruction(int maxIndex);

    public static Player[] buildPlayers(int numberOfPlayers) {
        if (numberOfPlayers == 1) {
            return new Player[]{new RealPlayer('X'), new ComputerPlayer('O')};
        } else {
            return new Player[]{new RealPlayer('X'), new RealPlayer('O')};
        }
    }
}
