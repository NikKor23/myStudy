package com.company;
import Accounts.BankAccount;
import Accounts.CardAccount;
import Accounts.DepositAccount;


public class Main {

    public static void main(String[] args) {

        BankAccount myAccount = new BankAccount(11111);
        //CardAccount second = new CardAccount(22222);
        DepositAccount third = new DepositAccount(50000);

     /*   *//*second.send(myAccount,20200);
        myAccount.cashBalance();
        second.cashBalance();*//*
        myAccount.cashBalance();
        third.send(myAccount,20200);
        myAccount.cashBalance();*/

        third.withdrawMoney(5000);
        third.cashBalance();
    }
}
