package task2FindMax;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainCompare {

    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("text1");
        list1.add("text2");
        list1.add("text3");
        System.out.println("" + findMax(list1, 0, 2));

        List<Integer> list2 = new ArrayList<>();
        list2.add(99);
        list2.add(10);
        list2.add(-77);
        list2.add(-707);
        list2.add(777);
        System.out.println("" + findMax(list2, 1, 3));

        List<TestForMax> list3 = new ArrayList<>();
        list3.add(new TestForMax("Ivan", 25));
        list3.add(new TestForMax("Kate", 19));
        list3.add(new TestForMax("Daniel", 27));
        System.out.println("" + findMax( list3, 0, 2));

    }

    public static <T> T findMax(List<? extends Comparable> list, int begin, int end) {
        T maxValue = (T) list.get(begin);
        for (int i = begin; i <= end; i++) {
            if (list.get(i).compareTo(maxValue) > 0) maxValue = (T) list.get(i);
        }
        return maxValue;
    }
}

//Напишите параметризированный метод для нахождения максимального элемента в диапазоне
// [begin, end) среди элементов List.
// Какую границу должен иметь параметр такого метода?