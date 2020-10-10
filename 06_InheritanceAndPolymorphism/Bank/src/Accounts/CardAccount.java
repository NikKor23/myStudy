package Accounts;

import java.math.BigDecimal;

public class CardAccount extends BankAccount{

    BigDecimal tax = new BigDecimal(1.01);

    public CardAccount(double moneyAmount) {
        super(moneyAmount);
    }

    public void withdrawMoney(double amountD) {
        BigDecimal amount = BigDecimal.valueOf(amountD);
        amount = amount.multiply(tax);
        super.withdrawMoney(amount.doubleValue());
    }


}
