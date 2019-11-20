package Accounts;

public class CardsAcc extends MainAccount {


    public CardsAcc(double amount) {
        super(amount);
    }

    @Override
    public void cashOut(double amount) {
        setAmount(getAmount() - (amount * 1.01));
    }

}
