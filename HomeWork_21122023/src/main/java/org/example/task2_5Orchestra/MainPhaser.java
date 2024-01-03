package org.example.task2_5Orchestra;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Phaser;

public class MainPhaser {
    public static void main(String[] args) {
        List<Instrument> orchestra = new ArrayList<>();
        orchestra.add(new Instrument(TypeInstrument.DRUMS, 2));
        orchestra.add(new Instrument(TypeInstrument.WINDS, 3));
        orchestra.add(new Instrument(TypeInstrument.PIANO, 1));
        orchestra.add(new Instrument(TypeInstrument.VIOLIN, 3));

        for (int i = 0; i < orchestra.size(); i++) {
        Phaser PHASER = new Phaser(1);

            int finalI = i;
            Thread thread = new Thread(() -> {
                for (int phase = 1; phase <= orchestra.get(finalI).getCountInstrumentsInSections(); phase++) {
                    System.out.println(Thread.currentThread().getName() + ": checking instrument number " +
                            phase + " for section " + orchestra.get(finalI).getTypeInstrument() );
                    PHASER.arriveAndAwaitAdvance(); // Блокировка потока до начала следующей фазы

                    // Выполнение работы для текущей фазы
                    System.out.println(Thread.currentThread().getName() + ": instrument number " +
                            phase + " for section " + orchestra.get(finalI).getTypeInstrument() + " is ready ");
                    PHASER.arriveAndAwaitAdvance(); // Блокировка потока до завершения работы в текущей фазе
                }
            });
            thread.start();
           for (int phase = 1; phase <= orchestra.get(finalI).getCountInstrumentsInSections(); phase++) {
                System.out.println("Process preparing for section "+ orchestra.get(finalI).getTypeInstrument() +
                        " is started. Instrument number: " + phase);
                PHASER.arriveAndAwaitAdvance();
            }
        }
        try {
            Thread.sleep(2000);
            System.out.println("Orchestra is ready");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}