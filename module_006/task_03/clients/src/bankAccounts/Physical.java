package bankAccounts;

public class Physical extends Clients {


    public Physical(double balance) {
        super(balance);
    }

    @Override
    public void cashIn(double amount) {
        setBalance(getBalance() + amount);
    }

    @Override
    public void cashOut(double amount) {
        setBalance(getBalance() - amount);
    }
}
