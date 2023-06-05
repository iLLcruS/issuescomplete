import Modules.CheckFilesAndDirectory;
import Modules.Checks;
import Modules.Logger;
import Modules.Visual;

public class Main{
    public static void main(String[] args) {
        new Logger().logWriter();
        new CheckFilesAndDirectory().allCheck();
        new Visual().printMsgWithProgressBar("Loading", 25, 60);
        System.out.println("\nHello! Its a Issue Program\n ");

        new Checks().checkPassword();

    }
}