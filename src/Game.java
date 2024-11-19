import java.util.Scanner;

public class Game {
    char[] board = new char[]{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
    int current = 0;
    boolean running = true;
    Player[] players;


    public Game() {
        welcome();
        players = createPlayers();
        run();
        System.out.println("Good bye!");
    }

    private Player[] createPlayers() {
        System.out.println("How many players are playing (default 2)? [1-2]:");
        return Player.buildPlayers(InputHandler.readNumberOfPlayers());
    }

    private void reset() {
        board = new char[]{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
    }

    public void welcome() {
        System.out.println("Welcome to the Tic Tac Toe game!\n");
    }

    public void run() {
        System.out.println("Game begins!\n");
        while (running) {
            System.out.println(Board.buildBoard(board) + "\n");

            players[current].writeInstruction();
            int index = players[current].play();
            while (players[current].isSlotOccupied(index, board)) {
                index = players[current].play();
            }

            int status = Solver.solve(index, players[current].getSign(), board);

            handleStatus(status);
        }
    }

    private void handleStatus(int status) {
        if (status == 0) {
            changePlayer();
        } else if (status == 1) {
            win();
            restart();
            changePlayer();
        } else if (status == 3) {
            draw();
            restart();
            changePlayer();
        }
    }

    private void changePlayer() {
        if (current == 0) current = 1;
        else current = 0;
    }

    private void draw() {
        System.out.println(Board.buildBoard(board) + "\n");
        System.out.println("Game ended in draw!");
    }

    private void win() {
        System.out.println(Board.buildBoard(board) + "\n");
        System.out.println("Winner is " + players[current].getName() + " using " + players[current].getSign() + " as sign!");
        players[current].setScore(players[current].getScore() + 1);
    }

    private void scoreBoard() {
        System.out.println("Scoreboard:\n " + players[0].getName() + " : " + players[0].getScore() + "\n " + players[1].getName() + " : " + players[1].getScore());

    }

    private void restart() {
        scoreBoard();
        if (quit()) {
            running = false;
        } else {
            reset();
        }
    }

    private boolean quit() {
        System.out.println("Do you want to play again? [y/n]:");
        Scanner answer_quit = new Scanner(System.in);
        return answer_quit.nextLine().equals("n");
    }
}
