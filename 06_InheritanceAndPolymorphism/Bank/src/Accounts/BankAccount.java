package Accounts;


import java.math.BigDecimal;

public class BankAccount
{
    private BigDecimal moneyAmount;

    public BankAccount(double amount)
    {
        moneyAmount = BigDecimal.valueOf(amount);
        System.out.println("Создан банковский счёт. Балланс: " + moneyAmount);
    }

    public void withdrawMoney(double amountD)
    {
        BigDecimal amount = BigDecimal.valueOf(amountD);
        if (amount.compareTo(moneyAmount) > 0) {
            System.out.println("Недостаточно средств для снятия.");
            return;
        }
        else {
            moneyAmount = moneyAmount.subtract(amount);
            System.out.println("Снятие денежных средств: " + amount);
        }
    }

    public void toPutMoney (double amount) {
        moneyAmount = moneyAmount.add(BigDecimal.valueOf(amount));
        System.out.println("Внесение денежных средств: " + amount);
    }

    public BigDecimal cashBalance () {
        System.out.println("Остаток средств на счёте: " + moneyAmount);
        return moneyAmount;
    }

    public boolean send(BankAccount receiver, double amount){
        if (BigDecimal.valueOf(amount).compareTo(moneyAmount) > 0) {
            System.out.println("Недостаточно средств для перевода");
            return false;
        }
        else {
            withdrawMoney(amount);
            receiver.toPutMoney(amount);
            System.out.println("Средства успешно перечислены.");
            return true;
        }
    }
}
