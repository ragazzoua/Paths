package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
        Path path = FileSystems.getDefault().getPath("WorkingDirectoryFile.txt");
        printFile(path);
        System.out.println("**************************");
//        Path filePath = FileSystems.getDefault().getPath("files", "SubdirectoryFile.txt");
        Path filePath = Paths.get(".","files", "SubdirectoryFile.txt");
        System.out.println("__________________________");
        printFile(filePath);
        filePath = Paths.get("/Users/s.a.miroshnychenko/IdeaProjects/OutThere.txt");
        System.out.println("__________________________");
        printFile(filePath);
        System.out.println("__________________________");
        filePath = Paths.get("C:\\Users\\s.a.miroshnychenko\\IdeaProjects\\OutThere.txt");
        printFile(filePath);
        System.out.println("**************************");
        filePath = Paths.get(".");
        System.out.println(filePath.toAbsolutePath());
    }

    private static void printFile(Path path) {
        try (BufferedReader fileReader = Files.newBufferedReader(path)) {
            String line;
            while ((line = fileReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
