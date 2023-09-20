package org.example.Practice3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LotteryEngineTest {

    @Test
    void testRunLotteryZiro() {
        LotteryEngine le = new LotteryEngine();
        le.runLottery();
        int[] realLuckyNom = le.getLuckyNumbers();
        int[] expLuckyNom = {0,0,0,0,0};
        boolean isZeroArr = Arrays.equals(realLuckyNom,expLuckyNom);
        Assertions.assertFalse(isZeroArr);
    }
}