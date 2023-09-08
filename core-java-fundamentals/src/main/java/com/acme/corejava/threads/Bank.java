package com.acme.corejava.threads;

import java.util.Arrays;

public class Bank {

    public double[] accounts;

    public Bank(int numberOfAccounts, double initialBalance) {
        accounts = new double[numberOfAccounts];
        Arrays.fill(accounts, initialBalance);
    }

    public void transfer(int from, int to, double amount) {
        if (accounts[from] < amount) {
            return;
        }
        accounts[from] -= amount;
        System.out.printf("%s: Transfer %6.3f from %d to %d\n", Thread.currentThread().getName(), amount, from, to);
        accounts[to] += amount;
        System.out.printf(" - Total balance: %10.2f\n", totalBalance());
    }

    public double balanceOf(int accountId) {
        return accounts[accountId];
    }

    public double totalBalance() {
        return Arrays.stream(accounts).sum();
    }
}
