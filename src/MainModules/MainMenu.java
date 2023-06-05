package MainModules;

import DataPackage.Variable;
import Modules.CheckFilesAndDirectory;
import Modules.GetIp;
import Modules.Logger;
import com.sun.tools.javac.Main;

import java.util.Date;

import static java.lang.System.out;

public class MainMenu extends Variable {
    Date date = new Date();



    public void Menu() {
        out.print("Welcome " + nameProperty + " to the program!\n" +
                "Input your command: ");
        setChooseAction(scanner.nextLine());

        new Logger().commandLoggerWriter(getChooseAction());
        if(chooseAction.contains("string") || chooseAction.contains("String")) {
            out.println("Available methods for string:\n " +
                    "Substring\n " +
                    "Append\n" +
                    " toLowerCase");
            out.print("Enter method: ");
            setChooseAction(scanner.nextLine().toLowerCase());
            new Logger().LogSubMethod(getChooseAction());
            if (chooseAction.contains("substring")) {
                new StringProcessing().substringString();

            }
            if (chooseAction.contains("contains")) {

            }

            if(chooseAction.contains("append")){
               new StringProcessing().appendString();
            }
            if(chooseAction.contains("tolowercase")){
               new StringProcessing().toLowerCaseString();
            }
        }
        if(chooseAction.contains("calc")) {
            new Calculator().calculator();
        }
        if(chooseAction.contains("info")) {
            out.println("Available methods for info:\n " +
                    "System");
            setChooseAction(scanner.nextLine().toLowerCase());
            new Logger().LogSubMethod(getChooseAction());
            if (chooseAction.contains("system")) {
               new SystemInfo().getSystemInfo();
            }
        }
        if(chooseAction.contains("time")){
            Date date = new Date();
            out.println("Current time: " + date);
            out.println("--------------------------------");
            Menu();
        }
        if(chooseAction.contains("ip")){
                out.println("Your ip: "  + new GetIp().getIp());
        }
        if(chooseAction.contains("check")){
            new CheckFilesAndDirectory().allCheck();
            out.println("Check complete.");
            new MainMenu().Menu();
        }
    }
}

