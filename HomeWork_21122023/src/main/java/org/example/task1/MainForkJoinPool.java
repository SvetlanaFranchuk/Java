package org.example.task1;

import com.github.javafaker.Faker;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

public class MainForkJoinPool {
    public static void main(String[] args) {
        String[] arr = generateArray(10_000);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        SortedMerge sortedMerge = new SortedMerge(arr);
        forkJoinPool.invoke(sortedMerge);
        String[] sortedArr = sortedMerge.join();
        System.out.println(Arrays.toString(sortedArr));
    }

    private static String[] generateArray(int countElements){
        String[] arr = new String[countElements];
        Faker faker = new Faker();
        for (int i = 0; i < countElements; i++) {
            arr[i]  = faker.team().name().toString();
        }
        return arr;
    }
}
