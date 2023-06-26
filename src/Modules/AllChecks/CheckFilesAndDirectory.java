package Modules.AllChecks;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static java.lang.System.out;

public class CheckFilesAndDirectory {
    public String getPathSessionFile() {
        return pathSessionFile;
    }

    private final String pathSessionFile = "./session/session.json";
    private final String pathLogFile = "./logs/log.txt";
    public String getPathLogFile() {
        return pathLogFile;
    }
    private final String pathSessionDir = "./session";
    private final String pathNameFile = "./session/name.txt";
    private final String pathLogDir = "./logs";
    private final String pathCommandDir = "./command";
    private final String pathCommandFile = "./command/availableCommand.txt";
    public String getPathCommandsLogFile() {
        return pathCommandsLogFile;
    }

    private final String pathCommandsLogFile = "./logs/commandsLog.txt";

    private void checkSessionFile()
    {
        File sessionFile = new File(pathSessionFile);
        if(!sessionFile.exists()){
            out.println("File with session not exists!");
            try {
                FileWriter file = new FileWriter(pathSessionFile);
                file.write("");
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            out.println("File created!");
        }
    }
    private void checkNameFile()
    {
        File sessionFile = new File(pathNameFile);
        if(!sessionFile.exists()){
            out.println("File with name not exists!");
            try {
                FileWriter file = new FileWriter(pathNameFile);
                file.write(System.getProperty("user.name"));
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            out.println("File created!");
        }
    }
    private void checkCommandLogFile()
    {
        File commandsFile = new File(pathCommandsLogFile);
        if(!commandsFile.exists()){
            out.println("File with session not exists!");
            try {
                FileWriter file = new FileWriter(pathCommandsLogFile);
                file.write(" ");
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            out.println("File created!");
        }
    }

    private void checkLogsFile(){
        File logsFile = new File(pathLogFile);
        if(!logsFile.exists()){
            out.println("File with logs not exists! Create new...");
            try {
                logsFile.createNewFile();
            } catch (IOException e) {
               out.println("Creating file...");
            }
            out.println("File created!");
        }
    }

    private void checkDirectorySession(){
        File sessionDir = new File(pathSessionDir);
        if(!sessionDir.exists()){
            out.println("Session directory has been deleted. Create new...");
            sessionDir.mkdir();
            out.println("File created!");
        }
    }

    private void checkDirectoryLog(){
        File logsDir = new File(pathCommandDir);
        if(!logsDir.exists()){
            out.println("Logs directory has been deleted. Create new...");
            logsDir.mkdir();
            out.println("File created!");
        }
    }

    private void checkDirectoryCommand(){
        File commandDir = new File(pathLogDir);
        if(!commandDir.exists()){
            out.println("Directory with Command has been deleted. Create new...");
            commandDir.mkdir();
            out.println("File created!");
        }
    }

    private void checkCommandFile(){
        File commandFile = new File(pathCommandFile);
        if(!commandFile.exists()){
            out.println("Command file has been deleted. Create new...");
            try {
                commandFile.createNewFile();
            } catch (IOException e) {
                out.println("Creating file...");
            }
            out.println("File created!");
        }
    }

    public void allCheck(){
        checkDirectoryLog();
        checkLogsFile();
        checkSessionFile();
        checkDirectorySession();
        checkDirectoryCommand();
        checkCommandFile();
        checkCommandLogFile();
        checkNameFile();

    }
}
