package MainModules;

import DataPackage.VariableChooses;
import MainModules.Calculator;
import MainModules.StringProcessing;

public class MainMenu extends VariableChooses {

    StringProcessing sp = new StringProcessing();
    Calculator calc = new Calculator();

    public void Menu() {
        System.out.println("Welcome to the program!\n " +
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
