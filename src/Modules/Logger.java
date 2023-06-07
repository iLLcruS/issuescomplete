package Modules;

import DataPackage.VariableChooses;
import MainModules.MainMenu;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

public class Logger {

    private final String pathSessionLogFile = "./logs/log.txt";

    private final String pathCommandsLogFile = "./logs/commandsLog.txt";

   public String logLogin(){
       Date date = new Date();
        return "[Name: " + new MainMenu().nameProperty +"]" + "[IP: " + new GetIp().getIp() + "]" + "[Date: " + date + "]";
   }

   public String logCommand(String method){
       Date date = new Date();
        return "[Name: " + new MainMenu().nameProperty +"]" + "[Command: " + method + "]" + "[Date: " + date + "]";
   }

    public void commandLoggerWriter(String command){
        try {
            FileWriter file = new FileWriter(pathCommandsLogFile, true);
            file.append(logCommand(command) + "\n");
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void LogSubMethod(String method)
    {
        try {

            FileWriter file = new FileWriter(pathCommandsLogFile, true);
            Date date = new Date();
            file.append("[Name: " + new MainMenu().nameProperty +"]" + "[Subcommand: " + method + "]" + "[Date: " + date + "]");
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

   public void logWriter(){
       try {
           FileWriter file = new FileWriter(pathSessionLogFile, true);
           file.append(logLogin() + "\n");
           file.close();
       } catch (IOException e) {
           throw new RuntimeException(e);
       }
   }


}
