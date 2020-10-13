package Clients;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LegalEntity extends Client{

    private BigDecimal WithDrawTax = new BigDecimal(0.01);

    public LegalEntity(String name, double amount) {
        super(name, amount);
    }

    @Override
    public void withDrawMoney(double amountD)
    {
        BigDecimal amount = BigDecimal.valueOf(amountD);
        amount = amount.multiply(WithDrawTax.add(BigDecimal.valueOf(1)));
        super.withDrawMoney(amount.doubleValue());
        System.out.println("В том числе за выполнение поперации " +
                BigDecimal.valueOf(amountD).multiply(WithDrawTax).setScale(2, RoundingMode.HALF_UP));
    }

    @Override
    public void terms() {
        System.out.println("Информация о клиенте:");
        System.out.println("\tЮридическое лицо");
        System.out.println("\tИмя: " + getName());
        System.out.println("\tБаланс: " + getMoneyAmount());
        System.out.println("\tБеспроцентное пополнение. Комиссия за снятие "
                + WithDrawTax.multiply(BigDecimal.valueOf(100)).setScale(2, RoundingMode.HALF_UP) + "%");
    }
}
