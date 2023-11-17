package org.example.immutableClass.complexNumber;

public class Main {
    public static void main(String[] args) {
        ComplexNumber number1 = new ComplexNumber(2,3);
        ComplexNumber number2 = new ComplexNumber(3,1);

        System.out.println("Number1: " + number1);
        System.out.println("Number2: " + number2);
        System.out.println("(" + number1 + ")+(" + number2 + ") = " +
                ActionToComplexNumbers.getSumTwoNumbers(number1, number2));
        System.out.println("(" + number1 + ")*(" + number2 + ") = " +
                ActionToComplexNumbers.getMultiplyTwoComplexNumbers(number1, number2));
        System.out.println("(" + number1 + ")/(" + number2 + ") = " +
                ActionToComplexNumbers.getDivideTwoComplexNumbers(number1, number2));
        System.out.println("5*(" + number2 + ") = " +
                ActionToComplexNumbers.getMultiply(number2,5));

    }

}
