public class Game {
    String[] players;
    char[] board;
    char[] signs;
    int current;


    public Game() {
        board = new char[]{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        signs = new char[]{'X', 'O'};
        current = 0;
        playerNames();
        run();
    }

    public void run() {
        boolean try_again = false;
        System.out.println("game begins!");
        while (true) {
            Board.printBoard(board);
            int index = askForIndex();
            int status = Solver.solve(index, signs[current], board);

            if (status == 0) {
                try_again = false;
            } else if (status == 1) {
                win();
                break;
            } else if (status == 2) {
                System.out.println("problem, try again");
                try_again = true;
            }


            if (!try_again) {
                if (current == 0) current = 1;
                else current = 0;
            }
        }
    }

    private void win() {
        Board.printBoard(board);
        System.out.println("Winner is " + players[current] + " using " + signs[current] + " as sign!");
    }

    private int askForIndex() {
        System.out.println(players[current] + " enter a slot number to place " + signs[current] + " in [1-9]:");
        return InputHandler.createIndex() - 1;
    }

    private void playerNames() {
        System.out.println("Enter name for player1 [X]: ");
        String player1 = InputHandler.createName();
        System.out.println("Enter name for player2 [O]: ");
        String player2 = InputHandler.createName();
        players = new String[]{player1, player2};
    }
}
