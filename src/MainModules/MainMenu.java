package MainModules;

import DataPackage.Variable;
import Modules.AllChecks.CheckFilesAndDirectory;
import Modules.GetIp;
import Modules.Logger;

import java.io.*;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.out;

public class MainMenu extends Variable {

    public void Menu() {
        try {
            out.print("Welcome " + new NameProcessing().getCurrentName() + " to the program!\n" +
                    "Input your command: ");
        } catch (FileNotFoundException e) {
            out.println("Error with file passed.");
            out.print("Welcome " + nameProperty + " to the program!\n" +
                    "Input your command: ");
        }

        setChooseAction(scanner.nextLine());
        
        Pattern pattern = Pattern.compile("string|calc|info|system|time|ip|check|log|location|weather|name|file");
        Matcher matcher = pattern.matcher(getChooseAction());

        if (matcher.find()) {
            switch (matcher.group()) {
                case "string" -> {
                    new Logger().commandLoggerWriter(getChooseAction());
                    pattern = Pattern.compile("substring|contains|append|tolowercase|touppercase|replace");
                    matcher = pattern.matcher(getChooseAction());
                    switch (matcher.group()) {
                        case "substring" -> {
                            new StringProcessing().substringString();
                            new Logger().LogSubMethod(getChooseAction());
                        }
                        case "contains" -> {
                        }
                        case "append" -> {
                            new StringProcessing().appendString();
                            new Logger().LogSubMethod(getChooseAction());
                        }
                        case "tolowercase" -> {
                            new StringProcessing().toLowerCaseString();
                            new Logger().LogSubMethod(getChooseAction());
                        }
                        case "touppercase" -> {
                            new StringProcessing().toUpperCaseString();
                            new Logger().LogSubMethod(getChooseAction());
                        }
                        case "replace" -> {
                            new StringProcessing().replaceString();
                            new Logger().LogSubMethod(getChooseAction());
                        }
                    }
                }
                case "calc" -> {
                    pattern = Pattern.compile("sum|minus|multiplication|division|interest|sqrt|cbrt|pow|sin|cos|tan|dis|average|asin|acos|atan|log|log10|sinh|cosh|tanh");
                    matcher = pattern.matcher(getChooseAction());

                    switch (matcher.group()) {
                        case "sum" -> {
                            new Calculator().sumComplete();
                            new Logger().LogSubMethod(getChooseAction());
                        }
                        case "minus" -> new Calculator().minusComplete();
                        case "multiplication" -> new Calculator().multiplicationComplete();
                        case "division" -> new Calculator().divisionComplete();
                        case "interest" -> new Calculator().interestComplete();
                        case "sqrt" -> new Calculator().sqrtComplete();
                        case "cbrt" -> new Calculator().cbrtComplete();
                        case "pow" -> new Calculator().powComplete();
                        case "sin" -> new Calculator().sinComplete();
                        case "cos" -> new Calculator().cosComplete();
                        case "tan" -> new Calculator().tanComplete();
                        case "dis" -> new Calculator().disc();
                        case "average" -> new Calculator().averageComplete();
                        case "asin" -> new Calculator().asinComplete();
                        case "acos" -> new Calculator().acosComplete();
                        case "atan" -> new Calculator().atanComplete();
                        case "log" -> new Calculator().logComplete();
                        case "log10" -> new Calculator().log10Complete();
                        case "sinh" -> new Calculator().sinhComplete();
                        case "cosh" -> new Calculator().coshComplete();
                        case "tanh" -> new Calculator().tanhComplete();
                    }
                }
                case "info" -> {
                    out.println("Available methods for info:\n " +
                            "System");
                    setChooseAction(scanner.nextLine().toLowerCase());
                    new Logger().commandLoggerWriter(getChooseAction());
                    if (chooseAction.contains("system")) {
                        new Logger().LogSubMethod(getChooseAction());
                        new SystemInfo().getSystemInfo();
                    }
                }
                case "system" -> {
                }
                case "time" -> {
                    new Logger().commandLoggerWriter(getChooseAction());
                    Date date = new Date();
                    out.println("Current time: " + date);
                    out.println("--------------------------------");
                    Menu();
                }
                case "ip" -> {
                    new Logger().commandLoggerWriter(getChooseAction());
                    out.println("Your ip: " + new GetIp().getIp());
                }
                case "check" -> {
                    new Logger().commandLoggerWriter(getChooseAction());
                    new CheckFilesAndDirectory().allCheck();
                    out.println("Check complete.");
                    new MainMenu().Menu();
                }
                case "log" -> {
                    out.println("Available methods for log:\n " +
                            "Show\n" +
                            "Clear");
                    setChooseAction(scanner.nextLine().toLowerCase());
                    new Logger().commandLoggerWriter(getChooseAction());
                    if (chooseAction.contains("show")) {
                        new Logger().LogSubMethod(getChooseAction());
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
                        new Logger().commandLoggerWriter(getChooseAction());
                        out.println("Bye bye!");
                        System.exit(0);
                    }
                }
                case "location" ->
                {
                    out.println("-------------------------------------");
                    out.println("Available functions for 'location'\n-> City");
                    out.println("-------------------------------------");
                    out.print("Enter a function: ");
                    setChooseAction(scanner.nextLine().toLowerCase());
                    switch (chooseAction)
                    {
                        case "city" -> {
                            out.print("Your city is => ");
                            out.print(new LocationProccesing().getCity() + "\n");
                            mm.Menu();
                        }
                        default -> {
                            mm.Menu();
                        }
                    }
                }
                case "weather" ->
                {
                    new Logger().commandLoggerWriter(getChooseAction());
                    out.println("=====================================");
                    out.println("Available functions for 'wheather':\n" +
                            "=> temperature");
                    out.println("=====================================");
                    out.print("Enter function: ");
                    setChooseAction(scanner.nextLine().toLowerCase());
                    switch (chooseAction)
                    {
                        case "temperature" ->
                        {
                            new Logger().LogSubMethod(chooseAction);
                            out.print("Your current temperature: ");
                            out.print(new GetWeather().GetTemperature() + "°" + "\n");
                            out.print("Your current temperature feels like: ");
                            out.print(new GetWeather().GetAllWheater().get("feelslike_c") + "°" + "\n");
                        }
                        default ->
                        {
                            mm.Menu();
                        }

                    }



                }
                case "name" -> {
                    new Logger().logCommand(getChooseAction());
                    try {
                        out.print("============================");
                        out.println("What are you want?\n" +
                                "See previous name => see\n" +
                                "Set a new name => set");
                        out.print("============================");
                        out.print("Enter a command:");
                        setChooseAction(scanner.nextLine().toLowerCase());
                        new Logger().LogSubMethod(getChooseAction());
                        switch (chooseAction)
                        {
                            case "see" ->
                            {
                                out.print("============================================");
                                out.println("Your previous name is: " + new NameProcessing().getCurrentName());
                                out.print("============================================");
                                mm.Menu();
                            }
                            case "set" ->
                            {

                                out.print("Enter new name: ");
                                new NameProcessing().SetNewName();
                                out.print("\n");
                                mm.Menu();
                            }
                            default -> {
                                mm.Menu();
                            }
                        }


                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "file" ->
                {
                    out.println("Available fucnctions for 'file'\n" +
                            "=> Rename\n" +
                            "=> mkFile\n" +
                            "=> mkDir\n" +
                            "=> Open");
                    out.print("Enter a function: ");
                    out.print("\n");
                    setChooseAction(scanner.nextLine().toLowerCase());
                    switch (chooseAction)
                    {
                        case "rename" ->{
                            FileProccesing f = new FileProccesing();
                            out.println("Path format './user/data/password/passwords.txt'");
                            out.print("Enter path to file:");
                            f.setPath();
                            f.renameFile();
                            mm.Menu();
                        }
                        case "mkfile" ->
                        {
                            FileProccesing f = new FileProccesing();
                            out.println("Path format './user/data/password/passwords.txt'");
                            out.print("Enter path to file:");
                            f.setPath();
                            f.makeNewFile();
                            mm.Menu();
                        }
                        case "mkdir" ->
                        {
                            FileProccesing f = new FileProccesing();
                            out.println("Path format './user/data/password/passwords.txt'");
                            out.print("Enter path to file:");
                            f.setPath();
                            f.makeNewDirectory();
                            mm.Menu();
                        }
                        case "open" ->
                        {
                            FileProccesing f = new FileProccesing();
                            out.println("Path format './user/data/password/passwords.txt'");
                            out.print("Enter path to file:");
                            f.setPath();
                            f.openFile();
                            mm.Menu();
                        }
                        default ->
                        {
                            mm.Menu();
                        }
                    }
                }
            }
        }
    }
}


      /*  new Logger().commandLoggerWriter(getChooseAction());
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
                    "cbrt\n" +
                    "pow\n" +
                    "sin\n" +
                    "cos\n" +
                    "dis[discernment]\n" +
                    "tan\n" +
                    "average\n" +
                    "asin\n" +
                    "acos\n" +
                    "atan\n" +
                    "log\n" +
                    "log10\n" +
                    "sinh\n" +
                    "cosh\n" +
                    "tanh\n"
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
            if (chooseAction.contains("cbrt")) {
                new Calculator().cbrtComplete();
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
            if (chooseAction.contains("dis")) {
                new Calculator().disc();
            }
            if (chooseAction.contains("average")) {
                new Calculator().averageComplete();
            }
            if (chooseAction.contains("asin")) {
                new Calculator().asinComplete();
            }
            if (chooseAction.contains("acos")) {
                new Calculator().acosComplete();
            }
            if (chooseAction.contains("atan")) {
                new Calculator().acosComplete();
            }
            if (chooseAction.contains("log")) {
                new Calculator().logComplete();
            }
            if (chooseAction.contains("log10")) {
                new Calculator().log10Complete();
            }
            if (chooseAction.contains("sinh")) {
                new Calculator().sinhComplete();
            }
            if (chooseAction.contains("cosh")) {
                new Calculator().coshComplete();
            }
            if (chooseAction.contains("tanh")) {
                new Calculator().tanhComplete();
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
        }*/




