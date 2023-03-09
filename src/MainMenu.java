import java.util.Scanner;

public class MainMenu {
    private String chooseAction = "";
    StringProcessing sp = new StringProcessing();
    Scanner input = new Scanner(System.in);

    public void Menu(){
        System.out.println("Welcome to the program!\n "+
                "Choose your command: ");
        chooseAction = input.nextLine();
        if(chooseAction.contains("string")){
            System.out.println("Available methods for string:\n "+
                    "Substring");
            chooseAction = input.next();
            if(chooseAction.contains("Substring")){
                sp.substringString();
                Menu();
            }
        }
    }
}
