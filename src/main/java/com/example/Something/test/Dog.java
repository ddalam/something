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

        // this와 같으면 0, this가 크면 양수, this가 작으면 음수 반환
        return this.weight.compareTo(o.getWeight());
    }
}
