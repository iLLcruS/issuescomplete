package MainModules;

import DataPackage.Variable;
import org.json.simple.parser.ParseException;

import static java.lang.System.out;


public class SystemInfo extends Variable {
    private static void getSystemVersion() {
        if (isWindows()) {
            out.println("This is Windows");
            out.println("It's version is: " + getOSVerion());
        } else if (isMac()) {
            out.println("This is Macintosh");
            out.println("It's version is: " + getOSVerion());
        } else if (isUnix()) {
            out.println("This is Unix or Linux OS");
            out.println("It's version is: " + getOSVerion());
        } else {
            out.println("This is unknown OS");
        }
        out.println("Version: " + getOSVerion());
    }

    private static boolean isWindows() {
        String os = System.getProperty("os.name").toLowerCase();
        return (os.indexOf("win") >= 0);
    }

    private static boolean isMac() {
        String os = System.getProperty("os.name").toLowerCase();
        return (os.indexOf("mac") >= 0);
    }

    private static boolean isUnix() {
        String os = System.getProperty("os.name").toLowerCase();
        return (os.indexOf("nix") >= 0 || os.indexOf("nux") >= 0);
    }

    private static String getOSVerion() {
        String os = System.getProperty("os.version");
        return os;
    }
    public void getSystemInfo() throws ParseException {
        getSystemVersion();
        mm.Menu();
    }
}
