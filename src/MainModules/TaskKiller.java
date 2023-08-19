package MainModules;

import lombok.SneakyThrows;

import java.util.Scanner;

public class TaskKiller {

    private final Scanner scanner = new Scanner(System.in);

    public void start(){
        System.out.print("Enter type (PID, NAME): ");
        String type = scanner.next();
        kill(type);
    }
    @SneakyThrows
    public void kill(String type){
        String os = System.getProperty("os.name").toLowerCase();
        String command = null;
        String proc = null;

        if (type.equalsIgnoreCase("name")) {
            System.out.print("Enter process name: ");
            proc = scanner.next();
        } else if (type.equalsIgnoreCase("pid")){
            System.out.print("Enter process PID: ");
            proc = scanner.next();
        }



        if (os.contains("win")) {
            if (type.equalsIgnoreCase("name")) {
                if (!proc.contains(".exe")) {
                    command = "taskkill /F /IM " + proc + ".exe";
                } else {
                    command = "taskkill /F /IM " + proc;
                }
            } else if (type.equalsIgnoreCase("pid")){
                command = "taskkill /F /PID " + proc;
            }
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
