package Modules.AllChecks;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static java.lang.System.out;

public class CheckFilesAndDirectory {
    private final String pathSessionFile = "./session/session.json";
    private final String pathLogFile = "./logs/log.txt";
    public String getPathLogFile() {
        return pathLogFile;
    }
    private final String pathSessionDir = "./session";
    private final String pathLogDir = "./logs";
    public String getPathCommandsLogFile() {
        return pathCommandsLogFile;
    }

    private final String pathCommandsLogFile = "./logs/commandsLog.txt";

    private void checkSessionFile(){
        File sessionFile = new File(pathSessionFile);
        if(!sessionFile.exists()){
            out.println("File with session not exists!");
            try {
                FileWriter file = new FileWriter(pathSessionFile);
                file.write(" ");
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            out.println("File created!");
        }
    }

    private void checkCommandsFile()
    {
        File sessionFile = new File(pathCommandsLogFile);
        if(!sessionFile.exists()){
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
                throw new RuntimeException(e);
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
        File logsDir = new File(pathLogDir);
        if(!logsDir.exists()){
            out.println("Logs directory has been deleted. Create new...");
            logsDir.mkdir();
            out.println("File created!");
        }
    }

    public void allCheck(){
        checkDirectoryLog();
        checkLogsFile();
        checkSessionFile();
        checkDirectorySession();
        checkCommandsFile();
    }
}
