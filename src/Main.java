import MainModules.SystemModules.AllProcessInfo;
import Modules.AllChecks.CheckFilesAndDirectory;
import Modules.AllChecks.CheckSession;
import Modules.Logger;
import Modules.VisualForConsole.ChangeConsoleColor;
import Modules.VisualForConsole.Visual;

import static java.lang.System.out;

public class Main{
    public static void main(String[] args){
        new CheckFilesAndDirectory().allCheck();
        new Logger().logWriter();
        new ChangeConsoleColor().setRedColor();
        new Visual().printMsgWithProgressBar("Loading", 25, 60);
        new ChangeConsoleColor().setGreenColor();
        out.println("\nHello! Its a Issue Program\n ");
        new CheckSession().checkSession();
    }

}