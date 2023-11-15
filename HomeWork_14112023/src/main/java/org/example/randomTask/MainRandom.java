package org.example.randomTask;

import java.util.Random;

public class MainRandom {
    public static void main(String[] args) {
        Random rnd = new Random();
        System.out.println(getRandomOdd(rnd));
    }

    public static int getRandomOdd(Random rnd) {
        int result = rnd.nextInt(-100,100);
        return result % 2==0 ? result+1: result;
    }

}
// Напишите метод, который принимает на вход объект класса Random.
// Метод должен возвращать случайное нечётное число из диапазона от -100 до 100. Напишите тест для проверки метода.
// Сделайте так, чтобы в тесте объект Random выдавал набор ожидаемых чисел, а не случайных.