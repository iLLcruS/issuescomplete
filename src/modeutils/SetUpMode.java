package modeutils;

import Utils.VisualForConsole.OutputModeStyle;
import lombok.SneakyThrows;

import java.io.*;
import java.util.Properties;
import java.util.Scanner;

import static java.lang.System.out;

public class SetUpMode {

    public SetUpMode.test test;

    public void changeMode() {
        String filePath = "./set/stg.init";
        String searchText = "sm_mode=";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            StringBuilder content = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                content.append(line).append(System.lineSeparator());
            }
            reader.close();

            int index = content.indexOf(searchText);

            if (index != -1) {

                String newContent = content.substring(0, index + searchText.length());
                BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
                writer.write(newContent);
                writer.close();

                System.out.println("Settings for mode successfully removed.");
            } else {
                System.out.println("Text not found in the file.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setUpMode() {
        String filePath = "./set/stg.init";
        String searchText = "sm_mode=";

        try {
            changeMode();
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            StringBuilder content = new StringBuilder();
            String line;

            while (true) {
                try {
                    if ((line = reader.readLine()) == null) break;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                content.append(line);
                if (line.contains(searchText)) {
                    out.println("Choose your mode [1 - dev] [2 - user]: ");
                    int action = new Scanner(System.in).nextInt();
                    if (action == 1) {
                        new OutputModeStyle().outDevelopMode();
                        content.append("dev\n");
                        out.println("Mode selected to: " + content);
                    }
                    if (action == 2) {
                        new OutputModeStyle().outUserMode();
                        changeMode();
                        content.append("user\n");
                        out.println("Mode selected to: " + content);
                    }
                }
            }
            reader.close();

            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            writer.write(content.toString());
            writer.write("\n");
            writer.close();

            new ModeCheckFile().checkMode();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public class test{

    }
}
