package com.example.Something.assertion;

public class Dog {
    private String name;
    private Float weight;

    public String getName() {
        return name;
    }

    public Float getWeight() {
        return weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Dog(String name, Float weight) {
        this.name = name;
        this.weight = weight;
    }
}
