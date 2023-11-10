package org.example.extraTask;

import java.util.ArrayList;
import java.util.List;

public class ExtraTasks {

    //Задачи для продлёнки
    //Необходимо реализовать и протестировать следующие методы:
    //Напишите программу на Java для поиска общих элементов между двумя массивами целых чисел
    //example input:
    //Array1: [1, 2, 5, 5, 8, 9, 7, 10]
    //Array2: [1, 0, 6, 15, 6, 4, 7, 0]
    //example expected: [1,7]
    //
    public List<Integer> commonElements(int[] array1, int[] array2) {
        if (array1==null || array2==null) throw new NullPointerException("Array is null");
        List<Integer> commonArr = new ArrayList<>();
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                if (array1[i] == array2[j]) commonArr.add(array1[i]);
            }
        }
        return commonArr;
    }


    //Напишите программу на Java для удаления повторяющихся элементов из массива.
    //example input: [0,3,-2,4,3,2]
    //example expected: [0,3,-2,4,2]
    public List<Integer> removeRepetitions(int[] array) {
        if (array==null) throw new NullPointerException("Array is null");

        List<Integer> array2 = new ArrayList<>();
        for (int k : array) {
            array2.add(k);
        }
        for (int i = array2.size() - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (array2.get(i) == array2.get(j)) array2.remove(i);
            }
        }
        return array2;
    }

    //Напишите программу на Java для поиска второго по величине элемента в массиве.
    //example input: [-1, 4, 0, 2, 7, -3]
    //example expected: 7
    public int maxNext(int[] array) {
        if (array==null) throw new NullPointerException("Array is null");

        int max = array[0];
        for (int k : array) {
            if (k > max) max = k;
        }
        int max2 = array[0];
        for (int k : array) {
            if (k > max2 && k<max) max2 = k;
        }
        return max2;
    }
    //
    //Напишите программу Java для поиска второго наименьшего элемента в массиве.
    //example input: [-1, 4, 0, 2, 7, -3]
    //example expected: -1
    public int minNext(int[] array) {
        if (array==null) throw new NullPointerException("Array is null");

        int min = array[0];
        for (int k : array) {
            if (k < min) min = k;
        }
        int min2 = array[0];
        for (int k : array) {
            if (k < min2 && k>min) min2 = k;
        }
        return min2;
    }

}
