package Modules;

import MainModules.MainMenu;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

public class Logger {

    private final String pathLogFile = "./logs/log.txt";

   public String logLogin(){
       Date date = new Date();
        return "[Name: " + new MainMenu().nameProperty +"]" + "[IP: " + new GetIp().getIp() + "]" + "[Date: " + date + "]";
   }
   /*public String logCommand(){

   }*/
   public void logWriter(){
       try {
           FileWriter file = new FileWriter(pathLogFile, true);
           file.append(logLogin() + "\n");
           file.close();
       } catch (IOException e) {
           throw new RuntimeException(e);
       }
   }

}
