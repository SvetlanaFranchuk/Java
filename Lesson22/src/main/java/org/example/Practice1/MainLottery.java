package org.example.Practice1;

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
        System.out.print("Номера, которые выиграли: ");
        for (int i=0; i<setSize; i++) {
            luckyRandom = random.nextInt(range-1)+1;
            System.out.print(luckyRandom+", ");
            if(luckyRandom == userNum1) {
                luckyCount++;
            }
            else if(luckyRandom == userNum2) {
                luckyCount++;
            }
            else if (luckyRandom == userNum3) {
                luckyCount++;
            }
            else if (luckyRandom == userNum4) {
                luckyCount++;
            }
            else if (luckyRandom == userNum5) {
                luckyCount++;
            }
        }
        System.out.println();
        System.out.println("Номера игрока: "+userNum1+", "+userNum2+", "+userNum3+", "+userNum4+", "+userNum5);
        System.out.println("Совпало -> "+luckyCount);
    }
}
