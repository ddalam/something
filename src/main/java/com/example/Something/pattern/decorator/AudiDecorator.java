package com.example.Something.pattern.decorator;

public class AudiDecorator implements Car {

    protected Audi audi;
    protected String modelName;
    protected int modelPrice;

    public AudiDecorator(Audi audi, String modelName, int modelPrice) {
        this.audi = audi;
        this.modelName = modelName;
        this.modelPrice = modelPrice;
    }

    @Override
    public int getPrice() {
        return audi.getPrice() + modelPrice;
    }

    @Override
    public void showPrice() {
        System.out.println(modelName + "의 가격은 " + getPrice() + "원 입니다.");
    }
}
