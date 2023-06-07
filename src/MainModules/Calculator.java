package MainModules;


import MainModules.AbstractClasses.CalculateAbs;

import java.util.Scanner;

import static java.lang.System.out;

public class Calculator extends CalculateAbs {

    public double sum(double x, double y) {
        return x + y;
    }

    public void sumComplete() {
        Scanner scanner = new Scanner(System.in);

        out.println("Enter your first number: ");
        setFirstNumber(scanner.nextDouble());

        out.println("Enter your second number: ");
        setSecondNumber(scanner.nextDouble());

        out.println("res: " + sum(getFirstNumber(), getSecondNumber()));
        new MainMenu().Menu();
    }

    public double minus(double x, double y) {
        return x - y;
    }

    public void minusComplete() {
        Scanner scanner = new Scanner(System.in);

        out.println("Enter your first number: ");
        setFirstNumber(scanner.nextDouble());

        out.println("Enter your second number: ");
        setSecondNumber(scanner.nextDouble());

        out.println("res: " + minus(getFirstNumber(), getSecondNumber()));
        new MainMenu().Menu();
    }

    public double multiplication(double x, double y) {
        return x * y;
    }

    public void multiplicationComplete() {
        Scanner scanner = new Scanner(System.in);

        out.println("Enter your first number: ");
        setFirstNumber(scanner.nextDouble());

        out.println("Enter your second number: ");
        setSecondNumber(scanner.nextDouble());

        out.println("res: " + multiplication(getFirstNumber(), getSecondNumber()));
        new MainMenu().Menu();
    }

    public double division(double x, double y) {
        return x / y;
    }

    public void divisionComplete() {
        Scanner scanner = new Scanner(System.in);

        out.println("Enter your first number: ");
        setFirstNumber(scanner.nextDouble());

        out.println("Enter your second number: ");
        setSecondNumber(scanner.nextDouble());

        out.println("res: " + division(getFirstNumber(), getSecondNumber()));
        new MainMenu().Menu();
    }

    public double interest(double x, double y) {
        return x % y;
    }

    public void interestComplete() {
        Scanner scanner = new Scanner(System.in);

        out.println("Enter your first number: ");
        setFirstNumber(scanner.nextDouble());

        out.println("Enter your second number: ");
        setSecondNumber(scanner.nextDouble());

        out.println("res: " + interest(getFirstNumber(), getSecondNumber()));
        new MainMenu().Menu();
    }

    public double sqrt(double x) {
        return Math.sqrt(x);
    }

    public void sqrtComplete() {
        Scanner scanner = new Scanner(System.in);

        out.println("Enter your first number: ");
        setFirstNumber(scanner.nextDouble());

        out.println("res: " + sqrt(getFirstNumber()));
        new MainMenu().Menu();
    }

    public double pow(double x, double y) {
        return Math.pow(x, y);

    }

    public void powComplete() {
        Scanner scanner = new Scanner(System.in);

        out.println("Enter your first number: ");
        setFirstNumber(scanner.nextDouble());

        out.println("Enter your second number: ");
        setSecondNumber(scanner.nextDouble());

        out.println("res: " + pow(getFirstNumber(), getSecondNumber()));
        new MainMenu().Menu();
    }
   public double sin(double x) {
        return Math.sin(x);
   }
   public void sinComplete() {
       Scanner scanner = new Scanner(System.in);

       out.println("Enter your first number: ");
       setFirstNumber(scanner.nextDouble());

       out.println("res: " + sin(getFirstNumber()));
       new MainMenu().Menu();
   }
    public double cos(double x) {
        return Math.cos(x);
    }
    public void cosComplete() {
        Scanner scanner = new Scanner(System.in);

        out.println("Enter your first number: ");
        setFirstNumber(scanner.nextDouble());

        out.println("res: " + cos(getFirstNumber()));
        new MainMenu().Menu();
    }
}














