import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class Bank {

    private ConcurrentHashMap<String, Account> accounts = new ConcurrentHashMap<>();
    private final Random random = new Random();
    public boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
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
    public void transfer(String fromAccountNum, String toAccountNum, long amount) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (this) {
            if (isBlocked(fromAccountNum, toAccountNum)) {
                System.out.println("Accounts (" +fromAccountNum + " " + toAccountNum +  ") are blocked");
                return;
            }
            if (accounts.get(fromAccountNum).getMoney() < amount) {
                try {
                    wait();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            } else {
                doTransfer(fromAccountNum, toAccountNum, amount);
                if (amount > 50000 && isFraud(fromAccountNum, toAccountNum, amount)) {
                    System.out.println("Checking...");
                    accounts.get(fromAccountNum).setBlock(true);
                    accounts.get(toAccountNum).setBlock(true);
                }
                notify();
            }
        }

    }

    private void doTransfer (String fromAccNum, String toAccNum, long amount) {
        accounts.get(fromAccNum).withDrawMoney(amount);
        accounts.get(toAccNum).putMoney(amount);
        System.out.println("Transfer: " + amount +
                ". From " + fromAccNum + " (" + accounts.get(fromAccNum).getMoney() + ")" +
                " to " + toAccNum + " (" + accounts.get(toAccNum).getMoney() + ").");
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
