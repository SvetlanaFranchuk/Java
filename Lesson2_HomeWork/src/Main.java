// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
       System.out.println("Задание 1.");
       System.out.println("В методе main инициализировать все примитивные типы и не примитивные типы.");
//          Вывести их результат в консоль:
//        char: G
//        int: 89
//        byte: 4
//        short: 56
//        float: 4.7333436
//        double: 4.355453532
//        long: 12121
//
//        Character: G
//        Integer: 89
//        Byte: 4
//        Short: 56
//        Float: 4.7333436
//        Double: 4.355453532
//        Long: 12121
//
         char   myChar      = 'G';
         int    myInt       = 89;
         byte   myByte      = 4;
         short  myShort     = 56;
         float  myFloat     = 4.7333436F;
         double myDouble    = 4.355453532;
         long   myLong      = 12121;

        Character varCharacter = 'G';
        Integer   varInteger   = 89;
        Byte      varByte      = 4;
        Short     varShort     = 56;
        Float     varFloat     = 4.7333436F;
        Double    varDouble    = 4.355453532;
        Long      varLong      = 12121L;

        System.out.println("char:  " + myChar);
        System.out.println("int:   " + myInt);
        System.out.println("byte:  " + myByte);
        System.out.println("short: " + myShort);
        System.out.println("float: " + myFloat);
        System.out.println("double:" + myDouble);
        System.out.println("long:  " + myLong);
        System.out.println("Character:" + varCharacter);
        System.out.println("Integer:  " + varInteger);
        System.out.println("Byte:     " + varByte);
        System.out.println("Short:    " + varShort);
        System.out.println("Float:    " + varFloat);
        System.out.println("Double:   " + varDouble);
        System.out.println("Long:     " + varLong);

        System.out.println("**Задание 2.");
        System.out.println("Дано трехзначное число. Вывести на экран все цифры этого числа");
//        Пример: 345
//        Вывод в консоль: Число 345 -> 3, 4, 5
        int num1 = 345;
        int countHundred = num1/100;
        int countDozens = (num1 - countHundred*100)/10;
        int countUnits = num1 - countHundred*100 - countDozens*10;

        System.out.println(num1 + " \u2192 " + countHundred + ", " + countDozens + ", " + countUnits);
    }
}