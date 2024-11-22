import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class InputHandler {

    private static final Scanner scanner = new Scanner(System.in);

    public static int readNumberOfPlayers() {
        String answer = scanner.nextLine();
        if (answer.equals("1")) {
            System.out.println("Player vs Computer!\n");
            return 1;
        } else if (answer.equals("2")) {
            System.out.println("Player vs Player!\n");
            return 2;
        } else {
            System.out.println("Invalid input! Playing default game Player vs Player!\n");
            return 2;
        }
    }

    public static String readName() {
        String answer = scanner.nextLine();
        if (answer.length() < 3 || answer.length() > 15) {
            return null;
        }
        return answer;
    }

    public static Integer readIndex() {
        String answer = scanner.next();
        try {
            return Integer.parseInt(answer);
        } catch (NumberFormatException _) {
            return null;
        }
    }

    public static int readNumberOfRows() {
        String answer = scanner.nextLine();
        if (answer.equals("3")) {
            return 3;
        } else if (answer.equals("4")) {
            return 4;
        } else if (answer.equals("5")) {
            return 5;
        } else if (answer.equals("6")) {
            return 6;
        } else if (answer.equals("7")) {
            return 7;
        } else if (answer.equals("8")) {
            return 8;
        } else if (answer.equals("9")) {
            return 9;
        } else if (answer.equals("10")) {
            return 10;
        } else {
            System.out.println("Invalid input! Playing default game 3x3!");
            return 3;
        }
    }
}
