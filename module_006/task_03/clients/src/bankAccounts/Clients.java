package bankAccounts;

public abstract class Clients {

    private double balance;

    Clients(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    protected void setBalance(double balance) {
        if (balance > 0) {
            this.balance = balance;
        } else {
            System.out.println("The balance can't be negative");
        }
    }

    public void cashIn(double amount) {
        setBalance(getBalance() + amount);
    }

    public void cashOut(double amount) {
        setBalance(getBalance() - amount);
    }


}
