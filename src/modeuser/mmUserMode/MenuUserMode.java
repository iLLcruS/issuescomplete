package modeuser.mmUserMode;

import MainModules.ProcessingModules.NameProcessing;
import modeuser.usermod.StringProcessing;
import Utils.Variable;
import Utils.VisualForConsole.OutputModeStyle;
import modeutils.ModeCheckFile;
import modeutils.SetUpMode;

import java.io.FileNotFoundException;
import java.util.ArrayList;
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
        // Логика обработки команд для калькулятора
    }

    private void handleSystemCommands() {
        // Логика обработки системных команд
    }

    private void handleTimeCommand() {
        // Логика обработки команды для получения времени
    }

    private void handleIpCommand() {
        // Логика обработки команды для получения IP-адреса
    }

    private void handleCheckCommand() {
        // Логика обработки команды для проверки файлов и директорий
    }

    private void handleLogCommand() {
        // Логика обработки команд для работы с логами
    }

    private void handleLocationCommand() {
        // Логика обработки команды для получения местоположения
    }

    private void handleWeatherCommand() {
        // Логика обработки команды для получения погоды
    }

    private void handleNameCommand() {
        // Логика обработки команды для работы с именем
    }

    private void handleFileCommands() {
        // Логика обработки команд для работы с файлами
    }

    private void handleFunCommand() {
        // Логика обработки команды для развлечений
    }

    private void handleGameCommand() {
        // Логика обработки команды для игр
    }

    private void handleWebCommand() {
        // Логика обработки команды для работы с веб-сайтами
    }

    private void handleRandomCommand() {
        // Логика обработки команды для случайных данных
    }

    private void handleGenerateCommand() {
        // Логика обработки команды для генерации данных
    }

    private void handleKillCommand() {
        // Логика обработки команды для завершения задач
    }

    private void handleEncodeCommand() {
        // Логика обработки команды для кодирования данных
    }

    private void handleDiaryCommand() {
        // Логика обработки команды для дневника
    }

    private void handlePingCommand() {

    }

    private void handleGetHttpCommand() {

    }

    private void handleHelpCommand() {
        // Логика обработки команды для помощи
    }

    private void handleGitRepCommand() {
        // Логика обработки команды для скачивания репозитория
    }

    private void handlePasswordCommand() {
        // Логика обработки команды для генерации паролей
    }
}
