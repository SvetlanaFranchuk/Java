package org.example.task4RemoveStr;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("Be", "slow", "to", "promise", "and", "quick", "to", "perform"));
        System.out.println(list);

        Predicate<String> predicate = s -> s.toLowerCase().startsWith("p");
        list.removeIf(predicate);
        System.out.println(list);
    }


}
//Создайте предикат для удаления из списка тех строк, что начинаются с определённой буквы. Создайте список строк и
// удалите элементы с помощью метода removeIf, передав в него предикат.