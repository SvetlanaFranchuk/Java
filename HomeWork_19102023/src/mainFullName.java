import compare.FirstNameComparator;
import fullName.FullName;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class mainFullName {

    public static void main(String[] args) {
        Set<FullName> set = new TreeSet<>(new FirstNameComparator());
        set.add(new FullName("Ivan","Ivanov"));
        set.add(new FullName("Petr","Ivanov"));
        set.add(new FullName("Simon","Ivanov"));

        set.forEach(fN -> System.out.println(fN.getFirstName() + " " + fN.getLastName()) );

        Iterator<FullName> iterator = set.iterator();
        while (iterator.hasNext()){
            FullName fullName = iterator.next();
            System.out.println(fullName.getFirstName());
        }

        for (Iterator<FullName> i = set.iterator(); i.hasNext();) {
            FullName fN = i.next();
            System.out.println(fN.getFirstName() + " - " + fN.getLastName());
        }


    }


}
// 1 уровень сложности: 1 Создайте класс fullName.FullName полного имени человека (firstName, lastName).
// Создайте TreeSet с экземплярами этого класса. При создании TreeSet передайте в него компаратор,
// который сравнивает экземпляры по полю firstName. Выведите множество в консоль.

//2 Создайте коллекцию (List или Set), добавьте несколько элементов.
// Организовать цикл while по коллекции с помощью итератора. Организовать цикл for (не путать с foreach!)
// по коллекции с помощью итератора.
//3 Создайте итератор по массиву целых чисел, который будет выводить элементы в порядке их убывания.
// Исходный массив не должен при этом измениться.