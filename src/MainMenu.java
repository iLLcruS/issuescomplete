import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainMenu {
    private String chooseAction = "";
    StringProcessing sp = new StringProcessing();
    Calculator calc = new Calculator();
    Scanner input = new Scanner(System.in);

    static MainMenu mm = new MainMenu();

    public void Menu() {
        System.out.println("Welcome to the program!\n " +
                "Choose your command: ");
        chooseAction = input.nextLine();
        if (chooseAction.contains("string")) {
            System.out.println("Available methods for string:\n " +
                    "Substring");
            chooseAction = input.next();
            if (chooseAction.contains("Substring")) {
                sp.substringString();
                Menu();
            }
        }
        if (chooseAction.contains("calc")) {
            calc.calculator();
            Menu();
        }
    }
}
