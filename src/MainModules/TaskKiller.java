package MainModules;

import lombok.SneakyThrows;

public class TaskKiller {
    @SneakyThrows
    public void kill(){
        String processName = null;

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
