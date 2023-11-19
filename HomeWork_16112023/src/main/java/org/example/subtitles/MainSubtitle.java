package org.example.subtitles;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainSubtitle {
    public static void main(String[] args) throws FileNotFoundException {
        String strPath = "VttFiles\\";
        File folder = new File(strPath);
        File[] listOfFiles = folder.listFiles();

        List<String> list = readFiles(strPath, listOfFiles);

        System.out.println(list.toString());
        makeCommonFile(list, new FileOutputStream("result.txt"));
    }

    private static List<String> readFiles(String strPath, File[] listOfFiles){
        String str;
        List<String> list = new ArrayList<>();
        try {
            for (File file : listOfFiles) {
                Scanner scanner = new Scanner(Path.of(strPath + file.getName()));
                while (scanner.hasNextLine()) {
                    str = scanner.nextLine();
                    if (str.length() > 0 && !str.contains("WEBVTT") && !str.contains("00:"))
                        list.add(str);
                }
                scanner.close();
            }
        } catch (IOException e) {
            System.err.println(e);
        }
        return  list;
    }
    private static void makeCommonFile(List<String> list, OutputStream output) {
        try (OutputStream output2 = new DataOutputStream(output)) {
            for (String oneStr : list)
                output2.write((oneStr+"\n").getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
//Есть архив VttFiles.zip (см. в группе дискорд) с набором vtt-файлов (субтитры к аудиодорожкам).
// Из субтитров нужно собрать единый файл txt для последующего создания документа со скриптами аудиодорожек.
// В txt поместите только тексты из субтитров. Все лишние записи (время, WEBVTT) должны быть удалены.