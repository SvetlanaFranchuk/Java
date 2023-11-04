import exceptions.IllegalArgumentException;
import exceptions.NullPointerException;

import java.util.List;

public class CommandLineParser {

    public static Setting parser(String[] array) throws IllegalArgumentException, NullPointerException {

        if (array.length == 0) throw new NullPointerException("No parameters");
        else if (array.length < 3) {
            throw new IllegalArgumentException("Not enough parameters ");
        } else {
            Setting set = new Setting();
            if (isFileNameNotEmpty(array[0])) set.setFileName(array[0]);

            if (array[1].charAt(0) != '-') throw new IllegalArgumentException("keys have mistake");
            else {
                if (array[1].charAt(1) == 'a' || array[1].charAt(1) == 'd') {
                    set.setSortMode(array[1]);
                } else if (isDateTypeCorrect(array[1])) set.setDateType(array[1]);
            }

            for (int i = 2; i < array.length; i++) {
                if (i == 2 && array[2].charAt(0) == '-') {
                    if (isDateTypeCorrect(array[2])) set.setDateType(array[2]);
                }
                set.setListNextFile(array[i]);
            }
            if (hasListNextFileDate(set.getListNextFile())) {
                System.out.println("parsing done");
                System.out.println(set);
            } else
                System.out.println("your parameters is not correct");
            return set;
        }
    }

    public static boolean isDateTypeCorrect(String dateType) {
        try {
            if (!(dateType.charAt(1) == 's' || dateType.charAt(1) == 'i'))
                throw new IllegalArgumentException("");
        } catch (IllegalArgumentException e) {
            System.out.println("The key for dateType is not correct");
            return false;
        }
        return true;
    }

    public static boolean isFileNameNotEmpty(String fileName) {
        try {
            if (fileName.charAt(0) == '-' || fileName.charAt(0) == ' ') throw new NullPointerException("");
        } catch (NullPointerException e) {
            System.out.println("File name is empty");
            return false;
        }
        return true;
    }

    public static boolean hasListNextFileDate(List<String> list) {
        try {
            if (list.size() == 0) throw new NullPointerException("");
        } catch (NullPointerException e) {
            System.out.println("Extra file is absent!");
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