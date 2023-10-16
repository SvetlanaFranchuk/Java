package task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomList {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        List<Integer> listPositive = new ArrayList<>();

        list = getRandomList();
      //  System.out.println(list);

        listPositive = getPositiveList(list);
      //  System.out.println(listPositive);
    }

    static List getRandomList() {
        List<Integer> list = new ArrayList<>();
        Random rnd = new Random();
       // int count = rnd.nextInt(1, 1000);
        int count = rnd.nextInt(1, Integer.MAX_VALUE);
        for (int i = 0; i < count; i++) {
            list.add(i, rnd.nextInt(-100, 101));
        }
        return list;
    }

    static List getPositiveList(List<Integer> list1) {
        for (int i = list1.size()-1; i >= 0; i--) {
            if (list1.get(i) < 0) {
                list1.remove(i);
            }
        }
        return list1;
    }

}
