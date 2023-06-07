package MainModules;

import AbstractClasses.StringProcessingAbs;
import DataPackage.VariableChooses;
import Modules.Logger;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.System;

import java.util.Scanner;

import static java.lang.System.out;
public class LogsProccesing  {
    public void logClear(String[] pathes) {
        for (String path:pathes) {
            try {
                FileWriter file = new FileWriter(path, false);
                file.write(" ");
                file.close();
            } catch (IOException e) {
                out.println("Error");
            }
        }
        out.println("-------------------");
        out.println("Logs: Logs cleared");
        out.println("-------------------");
        new MainMenu().Menu();
    }
}
