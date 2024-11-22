import java.util.Random;

public class ComputerPlayer extends Player {
    public ComputerPlayer(char sign) {
        super();
        setSign(sign);
        setName("Computer");
    }

    public int play(int maxIndex) {
        Random rng = new Random();
        return rng.nextInt(0, maxIndex);
    }

    public boolean isSlotOccupied(int index, Board board) {
        return board.isSlotOccupied(index);
    }

    public void writeInstruction(int maxIndex){
        System.out.println("Computer's turn to place " + getSign() + ":");
    }
}
