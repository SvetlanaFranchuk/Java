package task1;

import task1.util.Utils;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Random rnd = new Random();
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        list = Utils.fillList(rnd.nextInt(30)+1, rnd.nextInt(40)+1);
        System.out.println(list);

        set = Utils.removeDuplicate(list);
        System.out.println(set);
    }



}
// 1 уровень сложности: №1 Напишите метод, который убирает из списка целых чисел все дубликаты.
