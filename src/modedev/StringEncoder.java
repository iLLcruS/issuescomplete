package modedev;

import Utils.VisualForConsole.ChangeConsoleColor;
import lombok.SneakyThrows;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;
import java.util.Scanner;

import static Utils.Variable.getChooseAction;
import static Utils.Variable.setChooseAction;

public class StringEncoder {
    private final Scanner scanner = new Scanner(System.in);

    public void encode() {
        new ChangeConsoleColor().setPurpleColor();
        System.out.println("Welcome to 'Issue Encoder'!");
        new ChangeConsoleColor().setBlueColor();
        System.out.println("Available encode styles: \n-> 'rot13' \n-> 'base64' \n-> 'hashcode'");
        new ChangeConsoleColor().setYellowColor();
        System.out.print("Enter the encode style: ");
        setChooseAction(scanner.nextLine());
        System.out.print("Enter a text to encode: ");
        String text = scanner.nextLine();
        new ChangeConsoleColor().setCeruleanColor();
        switch (getChooseAction()) {

            case "rot13" -> System.out.println(encodeToRot(text));
            case "base64" -> System.out.println(encodeToBase64(text));
            case "hashcode" -> System.out.println(encodeToHash(text));
            default -> {
                new ChangeConsoleColor().setRedColor();
                System.out.println("This encoding style is not supported!");
            }
        }
        new ChangeConsoleColor().setGreenColor();
    }

    public static String encodeToRot(String text) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if ('a' <= c && c <= 'z') {
                char offset = 'a';
                result.append((char) (((c - offset + 13) % 26) + offset));
            } else if ('A' <= c && c <= 'Z') {
                char offset = 'A';
                result.append((char) (((c - offset + 13) % 26) + offset));
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }

    public static String encodeToBase64(String text) {
        byte[] bytesToEncode = text.getBytes();
        byte[] encodedBytes = Base64.getEncoder().encode(bytesToEncode);
        return new String(encodedBytes);
    }

    @SneakyThrows
    public static String encodeToHash(String text) {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = digest.digest(text.getBytes(StandardCharsets.UTF_8));

        StringBuilder hexString = new StringBuilder();
        for (byte hashByte : hashBytes) {
            String hex = Integer.toHexString(0xff & hashByte);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }

        return hexString.toString();
    }

}
