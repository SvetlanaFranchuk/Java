package org.example;

import java.util.Random;

public class RandomGenerator {


    // Тask: Реализуйте метод rand7() на базе метода rand5().
    //Другими словами, имеется метод, генерирующий случайные числа в диапазоне от О до 4 (включительно).
    //Напишите метод, который использует его для генерирования случайного числа в диапазоне от О до 6 (включительно).
    public static void main(String[] args) {
        System.out.println(random7());
        System.out.println(random7());
        System.out.println(random7());
        System.out.println(random7());
        System.out.println(random7());
    }

    public static int random5(){ // 0 1 2 3 4
        Random random = new Random();
        return random.nextInt(5);
    }

    public static int random7() { // 0 1 2 3 4 5 6
        int num;
        do {
            // Генерируем число от 0 до 24 (включительно)
            num = 5 * random5() + random5();
        } while (num >= 21); // Повторяем, пока не получим число в нужном диапазоне

        // Возвращаем число в диапазоне от 0 до 6 (включительно)
        return num % 7;
    }


}
