package MainModules;

import AbstractClasses.StringProcessingAbs;
import DataPackage.VariableChooses;

import java.util.Scanner;
public class StringProcessing extends StringProcessingAbs {
    public void substringString(){
        System.out.println("Input your sentence: ");
        setUserSentence(scanner.next());

        System.out.println("Input the first number: ");
        setNumberOneForSubstring(scanner.nextInt());

        System.out.println("Input the second number: ");
        setNumberTwoForSubstring(scanner.nextInt());

        System.out.println("Your final sentence is: ");
        System.out.println(userSentence.substring(numberOneForSubstring, numberTwoForSubstring));

        System.out.println("Do you want to back Main Menu?(1 - yes; 2 - no)");
        setEnterChooseNumber(scanner.nextInt());
        if (enterChooseNumber == 1) {
            mm.Menu();
        } else if (VariableChooses.enterChooseNumber == 2) {
            substringString();
        }
    }

}
