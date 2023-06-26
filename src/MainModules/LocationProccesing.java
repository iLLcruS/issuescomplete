package MainModules;

import Modules.GetIp;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class LocationProccesing {
    public String getAllLocation()
    {
        URL Service = null;
        try {
            Service = new URL("https://api.ipgeolocation.io/ipgeo?apiKey=583d4503077b4109bbacef872b83c879&ip=" + new GetIp().getIp());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        BufferedReader in;
        try {
            in = new BufferedReader(new InputStreamReader(
                    Service.openStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String Location;
        try {
            Location = in.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return Location;
    }

    public String getCity() {
        Object obj;
        try{
            obj = new JSONParser().parse(getAllLocation());
        }catch (ParseException e) {
            throw new RuntimeException(e);
        }

        JSONObject LocationJson = (JSONObject) obj;
        return (String) LocationJson.get("city");

    }

}
