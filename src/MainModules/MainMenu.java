package MainModules;

import DataPackage.Variable;
import MainModules.Calculator;
import MainModules.StringProcessing;
import java.time.LocalDateTime;
import java.util.Date;

public class MainMenu extends Variable {
    Date date = new Date();
    StringProcessing sp = new StringProcessing();
    private String nameProperty = System.getProperty("user.name");
    Calculator calc = new Calculator();

    SystemInfo si = new SystemInfo();

    public void Menu() {
        System.out.println("Welcome " + nameProperty + " to the program!\n" +
                "Current time: " + date + "\n" +
                "Choose your command: ");
        setChooseAction(scanner.nextLine());
        if (chooseAction.contains("string") || chooseAction.contains("String")) {
            System.out.println("Available methods for string:\n " +
                    "Substring");
            setChooseAction(scanner.nextLine());
            if (chooseAction.contains("Substring") || chooseAction.contains("substring")) {
                sp.substringString();
            } else if (chooseAction.contains("Contains") || chooseAction.contains("contains")) {
                sp.containsStringCheck();
            }
        }
        if (chooseAction.contains("calc") || chooseAction.contains("Calc")) {
            calc.calculator();
        }
        if(chooseAction.contains("info") || chooseAction.contains("Info")) {
            System.out.println("Available methods for string:\n " +
                    "System");
            setChooseAction(scanner.nextLine());
            if (chooseAction.contains("System") || chooseAction.contains("system")) {
                si.getSystemInfo();
            }
        }
    }
}

