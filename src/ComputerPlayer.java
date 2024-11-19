import java.util.Random;

public class ComputerPlayer extends Player {
    public ComputerPlayer(char sign) {
        super();
        setSign(sign);
        setName("Computer");
    }

    public int play() {
        Random rng = new Random();
        return rng.nextInt(0, 9);
    }

    public boolean isSlotOccupied(int index, char[] board) {
        return Solver.isSlotOccupied(index, board);
    }

    public void writeInstruction(){
        System.out.println("Computer's turn to place " + getSign() + ":");
    }
}
