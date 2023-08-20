import Utils.AllChecks.CheckFilesAndDirectory;
import modeutils.ModeCheckFile;
import Utils.AllChecks.Session;
import Utils.VisualForConsole.ChangeConsoleColor;
import Utils.VisualForConsole.Visual;
import modeuser.mmUserMode.MenuUserMode;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {
        new CheckFilesAndDirectory().allCheck();
        new ChangeConsoleColor().setRedColor();
        new Visual().printMessage("Loading...");
        new Visual().printMsgWithProgressBar("", 25, 60);
        new ChangeConsoleColor().setGreenColor();
        new ModeCheckFile().checkMode();
        out.println("\nHello! Its a Issue Program\n ");
       // new Session().start();
    }
}