package org.example.task2;

import org.example.task2.exchange.Exchanger;
import org.example.task2.exchange.TypeExchange;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Thread> videoThreads = Arrays.stream(new Object[5])
                .map(v -> {
                    Exchanger exchanger = new Exchanger(TypeExchange.VIDEO);
                    return new Thread(() -> {
                        try {
                            exchanger.run();
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    });
                })
                .peek(Thread::start)
                .toList();

        Thread audioThread = new Thread(new Exchanger(TypeExchange.AUDIO));
        Thread gameThread  = new Thread(new Exchanger(TypeExchange.GAME));

        videoThreads.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        audioThread.start();
        gameThread.start();
    }
}
//Создайте класс Connection с полями id (уникальный), host, port и protocol и двух наследников:
//FastConnection и SlowConnection. FastConnection лёгкий, поэтому каждому из классов, запрашивающих экземпляр
//FastConnection, выдаётся новый экземпляр, имеющий те же характеристики, что и ранее созданный (паттерн
//prototype). Класс SlowConnection тяжёлый, поэтому он создаётся в единственном экземпляре и следует паттерну
//singleton.
//- 2.1 Создайте класс Connector с методом getConnection. В методе реализуйте логику: если попытка соединиться
//занимает меньше 300 мс, то метод возвращает экземпляр FastConnection, в противном случае – экземпляр
//SlowConnection. Время ожидания подключения в классе просто сгенерируйте случайным образом один раз и
//сохраните в статическом поле. К getConnection могут обращаться несколько потоков.
//- 2.2 Создайте класс Exchanger и 3 объекта: videoExchanger, audioExchanger и gameExchanger, использующие
//классы соединений. Каждый Exchanger работает с тем же хостом, что и остальные, но в своём потоке.
//- 2.3 При запуске программы каждый Exchanger пытается получить соединение от класса Connector. Выведите id
//всех соединений в консоль поле получения.