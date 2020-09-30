package Accounts;


public class BankAccount
{
    public float moneyAmount;

    public BankAccount(float moneyAmount)
    {
        this.moneyAmount = moneyAmount;
        System.out.println("Создан банковский счёт. Балланс: " + moneyAmount);
    }

    public void setMoneyAmount(float moneyAmount)
    {
        this.moneyAmount = moneyAmount;
    }

    public float getMoneyAmount(float moneyAmount)
    {
        return moneyAmount;
    }

    public void withdrawMoney(float amount)
    {
        if (amount > moneyAmount ) {
            System.out.println("Недостаточно средств для снятия.");
            return;
        }
        else {
            moneyAmount = moneyAmount - amount;
            System.out.println("Снятие денежных средств: " + amount);
        }
    }

    public void toPutMoney (float amount) {
        moneyAmount = moneyAmount + amount;
        System.out.println("Внесение денежных средств: " + amount);
    }

    public float cashBalance () {
        System.out.println("Остаток средств на счёте: " + moneyAmount);
        return moneyAmount;
    }

    public boolean send( BankAccount receiver, float amount ){
        if (amount > moneyAmount) {
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
