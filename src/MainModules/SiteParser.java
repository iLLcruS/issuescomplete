package MainModules;

import Modules.AllChecks.CheckFilesAndDirectory;
import Modules.AllChecks.CheckSession;
import lombok.SneakyThrows;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class SiteParser {
    private final Scanner scanner = new Scanner(System.in);
    private final String url;

    public SiteParser() {
        System.out.print("Enter a url: ");
        url = getURL();
        start();
        new MainMenu().Menu();
    }

    @SneakyThrows
    public void start() {
        Document jsoup = Jsoup.connect(url).get();
        writeToFile(jsoup);
    }

    @SneakyThrows
    private void writeToFile(Document jsoup) {
        String name = jsoup.title();
        File file = new File(CheckFilesAndDirectory.PATH_TO_PARSER_DIR + "/" + "parsed" + ".txt");
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(jsoup.body().toString());
        fileWriter.close();
        openFile(file);
    }

    @SneakyThrows
    private void openFile(File file) {

        String os = System.getProperty("os.name").toLowerCase();

        if (os.contains("win")) {


            ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", "start", CheckFilesAndDirectory.PATH_TO_PARSER_DIR + "/" + "parsed" + ".txt");
            processBuilder.start();

        } else if (os.contains("nix") || os.contains("nux") || os.contains("mac")) {


            ProcessBuilder processBuilder = new ProcessBuilder("xdg-open", CheckFilesAndDirectory.PATH_TO_PARSER_DIR + "/" + "parsed" + ".txt");
            processBuilder.start();
        } else {
            System.out.println("Unsupported operating system");
        }
    }

    private String getURL() {
        return scanner.nextLine();
    }
}
