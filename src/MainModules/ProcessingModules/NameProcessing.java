package MainModules.ProcessingModules;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class NameProcessing {
    private String path = "./session/name.txt";

    public File getFileWithName()
    {
        return new File(path);
    }

    public String getCurrentName() throws FileNotFoundException {
        Scanner scan = new Scanner(getFileWithName());
        return scan.nextLine();
    }
    public void SetNewName() throws IOException {
        FileWriter fileName = new FileWriter(getFileWithName(), false);

        Scanner scan = new Scanner(System.in);
        fileName.write(scan.nextLine());
        fileName.close();
    }
}
