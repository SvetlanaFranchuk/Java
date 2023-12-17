package org.example.updateConcurrentMap;

import java.util.concurrent.ConcurrentMap;

public class Main {
    public static void main(String[] args) {
        UserConcurrentMap userConcurrentMap = new UserConcurrentMap();
        System.out.println("Первоначальный ConcurrentHashMap");
        ConcurrentMap<Integer, Integer> map = userConcurrentMap.getGeneratedConcurrentMap(1000);
        System.out.println(map);
        System.out.println("Измененный ConcurrentHashMap");
        System.out.println(userConcurrentMap.getChangedValueConcurrentMap(map));

    }
}