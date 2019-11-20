package bankAccounts;

public abstract class Clients {

    private double balance;
    private double cashInTotal;
    private double cashOutTotal;

    Clients(double balance) {
        this.balance = balance;
        setCashInTotal(balance);
    }

    public double getBalance() {
        return balance;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    public double getCashInTotal() {
        return cashInTotal;
    }

    protected void setCashInTotal(double amount) {
        cashInTotal = amount;
    }

    public double getCashOutTotal() {
        return cashOutTotal;
    }

    protected void setCashOutTotal(double amount) {
        cashOutTotal = amount;
    }

    public abstract void cashIn(double amount);
    public abstract void cashOut(double amount);


}
