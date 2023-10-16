package task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class StringInArray {
    public static void main(String[] args) {
        //Создайте программу, которая принимает от пользователя неограниченное количество строк.
        // Ввод строк должен закончится, когда пользователь введёт слово quit.
        // Выведите в консоль все строки, которые ввёл пользователь.
        // Реализуйте два метода – один находит самую длинную строку в списке, второй – самую короткую строку.
        // Выведите самую длинную и самую короткую из строк в консоль.
        Scanner scanner = new Scanner(System.in);
        String str;
        int i = 0;
        List<String> list = new ArrayList<>();
        do {
            System.out.print("Enter your line: ");
            str = scanner.nextLine();
            if (!Objects.equals(str, "quit")) list.add(i, str);
        } while (!Objects.equals(str, "quit"));
        System.out.println(list);
        System.out.println("The longest line is " + getLongestStr(list));
        System.out.println("The shortest line is " + getShortestStr(list));
    }

    static String getLongestStr(List<String> list) {
        String result = "";
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() > result.length()) result = list.get(i);
        }
        return result;
    }

    static String getShortestStr(List<String> list) {
        String result = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() < result.length()) result = list.get(i);
        }
        return result;
    }
}
