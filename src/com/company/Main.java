package com.company;

import java.io.IOException;
import java.nio.file.*;

public class Main {

    public static void main(String[] args) {

        try {
            Path fileToMove = FileSystems.getDefault().getPath("Examples", "file1copy.txt");
            Path destination = FileSystems.getDefault().getPath("Examples", "Dir1", "file1copy.txt");
            Files.move(fileToMove, destination);


//            Path sourceFile = FileSystems.getDefault().getPath("Examples", "file1.txt");
//            Path copyFile = FileSystems.getDefault().getPath("Examples", "file1copy.txt");
//            Files.copy(sourceFile, copyFile, StandardCopyOption.REPLACE_EXISTING);
//
//            sourceFile = FileSystems.getDefault().getPath("Examples","Dir1");
//            copyFile = FileSystems.getDefault().getPath("Examples", "Dir4");
//            Files.copy(sourceFile, copyFile, StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
