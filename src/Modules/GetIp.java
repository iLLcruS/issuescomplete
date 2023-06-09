package Modules;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class GetIp {
    public String getIp(){
        URL myIP = null;
        try {
           myIP = new URL("http://checkip.amazonaws.com");
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
        return ip;
    }
}
