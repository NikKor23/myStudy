public class Account {

    private long money;
    private String accNumber;
    private boolean block;

    public Account(String accNumber, long money) {
        this.accNumber = accNumber;
        this.money = money;
        block = false;
    }

    public boolean isBlock() {
        return block;
    }

    public void setBlock(boolean block) {
        this.block = block;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }
}
