package com.interviews;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureSample {

    private final Random random = new Random();
    private static final int MAX = 10000;
    private static final int MIN = 1;

    public void execute() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> s =
                CompletableFuture.supplyAsync(this::getNum)
                        .thenCombine(
                                CompletableFuture.supplyAsync(this::getNum),
                                (n1, n2) -> sum(n1, n2)
                        );

        System.out.println(s.get());
    }

    public int getNum() {
        int result = -1;
        try {
            result = shortRandom();
            System.out.println("getNum() INIT: "+ result);
            Thread.sleep(result);
        } catch (InterruptedException e) {
            System.out.println("getNum(): FAILS");
        }
        System.out.println("getNum(): END: "+ result);
        return result;
    }

    public int sum(int n1, int n2) {
        return n1 + n2;
    }

    public int shortRandom() {
        int value = random.nextInt(MAX + MIN) + MIN;
        return value;
    }
}
