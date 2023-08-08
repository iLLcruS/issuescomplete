package Modules.AllChecks;

import MainModules.MainMenu;
import lombok.SneakyThrows;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;

public class Session
{
    private Scanner scanner = new Scanner(System.in);
    private final String pathToSessionFile = "./session/accountSession.json";
    private final String API_LINK = ConfigAPI.API_LINK;
    public void start()
    {
        if (checkSessionFile())
        {
            sessionExistScript();
        }
        else
        {
            sessionNotExistScript();
        }
    }
    @SneakyThrows
    private void sessionExistScript()
    {
        Greetings();
    }
    private boolean checkSessionFile()
    {
        return new File(pathToSessionFile).exists();
    }

    @SneakyThrows
    private void sessionNotExistScript()
    {
        System.out.println("If you first type 'Register' in command line" +
                "\nIf you already have an account type 'Login' on command line");
        System.out.print("Enter command: ");
        String command = scanner.next();
        if (command.equalsIgnoreCase("register"))
        {
            HashMap<String,String> data = getData();
            assert data != null;
            String username = data.get("username");
            String password = data.get("password");
            register(password,username);

            Thread thread = new Thread(()->
            {
                createAccountSessionFile(Objects.requireNonNull(login(password, username)),username);
            });
            thread.start();
        }
        else if (command.equalsIgnoreCase("login"))
        {
            HashMap<String,String> data = getData();
            assert data != null;
            String username = data.get("username");
            String password = data.get("password");
            UUID uuid = login(password, username);
            if (uuid == null) return;
            createAccountSessionFile(Objects.requireNonNull(uuid),username);
        }
        Thread.sleep(200);
        Greetings();
    }

    private void Greetings() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        File file = new File(pathToSessionFile);
        Reader reader = new FileReader(file);

        Object jsonObj = parser.parse(reader);

        JSONObject jsonObject = (JSONObject) jsonObj;
        System.out.println("=> Welcome " + jsonObject.get("username") + " to our network" + "<=");
        new MainMenu().Menu();
    }

    @SneakyThrows
    private void createAccountSessionFile(UUID userToken, String userName)
    {
        File file = new File(pathToSessionFile);
        JSONObject obj = new JSONObject();
        obj.put("token", userToken.toString());
        obj.put("username",userName);
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(obj.toJSONString());
        fileWriter.flush();
        fileWriter.close();
    }

    @SneakyThrows
    private UUID login(String password, String username)
    {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.noBody())
                .uri(URI.create(API_LINK + "/account/login?username=" + username + "&password=" + password))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.body().isEmpty())
        {
            System.out.println("Error current user is not created! Or password incorrect!");
            return null;
        }
        return UUID.fromString(response.body());
    }
    @SneakyThrows
    private void register(String password, String username)
    {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.noBody())
                .uri(URI.create(API_LINK + "/account/register?username=" + username + "&password=" + password))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());


    }
    private HashMap<String, String> getData()
    {
        Console console = System.console();
        System.out.print("Enter username: ");
        String userName = scanner.next();
        System.out.print("Enter password: ");
        String password = scanner.next();
        if (password.isEmpty() || userName.isEmpty())
        {
            System.out.println("Password or username cannot be null!");
            return null;
        }
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("password", password);
        hashMap.put("username",userName);
        return hashMap;

    }

}
