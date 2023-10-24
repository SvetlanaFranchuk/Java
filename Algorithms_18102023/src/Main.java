public class Main {
    public static void main(String[] args) {
        //1 уровень сложности: Дан отсортированный массив, в котором все элементы встречаются дважды (один за другим),
        // а один элемент появляется только один раз.
        //Написать метод для нахождения этого элемента.
        //Решить задачу
        //через простой цикл
        //2*. через адаптацию алгоритма бинарного поиска

        int[] array = new int[]{1, 1, 4, 4, 7, 7, 8, 8, 9, 10, 10};
        if (array.length % 2 == 0) System.out.println("Bad date");
        else {
            System.out.println(searchElementNotDouble(array));
            System.out.println(searchBinaryElementNotDouble(array));
        }
    }


    public static int searchElementNotDouble(int[] array) {
        for (int i = 0; i < array.length - 1; i += 2) {
            if (array[i] != array[i + 1]) {
                return array[i];
            }
        }
        return array[array.length - 1];
    }

    public static int searchBinaryElementNotDouble(int[] array) {
        int start = 0;
        int end = array.length - 1;

        if (array[start] != array[start + 1]) return array[start];
        if (array[end] != array[end - 1]) return array[end];
        else {
            int middle = start + (end - start) / 2;
            while (start < end) {
                if ((middle % 2 == 0 && array[middle] == array[middle + 1]) ||
                        (middle % 2 != 0 && array[middle] == array[middle - 1])) { //we should search on the left
                    start = middle;
                    middle = start + (end - start) / 2;
                } else if ((middle % 2 == 0 && array[middle] == array[middle - 1]) ||
                        (middle % 2 != 0 && array[middle] == array[middle + 1])) { //we should search on the right
                    end = middle;
                    middle = start + (end - start) / 2;
                } else return array[middle];
            }
        }
        return 0; //Сюда не придет никогда
    }
}