package org.example.extraTaskFunction;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class MathFunction {
    public static void main(String[] args) {
        UnaryOperator<Double> unaryOperator1 = x -> getSquare(x);
        UnaryOperator<Double> unaryOperator2 = x -> getCube(x);
        UnaryOperator<Double> unaryOperator3 = x -> getRoot(x);
        UnaryOperator<Double> unaryOperator4 = x -> getSin(x);

        System.out.println("Square numbers from -Pi/2 to Pi/2 ");
        System.out.println(getCalculateFunction(unaryOperator1));

        System.out.println("\nCube numbers from -Pi/2 to Pi/2 ");
        System.out.println(getCalculateFunction(unaryOperator2));

        System.out.println("\nRoot numbers from -Pi/2 to Pi/2 ");
        System.out.println(getCalculateFunction(unaryOperator3));

        System.out.println("\nSin numbers from -Pi/2 to Pi/2 ");
        System.out.println(getCalculateFunction(unaryOperator4));
    }

    private static List<Double> getCalculateFunction(UnaryOperator<Double> function){
        List<Double> result = new ArrayList<>();
        for (double i = -Math.PI/2; i <= Math.PI/2; i+=0.2) {
            result.add(function.apply(i));
        }
        return result;
    }

    private static double getSquare(double x){
        return x*x;
    }

    private static double getCube(double x){
        return x*x*x;
    }

    private static double getRoot(double x){
        return Math.sqrt(Math.abs(x));
    }

    private static double getSin(double x){
        return Math.sin(x);
    }

}
