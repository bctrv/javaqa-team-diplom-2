package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

    @Test
    public void shouldAddLessThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(3_000);

        Assertions.assertEquals(2_000 + 3_000, account.getBalance());
    }

    @Test
    public void shouldAddExactMaxBalance() {
        SavingAccount account = new SavingAccount(
                3_000,
                1_000,
                10_000,
                5
        );

        account.add(7_000);

        Assertions.assertEquals(3_000 + 7_000, account.getBalance());
    }

    @Test
    public void shouldNotAddAboveMaxBalance() {
        SavingAccount account = new SavingAccount(
                3_000,
                1_000,
                10_000,
                5
        );

        account.add(9_000);

        Assertions.assertEquals(3_000, account.getBalance());
    }

    @Test
    public void shouldNotSetNegativeRate() {
        SavingAccount account = new SavingAccount(
                3_000,
                1_000,
                10_000,
                -2
        );

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            account.setRate(-2);
        });
    }

    @Test
    public void balanceShouldNotBeBelowMinBalanceWhenPay() {
        SavingAccount account = new SavingAccount(
                3_000,
                1_000,
                10_000,
                2
        );

        Assertions.assertEquals(false, account.pay(2300));
    }

    @Test
    public void amountShouldNotBeNegativeWhenPay() {
        SavingAccount account = new SavingAccount(
                3_000,
                1_000,
                10_000,
                2
        );

        Assertions.assertEquals(false, account.pay(-100));
    }

    @Test
    public void balanceShouldBeAboveMinBalanceWhenPay() {
        SavingAccount account = new SavingAccount(
                3_000,
                1_000,
                10_000,
                2
        );

        Assertions.assertEquals(true, account.pay(1300));
    }
    @Test
    public void balanceShouldBeEqualMinBalanceWhenPay() {
        SavingAccount account = new SavingAccount(
                3_000,
                1_000,
                10_000,
                2
        );

        Assertions.assertEquals(true, account.pay(2000));
    }

    @Test
    public void amountShouldNotBeZeroWhenPay() {
        SavingAccount account = new SavingAccount(
                3_000,
                1_000,
                10_000,
                2
        );

        Assertions.assertEquals(false, account.pay(0));
    }

    @Test
    public void shouldAddBalanceBelowMaxBalance() {
        SavingAccount account = new SavingAccount(
                3_000,
                1_000,
                10_000,
                2
        );

        Assertions.assertEquals(true, account.add(4000));
    }

    @Test
    public void shouldNotAddAmountZero() {
        SavingAccount account = new SavingAccount(
                3_000,
                1_000,
                10_000,
                2
        );

        Assertions.assertEquals(false, account.add(0));
    }

    @Test
    public void shouldNotAddNegativeAmount() {
        SavingAccount account = new SavingAccount(
                3_000,
                1_000,
                10_000,
                2
        );

        Assertions.assertEquals(false, account.add(-100));
    }

    @Test
    public void shouldNotAddBalanceAboveMaxBalance() {
        SavingAccount account = new SavingAccount(
                3_000,
                1_000,
                10_000,
                2
        );

        Assertions.assertEquals(false, account.add(8000));
    }

    @Test
    public void shouldAddBalanceEqualsMaxBalance() {
        SavingAccount account = new SavingAccount(
                3_000,
                1_000,
                10_000,
                2
        );

        Assertions.assertEquals(true, account.add(7000));
    }

    @Test
    public void shouldAddBalanceOneLessForMaxBalance() {
        SavingAccount account = new SavingAccount(
                3_000,
                1_000,
                10_000,
                2
        );

        Assertions.assertEquals(true, account.add(6999));
    }

    @Test
    public void shouldNotAddBalanceMaxBalancePlusOne() {
        SavingAccount account = new SavingAccount(
                3_000,
                1_000,
                10_000,
                2
        );

        Assertions.assertEquals(false, account.add(7001));
    }

    @Test
    public void shouldGetYearChange() {
        SavingAccount account = new SavingAccount(
                5_000,
                2_000,
                15_000,
                10
        );
        Assertions.assertEquals(500, account.yearChange());
    }

    @Test
    public void shouldNotGetYearChangeIfRateZero() {
        SavingAccount account = new SavingAccount(
                5_000,
                2_000,
                15_000,
                0
        );
        Assertions.assertEquals(0, account.yearChange());
    }

    @Test
    public void shouldNotGetYearChangeIfBalanceBelowMinBalance() {
        SavingAccount account = new SavingAccount(
                1_800,
                2_000,
                15_000,
                15
        );
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            account.yearChange();
        });
    }

    @Test
    public void shouldNotGetYearChangeIfBalanceAboveMaxBalance() {
        SavingAccount account = new SavingAccount(
                16_200,
                2_000,
                15_000,
                15
        );
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            account.yearChange();
        });
    }

    @Test
    public void shouldGetYearChangeIfBalanceEqualsMaxBalance() {
        SavingAccount account = new SavingAccount(
                15_000,
                2_000,
                15_000,
                15
        );
        Assertions.assertEquals(2_250, account.yearChange());
    }

    @Test
    public void shouldGetYearChangeIfBalanceLessForOneMaxBalance() {
        SavingAccount account = new SavingAccount(
                14_999,
                2_000,
                15_000,
                15
        );
        Assertions.assertEquals(2_249, account.yearChange());
    }

    @Test
    public void shouldNotGetYearChangeIfBalanceMaxBalancePlusOne() {
        SavingAccount account = new SavingAccount(
                15_001,
                2_000,
                15_000,
                15
        );
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            account.yearChange();
        });
    }

    @Test
    public void shouldGetYearChangeIfBalanceEqualsMinBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                2_000,
                15_000,
                15
        );
        Assertions.assertEquals(300, account.yearChange());
    }

    @Test
    public void shouldGetYearChangeIfBalanceMinBalancePlusOne() {
        SavingAccount account = new SavingAccount(
                2_001,
                2_000,
                15_000,
                15
        );
        Assertions.assertEquals(300, account.yearChange());
    }

    @Test
    public void shouldNotGetYearChangeIfBalanceLessOneForMinBalance() {
        SavingAccount account = new SavingAccount(
                1_999,
                2_000,
                15_000,
                15
        );
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            account.yearChange();
        });
    }

    @Test
    public void shouldGetMinBalance() {
        SavingAccount account = new SavingAccount(
                16_200,
                2_000,
                17_000,
                15
        );
        Assertions.assertEquals(2_000, account.getMinBalance());
    }

    @Test
    public void shouldGetMinBalanceWhenEqualsToBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                2_000,
                17_000,
                15
        );
        Assertions.assertEquals(2_000, account.getMinBalance());
    }

    @Test
    public void shouldNotGetMinBalanceAboveMaxBalance() {
        SavingAccount account = new SavingAccount(
                16_000,
                16_000,
                15_000,
                15
        );
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            account.getMinBalance();
        });
    }

    @Test
    public void shouldNotGetMaxBalanceIfEqualsToMinBalance() {
        SavingAccount account = new SavingAccount(
                16_200,
                16_000,
                16_000,
                15
        );
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            account.getMaxBalance();
        });
    }

    @Test
    public void shouldGetRate() {
        SavingAccount account = new SavingAccount(
                6_300,
                2_000,
                15_000,
                15
        );
        Assertions.assertEquals(15, account.getRate());
    }
    @Test
    public void shouldGetRateIfZero() {
        SavingAccount account = new SavingAccount(
                6_300,
                2_000,
                15_000,
                0
        );
        Assertions.assertEquals(0, account.getRate());
    }
    @Test
    public void shouldGetRateIfOne() {
        SavingAccount account = new SavingAccount(
                6_300,
                2_000,
                15_000,
                1
        );
        Assertions.assertEquals(1, account.getRate());
    }

    @Test
    public void shouldNotGetNegativeRate() {
        SavingAccount account = new SavingAccount(
                6_300,
                2_000,
                15_000,
                -15
        );
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            account.getRate();
        });
    }
}
