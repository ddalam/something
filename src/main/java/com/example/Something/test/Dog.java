package com.example.Something.test;

public class Dog implements Comparable<Dog> {
    private String name;
    private Float weight;

    public Dog(String name, Float weight) {
        this.name = name;
        this.weight = weight;
    }

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

    @Override
    public int compareTo(Dog o) {
        return this.weight.compareTo(o.getWeight());
    }
}
