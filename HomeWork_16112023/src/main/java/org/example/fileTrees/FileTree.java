package org.example.fileTrees;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class FileTree {
    public static void main(String[] args) {
        Path path = Paths.get("C:\\Users\\Tel-ran.de\\Documents\\Java_Git\\");

        if (Files.notExists(path)) {
            System.out.println("Папка " + path.toString() + " не существует");
            return;
        }

        try {
            Files.walkFileTree(path, new MyFileVisitor());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

//Files обладает способом обхода дерева каталогов. Более подробно можно об этом почитать в статье
// https://habr.com/ru/articles/437694/
//Создайте программу, которая будет принимать путь к существующей папке на Вашем компьютере.
// После этого программа должна вывести имена файлов и папок на каждом уровне, начиная с текущей
// папки до корня дерева (диска C или другого диска).