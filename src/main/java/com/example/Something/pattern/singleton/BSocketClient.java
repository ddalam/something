package com.example.Something.pattern.singleton;

public class BSocketClient {

    private SocketClient socketClient;

    public BSocketClient() {
        this.socketClient = SocketClient.getInstance();
    }

    public SocketClient getSocketClient() {
        return this.socketClient;
    }
}
