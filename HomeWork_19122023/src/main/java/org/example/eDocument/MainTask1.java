package org.example.eDocument;

public class MainTask1 {
    public static void main(String[] args) {
        Document document = new Document();
        for (int i = 0; i < 3; i++) {
            new Writer(document).start();
        }
        for (int i = 0; i < 30; i++) {
            new Reader(document).start();
        }
    }
}
