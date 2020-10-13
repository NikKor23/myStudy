package Clients;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.Bidi;

public abstract class Client {

    public String name;
    public BigDecimal moneyAmount;

    public Client (String name, double amount)
    {
        this.moneyAmount = BigDecimal.valueOf(amount);
        this.name = name;
        System.out.println("Клиент " + this.name + " добвлен. Балланс клиента: " + this.moneyAmount);
    }

    public void setMoneyAmount(double moneyAmount)
    {
        this.moneyAmount = BigDecimal.valueOf(moneyAmount);
    }

    public BigDecimal getMoneyAmount()
    {
        return moneyAmount.setScale(2, RoundingMode.HALF_UP);
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        String name = this.name;
        return this.name;
    }

    public void withDrawMoney (double amountD)
    {
        BigDecimal amount = BigDecimal.valueOf(amountD);
        if (amount.compareTo(this.moneyAmount) > 0) {
            System.out.println("Недостаточно средств на счёте!");
            return;
        }
        else {
            this.moneyAmount = this.moneyAmount.subtract(amount).setScale(2, RoundingMode.HALF_UP);
            System.out.println("Снятие средств: " + amount.setScale(2, RoundingMode.HALF_UP));
        }
    }

    public void toPutMoney (double amount)
    {
        this.moneyAmount = this.moneyAmount.add(BigDecimal.valueOf(amount));
        System.out.println("Внесение средств " + BigDecimal.valueOf(amount).setScale(2, RoundingMode.HALF_UP));
    }

    public void cashBalance()
    {
        System.out.println("Остаток средств на счёте: " + getMoneyAmount());
    }

    public abstract void terms();

}
