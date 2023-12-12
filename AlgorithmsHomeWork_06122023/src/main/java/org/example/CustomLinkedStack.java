package org.example;

// Class for the hometask
public class CustomLinkedStack {

    private Node last;
    private static int sizeNode=0;

    private static class Node {
        String data;
        Node previous;
        public Node(String data, Node previous) {
            this.data = data;
            this.previous = previous;
        }
    }

    public void push(String element) { // O(1)
        Node node = new Node(element,last);
        last = node;
        sizeNode++;
    }

    public Node pop() { // O(1)
        if (last == null) throw new RuntimeException("No element in stack");
        Node lastEl = last;
        last = last.previous;
        sizeNode--;
        return lastEl;
    }

    public Node peek() { // O(1)
        if (last == null) throw new RuntimeException("No element in stack");
        return last;
    }

    public boolean isEmpty(){ //O(1)
        return (last == null);
    }

    public int size(){ // O(1)
        return sizeNode;
    }

    public int search(String element) { // O(n)
        int nomEl = 0;
        Node current = last;
        while (current != null){
            if (current.data.equals(element)) return nomEl;
            current = current.previous;
            nomEl++;
        }
        return -1;
    }

    public void print(){
        Node current = last;
        while (current != null){
            System.out.println(current.data);
            current = current.previous;
        }
    }

    public static void main(String[] args) {
        CustomLinkedStack stack = new CustomLinkedStack();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");
        stack.print();
        System.out.println("pop " + stack.pop().data);
        stack.print();
        System.out.println("peek " + stack.peek().data);
        System.out.println("search B " + stack.search("B"));
        System.out.println("search G " + stack.search("G"));
        System.out.println("isEmpty " + stack.isEmpty());
        System.out.println("size " + stack.size());
    }
}
