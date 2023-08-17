package MainModules;

import lombok.SneakyThrows;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Diary {
    private final String path = "./configs/diary.json";
    private final File file = new File(path);
    private final Scanner scanner = new Scanner(System.in);
    public void start(){
        System.out.print("Choose what u want to do (delete, show, save): ");
        String variant = scanner.nextLine();
        try {
            switch (variant) {
                case "save" -> {
                    System.out.print("Choose day (Mon, Tues, Wed, Thurs, Fri, Sat, Sun): ");
                    String day = scanner.nextLine();
                    System.out.print("Enter event for day: ");
                    String data = scanner.nextLine();
                    System.out.print("Enter time for day: ");
                    String time = scanner.nextLine();
                    save(data, day.toLowerCase(), time);
                }
                case "show" -> {
                    System.out.print("Choose day (Mon, Tues, Wed, Thurs, Fri, Sat, Sun): ");
                    String day = scanner.nextLine();
                    show(day);
                }
                case "delete" -> {
                    System.out.print("Choose day (Mon, Tues, Wed, Thurs, Fri, Sat, Sun): ");
                    String day = scanner.nextLine();
                    delete(day);
                }
            }
        } catch (Exception e) {
            System.out.println("Error day is not valid");
            new MainMenu().Menu();
        }
    }

    @SneakyThrows
    private JSONObject parse(){
        JSONParser jsonParser = new JSONParser();
        Reader reader = new FileReader(file);
        JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
        return jsonObject;
    }

    @SneakyThrows
    private void save(String objectToSave, String key, String time){
        JSONParser jsonParser = new JSONParser();
        Reader reader = new FileReader(file);
        JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
        List<HashMap<String, String>> strings = (List<HashMap<String, String>>) jsonObject.get(key);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("content", objectToSave);
        hashMap.put("time", time);
        strings.add(hashMap);
        jsonObject.replace(key, strings);
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(jsonObject.toJSONString());
        fileWriter.flush();
        fileWriter.close();
    }

    @SneakyThrows
    private void delete(String key){
        show(key);
        System.out.print("Choose index: ");
        int index = scanner.nextInt();

        JSONParser jsonParser = new JSONParser();
        Reader reader = new FileReader(file);
        JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
        List<HashMap<String, String>> strings = (List<HashMap<String, String>>) jsonObject.get(key);
        strings.remove(index);
        jsonObject.replace(key, strings);
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(jsonObject.toJSONString());
        fileWriter.flush();
        fileWriter.close();
    }
    @SneakyThrows
    private void show(String key){
        JSONParser jsonParser = new JSONParser();
        Reader reader = new FileReader(file);
        JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
        List<HashMap<String, String>> strings = (List<HashMap<String, String>>) jsonObject.get(key);
        for (int i = 0; i < strings.size(); i++) {
            System.out.println("["+i+"] "+"["+strings.get(i).get("content")+"] "+"["+strings.get(i).get("time")+"]");
        }
    }
}
