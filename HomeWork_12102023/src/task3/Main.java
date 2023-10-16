package task3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Создайте класс Group, который хранит фамилии всех студентов в учебной группе. В классе напишите метод,
        // который по заданным первым буквам фамилии находит всех студентов и возвращает результат в виде списка.
        // Вызовите метод в main
        List<String> list = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        list.add(0, "Ivanov");
        list.add(1, "Petrov");
        list.add(2, "Sidorov");
        list.add(3, "Kusmin");
        list.add(4, "Volkov");
        list.add(5, "Sirkov");
        list.add(6, "Pestrunov");

        Group group = new Group(list);

        Scanner scanner = new Scanner(System.in);
        String partSurname;
        System.out.println("Enter part of surname: ");
        partSurname = scanner.nextLine();

        list1 = Group.getListOfFio (partSurname, group);
        System.out.println(list1);
    }
}