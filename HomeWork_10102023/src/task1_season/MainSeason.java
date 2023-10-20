package task1_season;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class MainSeason {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name of month: " + Arrays.toString(Month.values()) + " ");
        String userMonth = scanner.nextLine().toUpperCase(Locale.ROOT);
        System.out.println(Month.valueOf(userMonth).getSeason() + " average temperature: " +
                           Month.valueOf(userMonth).getAverageTemperature());
    }
}
