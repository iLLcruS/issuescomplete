package MainModules;

import lombok.SneakyThrows;

import java.util.Scanner;

public class TaskKiller {

    private Scanner scanner = new Scanner(System.in);

    public void start(){
        System.out.print("Enter process name: ");
        String processName = scanner.next();
        kill(processName);
    }
    @SneakyThrows
    public void kill(String proc){
        String processName = proc;

        String os = System.getProperty("os.name").toLowerCase();
        String command;

        if (os.contains("win")) {
            command = "taskkill /F /IM " + processName + ".exe";
        } else {
            command = "pkill " + processName;
        }

        Process process = Runtime.getRuntime().exec(command);
        int exitCode = process.waitFor();

        if (exitCode == 0) {
            System.out.println("Процесс успешно завершен.");
        } else {
            System.out.println("Не удалось завершить процесс.");
        }
    }
}
