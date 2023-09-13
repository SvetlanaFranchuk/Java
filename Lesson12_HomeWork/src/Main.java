import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("addAll, for example 1+3+5+7+9 = " + Util.addAll(1,3,5,7,9));
        System.out.println("minusAll, for example 20-3-5-7-9 = " + Util.minusAll(20,3,5,7,9));
        System.out.println("multAll, for example 1*3*5*7*9 = " + Util.multAll(1,3,5,7,9));
        System.out.println("powAll, for example 2^2^3^2 = " + Util.powAll(2,2,3,2));

        System.out.println("Task2");
        //В программе создайте 3 разных автомобиля и выведите каждый из них в консоль.
        //Создайте массив из этих автомобилей. С помощью Arrays.toString() превратите массив в
        // строку и выведите в консоль.
        //Перейдите в код метода Arrays.toString() и посмотрите на его реализацию. В какой момент
        // автомобиль становится строкой внутри этого метода? - Ответ - при возврате из метода. Внутри метода
        // формируется StringBuilder
        Auto auto1 = new Auto(ModelAuto.AUDI,2021, 12000, TypeAuto.CROSSOVER, 120);
        Auto auto2 = new Auto(ModelAuto.BMW,2019, 8000, TypeAuto.SEDAN, 115);
        Auto auto3 = new Auto(ModelAuto.BENTLEY,2022, 20000, TypeAuto.UNIVERSAL, 150);
        System.out.println(auto1.toString());
        System.out.println(auto2.toString());
        System.out.println(auto3.toString());

        Auto[] arrAuto = new Auto[]{auto1,auto2,auto3};
        System.out.println(Arrays.toString(arrAuto));
    }
}