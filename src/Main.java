import DataPackage.VariableChooses;

import java.util.Scanner;

public class Main extends VariableChooses {

    private String choose = "";
    private static String password = "123";
    private static String enterPassword = "";

    public static void main(String[] args) {
        System.out.println("Hello! Its a Issue Program\n " +
                "Enter your password: ");
        Scanner in = new Scanner(System.in);
        enterPassword = in.nextLine();
        if (enterPassword.contains(password)) {
            VariableChooses.mm.Menu();
        } else if (!enterPassword.contains(password)) {
            System.out.println("Wrong password, try again!");
        }
    }
}