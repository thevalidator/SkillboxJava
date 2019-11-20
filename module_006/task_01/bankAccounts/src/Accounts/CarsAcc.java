package Accounts;

public class CarsAcc extends MainAccount {

    public CarsAcc(double ammount) {
        super(ammount);
    }

    public void cashOut(double ammount) {
        setCashOutTotal(getCashOutTotal() - ammount);
        setAmmount(getAmmount() - (ammount * 1.01));
    }


}
