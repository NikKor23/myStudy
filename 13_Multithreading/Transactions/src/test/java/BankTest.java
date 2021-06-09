import org.junit.Test;

import static org.junit.Assert.*;

public class BankTest {

    @Test
    public void transfer() {
        Account first = new Account("1", 100000);
        Account second = new Account("2", 100000);
        Bank bank = new Bank();
        bank.addAcc("1", first);
        bank.addAcc("2", second);

        bank.transfer("1", "2", 10000);
        long actual = bank.getBalance("1");
        long expected = 90000L;
        assertEquals(expected, actual);
    }

    @Test
    public void getSumAllAccounts() {
        Account first = new Account("1", 100000);
        Account second = new Account("2", 100000);
        Bank bank = new Bank();
        bank.addAcc("1", first);
        bank.addAcc("2", second);
        long actual = bank.getSumAllAccounts();
        long expected = 200000L;
        assertEquals(expected, actual);
    }
}