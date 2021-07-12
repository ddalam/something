package com.example.Something.pattern.decorator;

public class Audi implements Car {

    private int price;

    public Audi(int price) {
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public void showPrice() {
        System.out.println("Audi의 가격 : " + this.price + " 원 입니다.");
    }
}
