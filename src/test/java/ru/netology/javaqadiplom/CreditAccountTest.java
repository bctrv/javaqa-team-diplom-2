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
    public void exceptionTestLimitNegative() {

        CreditAccount account = new CreditAccount(500, -55_000, 80);

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> account.getBalance());

    }

    @Test
    public void exceptionTestBalanceNegative() {

        CreditAccount account = new CreditAccount(-500, 55_000, 80);

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
    public void payTestOverBalance() {
        CreditAccount account = new CreditAccount(500, 55_000, 10);

        account.pay(600);

        Assertions.assertEquals(500, account.getBalance());
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

    @Test
    public void balanceOverLimitTest() {
        CreditAccount account = new CreditAccount(200_000, 55_000, 15);

        account.pay(600);

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> account.getBalance());
    }

    @Test
    public void addOverLimitTest() {
        CreditAccount account = new CreditAccount(500, 55_000, 10);

        account.add(300_000);

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> account.getBalance());

    }

    @Test
    public void payTwoTest() {
        CreditAccount account = new CreditAccount(5000, 5000, 10);

        account.pay(-300);

        Assertions.assertEquals(5000, account.getBalance());
    }

    @Test
    public void percTestTwo() {
        CreditAccount account = new CreditAccount(51, 55_000, 15);


        Assertions.assertEquals(7, account.yearChange());
    }

}
