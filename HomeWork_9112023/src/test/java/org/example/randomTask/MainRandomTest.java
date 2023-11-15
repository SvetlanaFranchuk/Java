package org.example.randomTask;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MainRandomTest {

    private static Stream<Arguments> getForRandomNumber() {
       return Stream.of(
                Arguments.of(-99),
                Arguments.of(-1),
                Arguments.of(1),
                Arguments.of(45),
                Arguments.of(99)
        );
    }
    @ParameterizedTest
    @MethodSource("getForRandomNumber")
    void getRandomOdd(int num) {
        Random rnd = Mockito.mock(Random.class);
        Mockito.when(rnd.nextInt(-100,100)).thenReturn(num);
        int expected = num;
        assertEquals(expected,new MainRandom().getRandomOdd(rnd));
    }
}