package task1_Utilits;

import java.util.Arrays;
import java.util.Scanner;

public class mainUtils {
    //Создайте утилитарный класс, который будет хранить полезные методы работы со строками.
    // В нём будет один приватный конструктор по умолчанию, а также только статические методы:
    //generateWord – генерирует строку заданной длины, состоящую только из букв английского алфавита
    //generateNumeric – генерирует строку заданной длины, состоящую из цифр
    //splitByFirst – находит в строке первый символ, который не является буквой или цифрой и разделяет строку на части,
    // используя найденный символ в качестве разделителя.
    // Например, splitByFirst(“Я люблю Java!”) вернёт массив строк [“Я”, “люблю”, “Java!”],
    // а splitByFirst(“Люди! Я люблю Java! Ура!”) вернёт массив строк [“Люди”, “ Я люблю Java”, “ Ура”, “”]
    //isNumeric – проверяет, состоит ли данная строка только из цифр (может быть распознана как целое неотрицательное число)
    //Используйте все методы в коде метода main.
    public static void main(String[] args) {


   Scanner scanner = new Scanner(System.in);
   System.out.print("Enter length for word ");
   int num1 = scanner.nextInt();

        System.out.println(utils.generateWord(num1));
        System.out.println(utils.generateNumeric(num1));
        System.out.println(Arrays.toString(utils.splitByFirst("Я люблю Java!")));
        System.out.println(Arrays.toString(utils.splitByFirst("Люди! Я люблю Java! Ура!")));
        System.out.println(utils.isNumeric("123456565"));
        System.out.println(utils.isNumeric("1234tyty6565"));
}
}