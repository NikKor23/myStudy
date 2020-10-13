package Clients;

import java.math.BigDecimal;

public class Individual extends Client{


    public Individual(String name, double amount) {
        super(name, amount);
    }

    @Override
    public void terms() {
        System.out.println("Информация о клиенте:");
        System.out.println("\tФизическое лицо");
        System.out.println("\tИмя: " + getName());
        System.out.println("\tБаланс: " + getMoneyAmount());
        System.out.println("\tБезпроцентное снятие и пополнение.");
    }
}
