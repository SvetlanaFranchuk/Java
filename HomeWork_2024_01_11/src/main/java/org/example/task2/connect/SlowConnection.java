package org.example.task2.connect;

public class SlowConnection extends Connection {
    private static  SlowConnection instance;

    public SlowConnection(String host, int port, TypeProtocol protocol, String typeSpeedConnection) {
        super(host, port, protocol, typeSpeedConnection);
    }

    public static SlowConnection getInstance(String host, int port, TypeProtocol protocol, String typeSpeedConnection){
        return instance = instance == null ? new SlowConnection(host, port, protocol, typeSpeedConnection):instance;
    }

}
//Класс SlowConnection тяжёлый, поэтому он создаётся в единственном экземпляре и следует паттерну
//singleton.