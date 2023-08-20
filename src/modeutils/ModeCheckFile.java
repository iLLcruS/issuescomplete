package modeutils;

import modedev.mmDevMode.MenuDevMode;
import modeuser.mmUserMode.MenuUserMode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ModeCheckFile {
    public void checkMode(){
        String filePath = "./set/stg.init"; // Путь к файлу
        String searchText = "sm_mode="; // Текст, после которого нужно получить значение

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                int index = line.indexOf(searchText);
                if (index != -1) {
                    String valueAfterText = line.substring(index + searchText.length());
                    if(valueAfterText.contains("dev")){
                        new MenuDevMode().Menu();
                        break;
                    }
                    if(valueAfterText.contains("user")){
                        new MenuUserMode().Menu();
                        break;
                    }
                    if(valueAfterText.contains("")){
                        new SetUpMode().setUpMode();
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
