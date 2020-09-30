package Accounts;

import Accounts.BankAccount;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DepositAccount extends BankAccount
{
    public static int isTransaction = 0;
    GregorianCalendar calendar = new GregorianCalendar();
    GregorianCalendar calendarOfTake = new GregorianCalendar();
    Date date = new Date();
    Date dateOfTake = new Date();

    public DepositAccount(float moneyAmount)
    {
        super(moneyAmount);
        System.out.println("Создан депозитный счёт. Балланс: " + moneyAmount);
        calendarOfTake.add(Calendar.MONTH, 1);
        dateOfTake = calendarOfTake.getTime();
    }



    public void withdrawMoney(float amount)
    {
        date = calendar.getTime();
        if (date.after(dateOfTake) || date.equals(dateOfTake)){
            if (moneyAmount == 0 || amount > moneyAmount) {
                System.out.println("Недостаточно средств");
            }
            else {
                moneyAmount = moneyAmount - amount;
                System.out.println("Списание средств: " + amount);
                isTransaction = 1;
            }

        }
        else System.out.println("С последнего пополнения счёта не прошёл месяц! Ближайшай дата снятия: " + dateOfTake);
    }

    public void toPutMoney (float amount)
    {
        this.moneyAmount = moneyAmount + amount;
        date = calendar.getTime();
        System.out.println("Внесение денежных средств: " + amount + " Дата внесения: " + date);
        calendarOfTake.add(Calendar.MONTH, 1);

    }

    public boolean send(BankAccount receiver, float amount ){
        if (amount > moneyAmount) {
            System.out.println("Недостаточно средств для перевода");
            return false;
        }
        else {
            withdrawMoney(amount);
            if (isTransaction == 1) {
                receiver.toPutMoney(amount);
                System.out.println("Денежные средства успешно перечислены.");
                isTransaction = 0;
                return true;
            }
            else return false;
        }
    }
}
