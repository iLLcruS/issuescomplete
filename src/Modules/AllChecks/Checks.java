package Modules.AllChecks;

import MainModules.MainMenu;

import java.util.Scanner;

public class Checks {

    public void checkPassword(){
        System.out.print("Enter your password: ");
        Scanner in = new Scanner(System.in);

        String enterPassword = in.nextLine();
        String password = "123";

        if (enterPassword.contains(password)) {

            new MainMenu().Menu();
        } else {
            System.out.println("Wrong password, try again!");
            checkPassword();
        }
    }
}
