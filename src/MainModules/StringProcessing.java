package MainModules;

import AbstractClasses.StringProcessingAbs;
import DataPackage.VariableChooses;
import Modules.Logger;

import java.lang.System;

import java.util.Scanner;

import static java.lang.System.out;

public class StringProcessing extends StringProcessingAbs {
    StringBuilder str = new StringBuilder();

    public void substringString() {
        out.println("Input your sentence: ");
        setUserSentence(scanner.next());

        out.println("Input the first number: ");
        setNumberOneForSubstring(scanner.nextInt());

        out.println("Input the second number: ");
        setNumberTwoForSubstring(scanner.nextInt());

        out.println("Your final sentence is: ");
        out.println(userSentence.substring(numberOneForSubstring, numberTwoForSubstring));

        out.println("Do you want to back Main Menu?(1 - yes; 2 - no)");
        setEnterChooseNumber(scanner.nextInt());
        if (enterChooseNumber == 1) {
            mm.Menu();
        } else if (VariableChooses.enterChooseNumber == 2) {
            substringString();
        }
    }

    public void appendString() {


        out.println("Enter Your Start Sentence: ");
        setUserSentence(scanner.next());

        out.println(getUserSentence() + "- it is your sentence.");
        str.append(getUserSentence() + " ");
        out.println("Enter Your Sentence which you want to add: ");

        setUserSentenceAppend(scanner.next());

        str.append(getUserSentenceAppend());

        out.println(str + "- it is your new sentence.");

        out.println("Do you want to back Main Menu?(1 - yes; 2 - no)");

        setEnterChooseNumber(scanner.nextInt());
        if (enterChooseNumber == 1) {
            mm.Menu();
        } else if (VariableChooses.enterChooseNumber == 2) {
            appendString();
        }

    }

    public void toLowerCaseString()
    {
        out.println("Enter your sentence: ");
        setUserSentence(scanner.next());
        out.println("---------------------------------------");
        out.println("You're sentence: \n" + getUserSentence() + "\nResult: \n" + getUserSentence().toLowerCase());
        out.println("---------------------------------------");
        out.println("Do you want to back Main Menu?(1 - yes; 2 - no)");

        setEnterChooseNumber(scanner.nextInt());
        if (enterChooseNumber == 1) {
            mm.Menu();
        } else if (VariableChooses.enterChooseNumber == 2) {
            toLowerCaseString();
        }
    }
    public void toUpperCaseString()
    {
        out.println("Enter your sentence: ");
        setUserSentence(scanner.next());
        out.println("---------------------------------------");
        out.println("You're sentence: \n" + getUserSentence() + "\nResult: \n" + getUserSentence().toUpperCase());
        out.println("---------------------------------------");
        out.println("Do you want to back Main Menu?(1 - yes; 2 - no)");

        setEnterChooseNumber(scanner.nextInt());
        if (enterChooseNumber == 1) {
            mm.Menu();
        } else if (VariableChooses.enterChooseNumber == 2) {
            toLowerCaseString();
        }
    }

}
