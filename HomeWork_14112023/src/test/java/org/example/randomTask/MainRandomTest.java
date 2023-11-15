package org.example.randomTask;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MainRandomTest {

    @Test
    void getRandomOdd() {
        Random rnd = Mockito.mock(Random.class);
        Mockito.when(rnd.nextInt(-100,100)).thenReturn(-99);
        int expected = -99;
        assertEquals(expected,new MainRandom().getRandomOdd(rnd));
    }
}