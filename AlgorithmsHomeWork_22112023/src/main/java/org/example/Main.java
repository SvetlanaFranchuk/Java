package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        CustomDynamicArray array = new CustomDynamicArray();
        array.add(10);
        array.InnerStructure();
        array.add(20);
        array.InnerStructure();
        array.add(30);
        array.InnerStructure();
        array.add(40);
        array.InnerStructure();
        array.add(50);
        array.InnerStructure();

        array.addAt(3, 999);
        array.InnerStructure();

        array.remove();
        array.InnerStructure();

        array.removeAt(3);
        array.InnerStructure();

        System.out.println(array.contains(20));
        System.out.println(array.contains(0));

        System.out.println(array);

        for (Integer i: array) {
            System.out.println(i);
        }
    }


}