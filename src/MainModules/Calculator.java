package MainModules;


import MainModules.AbstractClasses.CalculateAbs;

import java.util.Scanner;

import static java.lang.System.out;

public class Calculator extends CalculateAbs {
    @Override
    public double sum(double x, double y) {
        return x + y;
    }

    @Override
    public void sumComplete() {
        Scanner scanner = new Scanner(System.in);

        out.println("Enter your first number: ");
        setFirstNumber(scanner.nextDouble());

        out.println("Enter your second number: ");
        setSecondNumber(scanner.nextDouble());

        out.println("res: " + sum(getFirstNumber(), getSecondNumber()));
        new MainMenu().Menu();
    }

    @Override
    public double minus(double x, double y) {
        return x - y;
    }

    @Override
    public void minusComplete() {
        Scanner scanner = new Scanner(System.in);

        out.println("Enter your first number: ");
        setFirstNumber(scanner.nextDouble());

        out.println("Enter your second number: ");
        setSecondNumber(scanner.nextDouble());

        out.println("res: " + minus(getFirstNumber(), getSecondNumber()));
        new MainMenu().Menu();
    }

    @Override
    public double multiplication(double x, double y) {
        return x * y;
    }

    @Override
    public void multiplicationComplete() {
        Scanner scanner = new Scanner(System.in);

        out.println("Enter your first number: ");
        setFirstNumber(scanner.nextDouble());

        out.println("Enter your second number: ");
        setSecondNumber(scanner.nextDouble());

        out.println("res: " + multiplication(getFirstNumber(), getSecondNumber()));
        new MainMenu().Menu();
    }

    @Override
    public double division(double x, double y) {
        return x / y;
    }

    @Override
    public void divisionComplete() {
        Scanner scanner = new Scanner(System.in);

        out.println("Enter your first number: ");
        setFirstNumber(scanner.nextDouble());

        out.println("Enter your second number: ");
        setSecondNumber(scanner.nextDouble());

        out.println("res: " + division(getFirstNumber(), getSecondNumber()));
        new MainMenu().Menu();
    }

    @Override
    public double interest(double x, double y) {
        return x % y;
    }

    @Override
    public void interestComplete() {
        Scanner scanner = new Scanner(System.in);

        out.println("Enter your first number: ");
        setFirstNumber(scanner.nextDouble());

        out.println("Enter your second number: ");
        setSecondNumber(scanner.nextDouble());

        out.println("res: " + interest(getFirstNumber(), getSecondNumber()));
        new MainMenu().Menu();
    }

    @Override
    public double sqrt(double x) {
        return Math.sqrt(x);
    }


    @Override
    public void sqrtComplete() {
        Scanner scanner = new Scanner(System.in);

        out.println("Enter your first number: ");
        setFirstNumber(scanner.nextDouble());

        out.println("res: " + sqrt(getFirstNumber()));
        new MainMenu().Menu();
    }

    public double cbrt(double x) {
        return Math.cbrt(x);
    }

    @Override
    public void cbrtComplete() {
        Scanner scanner = new Scanner(System.in);

        out.println("Enter your first number: ");
        setFirstNumber(scanner.nextDouble());

        out.println("res: " + cbrt(getFirstNumber()));
        new MainMenu().Menu();
    }


    @Override
    public double pow(double x, double y) {
        return Math.pow(x, y);

    }

    @Override
    public void powComplete() {
        Scanner scanner = new Scanner(System.in);

        out.println("Enter your first number: ");
        setFirstNumber(scanner.nextDouble());

        out.println("Enter your second number: ");
        setSecondNumber(scanner.nextDouble());

        out.println("res: " + pow(getFirstNumber(), getSecondNumber()));
        new MainMenu().Menu();
    }

    @Override
    public double sin(double x) {
        return Math.sin(x);
    }

    @Override
    public void sinComplete() {
        Scanner scanner = new Scanner(System.in);

        out.println("Enter your first number: ");
        setFirstNumber(scanner.nextDouble());

        out.println("res: " + sin(getFirstNumber()));
        new MainMenu().Menu();
    }

