package breakfast;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ThreadLocalRandom;

public class Breakfast {
    static Deque<Integer> pancakes = new ArrayDeque<>();
    public static void main(String[] args) {
        Grandson grandson = new Grandson(ThreadLocalRandom.current().nextInt(3,21));
        System.out.println("Grandson is " + grandson.getAge());

        for (int i = 0; i < grandson.getAge(); i++) {
            makePancakes();
            System.out.println("Grandma: I make 2 pancakes");
            eatPancakes();
            System.out.println("Grandson: I eat 1 pancakes");
        }
        System.out.println("Grandson: I`m full");
        int countPancakes = 0;
        for (int i = 0; i < pancakes.size(); i++) {
            countPancakes++;
        }
        System.out.println(countPancakes + " pancakes left");
    }

    private static void makePancakes (){
        pancakes.push(1);
        pancakes.push(1);
    }

    private static void eatPancakes(){
        pancakes.pollFirst();
    }
 }
//Напишите программу Завтрак у бабушки. Бабушка жарит блинчик и кладёт его сверху на стопку.
// Внук может скушать только верхний блинчик. В цикле смоделируйте, что за одну итерацию бабушка жарит 2 блинчика,
// а внук съедает только один. Когда внук наелся. Цикл заканчивается.
// Количество блинов, которые может съесть внук равно его возрасту.