package org.example.task3Random;

import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.*;

public class RandomWithLambda {
    public static void main(String[] args) {
        System.out.println(getRandomBinaryOperator(10,20));
        System.out.println(getRandomSupplier(10,20));
        getRandomConsumer(10,20);
        System.out.println(getRandomUnaryOperator(10,20));
    }

    public static int getRandomBinaryOperator(int start, int end){
      BinaryOperator<Integer> binaryOperator = (s,e) -> s + (int)Math.round((e-s) * Math.random());
      return  binaryOperator.apply(start,end);
    }

    public static int getRandomSupplier(int start, int end){
        Supplier<Integer> supplier = () -> {
            Random random= new Random();
            return random.nextInt(start,end);
        };
        return supplier.get();
    }

    public static void getRandomConsumer(int start, int end){
        Consumer<Integer> consumer = v -> {
        SecureRandom secureRandom = new SecureRandom();
        System.out.println(start + secureRandom.nextInt(v));
        };
        consumer.accept(end+1-start);
    }

    public static int getRandomUnaryOperator(int start, int end){
        UnaryOperator<Integer> unaryOperator = v -> {
            Random rnd = ThreadLocalRandom.current();
            return rnd.nextInt(v);
        };
        return start + unaryOperator.apply(end+1-start);
    }
}
