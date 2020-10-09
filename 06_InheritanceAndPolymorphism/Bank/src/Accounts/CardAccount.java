package Accounts;

public class CardAccount extends BankAccount{

    public static final float WITHDRAWALTAX = 1.01f;

    public CardAccount(float moneyAmount) {
        super(moneyAmount);
    }

    public void withdrawMoney(float amount) {
        super.withdrawMoney(amount * WITHDRAWALTAX);
        if (isTransaction) {
            System.out.println("В том числе за совершение операции " + ((amount * WITHDRAWALTAX) - amount));
        }
    }


}
