package org.example.extraTask;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExtraTasksTest {

   public ExtraTasks extraTasks = new ExtraTasks();

    //example input:
    //Array1: [1, 2, 5, 5, 8, 9, 7, 10]
    //Array2: [1, 0, 6, 15, 6, 4, 7, 0]
    //example expected: [1,7]
    @Test
    void commonElements() {
        int[] array1 = new int[]{1, 2, 5, 5, 8, 9, 7, 10};
        int[] array2 = new int[]{1, 0, 6, 15, 6, 4, 7, 0};
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(7);
        assertEquals(expected, extraTasks.commonElements(array1,array2));
    }

    @Test
    void commonElementsArrayIsNull(){
        int[] array1 = new int[]{1, 2, 5, 5, 8, 9, 7, 10};
        int[] array2 = null;
        assertThrows(NullPointerException.class, ()->extraTasks.commonElements(array1,array2));
        assertThrows(NullPointerException.class, ()->extraTasks.commonElements(array2,array1));
     }


    //example input: [0,3,-2,4,3,2]
    //example expected: [0,3,-2,4,2]
    @Test
    void removeRepetitions() {
        int[] array1 = new int[]{0,3,-2,4,3,2};
        List<Integer> expected = new ArrayList<>();
        expected.add(0);
        expected.add(3);
        expected.add(-2);
        expected.add(4);
        expected.add(2);
        assertEquals(expected, extraTasks.removeRepetitions(array1));
    }
    @Test
    void removeRepetitionsArrayIsNull(){
        int[] array2 = null;
        assertThrows(NullPointerException.class, ()->extraTasks.removeRepetitions(array2));
    }

    //example input: [-1, 4, 0, 2, 7, -3]
    //example expected: 4
    @Test
    void maxNext() {
        int[] array1 = new int[]{-1, 4, 0, 2, 7, -3};
        int expected = 4;
        assertEquals(expected, extraTasks.maxNext(array1));
    }

    @Test
    void maxNextArrayIsNull(){
        int[] array2 = null;
        assertThrows(NullPointerException.class, ()->extraTasks.maxNext(array2));
    }

    //example input: [-1, 4, 0, 2, 7, -3]
    //example expected: -1
    @Test
    void minNext() {
        int[] array1 = new int[]{-1, 4, 0, 2, 7, -3};
        int expected = -1;
        assertEquals(expected, extraTasks.minNext(array1));
    }
    @Test
    void minNextArrayIsNull(){
        int[] array2 = null;
        Exception e = assertThrows(NullPointerException.class, ()->extraTasks.minNext(array2));
        assertEquals("Array is null", e.getMessage());
    }
}