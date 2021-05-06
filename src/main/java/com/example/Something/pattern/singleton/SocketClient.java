package com.example.Something.pattern.singleton;

/**
 * 매번 연결을 하는게 아니라 한번 연결해둔 connection 을 사용
 * 출처 : https://github.com/steve-developer/fastcampus-springboot-introduction/blob/master/02.%20%EB%94%94%EC%9E%90%EC%9D%B8%ED%8C%A8%ED%84%B4/SourceCode/design-pattern/src/com/company/design/singleton/SocketClient.java
 */
public class SocketClient {

    // 싱글톤은 자기 자신을 객체로 가지고 있어야 한다
    private static SocketClient socketClient = null;

    // 싱글톤은 기본 생성자를 private 으로 막아야 한다
    private SocketClient() {

    }

    // static 으로 getInstance 메서드를 제공해야 한다
    public static SocketClient getInstance() {

        // 현재 가지고 있는 객체가 널인지 체크
        // 없는 경우에는 생성
        if (socketClient == null) {
            socketClient = new SocketClient();
        }

        // 있는 경우에는 가지고 있는 객체를 리턴
        return socketClient;
    }

    public void connect() {
        System.out.println("connect");
    }
}
