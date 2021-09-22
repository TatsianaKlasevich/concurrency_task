package com.klasevich.homework.concurrency;

public class Main {
    public static void main(String[] args) {
        int n = NumberService.findNumber();
        System.out.println("The number is " + n);

        LandRover landRover = new LandRover(n);

        new Thread(landRover, "thread-A").start();
        new Thread(landRover, "thread-B").start();
        new Thread(landRover, "thread-C").start();
        new Thread(landRover, "thread-D").start();
    }
}

