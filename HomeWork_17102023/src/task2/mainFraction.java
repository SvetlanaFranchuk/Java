package task2;

import java.util.*;

public class mainFraction {
    public static void main(String[] args) {
        List<Fraction> list = new ArrayList<>();
        list = getList();
        System.out.println(list);

        System.out.println("not equal fractions");
        Set<Fraction> list1 = new HashSet<>(list);
        System.out.println(list1);

    }

    public static List<Fraction> getList() {
        Random rnd = new Random();
        List<Fraction> list = new ArrayList<>();
        int i = 0;
        int num1;
        int num2;
        //генерация листа дробей
        while (i < rnd.nextInt(10, 40)) {
            num1 = rnd.nextInt(1, 11);
            num2 = rnd.nextInt(1, 11);
            if (num1 != num2) {
                list.add(i, new Fraction(num1, num2));
                i++;
            }
        }
        return list;
    }

}
////№2 Создайте класс правильной дроби (например, 1/2, 7/8 и т.д.). Числитель и знаменатель будут храниться в
//// отдельных полях типа int. Самостоятельно (без генерации в IDE) реализуйте методы equals и hashCode для класса.
//// Причём дроби с одинаковым результатом необходимо считать эквивалентными, т.е. 1/2 эквивалентна 2/4, эквивалентна
//// 5/10 и т.д.