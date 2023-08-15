package MainModules.ProcessingModules;

import lombok.SneakyThrows;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;

public class PlainCodeGenerator {
    @SneakyThrows
    public void start()
    {
        File file = new File("./codes/generated.java");
        if (!file.exists()) file.createNewFile();
        FileWriter fileWriter = new FileWriter(file);

        String generatedText =
                "public class Main{\n" +
                "    public static void main(String[] args){\n" +
                "        System.out.println(\"Hello world!\");\n" +
                "    }\n" +
                "}";

        fileWriter.write(generatedText);
        fileWriter.flush();
        fileWriter.close();
        System.out.println("Code successfully generated!\nYou can find it on path: " + file.getAbsolutePath());
    }
}
