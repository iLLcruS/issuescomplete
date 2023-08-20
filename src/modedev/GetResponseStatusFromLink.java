package modedev;
import Utils.VisualForConsole.ChangeConsoleColor;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

import static Utils.Variable.getChooseAction;
import static Utils.Variable.setChooseAction;

public class GetResponseStatusFromLink {
    private final Scanner scanner = new Scanner(System.in);
    public void getResponseStatus()
    {
        new ChangeConsoleColor().setYellowColor();
        System.out.print("Enter link: ");
        setChooseAction(scanner.nextLine());
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(getChooseAction()))
                .GET()
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            new ChangeConsoleColor().setPurpleColor();
            System.out.println("Response status: " + "[" + response.statusCode() + "]");
            new ChangeConsoleColor().setGreenColor();
        } catch (IOException e) {
            new ChangeConsoleColor().setRedColor();
            System.out.println("Link is incorrect.");
            new ChangeConsoleColor().setGreenColor();
        } catch (InterruptedException e) {
            new ChangeConsoleColor().setRedColor();
            System.out.println("Connection time expired.");
            new ChangeConsoleColor().setGreenColor();
        }

    }
}
