package task2;

import java.util.Objects;

public class Fraction {
    int numerator;
    int denominator;
    String fraction;

    public Fraction(int num1, int num2) {
        if (num1>num2){
        this.numerator = num2;
        this.denominator = num1;}
        else{
            this.numerator = num1;
            this.denominator = num2;}
        this.fraction = getProperFraction(this.numerator, this.denominator);
    }

    public static String getProperFraction(int numerator, int denominator){
        return ""+ numerator+"/"+denominator;
    }

    @Override
    public String toString() {
        return  fraction;
    }

    @Override
    public int hashCode(){
        int result;
        result = 1000*this.numerator/this.denominator;
        return result;
    }

    @Override
    public boolean equals (Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fraction f = (Fraction)  o;
        if (denominator/numerator == f.denominator/ f.numerator) return true;
        else return false;
    }
}
////№2 Создайте класс правильной дроби (например, 1/2, 7/8 и т.д.). Числитель и знаменатель будут храниться в
//// отдельных полях типа int. Самостоятельно (без генерации в IDE) реализуйте методы equals и hashCode для класса.
//// Причём дроби с одинаковым результатом необходимо считать эквивалентными, т.е. 1/2 эквивалентна 2/4, эквивалентна
//// 5/10 и т.д.