package MainModules;

import DataPackage.Variable;
import Modules.CheckFilesAndDirectory;
import Modules.GetIp;
import com.sun.tools.javac.Main;

import java.util.Date;

import static java.lang.System.out;

public class MainMenu extends Variable {
    Date date = new Date();



    public void Menu() {
        out.println("Welcome " + nameProperty + " to the program!\n" +
                "Input your command: ");
        setChooseAction(scanner.nextLine());
        if(chooseAction.contains("string") || chooseAction.contains("String")) {
            out.println("Available methods for string:\n " +
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
        if(chooseAction.contains("calc") || chooseAction.contains("Calc")) {
            new Calculator().calculator();
        }
        if(chooseAction.contains("info") || chooseAction.contains("Info")) {
            out.println("Available methods for info:\n " +
                    "System");
            setChooseAction(scanner.nextLine());
            if (chooseAction.contains("System") || chooseAction.contains("system")) {
               new SystemInfo().getSystemInfo();
            }
        }
        if(chooseAction.contains("Time") || chooseAction.contains("time")){
            out.println("Current time: " + new Date().getDate());
            out.println("--------------------------------");
            Menu();
        }
        if(chooseAction.contains("ip") || chooseAction.contains("Ip") || chooseAction.contains("IP")){
                out.println("Your ip: "  + new GetIp().getIp());
        }
        if(chooseAction.contains("Check") || chooseAction.contains("check")){
            new CheckFilesAndDirectory().allCheck();
            out.println("Check complete.");
            new MainMenu().Menu();
        }
    }
}

