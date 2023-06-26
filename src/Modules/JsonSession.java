package Modules;

import MainModules.MainMenu;
import Modules.AllChecks.CheckFilesAndDirectory;
import org.json.simple.JSONObject;

import java.io.*;

public class JsonSession {

    public String createJsonObject(){

        JSONObject jsonSession = new JSONObject();

        jsonSession.put("namepc", new MainMenu().nameProperty);
        jsonSession.put("ip", new GetIp().getIp());

        StringWriter out = new StringWriter();
        try {
            jsonSession.writeJSONString(out);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String jsonText = out.toString();
        writeJsonObjectToFile(jsonText);
        return jsonText;
    }
    private void writeJsonObjectToFile(String object){
        try {
            FileWriter fileWriter = new FileWriter(new CheckFilesAndDirectory().getPathSessionFile());
            fileWriter.append(object);
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
   /* public void readJsonObjectFile(){
        File file = new File(new CheckFilesAndDirectory().getPathSessionFile());
        BufferedReader fin = null;
        try {
            fin = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        String line;
        while (true) {
            try {
                if (!((line = fin.readLine()) != null)) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println(line);
        }
    }*/
}
