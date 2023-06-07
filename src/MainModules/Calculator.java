package MainModules;


import MainModules.AbstractClasses.CalculateAbs;

import java.util.Scanner;

import static java.lang.System.out;

public  class Calculator extends CalculateAbs {

    public double sum(double x, double y){
        return x + y;
    }
    public void sumComplete(){
        Scanner scanner = new Scanner(System.in);

        out.println("Enter your first number: ");
        setFirstNumber(scanner.nextDouble());

        out.println("Enter your second number: ");
        setSecondNumber(scanner.nextDouble());

        out.println("Sum: " + sum(getFirstNumber(), getSecondNumber()));
        new MainMenu().Menu();
    }
}







