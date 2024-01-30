import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] arr = {7,6,5,-4,3,2,1};
        System.out.println(Arrays.toString(bubbleSort(arr)));
        int[] arr1 = {7,56,5,-4,3,-2,1};
        System.out.println(Arrays.toString(insertionSort(arr1)));
    }

    private static int[] bubbleSort(int[]arr){
        boolean isSorted;
        do {
            isSorted = true;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i + 1] < arr[i]) {
                    int temp = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = temp;
                    isSorted = false;
                }
            }
        } while (!isSorted);
        return arr;
    }

    private static int[] insertionSort(int[]arr){
        for (int i = 1; i < arr.length; i++) {
            int nom = arr[i];
            int j = i-1;
            while (j>=0 && arr[j]>nom ){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = nom;
        }
        return arr;
    }
}
