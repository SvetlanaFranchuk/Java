package model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Bag {
    List<Integer> bag;

    public Bag() {
        this.bag = fillBag();
    }

    public static List<Integer> fillBag(){
        List<Integer> bag = new ArrayList<>();
        for (int i = 0; i < 90; i++) {
            bag.add(i + 1);
        }
        return bag;
    }

    public List<Integer> getBag() {
        return bag;
    }

    public int takeCurrentNumber(){
        int nomRandom = ThreadLocalRandom.current().nextInt(1, this.bag.size());
        int currentNum = this.bag.get(nomRandom);
        this.bag.remove(nomRandom);
        return currentNum;
    }
}
