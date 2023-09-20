package org.example.Practice3;

import java.util.Arrays;

//Изменить написанный код
//Распределите ответственность написанного кода в соответствующие классы и методы
//Сохраните номера лотереи в массиве
//Введите контроль за количеством номеров в лотереи и от пользователя


//Протестируйте работу лотереи в классе StartLottery
//Выведите результаты на консоль
public class StartLottery {
    public static void main(String[] args) {
        // номера, которые ввел пользователь
        int[][] userNum = Utils.getUserLotteryNumber();
        LotteryEngine le = new LotteryEngine();
        le.runLottery();
        int[] luckyNom = le.getLuckyNumbers();
        int[] countWin = Utils.CompareWinnerNumbers(luckyNom,userNum);

        System.out.println("Счастливые номера лотереи  : "+ Arrays.toString(luckyNom));

        for (int i = 0; i <3 ; i++) {
            System.out.println("Для игрока " + (i+1));
            System.out.println("Пользовательские номера : "+ Arrays.toString(userNum[i]));

            System.out.println("Совпало : "+countWin[i]);
        }
    }
}
