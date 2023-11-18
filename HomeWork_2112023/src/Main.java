import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Random rnd = new Random();

        guessRiddle();
        Bicycle bicycle1 = new Bicycle(new Bicycle.SteeringWheel(),
                //new Bicycle.SteeringWheel(rnd.nextInt(10, 15)),
                new Bicycle.Saddle(),
                new Bicycle.Frame(),
                new Bicycle.Gear(),
                new Bicycle.Wheel(5),
                new Bicycle.Wheel(6));
        System.out.println(bicycle1);
        System.out.println((char) 27 + "[33m" + "Let`s go for a ride".toUpperCase(Locale.ROOT) + (char) 27 + "[0m");
        System.out.println();
        do {
            if (getMinMarginSafety(bicycle1) == 0) break;
            Obstacle.createObstacle(bicycle1);
            Thread.sleep(1000);
        } while (true);

        System.out.println();
        System.out.println("Margin safety of your bike: ");
        System.out.println(bicycle1);
    }

    /**
     * загадка про велосипед
     */
    private static void guessRiddle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Отгадайте загадку: с крыльями, но не летает, с цепью, но не лает,\n" +
                "                   со спицами, но не вяжет, с седлом, но не скачет, с рамой, но не дует");
        String answer = "";
        do {
            answer = scanner.next().toLowerCase(Locale.ROOT);
            if (answer.equals("велосипед") || answer.equals("bike") || answer.equals("bicycle")) {
                System.out.println("correct");
                break;
            } else
                System.out.println("try again");
        } while (true);
    }

    /**
     * метод для определения самой поврежденной части велосипеда
     *
     * @param bicycle - велосипед
     * @return минимальное значение прочности для существующих частей велосипеда
     */
    private static int getMinMarginSafety(Bicycle bicycle) {
        int[] marginSafety = new int[]{
                bicycle.getSteeringWheel().getMarginSafety(),
                bicycle.getSaddle().getMarginSafety(),
                bicycle.getFrame().getMarginSafety(),
                bicycle.getGear().getMarginSafety(),
                bicycle.getWheel1().getMarginSafety(),
                bicycle.getWheel2().getMarginSafety()
        };
        int min = marginSafety[0];
        for (int j : marginSafety) {
            if (j < min) min = j;
        }
        return min;
    }
}

// 1 уровень сложности: 1 Отгадайте загадку: с крыльями, но не летает, с цепью, но не лает,
// со спицами, но не вяжет, с седлом, но не скачет, с рамой, но не дует.
//2 Создайте класс Велосипед. Типы полей этого класса должны быть объявлены как внутренние классы
// (руль, седло, колесо, передачи, рама и т.д.). Каждая часть велосипеда помимо описания характеристик
// хранит запас прочности. Когда запас прочности равен 0, часть велосипеда ломается.
//3 В основной программе создайте велосипед. Велосипед должен ехать и встречать на пути препятствия
// (яма, бордюр, битое стекло, лужа и т.д.). Каждое препятствие уменьшает показатель прочности на
// случайную величину у случайной части велосипеда. Программа выполняется, пока у велосипеда нет сломанных частей.
//4 Напишите JavaDoc для написанных классов и  методов. Одним из способов сгенерируйте документацию.