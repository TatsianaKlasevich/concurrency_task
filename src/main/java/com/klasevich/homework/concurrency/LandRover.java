package com.klasevich.homework.concurrency;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

public class LandRover implements Runnable {
    private static final int FIRST_NUMBER = 1;
    private static final String PRINT_LAND = "\"land\",";
    private static final String PRINT_ROVER = "\"rover\",";
    private static final String PRINT_LAND_ROVER = "\"landRover\",";
    private static final String PRINT_NUMBER = ",";

    private int n;
    private AtomicInteger currentNumber = new AtomicInteger(FIRST_NUMBER);

    private final Runnable printLand = () -> System.out.print(PRINT_LAND);
    private final Runnable printRover = () -> System.out.print(PRINT_ROVER);
    private final Runnable printLandRover = () -> System.out.print(PRINT_LAND_ROVER);
    private final IntConsumer printNumber = n -> System.out.print(n + PRINT_NUMBER);

    public LandRover(int n) {
        this.n = n;
    }

    public void land(Runnable printLand) {
        if (currentNumber.get() <= n && currentNumber.get() % 3 == 0 && currentNumber.get() % 5 != 0) {
            printLand.run();
            currentNumber.incrementAndGet();
        }
    }

    public void rover(Runnable printRover) {
        if (currentNumber.get() <= n && currentNumber.get() % 3 != 0 && currentNumber.get() % 5 == 0) {
            printRover.run();
            currentNumber.incrementAndGet();
        }
    }

    public void landrover(Runnable printLandRover) {
        if (currentNumber.get() <= n && currentNumber.get() % 3 == 0 && currentNumber.get() % 5 == 0) {
            printLandRover.run();
            currentNumber.incrementAndGet();
        }
    }

    public void number(IntConsumer printNumber) {
        if (currentNumber.get() <= n && currentNumber.get() % 3 != 0 && currentNumber.get() % 5 != 0) {
            printNumber.accept(currentNumber.get());
            currentNumber.incrementAndGet();
        }
    }

    @Override
    public void run() {
        while (currentNumber.get() <= n) {
            switch (Thread.currentThread().getName()) {
                case ("thread-A"):
                    land(printLand);
                    Thread.yield();
                    break;
                case ("thread-B"):
                    rover(printRover);
                    Thread.yield();
                    break;
                case ("thread-C"):
                    landrover(printLandRover);
                    Thread.yield();
                    break;
                case ("thread-D"):
                    number(printNumber);
                    Thread.yield();
                    break;
            }
        }
    }
}
