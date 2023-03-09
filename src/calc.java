import java.util.Scanner;

public class calc {
    public void negr() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first num: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter second numb: ");
        double num2 = scanner.nextDouble();

        System.out.print("Enter an operator (+, OR  -, OR *, OR /): ");
        char operator = scanner.next().charAt(0);
        double result = 0.0;

                switch (operator){
                    case '+':
                result = num1 + num2;
                        break;

                    case '-':
                result = num1 - num2;
                        break;

                    case '*':
                            result = num1 * num2;
                                    break;

                    case '/':
                            result = num1 / num2;
                        break;
                    default:
                        System.out.println("Invalid operator.");
                        return;
                }

        System.out.println(num1 + " " + operator + " " + num2 + " = " + result);
    }
}





