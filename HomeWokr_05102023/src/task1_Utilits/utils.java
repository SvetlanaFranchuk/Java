package task1_Utilits;

import java.lang.reflect.Array;
import java.util.Random;

public class utils {
    //Создайте утилитарный класс, который будет хранить полезные методы работы со строками.
    // В нём будет один приватный конструктор по умолчанию,

    public utils(){}

    // а также только статические методы:
    //generateWord – генерирует строку заданной длины, состоящую только из букв английского алфавита
    static String generateWord(int lengthWord){
        Random rnd = new Random();
        int[] code = new int [52];

        int j=0;
        for (int i = 65; i <=90 ; i++) {
            code[j]=i;
            j++;
        }
        for (int i = 97; i <=122 ; i++) {
            code[j]=i;
            j++;
        }
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < lengthWord; i++) {
            str.append((char)code[rnd.nextInt(0, code.length)]);
        }
        return  str.toString();
    }

    //generateNumeric – генерирует строку заданной длины, состоящую из цифр
    static String generateNumeric(int lengthWord){
        Random rnd = new Random();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < lengthWord; i++) {
            str.append(rnd.nextInt(0, 10));
        }
        return  str.toString();
    }

    //splitByFirst – находит в строке первый символ, который не является буквой или цифрой и разделяет строку на части,
    // используя найденный символ в качестве разделителя.
    // Например, splitByFirst(“Я люблю Java!”) вернёт массив строк [“Я”, “люблю”, “Java!”],
    // а splitByFirst(“Люди! Я люблю Java! Ура!”) вернёт массив строк [“Люди”, “ Я люблю Java”, “ Ура”, “”]

    static String[] splitByFirst (String myStr){
        char mySplit = ' ';

        for (int i = 0; i < myStr.length() ; i++) {

            if (!(Character.isDigit(myStr.charAt(i)) || Character.isLetter(myStr.charAt(i)))){
                mySplit = myStr.charAt(i);
                break;
            }
        }
        String[] result = myStr.split("" + mySplit);
        return result;
    }

    //isNumeric – проверяет, состоит ли данная строка только из цифр (может быть распознана как целое неотрицательное число)
    static Boolean isNumeric (String myStr){
        Boolean result = true;
        for (int i = 0; i < myStr.length(); i++) {
            if (!Character.isDigit(myStr.charAt(i))) {
                result = false;
                break;
            }
        }
        return result;
    }
}
