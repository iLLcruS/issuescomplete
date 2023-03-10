package MainModules;

import DataPackage.VariableChooses;

public class SystemInfo extends VariableChooses {
    private static void getSystemVersion() {
        if (isWindows()) {
            System.out.println("This is Windows");
            System.out.println("It's version is: " + getOSVerion());
        } else if (isMac()) {
            System.out.println("This is Macintosh");
            System.out.println("It's version is: " + getOSVerion());
        } else if (isUnix()) {
            System.out.println("This is Unix or Linux OS");
            System.out.println("It's version is: " + getOSVerion());
        } else {
            System.out.println("This is unknown OS");
        }
        System.out.println("Version: " + getOSVerion());
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
    public void getSystemInfo() {
        getSystemVersion();
        mm.Menu();
    }
}
