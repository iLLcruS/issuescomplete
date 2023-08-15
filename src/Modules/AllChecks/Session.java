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
    private final Scanner scanner = new Scanner(System.in);
    public final String PATH_TO_ACCOUNT_DATA_FILE = "./session/accountSession.json";
    public final String PATH_TO_SESSIONS_FILE = "./session/Sesions.json";

    public void start()
    {

        File file = new File(PATH_TO_ACCOUNT_DATA_FILE);
        if (!file.exists())
        {
            System.out.println("Welcome, type register if you first, if you already have an account type login below");
            System.out.print("Enter command: ");
            String command = scanner.next();
            switch (command.toLowerCase())
            {
                case "register" ->
                {
                    this.register();
                }
                case "login" ->
                {
                    this.login();
                }
            }
        }
        new MainMenu().Menu();

    }
    @SneakyThrows
    public void login()
    {
        File file = new File(PATH_TO_ACCOUNT_DATA_FILE);
        if (!file.exists()) file.createNewFile();
        HashMap<String,String> accountData = getAccountDataForLogin();
        JSONObject accountsData = getAccountsData();
        List<HashMap<String,String>> accountsDataList = (List<HashMap<String,String>>) accountsData.get("accounts");
        for (HashMap<String,String> account : accountsDataList)
        {
            if (account.get("login").equals(accountData.get("login")))
            {
                if (account.get("password").equals(accountData.get("password")))
                {
                    JSONObject obj = new JSONObject();
                    obj.put("token",account.get("token"));
                    obj.put("login",accountData.get("login"));
                    FileWriter fileWriter = new FileWriter(PATH_TO_ACCOUNT_DATA_FILE);
                    FileWriter fileWriter1 = new FileWriter("./session/name.txt");
                    fileWriter1.write((String) obj.get("login"));
                    fileWriter1.flush();
                    fileWriter1.close();
                    fileWriter.write(obj.toJSONString());
                    fileWriter.flush();
                    fileWriter.close();
                    return;
                }
            }
        }
        file.delete();
        System.out.println("Error: username or password is incorrect");
        System.exit(0);

    }

    @SneakyThrows
    public JSONObject getAccountsData()
    {
        JSONParser parser = new JSONParser();
        Reader reader = new FileReader(this.PATH_TO_SESSIONS_FILE);
        return (JSONObject) parser.parse(reader);
    }
    public HashMap<String,String> getAccountDataForLogin()
    {
        System.out.print("Enter your username: ");
        String username = scanner.next();
        System.out.print("Enter your password: ");
        String password = scanner.next();
        HashMap<String,String> accountData = new HashMap<>();
        accountData.put("login",username);
        accountData.put("password",password);
        return accountData;
    }

    public HashMap<String,String> getAccountDataForRegister()
    {
        System.out.print("Enter your username: ");
        String username = scanner.next();
        System.out.print("Enter your password: ");
        String password = scanner.next();
        HashMap<String,String> accountData = new HashMap<>();
        accountData.put("login",username);
        accountData.put("password",password);
        accountData.put("token",UUID.randomUUID().toString());
        return accountData;
    }
    public void register()
    {
        saveRegisteredAccount(getAccountDataForRegister());
    }

    @SneakyThrows
    public void saveRegisteredAccount(HashMap<String,String> accountData)
    {
        JSONObject jsonObject = getAccountsData();

        List<HashMap<String,String>> accountsDataList = (List<HashMap<String,String>>) jsonObject.get("accounts");
        String newRegisteredUsername = accountData.get("login");

        for (HashMap<String,String> accountsData : accountsDataList)
        {
            if (accountsData.get("login").equals(newRegisteredUsername))
            {
                System.out.println("Error: This username is already taken!");
                System.exit(0);
            }
        }

        accountsDataList.add(accountData);
        jsonObject.replace("accounts",accountsDataList);

        FileWriter file = new FileWriter(PATH_TO_SESSIONS_FILE);
        file.write(jsonObject.toJSONString());
        file.flush();
        file.close();
        this.start();
    }
}
