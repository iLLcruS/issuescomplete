package modeuser.mmUserMode;

import MainModules.ProcessingModules.NameProcessing;
import modeuser.usermod.StringProcessing;
import Utils.Variable;
import Utils.VisualForConsole.OutputModeStyle;
import modeutils.ModeCheckFile;
import modeutils.SetUpMode;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.out;

public class MenuUserMode extends Variable {

    private static final Pattern COMMAND_PATTERN = Pattern.compile("calc|info|system|time|ip|check|log|location|weather|name|file|fun|game|string|web|generate|kill|random|password|gitrep|help|gethttp|ping|movie|diary|encode|runtime|change");
    private static final String WELCOME_MESSAGE = "Welcome %s to the program!\nInput your command: ";
    private static final String ERROR_MESSAGE = "Error with file passed.";
    public List<String> comString = new ArrayList<>();


    public void Menu() {
        new OutputModeStyle().outUserMode();

        try {
            out.printf(WELCOME_MESSAGE, new NameProcessing().getCurrentName());
        } catch (FileNotFoundException e) {
            out.println(ERROR_MESSAGE);
            out.printf(WELCOME_MESSAGE, nameProperty);
        }
        setChooseAction(scanner.nextLine().toLowerCase());
        Matcher matcher = COMMAND_PATTERN.matcher(getChooseAction());

        if (matcher.find()) {
            switch (matcher.group()) {
                case "string" -> handleStringCommands();
                case "calc" -> handleCalculatorCommands();
                case "system" -> handleSystemCommands();
                case "time" -> handleTimeCommand();
                case "ip" -> handleIpCommand();
                case "check" -> handleCheckCommand();
                case "log" -> handleLogCommand();
                case "location" -> handleLocationCommand();
                case "weather" -> handleWeatherCommand();
                case "name" -> handleNameCommand();
                case "file" -> handleFileCommands();
                case "fun" -> handleFunCommand();
                case "game" -> handleGameCommand();
                case "web" -> handleWebCommand();
                case "random" -> handleRandomCommand();
                case "generate" -> handleGenerateCommand();
                case "kill" -> handleKillCommand();
                case "encode" -> handleEncodeCommand();
                case "diary" -> handleDiaryCommand();
                case "ping" -> handlePingCommand();
                case "gethttp" -> handleGetHttpCommand();
                case "help" -> handleHelpCommand();
                case "gitrep" -> handleGitRepCommand();
                case "password" -> handlePasswordCommand();
                case "change" -> handleModeChangeCommand();
                /* case "movie" -> handleMovieCommand(); */
            }
        }
    }

    private void initSubComStr(){
        comString.add("Substring");
        comString.add("Contains");
        comString.add("Append");
        comString.add("LowerCase");
        comString.add("UpperCase");
        comString.add("Replace");
    }
    private void handleModeChangeCommand() {
        new SetUpMode().setUpMode();
        Menu();
    }
    private void handleStringCommands() {
        out.println("""
                            Available methods for string:
                            Substring
                            Append
                            LowerCase
                            UpperCase
                            Replace
                            """);

        setChooseAction(scanner.nextLine());
        getChooseAction();


        initSubComStr();
        for(String action : comString){
            if(action.equalsIgnoreCase("substring")){
                new StringProcessing().substringString();
            }
            if(action.equalsIgnoreCase("append")){
                new StringProcessing().appendString();
            }
            if(action.equalsIgnoreCase("lowercase")){
                new StringProcessing().toLowerCaseString();
            }
            if(action.equalsIgnoreCase("uppercase")){
                new StringProcessing().toUpperCaseString();
            }
            if(action.equalsIgnoreCase("Replace")){
                new StringProcessing().replaceString();
            }
        }
    }

    private void handleCalculatorCommands() {
    }

    private void handleSystemCommands() {
    }

    private void handleTimeCommand() {
    }

    private void handleIpCommand() {
    }

    private void handleCheckCommand() {
    }

    private void handleLogCommand() {
    }

    private void handleLocationCommand() {
    }

    private void handleWeatherCommand() {
    }

    private void handleNameCommand() {
    }

    private void handleFileCommands() {
    }

    private void handleFunCommand() {

    }

    private void handleGameCommand() {
    }

    private void handleWebCommand() {
    }

    private void handleRandomCommand() {
    }

    private void handleGenerateCommand() {
    }

    private void handleKillCommand() {
    }

    private void handleEncodeCommand() {
    }

    private void handleDiaryCommand() {
    }

    private void handlePingCommand() {
    }

    private void handleGetHttpCommand() {
    }

    private void handleHelpCommand() {
    }

    private void handleGitRepCommand() {
    }

    private void handlePasswordCommand() {
    }
}

