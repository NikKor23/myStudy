package com.company;
import Accounts.BankAccount;
import Accounts.CardAccount;
import Accounts.DepositAccount;

public class Main {

    public static void main(String[] args) {

        BankAccount myAccount = new BankAccount(10000);
        CardAccount second = new CardAccount(20000);
        DepositAccount third = new DepositAccount(50000);
    }
}
