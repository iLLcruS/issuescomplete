package MainModules;

import DataPackage.Variable;
import MainModules.FunModules.Anekdoter;
import MainModules.FunModules.CasinoMiniGame;
import MainModules.FunModules.RandomiZeName;
import MainModules.ProcessingModules.*;
import MainModules.SystemModules.AllProcessInfo;
import MainModules.SystemModules.SystemInfo;
import MainModules.WebModules.GetResponseStatusFromLink;
import MainModules.WebModules.GetWeather;
import MainModules.WebModules.OpenSite;
import Modules.AllChecks.CheckFilesAndDirectory;
import Modules.GetIp;
import Modules.Logger;
import Modules.VisualForConsole.ChangeConsoleColor;
import Modules.VisualForConsole.Visual;

import java.io.*;
import java.net.URISyntaxException;
import java.util.Date;
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
        Pattern pattern = Pattern.compile("calc|info|system|time|ip|check|log|location|weather|name|file|fun|game|string|web|generate|kill|random|password|gitrep|help|gethttp|ping|movie|diary|encode");
        Matcher matcher = pattern.matcher(getChooseAction());

        if (matcher.find()) {
            switch (matcher.group()) {
                case "string" -> {
                    new Logger().commandLoggerWriter(getChooseAction());
                    out.println("""
                            Available methods for string:
                            Substring
                            Contains
                            Append
                            LowerCase
                            UpperCase
                            Replace
                            """);
                    setChooseAction(scanner.nextLine().toLowerCase());

                    pattern = Pattern.compile("substring|contains|append|tolowercase|touppercase|replace|");
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
                        case "lowercase" -> {
                            new StringProcessing().toLowerCaseString();
                            new Logger().LogSubMethod(getChooseAction());
                        }
                        case "uppercase" -> {
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
                    new Logger().commandLoggerWriter(getChooseAction());
                    out.println("Enter subcommand");
                    setChooseAction(scanner.nextLine().toLowerCase());
                    pattern = Pattern.compile("sum|minus|multiplication|division|interest|sqrt|cbrt|pow|sin|cos|tan|dis|average|asin|acos|atan|log|log10|sinh|cosh|tanh");
                    matcher = pattern.matcher(getChooseAction());

                    switch (matcher.group()) {
                        case "sum" -> {
                            new Calculator().sumComplete();
                            new Logger().LogSubMethod(getChooseAction());
                        }

                        case "minus" -> {
                            new Calculator().minusComplete();
                            new Logger().LogSubMethod(getChooseAction());
                        }
                        case "multiplication" -> {
                            new Calculator().multiplicationComplete();
                            new Logger().LogSubMethod(getChooseAction());
                        }
                        case "division" -> {
                            new Calculator().divisionComplete();
                            new Logger().LogSubMethod(getChooseAction());
                        }
                        case "interest" -> {
                            new Calculator().interestComplete();
                            new Logger().LogSubMethod(getChooseAction());
                        }
                        case "sqrt" -> {
                            new Calculator().sqrtComplete();
                            new Logger().LogSubMethod(getChooseAction());
                        }
                        case "cbrt" -> {
                            new Calculator().cbrtComplete();
                            new Logger().LogSubMethod(getChooseAction());
                        }
                        case "pow" -> {
                            new Calculator().powComplete();
                            new Logger().LogSubMethod(getChooseAction());
                        }
                        case "sin" -> {
                            new Calculator().sinComplete();
                            new Logger().LogSubMethod(getChooseAction());
                        }
                        case "cos" -> {
                            new Calculator().cosComplete();
                            new Logger().LogSubMethod(getChooseAction());
                        }
                        case "tan" -> {
                            new Calculator().tanComplete();
                            new Logger().LogSubMethod(getChooseAction());
                        }
                        case "dis" -> {
                            new Calculator().disc();
                            new Logger().LogSubMethod(getChooseAction());
                        }
                        case "average" -> {
                            new Calculator().averageComplete();
                            new Logger().LogSubMethod(getChooseAction());
                        }
                        case "asin" -> {
                            new Calculator().asinComplete();
                            new Logger().LogSubMethod(getChooseAction());
                        }
                        case "acos" -> {
                            new Calculator().acosComplete();
                            new Logger().LogSubMethod(getChooseAction());
                        }
                        case "atan" -> {
                            new Calculator().atanComplete();
                            new Logger().LogSubMethod(getChooseAction());
                        }
                        case "log" -> {
                            new Calculator().logComplete();
                            new Logger().LogSubMethod(getChooseAction());
                        }
                        case "log10" -> {
                            new Calculator().log10Complete();
                            new Logger().LogSubMethod(getChooseAction());
                        }
                        case "sinh" -> {
                            new Calculator().sinhComplete();
                            new Logger().LogSubMethod(getChooseAction());
                        }
                        case "cosh" -> {
                            new Calculator().coshComplete();
                            new Logger().LogSubMethod(getChooseAction());
                        }
                        case "tanh" -> {
                            new Calculator().tanhComplete();
                            new Logger().LogSubMethod(getChooseAction());
                        }
                    }
                }
                case "system" -> {
                    new Visual().printMsgWithSeparator(25, 25);
                    new ChangeConsoleColor().setCeruleanColor();
                    out.println("""
                            Available methods for info:
                            Info
                            ap(all process)""");
                    new ChangeConsoleColor().setGreenColor();
                    new Visual().printMsgWithSeparator(25, 25);
                    setChooseAction(scanner.nextLine().toLowerCase());
                    new Logger().commandLoggerWriter(getChooseAction());
                    if (chooseAction.contains("info")) {
                        new Logger().LogSubMethod(getChooseAction());
                        new SystemInfo().getSystemInfo();
                        new MainMenu().Menu();
                    }
                    if (chooseAction.contains("ap")) {
                        new Logger().LogSubMethod(getChooseAction());
                        new AllProcessInfo().giveAllProcess();
                        new MainMenu().Menu();
                    }
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
                case "location" -> {
                    out.println("-------------------------------------");
                    out.println("Available functions for 'location'\n-> City");
                    out.println("-------------------------------------");
                    out.print("Enter a function: ");
                    setChooseAction(scanner.nextLine().toLowerCase());
                    switch (chooseAction) {
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
                case "weather" -> {
                    new Logger().commandLoggerWriter(getChooseAction());
                    out.println("=====================================");
                    out.println("Available functions for 'wheather':\n" +
                            "=> temperature");
                    out.println("=====================================");
                    out.print("Enter function: ");
                    setChooseAction(scanner.nextLine().toLowerCase());
                    switch (chooseAction) {
                        case "temperature" -> {
                            new Logger().LogSubMethod(chooseAction);
                            out.print("Your current temperature: ");
                            out.print(new GetWeather().GetTemperature() + "°" + "\n");
                            out.print("Your current temperature feels like: ");
                            out.print(new GetWeather().GetAllWheater().get("feelslike_c") + "°" + "\n");
                        }
                        default -> {
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
                        switch (chooseAction) {
                            case "see" -> {
                                out.print("============================================");
                                out.println("Your previous name is: " + new NameProcessing().getCurrentName());
                                out.print("============================================");
                                mm.Menu();
                            }
                            case "set" -> {

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
                case "file" -> {
                    out.println("Available fucnctions for 'file'\n" +
                            "=> Rename\n" +
                            "=> mkFile\n" +
                            "=> mkDir\n" +
                            "=> Open");
                    out.print("Enter a function: ");
                    out.print("\n");
                    setChooseAction(scanner.nextLine().toLowerCase());
                    switch (chooseAction) {
                        case "rename" -> {
                            FileProccesing f = new FileProccesing();
                            out.println("Path format './user/data/password/passwords.txt'");
                            out.print("Enter path to file:");
                            f.setPath();
                            f.renameFile();
                            mm.Menu();
                        }
                        case "mkfile" -> {
                            FileProccesing f = new FileProccesing();
                            out.println("Path format './user/data/password/passwords.txt'");
                            out.print("Enter path to file:");
                            f.setPath();
                            f.makeNewFile();
                            mm.Menu();
                        }
                        case "mkdir" -> {
                            FileProccesing f = new FileProccesing();
                            out.println("Path format './user/data/password/passwords.txt'");
                            out.print("Enter path to file:");
                            f.setPath();
                            f.makeNewDirectory();
                            mm.Menu();
                        }
                        case "open" -> {
                            FileProccesing f = new FileProccesing();
                            out.println("Path format './user/data/password/passwords.txt'");
                            out.print("Enter path to file:");
                            f.setPath();
                            f.openFile();
                            mm.Menu();
                        }
                        default -> {
                            mm.Menu();
                        }
                    }
                }

                case "fun" -> {
                    new Logger().commandLoggerWriter(getChooseAction());
                    new Anekdoter().sendAnecdot();
                    new MainMenu().Menu();
                }
                case "game" -> {
                    new Logger()
                            .commandLoggerWriter(getChooseAction());
                    new CasinoMiniGame().main();
                    new MainMenu().Menu();
                }
                case "web" -> {
                    new Logger().commandLoggerWriter(getChooseAction());
                    try {
                        new OpenSite().openWebPage();
                        new MainMenu().Menu();
                    } catch (URISyntaxException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "random" -> {
                    new Logger().commandLoggerWriter(getChooseAction());
                    new RandomiZeName().random();
                    new MainMenu().Menu();
                }
                case "generate" -> {
                    new PlainCodeGenerator().start();
                    new MainMenu().Menu();
                }
                case "kill" -> {
                    new Logger()
                            .commandLoggerWriter(getChooseAction());
                    new TaskKiller().start();
                    new MainMenu().Menu();
                }
                case "encode" ->
                {
                    new Logger().commandLoggerWriter(getChooseAction());
                    new StringEncoder().encode();
                case "diary" -> {
                    new Logger()
                            .commandLoggerWriter(getChooseAction());
                    new Diary().start();
                    new MainMenu().Menu();
                }
                case "ping" -> {
                    new Logger()
                            .commandLoggerWriter(getChooseAction());
                    new PingChecker().start();
                }
                case "gethttp" ->
                {
                    new Logger().commandLoggerWriter(getChooseAction());

                    new GetResponseStatusFromLink().getResponseStatus();
                }
                case "help" -> {
                    new Logger()
                            .commandLoggerWriter(getChooseAction());
                    try {
                        new HelpLink().start();
                    } catch (URISyntaxException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "gitrep" -> {
                    new Logger()
                            .commandLoggerWriter(getChooseAction());
                    new DownloadRepository().start();
                    new MainMenu().Menu();
                }
                case "password" ->
                {
                    new Logger()
                            .commandLoggerWriter(getChooseAction());
                    new PasswordGenerator().generatePassword();
                    new MainMenu().Menu();
                }
                case "movie" -> {
                    new Logger().commandLoggerWriter(getChooseAction());
                    new moviesearch().search();
                    new MainMenu().Menu();
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




