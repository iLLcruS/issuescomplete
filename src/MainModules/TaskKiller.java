package MainModules;

import lombok.SneakyThrows;

import java.util.Scanner;

public class TaskKiller {

    private final Scanner scanner = new Scanner(System.in);

    public void start(){
        System.out.print("Enter process name: ");
        String processName = scanner.next();
        kill(processName);
    }
    @SneakyThrows
    public void kill(String proc){
        String os = System.getProperty("os.name").toLowerCase();
        String command;

        if (os.contains("win")) {
            command = "taskkill /F /IM " + proc + ".exe";
        } else {
            command = "pkill " + proc;
        }

        Process process = Runtime.getRuntime().exec(command);
        int exitCode = process.waitFor();

        if (exitCode == 0) {
            System.out.println("Process successfully killed.");
        } else {
            System.out.println("Process can't be killed.");
        }

        System.out.print("Do you want kill process again? (yes / no): ");
        String result = scanner.next();

        if (result.equalsIgnoreCase("yes")) start();
    }
}
