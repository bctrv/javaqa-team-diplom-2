package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {

    @Test
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(3_000, account.getBalance());
    }

    @Test
    public void exeptionTest() {

        CreditAccount account = new CreditAccount(500, 55_000, -80);

        account.add(3_000);

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> account.getBalance());

    }

    @Test
    public void payTest() {
        CreditAccount account = new CreditAccount(500, 55_000, 10);

        account.pay(300);

        Assertions.assertEquals(200, account.getBalance());
    }

    @Test
    public void addTest() {
        CreditAccount account = new CreditAccount(500, 55_000, 10);

        account.add(3000);

        Assertions.assertEquals(3500, account.getBalance());

    }

    @Test
    public void percTest() {
        CreditAccount account = new CreditAccount(200, 55_000, 15);


        Assertions.assertEquals(0, account.yearChange());

    }
}
