package MainModules;

import DataPackage.Variable;
import Modules.AllChecks.CheckFilesAndDirectory;
import Modules.GetIp;
import Modules.Logger;

import java.io.IOException;
import java.util.Date;

import static java.lang.System.out;

public class MainMenu extends Variable {

    public void Menu() {
        out.print("Welcome " + nameProperty + " to the program!\n" +
                "Input your command: ");
        setChooseAction(scanner.nextLine());

        new Logger().commandLoggerWriter(getChooseAction());
        if (chooseAction.contains("string")) {
            out.println("Available methods for string:\n " +
                    "Substring\n " +
                    "Append\n" +
                    " toLowerCase" +
                    "\n toUpperCase" +
                    "\n Replace");
            out.print("Enter method: ");
            setChooseAction(scanner.nextLine().toLowerCase());
            new Logger().LogSubMethod(getChooseAction());
            if (chooseAction.contains("substring")) {
                new StringProcessing().substringString();
            }
            if (chooseAction.contains("contains")) {

            }

            if (chooseAction.contains("append")) {
                new StringProcessing().appendString();
            }
            if (chooseAction.contains("tolowercase")) {
                new StringProcessing().toLowerCaseString();
            }
            if (chooseAction.contains("touppercase")) {
                new StringProcessing().toUpperCaseString();
            }
            if (chooseAction.contains("replace")) {
                new StringProcessing().replaceString();
            }
        }
        if (chooseAction.contains("calc")) {
            out.println("Available methods for calculator:\n " +
                    "Sum\n" +
                    "minus\n" +
                    "multiplication\n" +
                    "division\n" +
                    "interest\n" +
                    "sqrt\n" +
                    "pow\n" +
                    "sin\n" +
                    "cos\n" +
                    "dis[discernment]\n"+
                    "tan\n"+
            "average\n"+
                    "asin\n"+
                    "acos\n"
                    );
            setChooseAction(scanner.nextLine().toLowerCase());
            new Logger().LogSubMethod(getChooseAction());
            if (chooseAction.contains("sum")) {
                new Calculator().sumComplete();
            }
            if (chooseAction.contains("minus")) {
                new Calculator().minusComplete();
            }
            if (chooseAction.contains("multiplication")) {
                new Calculator().multiplicationComplete();
            }
            if (chooseAction.contains("division")) {
                new Calculator().divisionComplete();
            }
            if (chooseAction.contains("interest")) {
                new Calculator().interestComplete();
            }
            if (chooseAction.contains("sqrt")) {
                new Calculator().sqrtComplete();
            }
            if (chooseAction.contains("pow")) {
                new Calculator().powComplete();
            }
            if (chooseAction.contains("sin")) {
                new Calculator().sinComplete();
            }
            if (chooseAction.contains("cos")) {
                new Calculator().cosComplete();
            }
            if (chooseAction.contains("tan")) {
                new Calculator().tanComplete();
            }
            if(chooseAction.contains("dis")){
                new Calculator().disc();
            }
            if(chooseAction.contains("average")){
                new Calculator().averageComplete();
            }
            if (chooseAction.contains("asin")) {
                new Calculator().asinComplete();
            }
            if (chooseAction.contains("acos")) {
                new Calculator().acosComplete();
            }

        }
        if (chooseAction.contains("info")) {
            out.println("Available methods for info:\n " +
                    "System");
            setChooseAction(scanner.nextLine().toLowerCase());
            new Logger().LogSubMethod(getChooseAction());
            if (chooseAction.contains("system")) {
                new SystemInfo().getSystemInfo();
            }
        }
        if (chooseAction.contains("time")) {
            Date date = new Date();
            out.println("Current time: " + date);
            out.println("--------------------------------");
            Menu();
        }
        if (chooseAction.contains("ip")) {
            out.println("Your ip: " + new GetIp().getIp());
        }
        if (chooseAction.contains("check")) {
            new CheckFilesAndDirectory().allCheck();
            out.println("Check complete.");
            new MainMenu().Menu();

        }
        if (chooseAction.contains("log")) {
            out.println("Available methods for log:\n " +
                    "Show\n" +
                    "Clear");
            setChooseAction(scanner.nextLine().toLowerCase());
            new Logger().LogSubMethod(getChooseAction());
            if (chooseAction.contains("show")) {
                out.println("1 - All logs   2 - Commands log  3 - Session logs");
                setEnterChooseNumber(scanner.nextInt());
                int chooseNumber = getEnterChooseNumber();
                if (chooseNumber == 1) {
                    try {
                        new LogReader().allLogReader();
                        mm.Menu();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                } else if (chooseNumber == 2) {
                    try {
                        new LogReader().logCommandReader();
                        mm.Menu();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                } else if (chooseNumber == 3) {
                    try {
                        new LogReader().logSessionReader();
                        mm.Menu();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                }
            }
            if (chooseAction.contains("exit")) {
                out.println("Bye bye!");
                System.exit(0);
            }
        }
    }
}


