public class RealPlayer extends Player {
    public RealPlayer(char sign) {
        super();
        setSign(sign);
        setName(buildName());
    }

    public int play() {
        return askForIndex();
    }

    public boolean isSlotOccupied(int index, char[] board) {
        if (Solver.isSlotOccupied(index, board)) {
            System.out.println("Error: this slot is taken, choose another!\n");
            return true;
        }

        return false;
    }

    public void writeInstruction(){
        System.out.println(getName() + " enter a slot number to place " + getSign() + " in [1-9]:");
    }

    private int askForIndex() {
        Integer answer = InputHandler.readIndex();
        while (answer == null) {
            System.out.println("Error! Try again [1-9]:");
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
