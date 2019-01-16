package com.yitian;

public class Dell implements Computer {
    @Override
    public void start() {
        System.out.println("dell正在开机");
    }

    @Override
    public void close() {
        System.out.println("dell正在关机");
    }
}
