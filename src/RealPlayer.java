public class RealPlayer extends Player {
    public RealPlayer(char sign) {
        super();
        setSign(sign);
        setName(buildName());
    }

    public int play(int maxIndex) {
        return askForIndex(maxIndex);
    }

    public boolean isSlotOccupied(int index, Board board) {
        if (board.isSlotOccupied(index)) {
            System.out.println("Error: this slot is taken, choose another!\n");
            return true;
        }

        return false;
    }

    public void writeInstruction(int maxIndex) {
        System.out.println(getName() + " enter a slot number to place " + getSign() + " in [1-" + maxIndex + "]:");
    }

    private int askForIndex(int maxIndex) {
        Integer answer = InputHandler.readIndex();
        while (answer == null || answer < 0 || answer > maxIndex) {
            System.out.println("Error! Try again [1-" + maxIndex + "]:");
            answer = InputHandler.readIndex();
        }

        return answer - 1;
    }

    private String buildName() {
        System.out.println("Enter name for player [" + this.getSign() + "]: ");
        String player = InputHandler.readName();
        while (player == null) {
            System.out.println("Error! Keep name between 3-15 characters long!");
            player = InputHandler.readName();
        }

        return player;
    }
}
