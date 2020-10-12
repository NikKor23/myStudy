package com.company;
import Accounts.BankAccount;
import Accounts.CardAccount;
import Accounts.DepositAccount;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {

        BankAccount myAccount = new BankAccount(10000);
        CardAccount second = new CardAccount(20000);
        DepositAccount third = new DepositAccount(50000);

        second.withdrawMoney(19800);
        second.cashBalance();


    }
}
