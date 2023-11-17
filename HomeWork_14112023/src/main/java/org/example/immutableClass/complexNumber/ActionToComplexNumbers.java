package org.example.immutableClass.complexNumber;

public class ActionToComplexNumbers {

    public ActionToComplexNumbers() {
    }

    public static ComplexNumber getSumTwoNumbers(ComplexNumber num1, ComplexNumber num2){
        return new ComplexNumber(num1.getA()+num2.getA(), num1.getB() +  num2.getB());
    }

    public static ComplexNumber getMultiplyTwoComplexNumbers (ComplexNumber num1, ComplexNumber num2) {
        double x1 = num1.getA();
        double x2 = num2.getA();
        double y1 = num1.getB();
        double y2 = num2.getB();

        return new ComplexNumber( x1*x2-y1*y2, x1*y2+x2*y1 );
    }

    public static ComplexNumber getMultiply(ComplexNumber num1, double num2){
        return new ComplexNumber(num1.getA()*num2, num1.getB()*num2);
    }

    public static ComplexNumber getDivideTwoComplexNumbers (ComplexNumber num1, ComplexNumber num2) {
        double x1 = num1.getA();
        double x2 = num2.getA();
        double y1 = num1.getB();
        double y2 = num2.getB();

        return new ComplexNumber( (x1*x2+y1*y2)/(x2*x2+y2*y2), (x2*y1-x1*y2)/(x2*x2+y2*y2) );
    }

}
