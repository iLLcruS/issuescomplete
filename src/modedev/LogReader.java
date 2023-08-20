package modedev;

import Utils.AllChecks.CheckFilesAndDirectory;

import java.io.*;
public class LogReader {

    public void logCommandReader() throws IOException{
        File file = new File(new CheckFilesAndDirectory().pathsToCheckFiles[2]);
        BufferedReader fin = new BufferedReader(new FileReader(file));
        String line;
        while ((line = fin.readLine()) != null) System.out.println(line);
    }

    public void allLogReader() throws IOException{
        logCommandReader();
    }
}
