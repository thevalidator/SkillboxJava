package bankAccounts;

public class Individual extends Clients {


    private double feeGradeMarker = 1000.;
    private double feeGradeOne = 0.99;
    private double feeGradeTwo = 0.995;

    public Individual(double balance) {
        super(balance);
    }

    @Override
    public void cashIn(double amount) {
        setCashInTotal(getCashInTotal() + amount);
        if (amount >= feeGradeMarker) {
            setBalance(getBalance() + amount * feeGradeTwo);
        } else {
            setBalance(getBalance() + amount * feeGradeOne);
        }
    }

    @Override
    public void cashOut(double amount) {
        setBalance(getBalance() - amount);
        setCashOutTotal(getCashOutTotal() - amount);
    }
}
