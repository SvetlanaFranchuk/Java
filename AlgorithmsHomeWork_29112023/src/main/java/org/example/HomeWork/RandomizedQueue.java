package org.example.HomeWork;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

// Class for the hometask
public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] itemArray;
    private int numberOfItems;
    private int realNumberOfItems;

    public RandomizedQueue() {
        this.itemArray = (Item[]) new Object[0];
        this.numberOfItems = 0;
        this.realNumberOfItems = 0;
    }

    //асимптотический анализ O(n) resize при (numberOfItems == 0) опускаем, т.к. единичная операция,
    //                            цикл при numberOfItems == itemArray.length даст нам сложность О(n)
    //амортизированный анализ Oam(при большом кол-ве операций с очередью усредненная сложность добавления
    //                            в очередь даст сложность О(1))
    public void enqueue(Item item) {
        if (item == null) throw new NullPointerException();
        if (numberOfItems == 0) resize(1);
        else if (numberOfItems == itemArray.length) resize(2 * itemArray.length);
        itemArray[numberOfItems++] = item;
        realNumberOfItems++;
    }

    //асимптотический анализ infinit
    //амортизированный анализ Oam(1)
    public Item sample() {
        if (realNumberOfItems > 0) {
            RandomOutput randomOutput = new RandomOutput(itemArray, numberOfItems).get();
            return randomOutput.randomItem;
        } else {
            throw new NoSuchElementException();
        }
    }

    //асимптотический анализ infinit
    //амортизированный анализ Oam(1)
    public Item dequeue() {
        if (realNumberOfItems > 0) {
            RandomOutput randomOutput = new RandomOutput(itemArray, numberOfItems).get();
            itemArray[randomOutput.randomIndex] = null;
            if (--realNumberOfItems == itemArray.length / 4) resize(itemArray.length / 2);
            return randomOutput.randomItem;
        } else {
            throw new NoSuchElementException();
        }
    }

    //асимптотический анализ O(1)
    //амортизированный анализ Oam(1)
    public boolean isEmpty() {
        return realNumberOfItems == 0;
    }

    //асимптотический анализ O(1)
    //амортизированный анализ Oam(1)
    public int size() {
        return realNumberOfItems;
    }

    //асимптотический анализ infinit
    //амортизированный анализ Oam(n)
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            private Item[] copy = getRandomCopy(itemArray, numberOfItems, realNumberOfItems);
            private int copyNumberOfItems = copy.length;
            @Override
            public boolean hasNext() {
                return copyNumberOfItems > 0;
            }
            @Override
            public Item next() {
                if (copyNumberOfItems == 0) throw new NoSuchElementException();
                return copy[--copyNumberOfItems];
            }
        };
    }

    private Item[] getRandomCopy(Item[] itemArray, int numberOfItems, int realNumberOfItems) {
        Item[] copy = (Item[]) new Object[realNumberOfItems];
        Item[] tmpCopy = getCopy(itemArray, numberOfItems, realNumberOfItems);
        for (int i = 0; i < realNumberOfItems; i++) {
            RandomOutput randomOutput = new RandomOutput(tmpCopy, tmpCopy.length).get();
            tmpCopy[randomOutput.randomIndex] = null;
            copy[i] = randomOutput.randomItem;
            if (tmpCopy.length - i - 1 == tmpCopy.length / 2) {
                tmpCopy = getCopy(tmpCopy, tmpCopy.length, tmpCopy.length - i - 1);
            }
        }
        return copy;
    }

    public static void main(String[] args) {

        System.out.println("Test 1");
        RandomizedQueue<String> queue = new RandomizedQueue<>();
        int temp = 0;
        for (int i = 0; i < 10; i++) {
            queue.enqueue("a = " + temp++);
            System.out.println("Queue size is " + queue.size());
        }
        System.out.println("First forEach");
        queue.forEach(System.out::println);
        System.out.println("Second forEach");
        queue.forEach(System.out::println);
        System.out.println();

        for (int i = 0; i < 10; i++) {
            queue.dequeue();
            System.out.println("Queue size is " + queue.size());
        }

        System.out.println("Test 2");
        RandomizedQueue<String> queue2 = new RandomizedQueue<>();
        queue2.enqueue("one");
        queue2.forEach(System.out::println);
        queue2.dequeue();
        queue2.forEach(System.out::println);

        System.out.println("Test 3");
        RandomizedQueue<String> queue3 = new RandomizedQueue<>();
        queue3.enqueue("one");
        queue3.forEach(System.out::println);
        queue3.dequeue();
        queue3.forEach(System.out::println);
        queue3.enqueue("new two");
        queue3.enqueue("new tree");
        queue3.enqueue("new four");
        queue3.enqueue("new five");
        queue3.forEach(System.out::println);
    }

    private void resize(int newCapacity) {
        itemArray = getCopy(itemArray, numberOfItems, newCapacity);
        numberOfItems = realNumberOfItems;
    }

    private Item[] getCopy(Item[] itemArray, int numberOfItems, int newCapacity) {
        Item[] copy =  (Item[]) new Object[newCapacity];
        int j = 0;
        for (int i = 0; i < numberOfItems; i++) {
            if (itemArray[i] != null) {
                copy[j++] = itemArray[i];
            }
        }
        return copy;
    }

    private class RandomOutput {

        private Item[] itemArray;
        private int numberOfItems;
        private Item randomItem;
        private int randomIndex;


        public RandomOutput(Item[] itemArray, int numberOfItems) {
            this.itemArray = itemArray;
            this.numberOfItems = numberOfItems;
        }

        RandomOutput get() {
            Random random = new Random();
            do {
                randomIndex = random.nextInt(numberOfItems);
            } while (itemArray[randomIndex] == null);
            randomItem = itemArray[randomIndex];
            return this;
        }
    }

}
