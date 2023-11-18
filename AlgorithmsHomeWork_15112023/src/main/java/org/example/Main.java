package org.example;

import java.util.Arrays;

//Решить задачу одним из методов динамического программирования:
//
//Самый дешёвый путь
//В каждой клетке прямоугольной таблицы N*M записано некоторое число.
//Изначально игрок находится в левой верхней клетке. За один ход ему разрешается перемещаться в соседнюю клетку либо вправо, либо вниз
//(влево и вверх перемещаться запрещено). При проходе через клетку игрок платит определенную сумму, значение которой записано в этой клетке.
//Требуется найти минимальную стоимость пути, отдав которую игрок может попасть в правый нижний угол.
//
//
//Входные данные:
//int[][] costs = new int[][]{{0, 1, 4, 4},
//{4, 1, 1, 1},
//{4, 4, 4, 1},
//{4, 4, 4, 0}};
//
//Результат: minCost(costs) = 5
public class Main {
    public static void main(String[] args) {
        int[][] costs = new int[][]{{0, 1, 4, 4},
                {4, 1, 1, 1},
                {4, 4, 4, 1},
                {4, 4, 4, 0}};

        System.out.println(Arrays.deepToString(costs));
        int[][] resultArray = costsTabulation(costs);
        System.out.println(Arrays.deepToString(resultArray));

        System.out.println("Minimum cost = " + resultArray[resultArray.length - 1][resultArray[0].length - 1]);
    }

    public static int[][] costsTabulation(int[][] costs) {
        int[][] costsSum = new int[costs.length][costs[0].length];
        costsSum[0][0] = costs[0][0];
        int minPrevious;
        for (int i = 0; i < costs.length; i++) {
           for (int j = 0; j < costs[0].length; j++) {
                if (i == 0 && j == 0) minPrevious = 0;
                else {
                    if (i == 0 && j > 0)      minPrevious = costsSum[i][j - 1];
                    else if (i > 0 && j == 0) minPrevious = costsSum[i - 1][j];
                    else {
                        if (costsSum[i - 1][j] < costsSum[i][j - 1]) minPrevious = costsSum[i - 1][j];
                        else  minPrevious=costsSum[i][j - 1];
                    }
                }
            costsSum[i][j] = minPrevious + costs[i][j];
            }
        }
        return costsSum;
    }

}

