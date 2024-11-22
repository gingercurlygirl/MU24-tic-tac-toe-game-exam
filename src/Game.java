import java.util.Scanner;

public class Game {
    Board board;
    int maxIndex;
    int current = 0;
    boolean running = true;
    Player[] players;
    Solver solver = new Solver();

    public Game() {
        welcome();
        board = createBoard();
        players = createPlayers();
        maxIndex = board.rows * board.rows;
        run();
        System.out.println("Good bye!");
    }

    private Board createBoard() {
        System.out.println("Tic Tac Toe is a game played NxN field. Write how many rows you want(N), between (3-10), default is 3x3?");
        return new Board(InputHandler.readNumberOfRows());
    }

    private Player[] createPlayers() {
        System.out.println("How many players are playing (default 2)? [1-2]:");
        return Player.buildPlayers(InputHandler.readNumberOfPlayers());
    }

    private void reset() {
        board.reset();
        solver.reset();
    }

    public void welcome() {
        System.out.println("--------------------------------");
        System.out.println("Welcome to the Tic Tac Toe game!");
        System.out.println("--------------------------------\n");
    }

    public void run() {
        System.out.println("Game begins!\n");
        while (running) {
            System.out.println(board.buildBoard() + "\n");

            players[current].writeInstruction(maxIndex);
            int index = players[current].play(maxIndex);
            while (players[current].isSlotOccupied(index, board)) {
                index = players[current].play(maxIndex);
            }

            String status = solver.solve(index, players[current].getSign(), board);

            handleStatus(status);
        }
    }

    private void handleStatus(String status) {
        if (status.equals("win")) {
            win();
            restart();
            changePlayer();
        } else if (status.equals("draw")) {
            draw();
            restart();
            changePlayer();
        } else {
            changePlayer();
        }
    }

    private void changePlayer() {
        if (current == 0) current = 1;
        else current = 0;
    }

    private void draw() {
        System.out.println(board.buildBoard() + "\n");
        System.out.println("Game ended in draw!");
    }

    private void win() {
        System.out.println(board.buildBoard() + "\n");
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
