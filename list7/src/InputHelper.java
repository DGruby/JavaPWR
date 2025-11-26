import java.util.Scanner;

public class InputHelper {
    // A helper class for handling numeric input from the user
    public static int readInt(String prompt) {
        System.out.print(prompt);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
    public static double readDouble(String prompt) {
        System.out.print(prompt);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextDouble();
    }
    public static String readString(String prompt) {
        System.out.print(prompt);
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
}
