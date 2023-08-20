package Utils.AllChecks;

import lombok.Getter;
import lombok.SneakyThrows;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;

import static java.lang.System.out;

@Getter
public class CheckFilesAndDirectory {
    public static final String PATH_TO_PARSER_DIR = "./parsed_templates";
    public static final String PATH_TO_SESSIONS_FILE = "./session/SESSIONS.json";
    public static final String PATH_TO_DIARY_FILE = "./configs/diary.json";

    public final String[] pathsToCheckFiles = {
            "./session/name.txt", "./command/availableCommand.txt",
            "./set/stg.init", "./logs/commandsLog.txt"
    };
    public final String[] pathsToCheckDirectory = {
            "./configs", "./session", "./logs", "./command",
            "./parsed", "./codes", "./saves", "./github-repositories",
            "./set"
    };

    private void checkFile(String path, JSONObject defaultContent) {
        File file = new File(path);
        if (!file.exists()) {
            out.println("File has been deleted. Creating new...");
            try {
                file.createNewFile();
                if (defaultContent != null) {
                    FileWriter fileToWrite = new FileWriter(file);
                    fileToWrite.write(" ");
                    fileToWrite.flush();
                    fileToWrite.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            out.println("Created!");
        }
    }

    private void checkDirectory(String path) {
        File dir = new File(path);
        if (!dir.exists()) {
            out.println("Directory has been deleted. Creating new...");
            dir.mkdir();
            out.println("Created!");
        }
    }

    @SneakyThrows
    private void checkSessionsFile() {
        File sessionsFile = new File(PATH_TO_SESSIONS_FILE);
        if (!sessionsFile.exists()) {
            sessionsFile.createNewFile();
            FileWriter fileWriter = new FileWriter(sessionsFile);
            JSONObject object = new JSONObject();
            object.put("accounts", Collections.EMPTY_LIST);
            fileWriter.write(object.toJSONString());
            fileWriter.flush();
            fileWriter.close();
        }
    }

    @SneakyThrows
    private void checkDiaryConfigFile() {
        File file = new File(PATH_TO_DIARY_FILE);
        if (!file.exists()) {
            out.println("File has been deleted. Creating new...");
            file.createNewFile();
            JSONObject object = new JSONObject();
            object.put("mon", Collections.EMPTY_LIST);
            object.put("tues", Collections.EMPTY_LIST);
            object.put("wed", Collections.EMPTY_LIST);
            object.put("thurs", Collections.EMPTY_LIST);
            object.put("fri", Collections.EMPTY_LIST);
            object.put("sat", Collections.EMPTY_LIST);
            object.put("sun", Collections.EMPTY_LIST);
            FileWriter fileToWrite = new FileWriter(file);
            fileToWrite.write(object.toJSONString());
            fileToWrite.flush();
            fileToWrite.close();
            out.println("Created!");
        }
    }

    public void allCheck() {
        for (String pathDirectory : pathsToCheckDirectory) {
                checkDirectory(pathDirectory);
        }
        for(String pathFiles : pathsToCheckFiles){
            checkFile(pathFiles, null);
        }
        checkSessionsFile();
        checkDiaryConfigFile();
    }
}
