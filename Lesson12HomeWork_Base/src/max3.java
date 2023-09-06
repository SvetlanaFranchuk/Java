import java.util.Scanner;

public class max3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number1 ");
        int number1 = sc.nextInt();
        System.out.print("Enter number2 ");
        int number2 = sc.nextInt();
        System.out.print("Enter number3 ");
        int number3 = sc.nextInt();
        if (number1>number2 && number1>number3){
            System.out.println("max number is " + number1);
        } else if (number2>number1 && number2>number3) {
            System.out.println("max number is " + number2);
        }else if (number3>number1 && number3>number2) {
            System.out.println("max number is " + number3);
        }
        else{
            System.out.println("all numbers are equal");
        }

    }
}
