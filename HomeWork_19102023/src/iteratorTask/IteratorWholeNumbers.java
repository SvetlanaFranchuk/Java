package iteratorTask;

import java.util.*;
import java.util.List;

public class IteratorWholeNumbers {
    public static void main(String[] args) {

        List<Integer> list = List.of(-7,23,1,2,300,5,3,6,8);

        Iterator<Integer> iterator = new Iterator<Integer>() {

            private final List<Integer> innerList = new ArrayList<>(list);
            {
                innerList.sort(Comparator.comparing(Integer::intValue));
                Collections.reverse(innerList);
            }
            @Override
            public boolean hasNext() {
                return !innerList.isEmpty();
            }

            @Override
            public Integer next() {
                if (!hasNext()) throw new NoSuchElementException();
                return innerList.remove(0);
            }
        };


        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("---------------------");
        for (Integer i: list) {
            System.out.println(i);
        }
    }
}
//3 Создайте итератор по массиву целых чисел, который будет выводить элементы в порядке их убывания.
// Исходный массив не должен при этом измениться.