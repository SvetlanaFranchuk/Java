package org.example.task2.connect;

import java.util.concurrent.ThreadLocalRandom;

public class Connector {
    private static final long TIME_WAIT_CONNECTION = ThreadLocalRandom.current().nextLong(200, 500);

    public static Connection getConnection() {
        if (TIME_WAIT_CONNECTION < 300) {
            return (Connection) new FastConnection("host1", 1717,
                    TypeProtocol.HTTPS, "fast-connector").clone();
        } else return SlowConnection.getInstance("host1", 1717,
                TypeProtocol.HTTPS, "slow-connector");
    }
}
//Создайте класс Connector с методом getConnection. В методе реализуйте логику: если попытка соединиться
//занимает меньше 300 мс, то метод возвращает экземпляр FastConnection, в противном случае – экземпляр
//SlowConnection. Время ожидания подключения в классе просто сгенерируйте случайным образом один раз и
//сохраните в статическом поле. К getConnection могут обращаться несколько потоков.
