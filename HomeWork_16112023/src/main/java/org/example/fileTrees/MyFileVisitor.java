package org.example.fileTrees;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class MyFileVisitor extends SimpleFileVisitor<Path> {
    @Override //перед посещением папки
    public FileVisitResult preVisitDirectory(Path dir,
                                             BasicFileAttributes attrs) throws IOException {
        System.out.println("\u001B[32m" + "Folder: " + dir.toString() + "\u001B[0m");
        return FileVisitResult.CONTINUE;
    }

    @Override //при чтении файла
    public FileVisitResult visitFile(Path file,
                                     BasicFileAttributes attrs) throws IOException {
        System.out.println("File: " + file.toString());
        return FileVisitResult.CONTINUE;
    }

    @Override //Ошибки чтения файла
    public FileVisitResult visitFileFailed(Path file, IOException exc)
            throws IOException {
        System.out.println("File reading error " + file.toString());
        return FileVisitResult.CONTINUE;
    }

    @Override //После посещения папки
    public FileVisitResult postVisitDirectory(Path dir, IOException exc)
            throws IOException {
        return FileVisitResult.CONTINUE;
    }
}
