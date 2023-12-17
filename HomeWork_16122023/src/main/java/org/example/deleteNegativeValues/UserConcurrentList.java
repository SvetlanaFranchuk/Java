package org.example.deleteNegativeValues;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;

@NoArgsConstructor
public class UserConcurrentList {
    public List<Integer> getGeneratedConcurrentList(int count){
        List<Integer> newList = new CopyOnWriteArrayList<>();
        for (int i = 0; i < count; i+=count/10) {
            int finalI = i;
            Thread thread = new Thread(()->fillList(newList, finalI));
            thread.start();
        }
        while (newList.size() < count){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return new ArrayList<>(newList);
    }

    public static void fillList(List<Integer> list, int count){
        for (int i = 0; i < count; i++) {
            list.add(ThreadLocalRandom.current().nextInt(-1000, 1001));
        }
    }

    public List<Integer> deleteNegativeValues(List<Integer> list){
        for (int i = list.size()-1; i >=0; i--) {
            if (list.get(i) <0) list.remove(i);
        }
        return new ArrayList<>(list);
    }

    public List<Integer> deleteNegativeValuesWithTread(List<Integer> list){
        for (int i = list.size()-1; i >=0; i-= list.size()/10) {
            Thread thread = new Thread(()-> deleteNegativeValues(list));
        }
        return new ArrayList<>(list);
    }

}
