package org.example.trench;

public class Trench {
    private int targetLength;
    private int currentLength;

    public Trench(int targetLength) {
        this.targetLength = targetLength;
        this.currentLength = 0;
    }

    public int getCurrentLength() {
        return currentLength;
    }

    public synchronized int dig(String nameDigger){
        if (currentLength >= targetLength){
            System.out.println("Work done!");
            return 0;
        }
        currentLength++;
        System.out.println(nameDigger + " dig. Current length of trench is " + currentLength + " m");
        return 1;
    }
}
