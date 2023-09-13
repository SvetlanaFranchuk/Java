import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //№1.
        //Создайте массив из 8 случайных целых чисел из интервала [1;50]
        //Выведите массив на консоль в строку.
        //Замените каждый элемент с нечетным индексом на ноль.
        //Снова выведете массив на консоль в отдельной строке.
        //
        Random rnd = new Random();
        int[] arr = new int[8];
        for (int i = 0; i < 8; i++) {
            arr[i]= 1 + rnd.nextInt(50);
        }
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < 8; i++) {
            if (i%2 != 0){
                arr[i]=0;
            }
        }
        System.out.println(Arrays.toString(arr));

        //№2.
        //Создайте массив из 5 случайных целых чисел из интервала [10;99]
        int[] arr2 = new int[5];
        for (int i = 0; i < 5; i++) {
            arr2[i]= 10 + rnd.nextInt(89);
        }

        //Выведите его на консоль в строку.
        System.out.println(Arrays.toString(arr2));
        //Определите и выведите на экран сообщение о том, является ли массив строго
        // возрастающей последовательностью.
        boolean isIncreasing = false;
        for (int i = 0; i < arr2.length-1; i++) {
            if(arr2[i]<arr2[i+1]){
                isIncreasing  =true;
            }
            else {
                isIncreasing = false;
                break;
            }
        }
        System.out.println("Array is " + (isIncreasing ? "": "not") + " increasing ");
    }
}