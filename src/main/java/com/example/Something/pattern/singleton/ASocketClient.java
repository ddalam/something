package com.example.Something.pattern.singleton;

public class ASocketClient {

    private SocketClient socketClient;

    public ASocketClient() {
        this.socketClient = SocketClient.getInstance();
    }

    public SocketClient getSocketClient() {
        return this.socketClient;
    }
}
