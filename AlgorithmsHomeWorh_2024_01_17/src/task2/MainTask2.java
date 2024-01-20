package task2;

public class MainTask2 {
    public static void main(String[] args) {
        String[] arr = {"at", "", "", "", "ball" , "", "" ,"car" , "", "","dad", ""};
        String findStr = "ball";

        int findPosition = findStringPosition(arr, findStr);
        if (findPosition == -1) System.out.println("Искомая строка не нейдена в заданном массиве");
        else System.out.println("Позиция найденной строки " + findPosition);

    }

    public static int findStringPosition(String[] arr, String findStr) {
        if (arr == null || arr.length == 0 || findStr == null)   return -1;
        int left = 0;
        int right = arr.length - 1;

        // findStr.intern();
        while (left <= right) {
            int mid = left + (right - left) / 2;

            while (arr[mid].isEmpty() && mid < right) mid++;
            if (mid == right) while (arr[mid].isEmpty() && mid > left) mid--;

            int comparisonResult = findStr.compareTo(arr[mid]);

            if (comparisonResult == 0) {
                return mid;
            } else if (comparisonResult < 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

}
//Имеется отсортированный массив строк, в котором могут присутствовать
//пустые строки. Напишите метод для определения позиции заданной строки.
//Пример:
//Ввод: строка "ball" в массиве {"at", "", "", "", "ball" , "", "" ," car" , '"', "",
//"dad", ,, .., ""}
//Вывод: 4