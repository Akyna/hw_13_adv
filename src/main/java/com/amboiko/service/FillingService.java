package com.amboiko.service;

import com.amboiko.common.Logger;
import com.amboiko.model.RandomCallable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class FillingService {
    final int threadQuantity;

    public FillingService(int threadQuantity) {
        this.threadQuantity = threadQuantity;
    }

    public List<Integer> getFilledList(final int listLength) {
        final ExecutorService executor = Executors.newFixedThreadPool(threadQuantity);
        final List<Integer> result = new ArrayList<>();
        final Callable<Integer> callable = new RandomCallable();
        List<Future<Integer>> futureList = new ArrayList<>();
        boolean isRunning = true;

        while (isRunning) {
            for (int i = 0; i < threadQuantity; i++) {
                Future<Integer> future = executor.submit(callable);
                futureList.add(future);
            }

            for (Future<Integer> item : futureList) {
                try {
                    int number = item.get();
                    Logger.info("Get number: " + number);
                    if (number % 2 == 0) {
                        result.add(number);
                    }

                    if (result.size() == listLength) {
                        isRunning = false;
                        break;
                    }

                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }

            futureList = new ArrayList<>();
        }

        executor.shutdown();

        return result;
    }
}
