package modeuser.mmUserMode;

import Utils.Variable;
import modedev.*;
import modeuser.usermod.StringProcessing;
import modeuser.webmod.LocationProccesing;
import modeuser.usermod.Anekdoter;
import modegaming.games.CasinoMiniGame;
import MainModules.ProcessingModules.*;
import modeuser.sysmod.AllProcessInfo;
import modeuser.sysmod.FileProccesing;
import modeuser.sysmod.SystemInfo;
import modeuser.usermod.*;
import modeuser.webmod.GetWeather;
import modeuser.webmod.OpenSite;
import modeuser.webmod.PingChecker;
import Utils.AllChecks.CheckFilesAndDirectory;
import Utils.GetIp;
import Utils.Logger;
import Utils.VisualForConsole.ChangeConsoleColor;
import Utils.VisualForConsole.Visual;

import java.io.*;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.getenv;
import static java.lang.System.out;

public class mmUser extends Variable {

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
        Pattern pattern = Pattern.compile("calc|info|system|time|ip|check|log|location|weather|name|file|fun|game|string|web|generate|kill|random|password|gitrep|help|gethttp|ping|movie|diary|encode|runtime");
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
                        new mmUser().Menu();
                    }
                    if (chooseAction.contains("ap")) {
                        new Logger().LogSubMethod(getChooseAction());
                        new AllProcessInfo().giveAllProcess();
                        new mmUser().Menu();
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
                    new mmUser().Menu();
                }
                case "log" -> {
                    out.println("""
                            Available methods for log:
                             Show
                            Clear""");
                    setChooseAction(scanner.nextLine().toLowerCase());
                    new Logger().commandLoggerWriter(getChooseAction());
                    if (chooseAction.contains("show")) {
                        new Logger().LogSubMethod(getChooseAction());
                        out.println("1 - Commands log");
                        setEnterChooseNumber(scanner.nextInt());
                        int chooseNumber = getEnterChooseNumber();
                        if (chooseNumber == 1) {
                            try {
                                new LogReader().allLogReader();
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
                    if (chooseAction.equals("city")) {
                        out.print("Your city is => ");
                        out.print(new LocationProccesing().getCity() + "\n");
                        mm.Menu();
                    } else {
                        mm.Menu();
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
                    if (chooseAction.equals("temperature")) {
                        new Logger().LogSubMethod(chooseAction);
                        out.print("Your current temperature: ");
                        out.print(new GetWeather().GetTemperature() + "°" + "\n");
                        out.print("Your current temperature feels like: ");
                        out.print(new GetWeather().GetAllWheater().get("feelslike_c") + "°" + "\n");
                    } else {
                        mm.Menu();
                    }


                }
                case "name" -> {
                    new Logger().logCommand(getChooseAction());
                    try {
                        out.print("============================");
                        out.println("""
                                What are you want?
                                See previous name => see
                                Set a new name => set""");
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
                            default -> mm.Menu();
                        }


                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "file" -> {
                    out.println("""
                            Available fucnctions for 'file'
                            => Rename
                            => mkFile
                            => mkDir
                            => Open""");
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
                        default -> mm.Menu();
                    }
                }

                case "fun" -> {
                    new Logger().commandLoggerWriter(getChooseAction());
                    new Anekdoter().sendAnecdot();
                    new mmUser().Menu();
                }
                case "game" -> {
                    new Logger()
                            .commandLoggerWriter(getChooseAction());
                    new CasinoMiniGame().main();
                    new mmUser().Menu();
                }
                case "web" -> {
                    new Logger().commandLoggerWriter(getChooseAction());
                    try {
                        new OpenSite().openWebPage();
                        new mmUser().Menu();
                    } catch (URISyntaxException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "random" -> {
                    new Logger().commandLoggerWriter(getChooseAction());
                    new RandomiZeName().random();
                    new mmUser().Menu();
                }
                case "generate" -> {
                    new PlainCodeGenerator().start();
                    new mmUser().Menu();
                }
                case "kill" -> {
                    new Logger()
                            .commandLoggerWriter(getChooseAction());
                    new TaskKiller().start();
                    new mmUser().Menu();
                }
                case "encode" -> {
                    new Logger().commandLoggerWriter(getChooseAction());
                    new StringEncoder().encode();
                }
                case "diary" -> {
                    new Logger()
                            .commandLoggerWriter(getChooseAction());
                    new Diary().start();
                    new mmUser().Menu();
                }
                case "ping" -> {
                    new Logger()
                            .commandLoggerWriter(getChooseAction());
                    new PingChecker().start();
                }
                case "gethttp" -> {
                    new Logger().commandLoggerWriter(getChooseAction());

                    new GetResponseStatusFromLink().getResponseStatus();
                }
                case "help" -> {
                    boolean IS_ACTIVE = false;
                    if (IS_ACTIVE == true) {
                        new Logger()
                                .commandLoggerWriter(getChooseAction());
                        try {
                            new HelpLink().start();
                        } catch (URISyntaxException e) {
                            throw new RuntimeException(e);
                        }
                    }else{
                        out.println("This method is inactive");
                        new mmUser().Menu();
                    }
                }
                case "gitrep" -> {
                    new Logger()
                            .commandLoggerWriter(getChooseAction());
                    new DownloadRepository().start();
                    new mmUser().Menu();
                }
                case "password" -> {
                    new Logger()
                            .commandLoggerWriter(getChooseAction());
                    new PasswordGenerator().generatePassword();
                    new mmUser().Menu();
                }
               /* case "movie" -> {
                    new Logger().commandLoggerWriter(getChooseAction());
                    new moviesearch().search();
                    new MainMenu().Menu();
                }*/
            }
        }
    }
}