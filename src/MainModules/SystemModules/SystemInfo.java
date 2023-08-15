package MainModules.SystemModules;

import DataPackage.Variable;

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
        out.println("Version: " + getOSVersion());
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
        getSystemVersion();
    }
}
