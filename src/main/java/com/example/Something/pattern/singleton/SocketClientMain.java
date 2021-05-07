package com.example.Something.pattern.singleton;

public class SocketClientMain {

    public static void main(String[] args) {

        ASocketClient aSocketClient = new ASocketClient();
        BSocketClient bSocketClient = new BSocketClient();

        SocketClient aClient = aSocketClient.getSocketClient();
        SocketClient bClient = bSocketClient.getSocketClient();

        System.out.println("두 개의 객체가 동일한가?");
        System.out.println(aClient.equals(bClient));
    }
}
