package TaskPair;
//Создайте класс для хранения пары строк (Pair). В классе создайте приватные поля first и second. Создайте геттеры
// для этих полей. Создайте блок инициализации, в котором выведите в консоль значение полей first и second, а затем
// присвойте полю first значение “one”, а полю second значение «two».
//Создайте конструктор по умолчанию (без входных параметров). Внутри конструктора выведите в консоль значение
// полей first и second.
//Создайте конструктор, который принимает параметры first и second и обновляет значения соответствующих полей.
// Внутри конструктора выведите в консоль значение полей first и second.
public class Pair {
    private String first;
    private String second;

    {
        System.out.println("В начале инициализации first = " + first);
        System.out.println("В начале инициализации second = " + second);

        first = "one";
        second = "two";
        System.out.println("После инициализации first = " + first);
        System.out.println("После инициализации second = " + second);

    }

    public Pair(){
        System.out.printf("Это вывод внутри конструктора по умолчанию %s \n", first);
        System.out.printf("Это вывод внутри конструктора по умолчанию %s \n", second);
    }

    public Pair(String first, String second){
        this.first = first;
        this.second = second;
        System.out.printf("Это вывод внутри конструктора c параметрами %s \n", first);
        System.out.printf("Это вывод внутри конструктора с параметрами %s \n", second);
    }

    public String getFirst() {
        return first;
    }

    public String getSecond() {
        return second;
    }
}
