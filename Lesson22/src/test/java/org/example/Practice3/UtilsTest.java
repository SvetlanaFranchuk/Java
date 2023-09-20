package org.example.Practice3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

    @Test
    void TestCompareWinnerNumbers() {
        int[] expWinCount = {5,5,5};
        int[] expLotteryNumbers = {1,2,3,4,5};
        int[][] expUserNumbers = {{1,2,3,4,5},{1,2,3,4,5},{1,2,3,4,5}};
        int[] realWinCount = Utils.CompareWinnerNumbers(expLotteryNumbers,expUserNumbers);
        Assertions.assertArrayEquals(expWinCount,realWinCount);
    }

    @Test
    void TestCompareWinnerNumbersNull() {
        int[] expWinCount = {0,0,0};
        int[] expLotteryNumbers = new int[5];
        int[][] expUserNumbers = {{1,2,3,4,5},{1,2,3,4,5},{1,2,3,4,5}};
        int[] realWinCount = Utils.CompareWinnerNumbers(expLotteryNumbers,expUserNumbers);
        Assertions.assertArrayEquals(expWinCount,realWinCount);
    }

}