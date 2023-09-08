package com.acme.corejava.threads;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankTest {

    @Test
    public void testBankCreation() {
        Bank myBank = new Bank(100, 1_000.0);

        myBank.transfer(1, 2, 300.0);
        myBank.transfer(3, 4, 500.0);

        assertEquals(700.0, myBank.balanceOf(1));
        assertEquals(1300.0, myBank.balanceOf(2));
        assertEquals(500.0, myBank.balanceOf(3));
        assertEquals(1500.0, myBank.balanceOf(4));
        assertEquals(100_000, myBank.totalBalance());
    }
}
