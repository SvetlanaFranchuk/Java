package task1ChangeElement;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] array = {"t0","t1","t2","t3"};
        System.out.println(Arrays.toString(array));

        swab(array, 2, 0);
        System.out.println(Arrays.toString(array));

        Integer[] array1 = {0,1,2,3};
        System.out.println(Arrays.toString(array1));

        swab(array1, 2, 0);
        System.out.println(Arrays.toString(array1));

    }
    private static <T> void swab(T[] array, int index1, int index2){
        Object o;
        o = array[index1];
        array[index1] = array[index2];
        array[index2] = (T)o;
    }
}
//Напишите параметризированный метод для обмена позициями двух разных элементов в массиве.
// Метод принимает параметризированный массив и индексы элементов, которые нужно обменять.