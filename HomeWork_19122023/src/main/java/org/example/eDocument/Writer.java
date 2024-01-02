package org.example.eDocument;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.concurrent.ThreadLocalRandom;

public class Writer extends Thread{
    private Document doc;

    public Writer(Document doc) {
        this.doc = doc;
    }

    @Override
    public void run() {
        for (int i = 0; i < ThreadLocalRandom.current().nextInt(1,5); i++) {
            String str = RandomStringUtils.random(25,true,false);
            System.out.println("Записана следующая строка " + str);
            doc.writeToList(str);
        }
    }
}
