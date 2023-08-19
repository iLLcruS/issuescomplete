package MainModules;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PingChecker {
    private final String ipAddress = "1.1.1.1";
    private final String command = "ping -t " + ipAddress;
    private String line;
    @SneakyThrows
    public void start(){
        execute();
    }

    @SneakyThrows
    public void execute(){
        Process process = Runtime.getRuntime().exec(command);
        BufferedReader input =
                new BufferedReader(new InputStreamReader(process.getInputStream()));
        while ((line = input.readLine()) != null) {
            System.out.print(line); //<-- Parse data here.
        }
        input.close();
    }
}
