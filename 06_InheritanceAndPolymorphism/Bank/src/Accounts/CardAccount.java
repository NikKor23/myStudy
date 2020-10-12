package Accounts;

import java.math.BigDecimal;

public class CardAccount extends BankAccount{

    public BigDecimal tax = BigDecimal.valueOf(1.01);

    public CardAccount(double moneyAmount) {
        super(moneyAmount);
    }

    public void withdrawMoney(double amountD) {
        BigDecimal amount = BigDecimal.valueOf(amountD);
        amount = amount.multiply(tax);
        super.withdrawMoney(amount.doubleValue());
    }


}
