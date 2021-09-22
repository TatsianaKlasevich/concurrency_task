package com.klasevich.homework.concurrency;

import java.util.Random;

public class NumberService {
    public static int findNumber() {
        Random random = new Random();
        return random.nextInt(50) + 1;
    }
}
