package bankAccounts;

public class Individual extends Clients {


    private static final double FEE_GRADE_MARKER = 1000.;
    private static final double FEE_GRADE_HIGH = 0.99;
    private static final double FEE_GRADE_LOW = 0.995;

    public Individual(double balance) {
        super(balance);
    }

    @Override
    public void cashIn(double amount) {
        if (amount >= FEE_GRADE_MARKER) {
            setBalance(getBalance() + amount * FEE_GRADE_LOW);
        } else {
            setBalance(getBalance() + amount * FEE_GRADE_HIGH);
        }
    }

}
