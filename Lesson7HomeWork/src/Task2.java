import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        System.out.println("2.Реализовать программу, выводящую на экран результаты:");
        System.out.println("Сложения двух чисел");
        System.out.println(" Вычитания двух чисел");
        System.out.println("Умножения двух чисел");
        System.out.println("Деления двух чисел");
        System.out.println("Каждая из арифметических операций должна быть реализована как отдельный метод.");

        int myInt1 = EnterNum();
        int myInt2 = EnterNum();

        System.out.println(myInt1 + " + " + myInt2 + " = " + CalcSum(myInt1, myInt2) );
        System.out.println(myInt1 + " - " + myInt2 + " = " + CalcCubstraction(myInt1, myInt2) );
        System.out.println(myInt1 + " * " + myInt2 + " = " + CalcMultiplay(myInt1, myInt2) );
        System.out.println(myInt1 + " / " + myInt2 + " = " + CalcDivide(myInt1, myInt2) );
    }
    static int EnterNum (){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number ");
        int num = scanner.nextInt();
        return num;
    }

    static int CalcSum(int num1, int num2){
        return num1 + num2;
    }

    static int CalcCubstraction(int num1, int num2){
        return num1 - num2;
    }

    static int CalcMultiplay(int num1, int num2){
        return num1 * num2;
    }

    static float CalcDivide(int num1, int num2){
        return num1 / num2;
    }

}
