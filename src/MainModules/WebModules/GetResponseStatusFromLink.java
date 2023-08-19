package MainModules.WebModules;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

import static DataPackage.Variable.getChooseAction;
import static DataPackage.Variable.setChooseAction;
public class GetResponseStatusFromLink {
    private final Scanner scanner = new Scanner(System.in);
    public void getResponseStatus()
    {
        System.out.print("Enter link: ");
        setChooseAction(scanner.nextLine());
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(getChooseAction()))
                .GET()
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Response status: " + "[" + response.statusCode() + "]");
        } catch (IOException e) {
            System.out.println("Link is incorrect!");
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
