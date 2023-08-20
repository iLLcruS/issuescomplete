package modeuser.webmod;

import modeuser.mmUserMode.mmUser;
import lombok.SneakyThrows;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class SiteParser {
    private final Scanner scanner = new Scanner(System.in);
    List<String> filesListInDir = new ArrayList<String>();

    public SiteParser() {
        try
        {
            System.out.print("Enter a url: ");
            String url = getURL();


            saveSiteData(url);
        }
        catch (Exception e)
        {
            System.out.println("Error parsing site.");
        }



        new mmUser().Menu();
    }



    @SneakyThrows
    private void saveSiteMarkup(String url)
    {
        Document document = Jsoup.connect(url).get();
        String data  = document.html();
        String sanitizedTitle = sanitizeFileName(document.title());
        File dir = new File("./parsed/" + sanitizedTitle);
        dir.mkdir();

        File MarkupData = new File(dir.getAbsolutePath() + "/" + sanitizedTitle + ".html");
        FileWriter fileWriter = new FileWriter(MarkupData);
        fileWriter.write(data);
        fileWriter.close();
    }
    private static String sanitizeFileName(String originalFileName) {

        return originalFileName.replaceAll("[^a-zA-Z0-9.-]", "_");
    }
    @SneakyThrows
    public void saveSiteData(String choosenUrl) {
        Document document = Jsoup.connect(choosenUrl).get();
        String sanitizedTitle = sanitizeFileName(document.title());
        File dir = new File("./parsed/" + sanitizedTitle);
        dir.mkdir();
        this.saveSiteMarkup(choosenUrl);

        String outputDir = "./parsed/" + sanitizedTitle;
        try {


            Elements imgElements = document.select("img[src]");
            for (Element imgElement : imgElements) {
                String source = imgElement.attr("src");
                URL imgUrl = new URL(new URL(choosenUrl), source);
                saveResource(imgUrl.toString(), outputDir);
            }


            Elements styleElements = document.select("link[rel=stylesheet]");
            for (Element styleElement : styleElements) {
                String source = styleElement.attr("href");
                URL styleUrl = new URL(new URL(choosenUrl), source);
                saveResource(styleUrl.toString(), outputDir);
            }

            Elements scriptElements = document.select("script[src]");
            for (Element scriptElement : scriptElements) {
                String source = scriptElement.attr("src");
                URL scriptUrl = new URL(new URL(choosenUrl), source);
                saveResource(scriptUrl.toString(), outputDir);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        zipDirectory(dir,sanitizedTitle + ".zip");
        deleteDirectoryFiles(dir);
        Files.delete(dir.toPath());

    }
    private void zipDirectory(File dir, String zipDirName) {
        try {
            populateFilesList(dir);

            FileOutputStream fos = new FileOutputStream(new File(new File("./parsed"),zipDirName));
            ZipOutputStream zos = new ZipOutputStream(fos);

            for(String filePath : filesListInDir){


                ZipEntry ze = new ZipEntry(filePath.substring(dir.getAbsolutePath().length()+1, filePath.length()));
                zos.putNextEntry(ze);

                FileInputStream fis = new FileInputStream(filePath);

                byte[] buffer = new byte[1024];
                int len;
                while ((len = fis.read(buffer)) > 0) {
                    zos.write(buffer, 0, len);
                }
                zos.closeEntry();
                fis.close();
            }
            zos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void populateFilesList(File dir) throws IOException {
        File[] files = dir.listFiles();
        for(File file : files){
            if(file.isFile()) filesListInDir.add(file.getAbsolutePath());
            else populateFilesList(file);
        }
    }
    private void deleteDirectoryFiles(File dir) throws IOException {
        File[] files = dir.listFiles();
        for(File file : files){
            if(file.isFile()) filesListInDir.add(file.getAbsolutePath());
            else populateFilesList(file);
            Files.delete(file.toPath());
        }

    }
    private static void saveResource(String resourceUrl, String outputDir) throws IOException {
        URL url = new URL(resourceUrl);
        String fileName = url.getFile();
        fileName = fileName.substring(fileName.lastIndexOf('/') + 1);

        fileName = sanitizeFileName(fileName);

        try (ReadableByteChannel readableByteChannel = Channels.newChannel(url.openStream())) {
            FileOutputStream fileOutputStream = new FileOutputStream(outputDir + "/" + fileName);
            fileOutputStream.getChannel().transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
            fileOutputStream.close();

        }
    }

    private String getURL() {
        return scanner.nextLine();
    }
}
