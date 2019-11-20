package Accounts;

public class MainAccount {

    private double amount = 0.;

    public MainAccount(double amount) {
        setAmount(amount);
    }

    public double getAmount() {
        return amount;
    }

    protected void setAmount(double amount) {
        if (amount > 0) {
            this.amount = amount;
        } else {
            System.out.println("The balance can't be negative");
        }
    }

    public void cashOut(double amount) {
        setAmount(getAmount() - amount);
    }

    public void cashIn(double amount) {
        setAmount(getAmount() + amount);
    }


}
