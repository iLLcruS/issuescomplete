package Modules.AllChecks;

import DataPackage.VariableChooses;
import MainModules.MainMenu;

import java.util.Scanner;

public class Checks {

    private String choose = "";
    private static String password = "123";
    private static String enterPassword = "";

    public void checkPassword(){

        System.out.print("Enter your password: ");
        Scanner in = new Scanner(System.in);
        enterPassword = in.nextLine();
        if (enterPassword.contains(password)) {

            new MainMenu().Menu();
        } else if (!enterPassword.contains(password)) {
            System.out.println("Wrong password, try again!");
            checkPassword();
        }
    }
}
