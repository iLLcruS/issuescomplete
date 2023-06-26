package Modules.AllChecks;

import java.io.*;
import java.util.Iterator;

import MainModules.MainMenu;
import Modules.JsonSession;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import static java.lang.System.out;

public class CheckSession {
    public void checkSession() {
        File file = new File(new CheckFilesAndDirectory().getPathSessionFile());
        BufferedReader fin = null;
        try {
            fin = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        String line;
        while (true) {
            try {
                if (!((line = fin.readLine()) != null)) {
                    if (line == null) {
                        out.println("Session not founded. Re-entering the password.");
                        new Checks().checkPassword();
                    }
                    break;
                } else {
                    out.println("Session founded, your session: \n" + line + "\n");
                    new MainMenu().Menu();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
