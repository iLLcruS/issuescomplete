import java.util.Scanner;

public class Main {
    private String choose = "";
    private static String password = "123";
    private static String enterPassword = "";
    static MainMenu mm = new MainMenu();

    public static void main(String[] args) {
        System.out.println("Hello! Its a Issue Program\n " +
                "Enter your password: ");
        Scanner in = new Scanner(System.in);
        enterPassword = in.nextLine();
        if (enterPassword.contains(password)) {
            mm.Menu();

        } else if (!enterPassword.contains(password)) {
            System.out.println("Wrong password, try again!");
        }
    }
}