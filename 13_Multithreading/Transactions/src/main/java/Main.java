public class Main
{
    public static void main(String[] args) {
        Bank bank = new Bank();

        Account first = new Account("01", 200000);
        Account second = new Account("02", 150000);

        bank.addAcc("01", first);
        bank.addAcc("02", second);
        System.out.println(bank.getSumAllAccounts());

        for (int i = 1; i < 1000; i++) try {
            new Thread(() -> bank.transfer("01", "02", Math.round(60000* Math.random()))).start();
            new Thread(() -> bank.transfer("02", "01",  Math.round(60000* Math.random()))).start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            Thread.currentThread().sleep(1000);
            System.out.println(bank.getSumAllAccounts());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
