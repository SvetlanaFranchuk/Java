import exceptions.IllegalArgumentException;
import exceptions.NullPointerException;

import java.util.List;

public class CommandLineParser {

    public static Setting parser(String[] array) throws IllegalArgumentException, NullPointerException {
        if (array.length == 0) throw new NullPointerException("No parameters");
        else {
            Setting set = new Setting();
            int numberFile = 0;
            for (String s : array) {
                if (s.length() > 2) {
                    if (numberFile == 0) {
                        set.setFileName(s);
                        numberFile++;
                    } else {
                        set.setListNextFile(s);
                    }
                } else if (s.charAt(1) == 'a' || s.charAt(1) == 'd') {
                    set.setSortMode(s);
                } else if (s.charAt(1) == 's' || s.charAt(1) == 'i') {
                    set.setDateType(s);
                } else throw new IllegalArgumentException("keys have mistake");
            }
            if (isDateTypeCorrect(set.getDateType()) && isFileNameNotEmpty(set.getFileName()) && hasListNextFileDate(set.getListNextFile())) {
                System.out.println("parsing done");
                System.out.println(set);
            } else
                System.out.println("try again, your parameters is not correct");
            return set;
        }
    }

    public static boolean isDateTypeCorrect(String dateType) {
        try {
            if (dateType == null)
                throw new NullPointerException("");
            else if (dateType.charAt(0) != '-')
                throw new IllegalArgumentException("");
        } catch (IllegalArgumentException e) {
            System.out.println("The key for dateType is not correct");
            return false;
        } catch (NullPointerException e) {
            System.out.println("Data type is empty");
            return false;
        }
        return true;
    }

    public static boolean isFileNameNotEmpty(String fileName) {
        try {
            if (fileName == null) throw new NullPointerException("");
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