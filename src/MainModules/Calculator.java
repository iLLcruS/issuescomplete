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

    @Override
    public double discriminant(double a, double b, double c) {
        return b * b - 4 * a * c;
    }

    @Override
    public double x1(double dis, double a, double b) {
        return (-b - Math.sqrt(dis)) / (2 * a);
    }

    @Override
    public double x2(double dis, double a, double b) {
        return (-b + Math.sqrt(dis)) / (2 * a);
    }

    @Override
    public double x(double b, double a) {
        return -b / (2 * a);
    }

    @Override
    public void disc() {

        out.println("Enter a value: ");
        double a = scanner.nextDouble();

        out.println("Enter b value: ");
        double b = scanner.nextDouble();

        out.println("Enter c value: ");
        double c = scanner.nextDouble();

        double disc = discriminant(a, b, c);
        if (disc > 0) {
            double x1 = x1(disc, a, b);
            double x2 = x2(disc, a, b);
            out.println("The equation has 2 roots");
            out.println("D = " + disc);
            out.println("x1= " + x1);
            out.println("x2= " + x2);
            new MainMenu().Menu();
        } else if (disc == 0) {
            double x = x(b, a);
            out.println("The equation has 1 roots");
            out.println("D = " + disc);
            out.println("x= " + x);
            new MainMenu().Menu();
        } else if (disc < 0) {
            out.println("The equation has 0 roots ");
            new MainMenu().Menu();
        }
    }
}














