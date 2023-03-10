package MainModules;

import AbstractClasses.CalculateAbs;
import java.util.Scanner;

public class Calculator extends CalculateAbs {

    public void calculator() {

        System.out.println("How many mathematical operations do you need to perform?");
        int countRepeat = scanner.nextInt();
        if (countRepeat > 20) {
            System.out.println("Sorry, many operations.");
            calculator();
        } else {
            for (int i = 0; i < countRepeat; i++) {

                System.out.print("Enter first num: ");
                firstNumber = scanner.nextDouble();

                System.out.print("Enter second numb: ");
                secondNumber = scanner.nextDouble();


                System.out.print("Enter an available operator (+, -, *, /) : ");

                char operator = scanner.next().charAt(0);


                switch (operator) {
                    case '+':
                        result = firstNumber + secondNumber;
                        setResult(result);
                        break;
                    case '-':
                        result = firstNumber - secondNumber;
                        setResult(result);
                        break;
                    case '*':
                        result = firstNumber * secondNumber;
                        setResult(result);
                        break;
                    case '/':
                        result = firstNumber / secondNumber;
                        setResult(result);
                        break;
                    default:
                        System.out.println("Invalid operator.");
                        mm.Menu();
                        return;
                }
                System.out.println("Result: " + result);
            }
        }
        System.out.println("Do you want to back Main Menu?(1 - yes; 2 - no)");
        setEnterChooseNumber(scanner.nextInt());
        if (enterChooseNumber == 1) {
            mm.Menu();
        } else if (enterChooseNumber == 2) {
            calculator();
        }
    }
}





