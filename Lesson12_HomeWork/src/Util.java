public class Util {
//    Создайте утилитарный класс, который будет аналогом класса Math.
//    В нём будет один приватный конструктор, а также только статические методы:
//addAll - сложение неограниченного числа аргументов
//minusAll – принимает исходное число и неограниченный набор аргументов,
// которые нужно вычесть из исходного числа
//multAll – перемножает все данные аргументы
//powAll – принимает исходное число-основание и неограниченный набор аргументов
// степеней. Нужно последовательно возвести основание во все степени.
    private Util(){}
    static int addAll(int ... arrNum){
        int sum = 0;
        for (int i = 0; i < arrNum.length; i++) {
            sum +=arrNum[i];
        };
        return sum;
    }

    static int minusAll(int startNum, int ... arrNum){
        for (int i = 0; i < arrNum.length; i++) {
            startNum -=arrNum[i];
        }
        return startNum;
    }

    static int multAll(int ... arrNum){
        int result = 1;
        for (int i = 0; i < arrNum.length; i++) {
            result *=arrNum[i];
        }
        return result;
    }

    static int powAll(int startNum, int ... arrNum){
        int result = 1;
        for (int i = 0; i < arrNum.length; i++) {
            result = 1;
            for (int j = 1; j <= arrNum[i]; j++) {
                result *= startNum;
            }
            startNum = result;
        }
        return result;
    }
}
