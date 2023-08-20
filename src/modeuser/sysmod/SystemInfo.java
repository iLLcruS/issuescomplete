package modeuser.sysmod;

import Utils.Variable;
import Utils.VisualForConsole.ChangeConsoleColor;
import Utils.VisualForConsole.Visual;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static java.lang.System.out;


public class SystemInfo extends Variable {
    private static void getSystemVersion() {

        if (isWindows()) {
            out.println("This is Windows");
            out.println("It's version is: " + getOSVersion());
        } else if (isMac()) {
            out.println("This is Macintosh");
            out.println("It's version is: " + getOSVersion());
        } else if (isUnix()) {
            out.println("This is Unix or Linux OS");
            out.println("It's version is: " + getOSVersion());
        } else {
            out.println("This is unknown OS");
        }
    }

    private static boolean isWindows() {
        String os = System.getProperty("os.name").toLowerCase();
        return (os.contains("win"));
    }

    private static boolean isMac() {
        String os = System.getProperty("os.name").toLowerCase();
        return (os.contains("mac"));
    }

    private static boolean isUnix() {
        String os = System.getProperty("os.name").toLowerCase();
        return (os.contains("nix") || os.contains("nux"));
    }

    private static String getOSVersion() {
        return System.getProperty("os.version");
    }
    public void getSystemInfo() {
        new Visual().printMsgWithSeparator(25, 25);
        new ChangeConsoleColor().setCeruleanColor();
        getSystemVersion();
        getCPUInfo();
        getHDDInfo();
        new ChangeConsoleColor().setGreenColor();
        new Visual().printMsgWithSeparator(25, 25);
    }

    private static void getCPUInfo(){

        if(isMac()){
            try {
                String line;
                Process p = Runtime.getRuntime().exec("sysctl -n machdep.cpu.brand_string");
                BufferedReader input =
                        new BufferedReader(new InputStreamReader(p.getInputStream()));
                while ((line = input.readLine()) != null) {
                    System.out.println("CPU Model: " + line);
                    System.out.println("Available processors (cores): " + Runtime.getRuntime().availableProcessors());
                }
                input.close();
            } catch (Exception err) {
                err.printStackTrace();
            }
        }
    }
    private static void getHDDInfo(){
        if(isMac()){
            try {
                String line;
                Process p = Runtime.getRuntime().exec("sysctl -n hw.physmem");
                BufferedReader input =
                        new BufferedReader(new InputStreamReader(p.getInputStream()));
                while ((line = input.readLine()) != null) {
                    System.out.println(line);
                }
                input.close();
            } catch (Exception err) {
                err.printStackTrace();
            }
        }
    }
}
