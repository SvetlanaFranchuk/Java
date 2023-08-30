import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Task1 {
    public static void main(String[] args) {
        System.out.println("№1.  Введите 2 слова, воспользуйтесь сканером, состоящие из четного количества букв ");
        System.out.println("(проверьте количество букв в слове). Нужно получить слово, состоящее из первой половины первого слова");
        System.out.println(" и второй половины второго слова. распечатать на консоль.");
//                Например:
//        ввод - mama, papa
//        вывод - mapa
        String str1 = enterStr("first");
        String str2 = enterStr("second");
        String newStr;
        // В задании не сказано, что делать со строкой, у которой нечетное кол-во символов
        //поэтому пошла таким методом
        if (changeLenghtStr(str1)) {
            newStr = str1.substring(0, str1.length()/2);
        }
        else {
            newStr = str1.substring(0, (str1.length()-1)/2);
        }
        if (changeLenghtStr(str2)) {
            newStr = newStr + str2.substring(str2.length()/2, str2.length());
        }
        else {
            newStr = newStr + str2.substring((str2.length()-1)/2, str2.length());
        }

        System.out.println("New str = " + newStr);
    }
    static String enterStr(String nomStr){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter " + nomStr + " word ");
        String str1 = scanner.nextLine();
        return str1;
    }

    static  boolean changeLenghtStr(String str){
        if (str.length() % 2 ==  0) {
            return true;
        }
        else {
            return false;
        }
    }


}