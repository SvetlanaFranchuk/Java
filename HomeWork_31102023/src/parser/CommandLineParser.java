package parser;

import exceptions.CommandLineParserException;
import setting.Setting;

import java.util.ArrayList;
import java.util.List;

public class CommandLineParser {

    public static Setting parser(String[] array) throws CommandLineParserException {
        if (array.length == 0) throw new CommandLineParserException("No parameters");
        else if (array.length < 3) {
            throw new CommandLineParserException("Not enough parameters ");
        } else {
            String fileName = null;
            String sortMode=null;
            String dateType = null;
            List<String> listNextFile = new ArrayList<>();

            if (isFileNameNotEmpty(array[0])) fileName = array[0];

            if (array[1].charAt(0) != '-') throw new CommandLineParserException("Keys have mistake");
            else {
                if (array[1].charAt(1) == 'a' || array[1].charAt(1) == 'd') {
                    sortMode= array[1];
                } else if (isDateTypeCorrect(array[1])) dateType = array[1];
            }

            for (int i = 2; i < array.length; i++) {
                if (i == 2 && array[2].charAt(0) == '-') {
                    if (isDateTypeCorrect(array[2])) dateType = array[2];
                }
                listNextFile.add(0,array[i]);
            }
            if (hasListNextFileDate(listNextFile)) {
                Setting set = new Setting(sortMode, dateType, fileName, listNextFile);
                System.out.println(set);
                System.out.println("parsing done");
            }
            return null;
        }
    }

    public static boolean isDateTypeCorrect(String dateType) {
        try {
            if (!(dateType.charAt(1) == 's' || dateType.charAt(1) == 'i'))
                throw new CommandLineParserException("The key for dateType is not correct");
        } catch (CommandLineParserException e) {
            return false;
        }
        return true;
    }

    public static boolean isFileNameNotEmpty(String fileName) {
        try {
            if (fileName.charAt(0) == '-' || fileName.charAt(0) == ' ')
                throw new CommandLineParserException("File name is empty");
        } catch (CommandLineParserException e) {
            return false;
        }
        return true;
    }

    public static boolean hasListNextFileDate(List<String> list) {
        try {
            if (list.size() == 0) throw new CommandLineParserException("Extra file is absent!");
        } catch (CommandLineParserException e) {
            return false;
        }
        return true;
    }

}
//a. режим сортировки (-a или -d), необязательный, по умолчанию сортируем по возрастанию;
//b. тип данных (-s или -i), обязательный;
//c. имя выходного файла, обязательное;
//d. остальные параметры – имена входных файлов, не менее одного.
//Примеры запуска из командной строки для Windows:
////sort-it.exe -i -a out.txt in.txt (для целых чисел по возрастанию) sort-it.exe -s out.txt in1.txt in2.txt in3.txt