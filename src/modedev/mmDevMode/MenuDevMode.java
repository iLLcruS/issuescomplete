package modedev.mmDevMode;

import modedev.DownloadRepository;
import MainModules.ProcessingModules.NameProcessing;
import modedev.StringEncoder;
import Utils.AllChecks.CheckFilesAndDirectory;
import Utils.GetIp;
import Utils.Variable;
import Utils.VisualForConsole.OutputModeStyle;
import modedev.GetResponseStatusFromLink;
import modedev.PlainCodeGenerator;
import modeutils.ModeCheckFile;
import modeutils.SetUpMode;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.out;

public class MenuDevMode extends Variable {

    private static final Pattern COMMAND_PATTERN = Pattern.compile("calc|info|system|time|ip|check|log|location|weather|name|file|fun|game|string|web|generate|kill|random|password|gitrep|help|gethttp|ping|movie|diary|encode|runtime|change");
    private static final String WELCOME_MESSAGE = "Welcome %s to the program!\nInput your command: ";
    private static final String ERROR_MESSAGE = "Error with file passed.";
    public List<String> comString = new ArrayList<>();

    public void Menu() {
        new OutputModeStyle().outDevelopMode();

        try {
            out.print(String.format(WELCOME_MESSAGE, new NameProcessing().getCurrentName()));
        } catch (FileNotFoundException e) {
            out.println(ERROR_MESSAGE);
            out.print(String.format(WELCOME_MESSAGE, nameProperty));
        }

        setChooseAction(scanner.nextLine().toLowerCase());
        Matcher matcher = COMMAND_PATTERN.matcher(getChooseAction());

        if (matcher.find()) {
            switch (matcher.group()) {
                case "ip" -> handleIpCommand();
                case "check" -> handleCheckCommand();
                case "generate" -> handleGenerateCommand();
                case "encode" -> handleEncodeCommand();
                case "gethttp" -> handleGetHttpCommand();
                case "gitrep" -> handleGitRepCommand();
                case "change" -> handleModeChangeCommand();
            }
        }
    }

    private void handleModeChangeCommand() {
        new SetUpMode().setUpMode();
        Menu();
    }

    private void handleIpCommand() {
        new GetIp().getIp();
        Menu();
    }

    private void handleCheckCommand() {
        new CheckFilesAndDirectory().allCheck();
        Menu();
    }

    private void handleGenerateCommand() {
        new PlainCodeGenerator().start();
        Menu();
    }

    private void handleEncodeCommand() {
        new StringEncoder().encode();
        Menu();
    }

    private void handleGetHttpCommand() {
        new GetResponseStatusFromLink().getResponseStatus();
        Menu();
    }

    private void handleGitRepCommand() {
        new DownloadRepository().start();
    }
}
