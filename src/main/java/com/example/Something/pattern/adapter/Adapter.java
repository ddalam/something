package com.example.Something.pattern.adapter;

public class Adapter implements Electronic110V {

    private Electronic220V electronic220V;

    public Adapter(Electronic220V electronic220V) {
        this.electronic220V = electronic220V;
    }

    @Override
    public void powerOn() {
        electronic220V.connect();
    }
}
