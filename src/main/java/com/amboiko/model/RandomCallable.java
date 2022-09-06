package com.amboiko.model;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class RandomCallable implements Callable<Integer> {

    @Override
    public Integer call() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        return new Random().nextInt(101);
    }
}
