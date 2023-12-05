package org.example.HomeWork;

public class CustomArrayQueue {
    private int[] data;
    private int tail;
    private int head;
    private int count;

    public  CustomArrayQueue(int capacity){
        data = new int[capacity];
        count = 0;
        head = -1;
        tail = -1;
    }

    public void enqueue(int element){
        if(count>=data.length) throw new RuntimeException("Queue is full");
        if (++tail >= data.length) tail =0;
        data[tail] = element;
        if (head == -1) head++;
        count++;

    }

    public int dequeue(){
        if(count ==0) throw new RuntimeException("Queue is empty");
        int result = data[head];
        if(++head == data.length) head = 0;
        if(--count ==0) {
        head = -1;
        tail = -1;
        };
        return result;
    }

    public int search(int element){//TODO
        int start;
        int end;
        if (head<tail) {
            start = head;
            end = tail;}
        else{
            start = tail;
            end = head;
        }
        for (int i = start; i <= end; i++) {
            if (data[i] == element) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        CustomArrayQueue queue = new CustomArrayQueue(5);

        //Test 1
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        System.out.println("search (5) "+ queue.search(5));
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

        //Test2
        queue.enqueue(6);
        queue.enqueue(7);
        System.out.println("search (7) "+ queue.search(7));
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

        //Test3
        queue.enqueue(8);
        queue.enqueue(9);
        queue.enqueue(10);
        System.out.println("search (10) "+ queue.search(10));
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.enqueue(11);
        queue.enqueue(12);
        queue.enqueue(13);
        queue.enqueue(14);
        System.out.println("search (14) "+ queue.search(14));
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

    }
}
