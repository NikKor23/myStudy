package Accounts;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class DepositAccount extends BankAccount
{
    Calendar calendar = new GregorianCalendar();
    Calendar calendarOfTake = new GregorianCalendar();

    public DepositAccount(float moneyAmount) {
        super(moneyAmount);
        calendar = Calendar.getInstance();
    }



    public void withdrawMoney(float amount)
    {
        int days;
        calendarOfTake = Calendar.getInstance();
        if (calendarOfTake.get(Calendar.YEAR) != calendar.get(Calendar.YEAR)) {
            int firstDate =  calendarOfTake.getActualMaximum(Calendar.DAY_OF_YEAR) - calendarOfTake.get(Calendar.DAY_OF_YEAR);
            int secondDate = calendar.get(Calendar.DAY_OF_YEAR);
            days = firstDate + secondDate;
        }
        else {
            days = calendarOfTake.get(Calendar.DAY_OF_YEAR) - calendar.get(Calendar.DAY_OF_YEAR);
        }
        if (days >= 30) {
            super.withdrawMoney(amount);
        }
        else {
            System.out.println("С последнего пополнения счёта не прошёл месяц!");

        }
    }

    public void toPutMoney (float amount)
    {
        calendar = Calendar.getInstance();
        super.toPutMoney(amount);

    }
}
