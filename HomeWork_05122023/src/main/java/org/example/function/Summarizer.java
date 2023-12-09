package org.example.function;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Summarizer {

    public Summarizer() {
    }

    public static double sum(long low, long high){
        double sum = 0;
        for (long n = low; n <= high; n++) {
            sum += 1.0/(n*(n+1));
         }
        return sum;
    }

    public static double parallelSum(long upperLimit){
        System.out.println("We use thread in task");
        List<Task> tasks = getTask(upperLimit);
        for (Task t:tasks) {
            Thread thread = new Thread(()->t.setResult(sum(t.getLow(), t.getHigh())));
            thread.start();
        }
        double sum = 0;
        while (!tasks.isEmpty()){
            for (Iterator<Task> i = tasks.iterator(); i.hasNext();) {
                Task t = i.next();
                if (t.getResult().isPresent()){
                    sum += t.getResult().get();
                    System.out.println(t);
                    i.remove();
                }
            }
        }
        return sum;
    }
    
    private static List<Task> getTask(long upperLimit){
        List<Task> tasks = new ArrayList<>();
        for (long i = 0; i < upperLimit; i+=upperLimit/5) {
            tasks.add(new Task(i+1, i + upperLimit / 5<=upperLimit ? (i+upperLimit/5) : upperLimit));
        }
        return tasks;
    }
}
