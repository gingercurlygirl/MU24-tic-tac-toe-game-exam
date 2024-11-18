import java.util.Scanner;

public class InputHandler {

    public static String createName() {
        Scanner name = new Scanner(System.in);
        String answer = name.nextLine();
        if (answer.length() < 3 || answer.length() > 15) {
            return null;
        }
        return answer;
    }

    public static Integer createIndex() {
        Scanner index = new Scanner(System.in);
        String answer = index.next();
        if (answer.equals("1")) {
            return 1;
        } else if (answer.equals("2")) {
            return 2;
        } else if (answer.equals("3")) {
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
        } else {
            return null;
        }
    }
}
