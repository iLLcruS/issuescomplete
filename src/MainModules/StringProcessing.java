package MainModules;

import DataPackage.VariableChooses;

import java.util.Scanner;

public class StringProcessing extends VariableChooses {
    private String userSentence;
    private int numberOneForSubstring;
    private int numberTwoForSubstring;

    public void substringString() {
        System.out.println("Input your sentence: ");
        userSentence = scanner.nextLine();

        System.out.println("Input the first number: ");
        numberOneForSubstring = scanner.nextInt();

        System.out.println("Input the second number: ");
        numberTwoForSubstring = scanner.nextInt();

        System.out.println("Your final sentence is: ");
        System.out.println(userSentence.substring(numberOneForSubstring, numberTwoForSubstring));

        System.out.println("Do you want to back Main Menu?(1 - yes; 2 - no)");
        enterChooseNumber = scanner.nextInt();

        if (enterChooseNumber == 1) {
            mm.Menu();
        } else if (VariableChooses.enterChooseNumber == 2) {
            substringString();
        }
    }
}
