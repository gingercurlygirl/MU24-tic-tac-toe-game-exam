import java.util.Scanner;

public class InputHandler {

    public static String createName(){
        //name must have min 3 character
        // name must have max 3 characters
        // just english alphabet
        Scanner name = new Scanner(System.in);
        return name.next();
    }

    public static int createIndex(){
        Scanner index = new Scanner(System.in);
        return index.nextInt();
    }
}
