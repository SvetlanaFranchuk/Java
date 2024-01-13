package org.example.task2.connect;

import lombok.Getter;

import java.util.UUID;

@Getter
public class Connection {
    protected UUID id ;
    protected String host;
    protected int port;
    protected TypeProtocol protocol;
    protected String typeSpeedConnection;

    public Connection(String host, int port, TypeProtocol protocol, String typeSpeedConnection) {
        this.id = UUID.randomUUID();
        this.host = host;
        this.port = port;
        this.protocol = protocol;
        this.typeSpeedConnection = typeSpeedConnection;
    }

    public UUID getId() {
        return id;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public TypeProtocol getProtocol() {
        return protocol;
    }

    public String getTypeSpeedConnection() {
        return typeSpeedConnection;
    }
}
