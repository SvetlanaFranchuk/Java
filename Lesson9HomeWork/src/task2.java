import java.util.Random;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class task2 {
    public static void main(String[] args) {
    int countSec = randomNum();
    int leftHours;
    leftHours = countSec / 3600;
        System.out.println("До конца рабочего дня осталось " + countSec + " секунд");
        if (leftHours >= 5) {
        System.out.println("До конца рабочего дня осталось " + leftHours + " часов");}
        else if (leftHours < 5 && leftHours >= 2) {
            System.out.println("До конца рабочего дня осталось " + leftHours + " часа");}
        else if (leftHours == 1) {
            System.out.println("До конца рабочего дня остался " + leftHours + " час");}
        else {
            System.out.println("До конца рабочего дня осталось меньше часа ");}

    }
    static int randomNum(){
        Random rand = new Random();
        int myNum = rand.nextInt(28800);
        return myNum;
    }
}