import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Bank {

    private Map<String, Account> accounts = new HashMap<>();
    private final Random random = new Random();

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
    {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        return random.nextBoolean();
    }

    /**
     * TODO: реализовать метод. Метод переводит деньги между счетами. Если сумма транзакции > 50000,
     * то после совершения транзакции, она отправляется на проверку Службе Безопасности – вызывается
     * метод isFraud. Если возвращается true, то делается блокировка счетов (как – на ваше
     * усмотрение)
     */
    public synchronized void transfer(String fromAccountNum, String toAccountNum, long amount){

        if (isBlocked(fromAccountNum, toAccountNum)) {
            System.out.println("Accounts are blocked");
            return;
        }
        if (accounts.get(fromAccountNum).getMoney() < amount) {
            System.out.println("Not enough money for transfer. (" + amount + ")");
            try {
                wait(100);
            }catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        else {
            long moneyFrom = getBalance(fromAccountNum);
            long moneyTo = getBalance(toAccountNum);
            System.out.println(fromAccountNum + " " + moneyFrom + " " + toAccountNum + " " + moneyTo);
            accounts.get(fromAccountNum).setMoney(moneyFrom - amount);
            accounts.get(toAccountNum).setMoney(moneyTo + amount);
            System.out.println("Movement " + amount + " is done. " +
                    "\nFrom " + fromAccountNum + " " + getBalance(fromAccountNum) +
                    " to " + toAccountNum + " " + getBalance(toAccountNum) + "\n"
            );
        }
        if (amount > 50000 && isFraud(fromAccountNum, toAccountNum, amount)) {
            accounts.get(fromAccountNum).setBlock(true);
            accounts.get(toAccountNum).setBlock(true);
        }
        notify();
    }

    /**
     * TODO: реализовать метод. Возвращает остаток на счёте.
     */
    public long getBalance(String accountNum) {
        return accounts.get(accountNum).getMoney();
    }

    public long getSumAllAccounts() {
        long sum = accounts.keySet().stream().mapToLong(k -> accounts.get(k).getMoney()).sum();
        return sum;
    }

    public void addAcc(String string, Account account)
    {
        accounts.put(string,account);
    }

    public boolean isBlocked(String fromAcc, String toAcc) {
        return accounts.get(fromAcc).isBlock() && accounts.get(toAcc).isBlock();
    }
}
