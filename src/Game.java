import java.util.Scanner;

public class Game {
    String[] players;
    char[] board = new char[]{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
    char[] signs = new char[]{'X', 'O'};
    int current = 0;
    int[] playerScore = new int[]{0, 0};
    boolean running = true;


    public Game() {
        welcome();
        players = constructPlayerNames();
        run();
    }

    private void reset() {
        board = new char[]{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        signs = new char[]{'X', 'O'};
        current = 0;
    }

    public void welcome() {
        System.out.println("Welcome to the Tic Tac Toe game!\n");
    }

    public void run() {
        System.out.println("game begins!\n");
        while (running) {
            System.out.println(Board.buildBoard(board) + "\n");

            int index = askForIndex();
            int status = Solver.solve(index, signs[current], board);

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
        } else if (status == 2) {
            System.out.println("Error: this slot is taken, choose another!\n");
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
        System.out.println("Winner is " + players[current] + " using " + signs[current] + " as sign!");
        playerScore[current]++;
    }

    private void scoreBoard() {
        System.out.println("Scoreboard:\n " + players[0] + " : " + playerScore[0] + "\n " + players[1] + " : " + playerScore[1]);

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

    private int askForIndex() {
        System.out.println(players[current] + " enter a slot number to place " + signs[current] + " in [1-9]:");
        Integer answer = InputHandler.createIndex();
        while (answer == null) {
            System.out.println("Error! Try again [1-9]:");
            answer = InputHandler.createIndex();
        }

        return answer - 1;
    }

    private String[] constructPlayerNames() {
        System.out.println("Enter name for first player [X]: ");
        String player1 = buildName();

        System.out.println("Enter name for second player [O]: ");
        String player2 = buildName();
        return new String[]{player1, player2};
    }

    private String buildName() {
        String player = InputHandler.createName();
        while (player == null) {
            System.out.println("Error! Keep name between 3-15 characters long!");
            player = InputHandler.createName();
        }
        return player;
    }
}
