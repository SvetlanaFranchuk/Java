package org.example.task2ThreadLocal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        List<Client> clients = new ArrayList<>();
        List<Product> products = new ArrayList<>();
        List<Task> tasks = new ArrayList<>();
        Arrays.stream(new int[5]).mapToObj(c-> new Thread(String.valueOf(clients.add(new Client())))).forEach(Thread::start);
        Arrays.stream(new int[5]).mapToObj(p-> new Thread(String.valueOf(products.add(new Product())))).forEach(Thread::start);
        Arrays.stream(new int[5]).mapToObj(t-> new Thread(String.valueOf(tasks.add(new Task())))).forEach(Thread::start);
        clients.forEach(c -> System.out.println("Client " + c.getGen()));
        products.forEach(p -> System.out.println("Product " + p.getGen()));
        tasks.forEach(t -> System.out.println("Task " + t.getGen()));
    }
}