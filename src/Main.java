import Modules.AllChecks.CheckFilesAndDirectory;
import Modules.AllChecks.Checks;
import Modules.Logger;
import Modules.Visual;

import static java.lang.System.out;

public class Main{
    public static void main(String[] args) {
        new Logger().logWriter();
        new CheckFilesAndDirectory().allCheck();
        new Visual().printMsgWithProgressBar("Loading", 25, 60);
        out.println("\nHello! Its a Issue Program\n ");
        new Checks().checkPassword();

    }
}