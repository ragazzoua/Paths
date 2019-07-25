package com.company;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class CopyFiles extends SimpleFileVisitor<Path> {

    private Path sourseRoot;
    private Path targetRoot;

    public CopyFiles(Path sourseRoot, Path targetRoot) {
        this.sourseRoot = sourseRoot;
        this.targetRoot = targetRoot;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.out.println("Error accesing file " + file.toAbsolutePath() + exc.getMessage());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        Path relativizedPath = sourseRoot.relativize(dir);
        System.out.println("Relativized Path" + relativizedPath);
        Path copyDirectory = targetRoot.resolve(relativizedPath);
        System.out.println("Resolved path for copy = " + copyDirectory);

        try {
            Files.copy(dir, copyDirectory);
        } catch (IOException exc) {
            System.out.println(exc.getMessage());
            return FileVisitResult.SKIP_SUBTREE;
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        Path relativizedPath = sourseRoot.relativize(file);
        System.out.println("Relativized Path" + relativizedPath);
        Path copyDirectory = targetRoot.resolve(relativizedPath);
        System.out.println("Resolved path for copy = " + copyDirectory);

        try {
            Files.copy(file, copyDirectory);
        } catch (IOException exc) {
            System.out.println(exc.getMessage());
        }
        return FileVisitResult.CONTINUE;
    }
}
