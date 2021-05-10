package com.example.Something.pattern.proxy;

import java.util.concurrent.atomic.AtomicLong;

public class BrowserMain {

    public static void main(String[] args) {
        //ABrowser aBrowser = new ABrowser("www.naver.com");

        // 여러번 호출할 때마다 계속 동일한 HTML을 로 -> BrowserProxy(Proxy Pattern)를 사용해 캐시 기능 적용
        // aBrowser.show();
        // aBrowser.show();
        // aBrowser.show();
        // aBrowser.show();

        // BrowserProxy를 사용하면 구현체를 변경하지 않으면서 캐시 기능을 적용할 수 있다
        Browser browser = new BrowserProxy("www.naver.com");
        browser.show();
        browser.show();
        browser.show();
        browser.show();
        browser.show();

        // Spring AOP와 같은 역할을 하는 기능을 구현
        AtomicLong start = new AtomicLong();
        AtomicLong end = new AtomicLong();

        Browser aopBrowser = new AopBrowser("www.naver.com",
                () -> {
                    System.out.println("befor");
                    start.set(System.currentTimeMillis());
                },
                () -> {
                    long now = System.currentTimeMillis();
                    end.set(now - start.get());
                }
        );

        aopBrowser.show();
        System.out.println("loading time : " + end.get());

        aopBrowser.show();
        System.out.println("loading time : " + end.get());
    }
}
