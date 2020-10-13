package Clients;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.Bidi;

public class SoleProprietor extends Client
{
    private BigDecimal FixThreshold = new BigDecimal(1000);
    private BigDecimal ToPutOverFixThresholdTax = new BigDecimal(0.005);
    private BigDecimal ToPutUnderFixThresholdTax = new BigDecimal(0.01);

    public SoleProprietor(String name, double amount) {
        super(name, amount);
    }

    @Override
    public void toPutMoney(double amountD)
    {
        super.toPutMoney(amountD);
        BigDecimal amount = BigDecimal.valueOf(amountD);
        BigDecimal tax;
        if (amount.compareTo(FixThreshold) < 0)
        {
            tax = amount.multiply(ToPutUnderFixThresholdTax);
        }
        else
        {
            tax = amount.multiply(ToPutOverFixThresholdTax);
        }
        System.out.print("За выполение операции ");
        withDrawMoney(tax.doubleValue());
    }

    @Override
    public void terms() {
        System.out.println("Информация о клиенте:");
        System.out.println("\tИндивидуальный предприниматель");
        System.out.println("\tИмя: " + getName());
        System.out.println("\tБаланс: " + getMoneyAmount());
        System.out.println("\tБеспроцентное снятие. Комиссия за пополнение до 1000 рублей: "
                + ToPutUnderFixThresholdTax.multiply(BigDecimal.valueOf(100)).setScale(2, RoundingMode.HALF_UP) + "%");
        System.out.println("\tКомиссия за пополнение более 1000 рублей: "
                + ToPutOverFixThresholdTax.multiply(BigDecimal.valueOf(100)).setScale(2, RoundingMode.HALF_UP) + "%");
    }
}
