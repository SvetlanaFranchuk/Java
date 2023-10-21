package task1.util;

import java.util.*;

public class Utils {
    public static List<Integer> fillList (int count, int maxValue){
        List<Integer> list = new ArrayList<>();
        Random rnd = new Random();

        for (int i = 0; i < count ; i++) {
            list.add(i, rnd.nextInt(maxValue));
        }
        return list;
    }

    public static Set<Integer> removeDuplicate (List<Integer> list){
        return new HashSet<>(list);
    }
}
// 1 уровень сложности: №1 Напишите метод, который убирает из списка целых чисел все дубликаты.

