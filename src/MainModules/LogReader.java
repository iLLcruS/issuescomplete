package MainModules;

import Modules.CheckFilesAndDirectory;

import java.io.*;

public class LogReader {
    public void logSessionReader() throws IOException {
        File f = new File(new CheckFilesAndDirectory().getPathLogFile());
        BufferedReader fin = new BufferedReader(new FileReader(f));
        String line;
        while ((line = fin.readLine()) != null) System.out.println(line);
    }
    public void logCommandReader() throws IOException{
        File file = new File(new CheckFilesAndDirectory().getPathCommandsLogFile());
        BufferedReader fin = new BufferedReader(new FileReader(file));
        String line;
        while ((line = fin.readLine()) != null) System.out.println(line);
    }
    public void allLogReader() throws IOException{
        logCommandReader();
        logSessionReader();
    }
}
