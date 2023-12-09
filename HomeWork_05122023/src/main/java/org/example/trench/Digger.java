package org.example.trench;

public class Digger {
    String name;

    public Digger(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Runnable doWork(Trench trench) {
        Runnable digging = () -> {
            while (trench.dig(name) > 0) {
                try {
                    System.out.println(name + " rest now");
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        return digging;
    }
}
