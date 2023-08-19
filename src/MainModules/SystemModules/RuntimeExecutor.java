package MainModules.SystemModules;

import Modules.VisualForConsole.ChangeConsoleColor;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static DataPackage.Variable.getChooseAction;
import static DataPackage.Variable.setChooseAction;
public class RuntimeExecutor {
    private final Scanner scanner = new Scanner(System.in);
    @SneakyThrows
    public void Execute()
    {
        System.out.print("Enter command to execute: ");
        setChooseAction(scanner.nextLine());

        Process process = Runtime.getRuntime().exec(getChooseAction());
        process.inputReader(StandardCharsets.UTF_8);
        process.outputWriter(StandardCharsets.UTF_8);

        new ChangeConsoleColor().setBlueColor();

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(process.getInputStream(), StandardCharsets.UTF_8));

        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        process.waitFor();
        new ChangeConsoleColor().setGreenColor();

    }
}
