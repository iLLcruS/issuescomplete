package Utils;

import lombok.Getter;
import lombok.Setter;
import modeuser.mmUserMode.MenuUserMode;
import modeuser.mmUserMode.mmUser;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@Getter
@Setter
public class Variable {

    protected double firstNumber;

    protected int numberOneForSubstring;

    protected double secondNumber;

    protected char charOne;

    protected char charTwo;

    protected double result;

    protected String userSentenceAppend;

    protected String userSentence;

    protected int numberTwoForSubstring;

    public String nameProperty = System.getProperty("user.name");

    public static Scanner scanner = new Scanner(System.in);

    protected static mmUser mm = new mmUser();

    @Getter
    protected static int enterChooseNumber;

    public static void setEnterChooseNumber(int enterChooseNumber) {
        Variable.enterChooseNumber = enterChooseNumber;
    }

    public static void setChooseAction(String chooseAction) {
        Variable.chooseAction = chooseAction;
    }

    public static String getChooseAction() {
        return chooseAction;
    }

    protected static String chooseAction = "";

}
