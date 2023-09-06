import java.util.Scanner;

public class Year {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter year ");
        int userYear = sc.nextInt();
        String result ="";
        result = isLeap(userYear) ? "leap" : "not leap";
        System.out.println("This year is " + result);
    }
    static boolean isLeap(int year){
        if ((year >1584)&&
           ((year%400 == 0)||(year%4 ==0 && year%100 !=0))){
            return true;
        }
        else{
            return false;
        }

    }
}
