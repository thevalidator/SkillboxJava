package bankAccounts;

public class Legal extends Clients {


    private static final double FEE = 1.01;

    public Legal(double balance) {
        super(balance);
    }

    @Override
    public void cashOut(double amount) {
        setBalance(getBalance() - amount * FEE);
    }
}
