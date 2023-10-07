package task3_Bicycles;

import java.util.Arrays;

public class MainBicycle {
    public static void main(String[] args) {
        //Напишите класс Велосипед  с минимум пятью полями.
        // В программе создайте 3 разных велосипеда (например, шоссейный, горный, детский) и выведите каждый из них в консоль.
        //Создайте массив из этих велосипедов. С помощью Arrays.toString() превратите массив в строку и выведите в консоль. Запустите программу.
        //Вернитесь в объявление класса велосипед. Переопределите метод toString, чтобы он выводил полное описание велосипеда по его полям.
        //Перейдите в код метода Arrays.toString() и посмотрите на его реализацию.
        // В какой момент автомобиль становится строкой внутри этого метода?
        //Ответ: - когда начинаем использовать StringBuilder

        Bicycle childrenBicycle = new Bicycle(TypeBicycle.ДЕТСКИЙ, 4, false, 1300, "Turbotrike M 3197");
        Bicycle moutainBicycle = new Bicycle(TypeBicycle.ГОРНЫЙ, 2, false, 2200, "E-Bikes 40/45");
        Bicycle roadBicycle = new Bicycle(TypeBicycle.ШОССЕЙНЫЙ, 2, true, 7500, "Giant TCR");

        System.out.println("Тип: " + childrenBicycle.getTypeBicycle() +
                            " ; Кол-во колес: " + childrenBicycle.getCountOfWheel() +
                            " ; Электро: " + childrenBicycle.getElectro() +
                            " ; Цена: " + childrenBicycle.getPrice() +
                            " ; Модель: " + childrenBicycle.getModel());
        System.out.println("Тип: " + moutainBicycle.getTypeBicycle() +
                            " ; Кол-во колес: " + moutainBicycle.getCountOfWheel() +
                            " ; Электро: " + moutainBicycle.getElectro() +
                            " ; Цена: " + moutainBicycle.getPrice() +
                            " ; Модель: " + moutainBicycle.getModel());
        System.out.println("Тип: " + roadBicycle.getTypeBicycle() +
                            " ; Кол-во колес: " + roadBicycle.getCountOfWheel() +
                            " ; Электро: " + roadBicycle.getElectro() +
                            " ; Цена: " + roadBicycle.getPrice() +
                            " ; Модель: " + roadBicycle.getModel());

        Bicycle[] bicycle = {childrenBicycle, moutainBicycle, roadBicycle};
        System.out.println(Arrays.toString(bicycle));

        System.out.println(childrenBicycle);
        System.out.println(moutainBicycle);
        System.out.println(roadBicycle);
    }
}
