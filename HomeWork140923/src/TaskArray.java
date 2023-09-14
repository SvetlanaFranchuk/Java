import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TaskArray {
    public static void main(String[] args) {
       //№1
        //Дан массив размера  n-1, содержащий только различные целые числа в
        // диапазоне от 1 до n . Найдите недостающий элемент.
        //input:
        //arr[] = {1,2,3,5}
        //out: 4
        //arr[] = {6,1,2,8,3,4,7,10,5}
        //out: 9
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = scanner.nextInt();
        Random rnd = new Random();
        int[] arr = new int[n-1];
        int num=0;
        boolean isUnic=false;
        for (int i = 0; i < n-1 ; i++) {
           while (isUnic==false) {
               isUnic = true;
               num = 1 + rnd.nextInt(n);
               for (int j = 0; j <= i; j++) {
                   if (arr[j] == num) {
                       isUnic = false;
                       break;
                   }
               }
           }
            if (isUnic){
                arr[i] = num;}
            isUnic = false;
        }
        System.out.println(Arrays.toString(arr));

        boolean isFind;
        for (int i = 1; i <= arr.length; i++) {
            isFind = false;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j]==i){
                    isFind = true;
                    break;
                }
            }
            if (!isFind){
                System.out.println("There isn't number " + i);
                break;
            }
        }

    }
}