import java.util.Scanner;

public class StringProcessing {

    public static void substringString(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input your sentence: ");
        String userSentence = scanner.nextLine();
        System.out.println("Input the first number: ");
        int numberOneForSubstring = scanner.nextInt();
        System.out.println("Input the second number: ");
        int numberTwoForSubstring = scanner.nextInt();

        System.out.println("Your final sentence is: ");
        System.out.println(userSentence.substring(numberOneForSubstring,numberTwoForSubstring));
    }
}
