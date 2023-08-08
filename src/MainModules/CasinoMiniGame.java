package MainModules;

import Modules.AllChecks.CheckFilesAndDirectory;
import Modules.AllChecks.Checks;
import Modules.AllChecks.ConfigAPI;
import com.sun.source.tree.WhileLoopTree;
import lombok.SneakyThrows;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Date;
import java.util.Scanner;

public class CasinoMiniGame
{
    double balance;
    boolean game = true;
    private final String pathToSessionFile = "./session/accountSession.json";

    public void initialize()
    {
        JSONParser parser = new JSONParser();
        Reader reader = null;
        try {
            reader = new FileReader(pathToSessionFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        Object jsonObj = null;
        try {
            jsonObj = parser.parse(reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        JSONObject jsonObject = (JSONObject) jsonObj;


        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(ConfigAPI.API_LINK + "/account/games/casino/score/get?score=" + this.balance + "&UUID=" + jsonObject.get("token")))
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            this.balance = Double.parseDouble(response.body());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public void main()
    {
        this.initialize();
        this.greetings();
        while (game)
        {
            play();
        }

    }
    @SneakyThrows
    public void play()
    {
        System.out.println("\nYour current balance: " + balance +"$");
        float bet = this.getBet();
        if (bet > balance) {
            System.out.print("Sorry your bet is incorrect! Try again!" );
            return;
        }
        int coefficient = this.getCoefficient();
        if (coefficient > 99) {
            System.out.print("Sorry your coefficient is incorrect! Try again!" );
            return;
        }
        if (this.startMakingOrLosingMoney(bet,coefficient))
        {
            double win = balance - bet * 2;
            System.out.println("Congratulations you win " + win + "$");
        }
        else{
            System.out.println("Unfortunately you lost!");
        }
        System.out.print("Want continue? (Yes): ");
        //Getting answer ^_^
        this.game = needContinue();
        //Saving
        new Thread(()->
        {
            JSONParser parser = new JSONParser();
            File file = new File(pathToSessionFile);

            Reader reader = null;
            try {
                reader = new FileReader(file);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

            Object jsonObj = null;
            try {
                jsonObj = parser.parse(reader);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }

            JSONObject jsonObject = (JSONObject) jsonObj;



            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(ConfigAPI.API_LINK + "/account/games/casino/score/set?score=" + this.balance + "&UUID=" + jsonObject.get("token")))
                    .POST(HttpRequest.BodyPublishers.noBody())
                    .build();
            try {
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

    }
    private boolean needContinue()
    {
        return new Scanner(System.in).next().equalsIgnoreCase("yes");
    }

    private void greetings()
    {
        JSONParser parser = new JSONParser();
        Reader reader = null;
        try {
            reader = new FileReader(pathToSessionFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        Object jsonObj = null;
        try {
            jsonObj = parser.parse(reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        JSONObject jsonObject = (JSONObject) jsonObj;

        System.out.println("Hello dear " + jsonObject.get("username"));
        System.out.println("Welcome to our casino!\nWhich bet you wand do?");
    }
    private float getBet()
    {
        System.out.print("Enter your bet: ");
        return new Scanner(System.in).nextFloat();
    }
    private int getCoefficient()
    {
        System.out.print("Enter coefficient: ");
        return new Scanner(System.in).nextInt();
    }

    private boolean startMakingOrLosingMoney(float bet, float coefficient) {
        int chance = 100;
        chance = Math.round(chance / coefficient);


        int randomValue = (int) (Math.random() * 100) + 1;

        if (randomValue <= chance) {

            float profit = bet * coefficient - bet;
            balance += profit;
            return true;


        } else {

            float loss = -bet;
            balance += loss;
            return false;
        }
    }


}
