import Modules.AllChecks.CheckFilesAndDirectory;
import Modules.AllChecks.CheckSession;
import Modules.AllChecks.Checks;
import Modules.JsonSession;
import Modules.Logger;
import Modules.Visual;

import static java.lang.System.out;

public class Main{
    public static void main(String[] args){
        new CheckFilesAndDirectory().allCheck();
        new Logger().logWriter();
        new Visual().printMsgWithProgressBar("Loading", 25, 60);
        out.println("\nHello! Its a Issue Program\n ");
        new CheckSession().checkSession();
    }

}