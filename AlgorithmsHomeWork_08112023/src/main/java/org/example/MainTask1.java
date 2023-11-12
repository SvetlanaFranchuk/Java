package org.example;

import java.io.*;
import java.util.Scanner;

public class MainTask1 {
    public static void main(String[] args) throws IOException {

        String s;
        while (true) {
            System.out.println("Enter full path ('quit' to exit): ");
            Scanner scanner = new Scanner(System.in);
            s = scanner.nextLine();

            if (s.equals("quit")) break;
            File f = new File(s);
            if (!f.exists()) {
                System.out.println("\nNot found: " + s);
                continue;
            }

            if (!f.isDirectory()) {
                System.out.println("\nNot directory: " + s);
                continue;
            }

            list(s);
        }

    }
        public static void list(String szDir) throws IOException {
            File f = new File(szDir);
            String[] sDirList = f.list();

            int i;
            for(i = 0; i < sDirList.length; i++) {
                File f1 = new File(szDir + File.separator + sDirList[i]);

                if(f1.isFile()) {
                    if (f1.toString().contains(".txt")) {
                        System.out.println();
                        System.out.println("File: " + szDir + File.separator + sDirList[i]);
                        readFile(f1);
                    }
                }else {
                   // System.out.println("Moving to dir: " + szDir + File.separator + sDirList[i]);
                    list(szDir + File.separator + sDirList[i]);
                }
            }
        }
        public static void readFile(File f) throws IOException {
            BufferedReader fin = new BufferedReader(new FileReader(f));
            String line;
            while ((line = fin.readLine()) != null) System.out.println(line);
        }
    }
    //1 уровень сложности: 1. Написать программу, которая находила бы все текстовые файлы расширения .txt
    // в заданной папке и ее подпапках и выводила бы их содержимое в консоль.
    // За основу решения можно взять класс ListFileTree.java (см. репозиторий).
    //
    //

