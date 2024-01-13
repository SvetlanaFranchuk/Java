package org.example.task2.exchange;

import org.example.task2.connect.Connection;
import org.example.task2.connect.Connector;

public class Exchanger implements Runnable{
    private final Connection connection;
    private final TypeExchange typeExchange;

    public Exchanger(TypeExchange typeExchange) {
        this.connection = Connector.getConnection();
        this.typeExchange = typeExchange;
    }

    @Override
    public void run() {
        if (connection != null) {
            System.out.println(Thread.currentThread().getName()+ ": " + connection.getTypeSpeedConnection() + ": " +
                    typeExchange + " got connection with id: " + connection.getId());
        } else {
            System.out.println(typeExchange + " failed to get connection");
        }
    }
}
//Создайте класс Exchanger и 3 объекта: videoExchanger, audioExchanger и gameExchanger, использующие
//классы соединений. Каждый Exchanger работает с тем же хостом, что и остальные, но в своём потоке.
