import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter sum your account ");
        int mySum = scanner.nextInt();
        int myDiv = 1;
        int countDays = 0;
        while (mySum >= 1) {
            for (int i = mySum; i >= 1; i--) {
                myDiv = 1;
                if (mySum != i && mySum % i == 0) {
                    myDiv = i;
                    break;
                }
            }
            mySum -= myDiv;
            ++countDays;
            System.out.println("Снято " + myDiv + ", осталось = " + mySum);
        }
        System.out.println("Количество дней для снятия всей суммы " + countDays);
    }
}
