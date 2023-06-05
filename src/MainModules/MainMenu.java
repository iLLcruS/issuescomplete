package MainModules;

import DataPackage.Variable;
import MainModules.Calculator;
import MainModules.StringProcessing;
import Modules.JsonSession;
import Modules.Module;

import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.util.Date;

public class MainMenu extends Variable {
    Date date = new Date();
    StringProcessing sp = new StringProcessing();
    public String nameProperty = System.getProperty("user.name");
    Calculator calc = new Calculator();

    SystemInfo si = new SystemInfo();

    public void Menu() {
        System.out.println("Welcome " + nameProperty + " to the program!\n" +
                "Choose your command: ");
        setChooseAction(scanner.nextLine());
        if(chooseAction.contains("S") || chooseAction.contains("s")){

        }
        if (chooseAction.contains("string") || chooseAction.contains("String")) {
            System.out.println("Available methods for string:\n " +
                    "Substring\n " +
                    "Append");
            setChooseAction(scanner.nextLine());
            if (chooseAction.contains("Substring") || chooseAction.contains("substring")) {
                sp.substringString();
            if (chooseAction.contains("Contains") || chooseAction.contains("contains")) {

            }
            }
            if(chooseAction.contains("Append") || chooseAction.contains("append")){
                sp.appendString();
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
        if(chooseAction.contains("Weather") || chooseAction.contains("Sql") || chooseAction.contains("SQL")){

        }
        if(chooseAction.contains("Time") || chooseAction.contains("time")){
            System.out.println("Current time: " + date);
            System.out.println("--------------------------------");
            Menu();
        }
        if(chooseAction.contains("ip") || chooseAction.contains("Ip") || chooseAction.contains("IP")){
                System.out.println("Your ip: "  + new Module().getIp());
        }
        //if(chooseAction.contains(""))
    }
}

