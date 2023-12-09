package org.example.function;

import java.util.Scanner;

public class MainFunction {
    public static void main(String[] args) {
        long upperLimit = getEndNumber();
        System.out.println(Summarizer.parallelSum(upperLimit));

    }

    public static long getEndNumber(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter upper limit: ");
        return scanner.nextLong();
    }
}
//1/n*(n+1)=1