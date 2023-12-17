package org.example.task2;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
public class MainTask2 {
    public static void main(String[] args) {
        ConcurrentMap<String, Integer> map = new ConcurrentHashMap<>();
        map.put("stock", 990);

        Thread[] threads = new Thread[1000];
        for (int i = 0; i < threads.length; i++) {
            int finalI = i;
            threads[i] = new Thread(() -> decreaseValue(map, "stock", 1));
            threads[i].start();
        }
        for (int i = 0; i < threads.length; i++) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void decreaseValue(ConcurrentMap<String, Integer> map, String key, int value){
        map.merge(key, value, (v, v1) -> v > 0 ? (v - v1): v);
        System.out.println("result changing map:" + map);
    }
}
