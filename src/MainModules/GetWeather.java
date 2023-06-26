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

public class GetWeather
{
    public JSONObject GetAllWheater() {
        Object obj;
        try
        {
            obj = new JSONParser().parse(new LocationProccesing().getAllLocation());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        JSONObject JsonInfo = (JSONObject) obj;
        String API_KEY = "53db67f2c4434a14b47103300232506";

        URL myIP = null;
        try {
            myIP = new URL("http://api.weatherapi.com/v1/current.json?key=" + API_KEY +"&q="+new GetIp().getIp());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        BufferedReader in;
        try {
            in = new BufferedReader(new InputStreamReader(
                    myIP.openStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String ip;
        try {
            ip = in.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Object objToReady;
        try
        {
            objToReady = new JSONParser().parse(ip);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        JSONObject Data = (JSONObject) objToReady;
        Object parse1 =  Data.get("current");
        JSONObject Data1 = (JSONObject) parse1;
        return Data1;

    }
    public Double GetTemperature(){
        return (Double) GetAllWheater().get("temp_c");
    }
}
