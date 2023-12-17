package org.example.updateConcurrentMap;

import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ThreadLocalRandom;

@NoArgsConstructor
@ToString
public class UserConcurrentMap {

    public ConcurrentMap<Integer, Integer> getGeneratedConcurrentMap(int count) {
        ConcurrentMap<Integer, Integer> newMap = new ConcurrentHashMap<>();
        for (int i = 0; i < count; i += count * 0.1) {
            int finalI = i;
            Thread thread = new Thread(() -> fillMap(newMap, finalI, finalI + count *0.1));
            thread.start();
        }
        while (newMap.size() < count) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return new ConcurrentHashMap<>(newMap);
    }

    public void fillMap(ConcurrentMap<Integer, Integer> map, int start, double end) {
        for (int i = start; i < end; i++) {
            map.put(i, ThreadLocalRandom.current().nextInt(-1000, 1001));
        }
    }

    public ConcurrentMap<Integer, Integer> getChangedValueConcurrentMap(ConcurrentMap<Integer, Integer> map) {
        ConcurrentMap<Integer, Integer> map1 = new ConcurrentHashMap<>(map);
        for (int i = 0; i < map1.size(); i += map1.size() * 0.1) {
            int finalI = i;
            Thread thread = new Thread(() -> changeValue(map1, finalI, finalI + map1.size() * 0.1));
            thread.start();
        }
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new ConcurrentHashMap<>(map1);
    }

    private static void changeValue(ConcurrentMap<Integer, Integer> map1, int start, double end) {
        for (int i = start; i < end; i++) {
            if (map1.get(i) > 0) map1.put(i, map1.get(i) - 1);
        }
    }
}


