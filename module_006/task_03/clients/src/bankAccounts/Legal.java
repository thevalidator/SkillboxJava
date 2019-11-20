package bankAccounts;

public class Legal extends Clients {


    private double fee = 1.01;

    public Legal(double balance) {
        super(balance);
    }

    @Override
    public void cashIn(double amount) {
        setBalance(getBalance() + amount);
        setCashInTotal(getCashInTotal() + amount);
    }

    @Override
    public void cashOut(double amount) {
        setBalance(getBalance() - amount * fee);
        setCashOutTotal(getCashOutTotal() - amount);
    }
}
