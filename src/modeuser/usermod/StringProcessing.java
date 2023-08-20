package modeuser.usermod;

import Utils.Variable;
import Utils.AbstractClasses.StringProcessingAbs;


import static java.lang.System.out;

public class StringProcessing extends StringProcessingAbs {
    StringBuilder str = new StringBuilder();

    @Override
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
        } else if (Variable.enterChooseNumber == 2) {
            substringString();
        }
    }

    @Override
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
        } else if (Variable.enterChooseNumber == 2) {
            appendString();
        }

    }

    @Override
    public void toLowerCaseString() {
        out.println("Enter your sentence: ");
        setUserSentence(scanner.next());
        out.println("---------------------------------------");
        out.println("You're sentence: \n" + getUserSentence() + "\nResult: \n" + getUserSentence().toLowerCase());
        out.println("---------------------------------------");
        out.println("Do you want to back Main Menu?(1 - yes; 2 - no)");

        setEnterChooseNumber(scanner.nextInt());
        if (enterChooseNumber == 1) {
            mm.Menu();
        } else if (Variable.enterChooseNumber == 2) {
            toLowerCaseString();
        }
    }
    @Override
    public void toUpperCaseString() {
        out.println("Enter your sentence: ");
        setUserSentence(scanner.next());
        out.println("---------------------------------------");
        out.println("You're sentence: \n" + getUserSentence() + "\nResult: \n" + getUserSentence().toUpperCase());
        out.println("---------------------------------------");
        out.println("Do you want to back Main Menu?(1 - yes; 2 - no)");

        setEnterChooseNumber(scanner.nextInt());
        if (enterChooseNumber == 1) {
            mm.Menu();
        } else if (Variable.enterChooseNumber == 2) {
            toLowerCaseString();
        }
    }

    @Override
    public void replaceString()
    {
        out.print("Enter your sentence: ");
        setUserSentence(scanner.next());
        out.print("Letter to replace: ");
        setCharOne(scanner.next().charAt(0));
        out.print("Letter for replace: ");
        setCharTwo(scanner.next().charAt(0));
        out.println("---------------------------------------");
        out.println("You're sentence: \n" + getUserSentence() + "\nResult: \n" + getUserSentence().replace(getCharOne(),getCharTwo()));
        out.println("---------------------------------------");
        out.println("Do you want to back Main Menu?(1 - yes; 2 - no)");

    }
}
