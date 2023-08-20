package modeuser.usermod;

import lombok.SneakyThrows;

import java.util.Random;
import java.util.Scanner;
import java.util.stream.Stream;

public class PasswordGenerator {

    @SneakyThrows
    public void generatePassword()
    {
        System.out.print("Enter count of password characters: ");
        Scanner scanner = new Scanner(System.in);
        int attempts = scanner.nextInt();
        StringBuilder builder = new StringBuilder();
        Stream.generate(() -> "*").limit(attempts).forEach(builder::append);

        System.out.println("Your new password below.\n");

        for (int i = 0; i <= attempts; i++)
        {
            int random = new Random().nextInt(1, generateAllowedCharacters().length);
            String selected = String.valueOf(generateAllowedCharacters()[random]);
            builder.replace(i, i+1, selected);
            String changed = "\r"+builder;
            System.out.print(changed);
            Thread.sleep(200);
        }
        System.out.println();


    }

    public static char[] generateAllowedCharacters() {
        StringBuilder allowedChars = new StringBuilder();

        for (char c = 'A'; c <= 'Z'; c++) {
            allowedChars.append(c);
        }
        for (char c = 'a'; c <= 'z'; c++) {
            allowedChars.append(c);
        }


        for (char c = '0'; c <= '9'; c++) {
            allowedChars.append(c);
        }


        String specialCharacters = "!-_.";
        allowedChars.append(specialCharacters);

        return allowedChars.toString().toCharArray();
    }
}
