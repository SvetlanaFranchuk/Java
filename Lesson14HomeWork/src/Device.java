import java.util.Scanner;

public class Device {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter temperature1 ");
        double temperature1 = scanner.nextDouble();
        System.out.print("Enter temperature2 ");
        double temperature2 = scanner.nextDouble();
        String result = checkDevice(temperature1,temperature2) ? "Device wokrs correctly": "Device doesn't work correctly";
        System.out.println(result);
    }
    static boolean checkDevice(double t1, double t2){
        if (t1>100 && t2<100){
            return true;
        }
        else{
            return false;
        }
    }
}