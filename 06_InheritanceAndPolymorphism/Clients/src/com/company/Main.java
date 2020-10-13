package com.company;

import Clients.Client;
import Clients.Individual;
import Clients.LegalEntity;
import Clients.SoleProprietor;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {

        Client firstClient = new SoleProprietor("Тереньтьев Михаил Павлович", 100000);
        firstClient.terms();
        firstClient.withDrawMoney(100);
        firstClient.cashBalance();
    }
}
