package org.example.ClassWork;

public class CustomArrayStack {
    private int[] data;
    private int count;

    public CustomArrayStack(int capacity) {
        data = new int[capacity];
        this.count = 0;
    }

    public void  push(int element){
        if(count>=data.length) throw new RuntimeException("Stack is full");
        data[count++] = element;
    }

    public int pop(){
        if(count==0) throw new RuntimeException("Stack is full");
        int result = data[--count];
        data[count] = 0;
        return result;
    }

    public int peek(){
        if(count==0) throw new RuntimeException("Stack is full");
        return data[count-1];
    }

    public boolean isEmpty(){
        return count==0;
    }

    public int size(){
        return count;
    }

    public int search(int element){
        for (int i = count -1; i >=0 ; i--) {
            if(data[i]==element){
                return count-i-1;
            }
        }
        return -1;
    }

    public static void  main(String[] args){
        CustomArrayStack stack = new CustomArrayStack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println("search "+stack.search(5));
        System.out.println("peek "+stack.peek());
        System.out.println("size " +stack.size());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());

    }
}
