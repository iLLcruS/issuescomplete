import Modules.CheckFilesAndDirectory;
import Modules.Checks;
import Modules.Visual;

public class Main{
    public static void main(String[] args) {
        new Visual().printMsgWithProgressBar("Loading", 25, 60);
        System.out.println("\nHello! Its a Issue Program\n ");
        new CheckFilesAndDirectory().allCheck();
        new Checks().checkPassword();
    }
}