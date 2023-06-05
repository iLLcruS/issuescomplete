package MainModules;

import DataPackage.Variable;
import Modules.GetIp;

import java.util.Date;

public class MainMenu extends Variable {
    Date date = new Date();
    public String nameProperty = System.getProperty("user.name");


    public void Menu() {
        System.out.println("Welcome " + nameProperty + " to the program!\n" +
                "Choose your command: ");
        setChooseAction(scanner.nextLine());
        if (chooseAction.contains("string") || chooseAction.contains("String")) {
            System.out.println("Available methods for string:\n " +
                    "Substring\n " +
                    "Append");
            setChooseAction(scanner.nextLine());
            if (chooseAction.contains("Substring") || chooseAction.contains("substring")) {
                new StringProcessing().substringString();
            }
            if (chooseAction.contains("Contains") || chooseAction.contains("contains")) {

            }

            if(chooseAction.contains("Append") || chooseAction.contains("append")){
               new StringProcessing().appendString();
            }
        }
        if (chooseAction.contains("calc") || chooseAction.contains("Calc")) {
            new Calculator().calculator();
        }
        if(chooseAction.contains("info") || chooseAction.contains("Info")) {
            System.out.println("Available methods for info:\n " +
                    "System");
            setChooseAction(scanner.nextLine());
            if (chooseAction.contains("System") || chooseAction.contains("system")) {
               new SystemInfo().getSystemInfo();
            }
        }
        if(chooseAction.contains("Time") || chooseAction.contains("time")){
            System.out.println("Current time: " + new Date().getTime());
            System.out.println("--------------------------------");
            Menu();
        }
        if(chooseAction.contains("ip") || chooseAction.contains("Ip") || chooseAction.contains("IP")){
                System.out.println("Your ip: "  + new GetIp().getIp());
        }
    }
}

