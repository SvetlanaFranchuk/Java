import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
    float myNum1 = enterNum();
    float myNum2 = enterNum();
    //найдем положительную разницу
        float razn1;
        float razn2;
        if ((10-myNum1) >=0) {
            razn1 = 10-myNum1;
        }
        else {
            razn1 = -1 * (10-myNum1);
        }
        if ((10-myNum2) >=0) {
            razn2 = 10-myNum2;
        }
        else {
            razn2 = -1 * (10 - myNum2);
        }
    if (razn1 >razn2){
        System.out.println("Число " + myNum2 + " ближе к 10");
    }
    else if (razn1 < razn2) {
        System.out.println("Число " + myNum1 + " ближе к 10");
    }
    else {
        System.out.println("Числа " + myNum1 + " и " + myNum2 + " одинаково удалены от 10");
    }
    }
    static float enterNum(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number ");
        float myNumber = (float)scanner.nextFloat();
        return myNumber;
    }
}
