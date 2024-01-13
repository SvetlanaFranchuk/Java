package org.example.task2.connect;

public class FastConnection extends Connection implements Cloneable{

    public FastConnection(String host, int port, TypeProtocol protocol, String typeSpeedConnection) {
        super(host, port, protocol, typeSpeedConnection);
    }

    @Override
    protected Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
