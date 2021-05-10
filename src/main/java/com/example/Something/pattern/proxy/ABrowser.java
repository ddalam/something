package com.example.Something.pattern.proxy;

public class ABrowser implements Browser {

    private String url;

    public ABrowser(String url) {
        this.url = url;
    }

    @Override
    public Html show() {
        System.out.println("browser loading html from : " + url);
        return new Html(url);
    }
}
