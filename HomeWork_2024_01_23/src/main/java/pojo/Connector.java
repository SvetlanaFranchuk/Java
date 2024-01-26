package pojo;

import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;


public class Connector {

    public Connector() {
        connectToServer();
    }

    public static void connectToServer(){
        System.out.print("Wait ... it`s process saving data: ");
        for (int i = 0; i <= 100; i++) {
            System.out.printf("%d", i);
            System.out.print("%");
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print("\b".repeat(String.valueOf(i).length() + 1));
        }
        System.out.println("100%");
        System.out.println("Date saved");
    }
}
