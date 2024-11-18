public class Game {
    String[] players;
    char[] board;
    char[] signs;
    int current;


    public Game() {
        board = new char[]{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        signs = new char[]{'X', 'O'};
        current = 0;
        welcome();
        playerNames();
        run();
    }

    public void welcome() {
        System.out.println("Welcome to the Tic Tac Toe game!\n");
    }

    public void run() {
        boolean try_again = false;
        System.out.println("game begins!\n");
        while (true) {
            System.out.println(Board.buildBoard(board) + "\n");

            int index = askForIndex();
            int status = Solver.solve(index, signs[current], board);

            if (status == 0) {
                try_again = false;
            } else if (status == 1) {
                win();
                break;
            } else if (status == 2) {
                System.out.println("Error: this slot is taken, choose another!\n");
                try_again = true;
            }


            if (!try_again) {
                if (current == 0) current = 1;
                else current = 0;
            }
        }
    }

    private void win() {
        System.out.println(Board.buildBoard(board) + "\n");
        System.out.println("Winner is " + players[current] + " using " + signs[current] + " as sign!");
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

    private void playerNames() {
        System.out.println("Enter name for first player [X]: ");
        String player1 = InputHandler.createName();
        System.out.println("Enter name for second player [O]: ");
        String player2 = InputHandler.createName();
        players = new String[]{player1, player2};
    }
}
