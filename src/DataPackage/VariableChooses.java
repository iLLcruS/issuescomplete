package DataPackage;

import java.util.Scanner;
import MainModules.MainMenu;

public class VariableChooses {
    protected Scanner scanner = new Scanner(System.in);
    protected static MainMenu mm = new MainMenu();

    protected static int enterChooseNumber;
    public static int getEnterChooseNumber() {
        return enterChooseNumber;
    }

    public static void setEnterChooseNumber(int enterChooseNumber) {
        VariableChooses.enterChooseNumber = enterChooseNumber;
    }

    protected static String chooseAction = "";
    public static String getChooseAction() {
        return chooseAction;
    }
    public static void setChooseAction(String chooseAction) {
        VariableChooses.chooseAction = chooseAction;
    }
}
