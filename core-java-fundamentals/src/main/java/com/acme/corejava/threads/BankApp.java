package com.acme.corejava.threads;

public class BankApp {

    public static final double MAX_AMOUNT = 100;
    public static final int DELAY = 100;
    public static final int STEPS = 1000;

    public static void main(String[] args) {
        Bank myBank = new Bank(100, 1_000);
        test2(myBank);
    }

    public static void test1(Bank bank) {
        Runnable task1 = () -> {
            try {
                for(int i= 0; i < STEPS; i++) {
                    var amount = MAX_AMOUNT * Math.random();
                    bank.transfer(1, 2, amount);
                    Thread.sleep((int) (DELAY * Math.random()));
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Runnable task2 = () -> {
            try {
                for(int i= 0; i < STEPS; i++) {
                    var amount = MAX_AMOUNT * Math.random();
                    bank.transfer(3, 4, amount);
                    Thread.sleep((int) (DELAY * Math.random()));
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);
        thread1.start();
        thread2.start();
    }

    public static void test2(Bank bank) {
        while (true) {
            for(int i = 0; i < bank.accounts.length; i++) {
                final int fromAccount = i;
                Runnable task = () -> {
                    try {
                        double amount = MAX_AMOUNT * Math.random();
                        int toAccount = (int) (bank.accounts.length * Math.random());
                        bank.transfer(fromAccount, toAccount, amount);
                        Thread.sleep((int) (DELAY * Math.random()));
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                };
                Thread thread = new Thread(task);
                thread.start();
            }
        }
    }
}

