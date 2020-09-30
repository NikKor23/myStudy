package Accounts;

public class CardAccount extends BankAccount{

    public static final float WITHDRAWALTAX = 1.01f;
    public static int isMoneyEnough = 0;

    public CardAccount(float moneyAmount) {
        super(moneyAmount);
        System.out.println("Создан карточный счёт. Номер: Балланс: " + moneyAmount);
    }

    public void withdrawMoney(float amount) {
        if ((amount * WITHDRAWALTAX) > moneyAmount) {
            System.out.print("Недостаточно средств для осуществления снятия! Необходимо для снятия: " + (amount * WITHDRAWALTAX) + ". В том числе налог: ");
            System.out.printf("%.2f \n", amount * (WITHDRAWALTAX - 1));
        }
        else {
            moneyAmount = moneyAmount - (amount * WITHDRAWALTAX);
            System.out.println("Произведено снятие денежных средств: " + amount);
            isMoneyEnough = 1;
        }
    }

    public boolean send(BankAccount receiver, float amount) {
        if (amount > moneyAmount) {
            System.out.println("Недостаточно средств для перевода.");
            return false;
        }
        else {
            withdrawMoney(amount);
            if (isMoneyEnough == 1) {
                receiver.toPutMoney(amount);
                System.out.println("Денежные срелства успешно перчислены!");
                isMoneyEnough = 0;
                return true;
            }
            else return false;
        }
    }
}
