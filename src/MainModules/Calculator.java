package MainModules;

import DataPackage.VariableChooses;
import java.util.Scanner;

public class Calculator extends VariableChooses {
    private double firstNumber;

    public double getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(double firstNumber) {
        this.firstNumber = firstNumber;
    }

    private double secondNumber;

    public double getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(double secondNumber) {
        this.secondNumber = secondNumber;
    }

    double result;

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

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
                        break;
                    case '-':
                        result = firstNumber - secondNumber;
                        break;
                    case '*':
                        result = firstNumber * secondNumber;
                        break;
                    case '/':
                        result = firstNumber / secondNumber;
                        break;
                    default:
                        System.out.println("Invalid operator.");
                        return;
                }
                System.out.println("Result: " + result);
            }
        }
        System.out.println("Do you want to back Main Menu?(1 - yes; 2 - no)");
        enterChooseNumber = scanner.nextInt();
        if (enterChooseNumber == 1) {
            mm.Menu();
        } else if (enterChooseNumber == 2) {
            calculator();
        }
    }
}




