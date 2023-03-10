package MainModules;

import DataPackage.VariableChooses;
import MainModules.Calculator;
import MainModules.StringProcessing;
import java.time.LocalDateTime;
import java.util.Date;

public class MainMenu extends VariableChooses {
    Date date = new Date();
    StringProcessing sp = new StringProcessing();
    private String nameProperty = System.getProperty("user.name");
    Calculator calc = new Calculator();

    SystemInfo si = new SystemInfo();

    public void Menu() {
        System.out.println("Welcome " + nameProperty + " to the program!\n" +
                "Current time: " + date + "\n" +
                "Choose your command: ");
        chooseAction = scanner.nextLine();
        if (chooseAction.contains("string")) {
            System.out.println("Available methods for string:\n " +
                    "Substring");
            chooseAction = scanner.next();
            if (chooseAction.contains("Substring")) {
                sp.substringString();
            }
        }
        if (chooseAction.contains("calc")) {
            calc.calculator();
        }
        if(chooseAction.contains("weather")) {

        }
    }
}

