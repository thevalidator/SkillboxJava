package Accounts;

public class CardsAcc extends MainAccount {

    public CardsAcc(double ammount) {
        super(ammount);
    }

    public void cashOut(double ammount) {
        setCashOutTotal(getCashOutTotal() - ammount);
        setAmmount(getAmmount() - (ammount * 1.01));
    }


}