    @Override
    public double cos(double x) {
        return Math.cos(x);
    }

    @Override
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

    @Override
    public double tan(double x) {
        return Math.tan(x);
    }

    @Override
    public void tanComplete() {
        Scanner scanner = new Scanner(System.in);

        out.println("Enter your first number: ");
        setFirstNumber(scanner.nextDouble());

        out.println("res: " + tan(getFirstNumber()));
        new MainMenu().Menu();
    }

    @Override
    public double[] average() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter count of numbers: ");
        int size = input.nextInt();
        double array[] = new double[size];
        System.out.println("Enter the number:");

        for (int i = 0; i < size; i++) {
            array[i] = input.nextDouble();
        }
        return array;
    }

    @Override
    public void averageComplete() {

        double[] numbers = average();

        double result = 0;
        if (numbers.length > 0) {
            double sum = 0;
            for (int j = 0; j < numbers.length; j++) {
                sum += numbers[j];
            }
            result = sum / numbers.length;
        }
        out.println(result);
    }

    @Override
    public double asin(double x) {
        return Math.asin(x);
    }

    @Override
    public void asinComplete() {
        Scanner scanner = new Scanner(System.in);

        out.println("Enter your first number: ");
        setFirstNumber(scanner.nextDouble());

        out.println("res: " + asin(getFirstNumber()));
        new MainMenu().Menu();
    }

    @Override
    public double acos(double x) {
        return Math.acos(x);
    }

    @Override
    public void acosComplete() {
        Scanner scanner = new Scanner(System.in);

        out.println("Enter your first number: ");
        setFirstNumber(scanner.nextDouble());

        out.println("res: " + acos(getFirstNumber()));
        new MainMenu().Menu();
    }

    @Override
    public double atan(double x) {
        return Math.atan(x);
    }

    @Override
    public void atanComplete() {
        Scanner scanner = new Scanner(System.in);

        out.println("Enter your first number: ");
        setFirstNumber(scanner.nextDouble());

        out.println("res: " + atan(getFirstNumber()));
        new MainMenu().Menu();
    }

    @Override
    public double log(double x) {
        return Math.log(x);
    }

    @Override
    public void logComplete() {
        Scanner scanner = new Scanner(System.in);

        out.println("Enter your first number: ");
        setFirstNumber(scanner.nextDouble());

        out.println("res: " + log(getFirstNumber()));
        new MainMenu().Menu();
    }

    @Override
    public double log10(double x) {
        return Math.log10(x);
    }

    @Override
    public void log10Complete() {
        Scanner scanner = new Scanner(System.in);

        out.println("Enter your first number: ");
        setFirstNumber(scanner.nextDouble());

        out.println("res: " + log10(getFirstNumber()));
        new MainMenu().Menu();
    }
    @Override
    public double sinh(double x) {
        return Math.sinh(x);
    }
    @Override
    public void sinhComplete() {
        Scanner scanner = new Scanner(System.in);

        out.println("Enter your first number: ");
        setFirstNumber(scanner.nextDouble());

        out.println("res: " + sinh(getFirstNumber()));
        new MainMenu().Menu();
    }
    @Override
    public double cosh(double x) {
        return Math.cosh(x);
    }
    @Override
    public void coshComplete() {
        Scanner scanner = new Scanner(System.in);

        out.println("Enter your first number: ");
        setFirstNumber(scanner.nextDouble());

        out.println("res: " + cosh(getFirstNumber()));
        new MainMenu().Menu();
    }
    @Override
    public double tanh(double x) {
        return Math.tanh(x);
    }
    @Override
    public void tanhComplete() {
        Scanner scanner = new Scanner(System.in);

        out.println("Enter your first number: ");
        setFirstNumber(scanner.nextDouble());

        out.println("res: " + tanh(getFirstNumber()));
        new MainMenu().Menu();
    }
}




















