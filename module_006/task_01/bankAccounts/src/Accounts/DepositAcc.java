package Accounts;

import java.time.LocalDate;

public class DepositAcc extends MainAccount {

    private LocalDate lastCashInDate = getDateOfCreation();

    public DepositAcc(double ammount) {
        super(ammount);
    }

    public void cashIn(double ammount) {
        setCashInTotal(getCashOutTotal() + ammount);
        setAmmount(getAmmount() + ammount);
        lastCashInDate = LocalDate.now();
    }

    public void setLastCashInDate(int day, int month, int year) {
        lastCashInDate = LocalDate.of(year,month,day);
    }

    public void cashOut(double ammount) {
        if (LocalDate.now().isAfter(lastCashInDate.plusMonths(1))) {
            setCashOutTotal(getCashOutTotal() - ammount);
            setAmmount(getAmmount() - ammount);
        } else {
            System.out.println("The block period has not expired!");
        }
    }

}
