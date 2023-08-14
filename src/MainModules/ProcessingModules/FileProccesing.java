package MainModules.ProcessingModules;

import java.awt.*;
import java.io.*;
import java.util.Scanner;

public class FileProccesing {
    private String pathToThisFile;

    public void setPath() {
        Scanner sc = new Scanner(System.in);
        this.pathToThisFile = sc.nextLine();
    }

    public void renameFile() {
        File file;
        Scanner scan;
        file = new File(pathToThisFile);
        scan = new Scanner(System.in);
        if (!file.exists()) {
            System.out.println("Invalid path!");

        } else {
            System.out.print("Enter new file name(with sufics like '.txt'): ");
            String newFileName = scan.nextLine();
            File renameFile = new File(file.getParent(), newFileName);
            boolean renamed = file.renameTo(renameFile);
            if (renamed) {
                System.out.println("Successfully renamed!");

            } else {
                System.out.println("Error.");
            }
        }
    }

    public void makeNewFile() {
        File file;
        Scanner scan;
        file = new File(pathToThisFile);
        scan = new Scanner(System.in);
        if (!file.exists()) {
            System.out.println("Invalid path!");

        } else {
            System.out.print("Enter file name(with sufics like '.txt'): ");
            file = new File(pathToThisFile, scan.nextLine());
            try {
                file.createNewFile();
                System.out.print("Successfully created!\n");
            } catch (IOException e) {
                System.out.print("Error.");
            }
        }
    }

    public void makeNewDirectory() {
        File file;
        Scanner scan;
        file = new File(pathToThisFile);
        scan = new Scanner(System.in);
        if (!file.exists()) {
            System.out.println("Invalid path!");

        } else {
            System.out.print("Enter directory name: ");
            file = new File(pathToThisFile, scan.nextLine());
            file.mkdir();
            System.out.print("Successfully created!\n");
        }
    }

    public void openFile() {
        File file;
        Scanner scan;
        file = new File(pathToThisFile);
        scan = new Scanner(System.in);
        if (!file.exists()) {
            System.out.println("Invalid path!");

        } else {
            Desktop desk = Desktop.getDesktop();
            try {
               desk.open(file);
            } catch (IOException e) {
                System.out.println("Error opening file!");
            }
        }
    }
}
