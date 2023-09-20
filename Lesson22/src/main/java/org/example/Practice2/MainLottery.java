package org.example.Practice2;

import java.util.Random;
import java.util.Scanner;

public class MainLottery {
    public static void main(String[] args) {
        int setSize = 5;
        int range = 50;
        int luckyRandom;
        int luckyCount = 0;

        // номера, которые ввел пользователь
        int userNum1 = 0;
        int userNum2 = 0;
        int userNum3 = 0;
        int userNum4 = 0;
        int userNum5 = 0;

        // номера, которые выиграли
        int lucky1 = 0;
        int lucky2 = 0;
        int lucky3 = 0;
        int lucky4 = 0;
        int lucky5 = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите "+setSize+" чисел от 1..50");
        System.out.print("Введите 1-е число: ");
        userNum1 = scanner.nextInt();
        System.out.print("Введите 2-е число: ");
        userNum2 = scanner.nextInt();
        System.out.print("Введите 3-е число: ");
        userNum3 = scanner.nextInt();
        System.out.print("Введите 4-е число: ");
        userNum4 = scanner.nextInt();
        System.out.print("Введите 5-е число: ");
        userNum5 = scanner.nextInt();

        Random random = new Random();

        for (int genericCount =1; genericCount<=setSize; ) {
            luckyRandom = random.nextInt(range - 1) + 1;
            switch (genericCount) {
                case 1: {
                    lucky1 = luckyRandom;
                    genericCount++;
                    break;
                }
                case 2: {
                    if (lucky1!=luckyRandom) {
                        lucky2 = luckyRandom;
                        genericCount++;
                    }
                    break;
                }
                case 3: {
                    if (lucky1!=luckyRandom && lucky2!=luckyRandom) {
                        lucky3 = luckyRandom;
                        genericCount++;
                    }
                    break;
                }
                case 4: {
                    if (lucky1!=luckyRandom && lucky2!=luckyRandom && lucky3!=luckyRandom) {
                        lucky4 = luckyRandom;
                        genericCount++;
                    }
                    break;
                }
                case 5: {
                    if (lucky1!=luckyRandom && lucky2!=luckyRandom && lucky3!=luckyRandom && lucky4!=luckyRandom) {
                        lucky5 = luckyRandom;
                        genericCount++;
                    }
                }
            }
        }
        System.out.println();
        System.out.println("Номера игрока: "+userNum1+", "+userNum2+", "+userNum3+", "+userNum4+", "+userNum5);
        System.out.println("Счастливые номера: "+lucky1+", "+lucky2+", "+lucky3+", "+lucky4+", "+lucky5);
    }
    }
