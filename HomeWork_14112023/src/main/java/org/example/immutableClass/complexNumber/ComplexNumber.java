package org.example.immutableClass.complexNumber;

public final class ComplexNumber {
    private final double a;
    private final double b;

    public ComplexNumber(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    @Override
    public String toString() {
        return  a + " + i" + b;
    }

}
//создайте неизменяемый класс комплексных чисел