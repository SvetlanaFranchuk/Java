package org.example.deleteNegativeValues;

import java.util.List;

public class MainTask1 {
    public static void main(String[] args) {
        UserConcurrentList randomList = new UserConcurrentList();
        int count = 10_000;
        List<Integer> list = randomList.getGeneratedConcurrentList(count);
        List<Integer> list1 = list;
        System.out.println(list);

        long start = System.currentTimeMillis();
        System.out.println(randomList.deleteNegativeValues(list));
        System.out.println("Время в однопоточном режиме " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        System.out.println(randomList.deleteNegativeValuesWithTread(list1));
        System.out.println("Время в многопоточном режиме " + (System.currentTimeMillis() - start));

    }
}
