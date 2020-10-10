package Accounts;

import jdk.vm.ci.meta.Local;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DepositAccount extends BankAccount
{
    LocalDate firstDate;
    LocalDate secondDate;

    public DepositAccount(double moneyAmount) {
        super(moneyAmount);
        firstDate = LocalDate.now();
    }



    public void withdrawMoney(double amount)
    {
        secondDate = LocalDate.now();
        long days =  ChronoUnit.DAYS.between(firstDate, secondDate);
        if (days >= 30) {
            super.withdrawMoney(amount);
        }
        else {
            System.out.println("С последнего пополнения счёта не прошёл месяц!");

        }
    }

    public void toPutMoney (double amount)
    {
        super.toPutMoney(amount);
        firstDate = LocalDate.now();

    }
}
