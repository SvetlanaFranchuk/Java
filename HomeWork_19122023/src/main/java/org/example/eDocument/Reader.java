package org.example.eDocument;

import java.util.concurrent.ThreadLocalRandom;

public class Reader extends Thread{
    private Document doc;

    public Reader(Document doc) {
        this.doc = doc;
    }

    @Override
    public void run() {
        System.out.println("Была прочитана следующая строка: " +
                doc.readFromList(ThreadLocalRandom.current().nextInt(0, doc.size())));
    }
}
