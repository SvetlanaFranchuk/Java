import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        System.out.println("№ 1");
        System.out.println("1. Создайте строку через new - I study Basic Java!");
        String myStr = new String("I study Basic Java!");

        System.out.println("2. Распечатать пред-последний символ строки. Используем метод String.charAt(). ");
        System.out.println("Result = " + myStr.charAt(myStr.length()-2));

        System.out.println("3. Проверить, содержит ли ваша строка подстроку “Java”. Используем метод String.contains(). ");
        System.out.println("Result = " + myStr.contains("Java"));

        System.out.println("4. Вырезать строку Java c помощью метода String.substring().");
        String myStr1 = myStr.substring(14);
        System.out.println("Result = " + myStr1.substring(0,4));

        System.out.println("5. Заменить все символы “а” на “о”.");
        System.out.println(myStr.replace("a","o"));

        System.out.println("6. Преобразуйте строку к верхнему регистру.");
        System.out.println(myStr.toUpperCase());

        System.out.println("7. Преобразуйте строку к нижнему регистру.");
        System.out.println(myStr.toLowerCase());

        System.out.println("№ 2");
        System.out.println("Создайте программу, в которой нужно ввести 2 параметра, сделайте  операции с математическими операциями +, -, *, /");
        System.out.println("Результат распечатайте в консоль");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first number (type float) ");
        float myFloat1 = scanner.nextFloat();
        System.out.print("Enter second number (type float) ");
        float myFloat2 = scanner.nextFloat();

        float myResult;
        myResult= myFloat1 + myFloat2;
        System.out.println("result: " + myFloat1 + " + " + myFloat2 + " = " + myResult);
        myResult = myFloat1 - myFloat2;
        System.out.println("result: " + myFloat1 + " - " + myFloat2 + " = " + myResult);
        myResult = myFloat1 * myFloat2;
        System.out.println("result: " + myFloat1 + " * " + myFloat2 + " = " + myResult);
        myResult = myFloat1 / myFloat2;
        System.out.println("result: " + myFloat1 + " / " + myFloat2 + " = " + myResult);

    }
}