package modeutils;

import modedev.mmDevMode.MenuDevMode;
import modeuser.mmUserMode.MenuUserMode;

import java.io.*;
import java.util.Scanner;

import static java.lang.System.out;

public class SetUpMode {

    public void changeMode() {
        String filePath = "./set/stg.init"; // Укажите путь к вашему файлу
        char targetSymbol = '='; // Символ, после которого вы хотите выполнить замену
        try {
            File file = new File(filePath);
            BufferedReader reader = new BufferedReader(new FileReader(file));

            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append(System.lineSeparator());
            }
            reader.close();

            int symbolPosition = content.indexOf(Character.toString(targetSymbol));
            if (symbolPosition != -1) {
                String modifiedContent = content.substring(0, symbolPosition + 1);

                // Запись обновленного текста обратно в файл
                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                writer.write(modifiedContent);
                writer.close();
            } else {
                out.println("Символ не найден.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setUpMode() {
        String filePath = "./set/stg.init";
        String searchText = "sm_mode=";

        try {
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
                        changeMode();
                        content.append("dev\n");
                        out.println("Mode selected to: " + content);
                    }
                    if (action == 2) {
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

}
