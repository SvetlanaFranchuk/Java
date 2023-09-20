package org.example.Practice3;

import java.util.Scanner;

public class Utils {
    //Получите от пользователя 5 номеров, сохраните их в массив

//HomeWork    №1.

//    Увеличьте одновременное количество игроков до трех.
//    Три игрока вводят номера для игры.
//    Лотерея играет один раз.

    public static int[][] getUserLotteryNumber(){

        int[][] userNum = new int[3][Constants.COUNT_SET_SIZE];
        Scanner scanner = new Scanner(System.in);
        for (int k = 0; k < 3 ; k++) {
            System.out.println("Игрок номер " + (k+1));
            for (int i = 0; i < userNum[k].length; i++) {
                do {//Добавьте проверку пользовательских номеров с номерами лотереи
                    System.out.print("Введите " + (i + 1) + "-е число: в диапазоне от 1 до " + Constants.RANGE_NUMBER_LOTTERY + " ");
                    userNum[k][i] = scanner.nextInt();
                } while (userNum[k][i] <= 0 || userNum[k][i] > Constants.RANGE_NUMBER_LOTTERY);
            }
        }
        return userNum;
    }

//Реализуйте метод в классе Utils
//Метод должен принимать два массива (lotteryNumber, userNumber)
//Возвращать количество совпадений
public static int[] CompareWinnerNumbers(int[] lotteryNumber, int[][] userNumber ) {
    int[] countWin = new int[3];
    for (int k = 0; k < 3; k++) {
        for (int i = 0; i < userNumber[k].length; i++) {
            for (int nomWin : lotteryNumber) {
                if (nomWin == userNumber[k][i]) {
                    countWin[k]++;
                    break;
                }
            }
        }
    }
    return countWin;
}
}
