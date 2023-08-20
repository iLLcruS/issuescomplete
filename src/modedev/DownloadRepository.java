package modedev;

import lombok.SneakyThrows;
import org.eclipse.jgit.api.Git;
import java.io.File;
import java.util.Scanner;

public class DownloadRepository {
    private final Scanner scanner = new Scanner(System.in);
    @SneakyThrows
    public void start(){
        System.out.print("Enter repository URL: ");
        String url = scanner.next();
        saveWithGit(url);
    }

    @SneakyThrows
    public void saveWithGit(String repoUrl){
        if (!repoUrl.contains("github.com")) {
            System.out.println("This repo dont contains \"github.com\"");
            return;
        }
        repoUrl += ".git";
        File file = new File("./github-repositories/"+sanitizeFileName(repoUrl));
        file.mkdir();
        try {
            System.out.println("Cloning " + repoUrl);
            Git.cloneRepository()
                    .setURI(repoUrl)
                    .setDirectory(file)
                    .call();
            System.out.println("Completed Cloning");
        } catch (Exception e) {
            System.out.println("Exception occurred while cloning repo");
        }
    }

    private static String sanitizeFileName(String originalFileName) {
        return originalFileName.replaceAll("[^a-zA-Z0-9.-]", "_");
    }
}
