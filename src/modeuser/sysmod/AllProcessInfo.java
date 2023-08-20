package modeuser.sysmod;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AllProcessInfo {
    public void giveAllProcess() {
        try {
            String os = System.getProperty("os.name").toLowerCase();
            String line;
            Process p;
            if (os.contains("win")) {
                p = Runtime.getRuntime().exec("tasklist ");
            } else {
                p = Runtime.getRuntime().exec("ps -e");
            }
            BufferedReader input =
                    new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((line = input.readLine()) != null) {
                System.out.println(line); //<-- Parse data here.
            }
            input.close();
        } catch (Exception err) {
            err.printStackTrace();
        }
    }
}
