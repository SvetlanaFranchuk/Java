package org.example.task1ListNumbers;

import java.util.List;

public class ListNumbers {
    public static void main(String[] args) {
        List<Integer> numbs = List.of(-5,6,-27,15,42,-34);
        numbs.forEach(i -> System.out.println((i<0)?(-1)*i:i));
    }
//Создайте список чисел. С помощью метода forEach выведите каждое число в консоль по модулю.
}
