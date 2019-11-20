package bankAccounts;

public class Individual extends Clients {


    private double feeGradeMarker = 1000.;
    private double feeGradeHigh = 0.99;
    private double feeGradeLow = 0.995;

    public Individual(double balance) {
        super(balance);
    }

    @Override
    public void cashIn(double amount) {
        if (amount >= feeGradeMarker) {
            setBalance(getBalance() + amount * feeGradeLow);
        } else {
            setBalance(getBalance() + amount * feeGradeHigh);
        }
    }

    @Override
    public void cashOut(double amount) {
        setBalance(getBalance() - amount);
    }
}
